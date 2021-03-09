/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteoinfo.desktop.forms;

import org.meteoinfo.data.GridDataSetting;

/**
 *
 * @author yaqiang
 */
public class FrmGridSet extends javax.swing.JDialog {

    private boolean _isOK = false;
    
    /**
     * Creates new form FrmGridSet
     */
    public FrmGridSet(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_MinX = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_MaxX = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_MinY = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_MaxY = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_XSize = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_YSize = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_XNum = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField_YNum = new javax.swing.JTextField();
        jButton_OK = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grid Set");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Output Grid Set"));

        jLabel1.setText("MinX:");

        jTextField_MinX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MinXActionPerformed(evt);
            }
        });

        jLabel2.setText("MaxX:");

        jTextField_MaxX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MaxXActionPerformed(evt);
            }
        });

        jLabel3.setText("MinY:");

        jTextField_MinY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MinYActionPerformed(evt);
            }
        });

        jLabel4.setText("MaxY:");

        jTextField_MaxY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MaxYActionPerformed(evt);
            }
        });

        jLabel5.setText("XSize:");

        jTextField_XSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_XSizeActionPerformed(evt);
            }
        });

        jLabel6.setText("YSize:");

        jTextField_YSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_YSizeActionPerformed(evt);
            }
        });

        jLabel7.setText("XNum:");

        jTextField_XNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_XNumActionPerformed(evt);
            }
        });

        jLabel8.setText("YNum:");

        jTextField_YNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_YNumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_XSize, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_MinY, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_MaxY, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField_XNum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_YNum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_YSize, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_MinX, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_MaxX, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_MinX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_MaxX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_MinY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_MaxY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_XSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_YSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_XNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField_YNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_OK.setText("OK");
        jButton_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OKActionPerformed(evt);
            }
        });

        jButton_Cancel.setText("Cancel");
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jButton_Cancel)
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_OK)
                    .addComponent(jButton_Cancel))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Get if is OK
     * @return Boolean
     */
    public boolean isOK(){
        return this._isOK;
    }
    
    private void jTextField_MinXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_MinXActionPerformed
        // TODO add your handling code here:
        this.setXYSize();
    }//GEN-LAST:event_jTextField_MinXActionPerformed

    private void jTextField_MaxXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_MaxXActionPerformed
        // TODO add your handling code here:
        this.setXYSize();
    }//GEN-LAST:event_jTextField_MaxXActionPerformed

    private void jTextField_MinYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_MinYActionPerformed
        // TODO add your handling code here:
        this.setXYSize();
    }//GEN-LAST:event_jTextField_MinYActionPerformed

    private void jTextField_MaxYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_MaxYActionPerformed
        // TODO add your handling code here:
        this.setXYSize();
    }//GEN-LAST:event_jTextField_MaxYActionPerformed

    private void jTextField_XSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_XSizeActionPerformed
        // TODO add your handling code here:
        this.setXYNum();
    }//GEN-LAST:event_jTextField_XSizeActionPerformed

    private void jTextField_YSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_YSizeActionPerformed
        // TODO add your handling code here:
        this.setXYNum();
    }//GEN-LAST:event_jTextField_YSizeActionPerformed

    private void jTextField_XNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_XNumActionPerformed
        // TODO add your handling code here:
        this.setXYSize();
    }//GEN-LAST:event_jTextField_XNumActionPerformed

    private void jTextField_YNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_YNumActionPerformed
        // TODO add your handling code here:
        this.setXYSize();
    }//GEN-LAST:event_jTextField_YNumActionPerformed

    private void jButton_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OKActionPerformed
        // TODO add your handling code here:
        this._isOK = true;
        this.dispose();
    }//GEN-LAST:event_jButton_OKActionPerformed

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        // TODO add your handling code here:
        this._isOK = false;
        this.dispose();
    }//GEN-LAST:event_jButton_CancelActionPerformed

    public void setParameters(GridDataSetting aGDP) {
        this.jTextField_MinX.setText(String.valueOf(aGDP.dataExtent.minX));
        this.jTextField_MaxX.setText(String.valueOf(aGDP.dataExtent.maxX));
        this.jTextField_MinY.setText(String.valueOf(aGDP.dataExtent.minY));
        this.jTextField_MaxY.setText(String.valueOf(aGDP.dataExtent.maxY));
        this.jTextField_XNum.setText(String.valueOf(aGDP.xNum));
        this.jTextField_YNum.setText(String.valueOf(aGDP.yNum));
        setXYSize();
    }

    public GridDataSetting getParameters() {
        float minX, maxX, minY, maxY;
        minX = Float.parseFloat(this.jTextField_MinX.getText());
        maxX = Float.parseFloat(this.jTextField_MaxX.getText());
        minY = Float.parseFloat(this.jTextField_MinY.getText());
        maxY = Float.parseFloat(this.jTextField_MaxY.getText());

        GridDataSetting aGDP = new GridDataSetting();
        aGDP.dataExtent.minX = minX;
        aGDP.dataExtent.maxX = maxX;
        aGDP.dataExtent.minY = minY;
        aGDP.dataExtent.maxY = maxY;
        aGDP.xNum = Integer.parseInt(this.jTextField_XNum.getText());
        aGDP.yNum = Integer.parseInt(this.jTextField_YNum.getText());

        return aGDP;
    }

    private void setXYNum() {
        float minX, maxX, minY, maxY;
        float XSize, YSize;
        int XNum, YNum;
        minX = Float.parseFloat(this.jTextField_MinX.getText());
        maxX = Float.parseFloat(this.jTextField_MaxX.getText());
        minY = Float.parseFloat(this.jTextField_MinY.getText());
        maxY = Float.parseFloat(this.jTextField_MaxY.getText());
        XSize = Float.parseFloat(this.jTextField_XSize.getText());
        YSize = Float.parseFloat(this.jTextField_YSize.getText());

        XNum = (int) ((maxX - minX) / XSize);
        YNum = (int) ((maxY - minY) / YSize);

        maxX = minX + XNum * XSize;
        maxY = minY + YNum * YSize;

        XNum += 1;
        YNum += 1;
        this.jTextField_XNum.setText(String.valueOf(XNum));
        this.jTextField_YNum.setText(String.valueOf(YNum));

        this.jTextField_MaxX.setText(String.valueOf(maxX));
        this.jTextField_MaxY.setText(String.valueOf(maxY));
    }

    private void setXYSize() {
        float minX, maxX, minY, maxY;
        float XSize, YSize;
        int XNum, YNum;
        minX = Float.parseFloat(this.jTextField_MinX.getText());
        maxX = Float.parseFloat(this.jTextField_MaxX.getText());
        minY = Float.parseFloat(this.jTextField_MinY.getText());
        maxY = Float.parseFloat(this.jTextField_MaxY.getText());
        XNum = Integer.parseInt(this.jTextField_XNum.getText());
        YNum = Integer.parseInt(this.jTextField_YNum.getText());

        XSize = (maxX - minX) / (XNum - 1);
        YSize = (maxY - minY) / (YNum - 1);
        this.jTextField_XSize.setText(String.valueOf(XSize));
        this.jTextField_YSize.setText(String.valueOf(YSize));
    }

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
            java.util.logging.Logger.getLogger(FrmGridSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGridSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGridSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGridSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmGridSet dialog = new FrmGridSet(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_OK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_MaxX;
    private javax.swing.JTextField jTextField_MaxY;
    private javax.swing.JTextField jTextField_MinX;
    private javax.swing.JTextField jTextField_MinY;
    private javax.swing.JTextField jTextField_XNum;
    private javax.swing.JTextField jTextField_XSize;
    private javax.swing.JTextField jTextField_YNum;
    private javax.swing.JTextField jTextField_YSize;
    // End of variables declaration//GEN-END:variables
}
