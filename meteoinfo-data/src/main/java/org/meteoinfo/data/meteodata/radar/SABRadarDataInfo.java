package org.meteoinfo.data.meteodata.radar;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.meteoinfo.common.DataConvert;
import org.meteoinfo.data.dimarray.Dimension;
import org.meteoinfo.data.meteodata.Attribute;
import org.meteoinfo.data.meteodata.DataInfo;
import org.meteoinfo.data.meteodata.Variable;
import org.meteoinfo.ndarray.*;
import org.meteoinfo.ndarray.math.ArrayUtil;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SABRadarDataInfo extends BaseRadarDataInfo implements IRadarDataInfo {

    private boolean isCACB = false;
    private int reflectivityFixSize = 460;
    private int dopplerFixSize = 920;

    @Override
    public boolean isValidFile(java.io.RandomAccessFile raf) {
        return false;
    }

    void setScaleOffset(RadialRecord record, int vResolution) {
        switch (record.product) {
            case "dBZ":
                record.scale = 0.5f;
                record.offset = -33.f;
                break;
            case "V":
                if (vResolution == 2) {
                    record.scale = 0.5f;
                    record.offset = -64.5f;
                } else {
                    record.scale = 1.f;
                    record.offset = -129.f;
                }
                break;
            case "W":
                record.scale = 0.5f;
                record.offset = -64.5f;
                break;
        }
    }

    /**
     * Set if the data is CA/CB
     * @param value Boolean
     */
    public void setCACB(Boolean value) {
        this.isCACB = value;
        if (isCACB) {
            this.reflectivityFixSize = 800;
            this.dopplerFixSize = 1600;
        } else {
            this.reflectivityFixSize = 460;
            this.dopplerFixSize = 1600;
        }
    }

    @Override
    void readDataInfo(InputStream is) {
        try {
            int index = 0;
            byte[] rhBytes = new byte[RadialHeader.length];
            while (is.read(rhBytes) != -1) {
                RadialHeader radialHeader = new RadialHeader(rhBytes);
                if (index == 0) {
                    this.logResolution = radialHeader.gateSizeOfReflectivity;
                    this.dopplerResolution = radialHeader.gateSizeOfDoppler;
                    if (radialHeader.gatesNumberOfReflectivity > 460) {
                        this.setCACB(true);
                    }
                }
                if (!radialHeader.hasReflectivityData()) {
                    is.read(new byte[this.reflectivityFixSize]);
                }
                for (String product : radialHeader.getProducts()) {
                    RadialRecord record;
                    if (this.recordMap.containsKey(product)) {
                        record = this.recordMap.get(product);
                    } else {
                        record = new RadialRecord(product);
                        record.setBinLength(1);
                        setScaleOffset(record, radialHeader.resolutionOfVelocity);
                        this.recordMap.put(product, record);
                    }
                    if (radialHeader.radialNumber == 1) {
                        record.fixedElevation.add(radialHeader.getElevation());
                        record.elevation.add(new ArrayList<>());
                        record.azimuth.add(new ArrayList<>());
                        record.azimuthMinIndex.add(0);
                        if (isVelocityGroup(record)) {
                            record.disResolution.add((float) radialHeader.gateSizeOfDoppler);
                            record.distance.add(ArrayUtil.arrayRange1(radialHeader.rangeToFirstGateOfDop,
                                    radialHeader.gatesNumberOfDoppler, radialHeader.gateSizeOfDoppler));
                        } else {
                            record.disResolution.add((float) radialHeader.gateSizeOfReflectivity);
                            record.distance.add(ArrayUtil.arrayRange1(radialHeader.rangeToFirstGateOfRef,
                                    radialHeader.gatesNumberOfReflectivity, radialHeader.gateSizeOfReflectivity));
                        }
                        record.newScanData();
                    }
                    record.elevation.get(record.elevation.size() - 1).add(radialHeader.getElevation());
                    record.addAzimuth(radialHeader.getAzimuth());
                    int dataLength = isVelocityGroup(record) ? radialHeader.gatesNumberOfDoppler : radialHeader.gatesNumberOfReflectivity;
                    byte[] bytes = new byte[dataLength];
                    is.read(bytes);
                    record.addDataBytes(bytes);
                    if (isVelocityGroup(record)) {
                        if (dataLength < this.dopplerFixSize) {
                            is.read(new byte[this.dopplerFixSize - dataLength]);
                        }
                    } else {
                        if (dataLength < this.reflectivityFixSize) {
                            is.read(new byte[this.reflectivityFixSize - dataLength]);
                        }
                    }
                }
                if (!radialHeader.hasDopplerData()) {
                    is.read(new byte[this.dopplerFixSize * 2]);
                }
                is.read(new byte[4]);
                index += 1;
            }
            is.close();

            this.addAttribute(new Attribute("featureType", "RADIAL"));
            this.addAttribute(new Attribute("DataType", "Radial"));
            String radarDataTypeStr = "SA/SB";
            if (this.isCACB) {
                radarDataTypeStr = "CA/CB";
            }
            this.addAttribute(new Attribute("RadarDataType", radarDataTypeStr));

            //Add dimensions and variables
            RadialRecord refRadialRecord = this.recordMap.get("dBZ");
            radialDim = new Dimension();
            radialDim.setName("radial");
            radialDim.setLength(refRadialRecord.getMaxRadials());
            this.addDimension(radialDim);
            scanDim = new Dimension();
            scanDim.setName("scan");
            scanDim.setLength(refRadialRecord.getScanNumber());
            this.addDimension(scanDim);
            gateRDim = new Dimension();
            gateRDim.setName("gateR");
            gateRDim.setLength(refRadialRecord.getGateNumber(0));
            this.addDimension(gateRDim);
            makeRefVariables(refRadialRecord);

            RadialRecord velRadialRecord = this.recordMap.get("V");
            gateVDim = new Dimension();
            gateVDim.setName("gateV");
            gateVDim.setLength(velRadialRecord.getGateNumber(0));
            this.addDimension(gateVDim);
            makeVelVariables(velRadialRecord);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RadarDataType getRadarDataType() {
        return RadarDataType.SAB;
    }

    static class RadialHeader {
        public static int length = 128;
        public short messageType;
        public int mSecond;    // collection time for this radial, msecs since midnight
        public short julianDate;    // prob "collection time"
        public short uRange;    // unambiguous range
        public int azimuth;    // azimuth angle
        public short radialNumber;    // radial number within the elevation
        public short radialStatus;
        public short elevation;
        public short elNumber;    // elevation number
        public int rangeToFirstGateOfRef;    // range to first gate of reflectivity (m) may be negative
        public int rangeToFirstGateOfDop;    // range to first gate of doppler (m) may be negative
        public int gateSizeOfReflectivity;    // reflectivity data gate size (m)
        public int gateSizeOfDoppler;    // doppler data gate size (m)
        public int gatesNumberOfReflectivity;    // number of reflectivity gates
        public int gatesNumberOfDoppler;    // number of velocity or spectrum width gates
        public short cutSectorNumber;
        public int calibrationConst;
        public short ptrOfReflectivity;
        public short ptrOfVelocity;
        public short ptrOfSpectrumWidth;
        public int resolutionOfVelocity;
        public short vcpNumber;
        public short nyquist;

        /**
         * Constructor
         * @param is InputStream
         */
        public RadialHeader(byte[] inBytes) throws IOException {
            ByteBuffer byteBuffer = ByteBuffer.wrap(inBytes);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.position(14);
            messageType = byteBuffer.getShort();
            byteBuffer.position(28);
            mSecond = byteBuffer.getInt();
            julianDate = byteBuffer.getShort();
            uRange = byteBuffer.getShort();
            azimuth = DataType.unsignedShortToInt(byteBuffer.getShort());
            radialNumber = byteBuffer.getShort();
            radialStatus = byteBuffer.getShort();
            elevation = byteBuffer.getShort();
            elNumber = byteBuffer.getShort();
            rangeToFirstGateOfRef = byteBuffer.getShort();
            rangeToFirstGateOfDop = byteBuffer.getShort();
            gateSizeOfReflectivity = byteBuffer.getShort();
            gateSizeOfDoppler = byteBuffer.getShort();
            gatesNumberOfReflectivity = byteBuffer.getShort();
            gatesNumberOfDoppler = byteBuffer.getShort();
            cutSectorNumber = byteBuffer.getShort();
            calibrationConst = byteBuffer.getShort();
            ptrOfReflectivity = byteBuffer.getShort();
            ptrOfVelocity = byteBuffer.getShort();
            ptrOfSpectrumWidth = byteBuffer.getShort();
            resolutionOfVelocity = byteBuffer.getShort();
            vcpNumber = byteBuffer.getShort();
            byteBuffer.position(byteBuffer.position() + 14);
            nyquist = byteBuffer.getShort();
        }

        /**
         * Get date time
         * @return Date time
         */
        public LocalDateTime getDateTime() {
            long total = ((long) (julianDate - 1)) * 24 * 3600 * 1000 + mSecond;
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(total), ZoneId.systemDefault());
        }

        /**
         * Has reflectivity data or not
         * @return Has reflectivity data
         */
        public boolean hasReflectivityData() {
            return gatesNumberOfReflectivity > 0;
        }

        /**
         * Has doppler data or not
         * @return Has doppler data
         */
        public boolean hasDopplerData() {
            return gatesNumberOfDoppler > 0;
        }

        /**
         * Get product names
         * @return Product names
         */
        public List<String> getProducts() {
            List<String> products = new ArrayList<>();
            if (hasReflectivityData()) {
                products.add("dBZ");
            }
            if (hasDopplerData()) {
                products.add("V");
                products.add("W");
            }

            return products;
        }

        /**
         * Get azimuth
         * @return Azimuth
         */
        public float getAzimuth() {
            return azimuth / 8.f * 180.f / 4096.f;
        }

        /**
         * Get elevation
         * @return Elevation
         */
        public float getElevation() {
            return elevation / 8.f * 180.f / 4096.f;
        }
    }
}
