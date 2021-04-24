/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteoinfo.map.forms;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.meteoinfo.geo.layer.LayerTypes;
import org.meteoinfo.geo.layer.MapLayer;
import org.meteoinfo.geo.layer.VectorLayer;
import org.meteoinfo.geo.mapview.MapView;

/**
 *
 * @author Yaqiang Wang
 */
public class FrmConvexhull extends javax.swing.JDialog {

    List<VectorLayer> _vLayers = new ArrayList<>();
    private final FrmMain _parent;

    /**
     * Creates new form FrmClipping
     * @param parent
     * @param modal
     */
    public FrmConvexhull(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        _parent = (FrmMain)parent;
        this.initialize();
    }

    private void initialize() {
        MapView mapView = _parent.getMapDocument().getActiveMapFrame().getMapView();
        this.jComboBox_SubjectLayer.removeAllItems();
        for (int i = 0; i < mapView.getLayerNum(); i++) {
            MapLayer layer = mapView.getLayers().get(i);
            if (layer.getLayerType() == LayerTypes.VECTOR_LAYER) {
                this._vLayers.add((VectorLayer) layer);
                this.jComboBox_SubjectLayer.addItem(layer.getLayerName());
            }
        }

        if (this.jComboBox_SubjectLayer.getItemCount() > 0) {
            this.jComboBox_SubjectLayer.setSelectedIndex(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox_SubjectLayer = new javax.swing.JComboBox();
        jCheckBox_SelFeatureOnly = new javax.swing.JCheckBox();
        jButton_Apply = new javax.swing.JButton();
        jCheckBox_IsMerge = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Convexhull");

        jLabel1.setText("Subject layer:");

        jComboBox_SubjectLayer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCheckBox_SelFeatureOnly.setText("Selected features only");

        jButton_Apply.setText("Apply");
        jButton_Apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ApplyActionPerformed(evt);
            }
        });

        jCheckBox_IsMerge.setSelected(true);
        jCheckBox_IsMerge.setText("Create only one convexhull");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_SubjectLayer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_IsMerge)
                            .addComponent(jCheckBox_SelFeatureOnly)
                            .addComponent(jLabel1))
                        .addGap(0, 185, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Apply, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_SubjectLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_SelFeatureOnly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_IsMerge)
                .addGap(18, 18, 18)
                .addComponent(jButton_Apply)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ApplyActionPerformed
        // TODO add your handling code here:        
        //---- Show progressbar                      
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        VectorLayer fromLayer = _vLayers.get(this.jComboBox_SubjectLayer.getSelectedIndex());
        boolean onlySel = this.jCheckBox_SelFeatureOnly.isSelected();
        boolean isMerge = this.jCheckBox_IsMerge.isSelected();
        VectorLayer newLayer = fromLayer.convexhull(onlySel, isMerge);
        newLayer.setLayerName("Convexhull_" + newLayer.getLayerName());
        _parent.getMapDocument().getActiveMapFrame().addLayer(newLayer);

        //---- Hide progressbar                      
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jButton_ApplyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmConvexhull.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConvexhull.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConvexhull.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConvexhull.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrmConvexhull dialog = new FrmConvexhull(new FrmMain(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Apply;
    private javax.swing.JCheckBox jCheckBox_IsMerge;
    private javax.swing.JCheckBox jCheckBox_SelFeatureOnly;
    private javax.swing.JComboBox jComboBox_SubjectLayer;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}