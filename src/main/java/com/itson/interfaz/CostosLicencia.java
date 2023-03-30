/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.interfaz;

/**
 *
 * @author arace
 */
public class CostosLicencia extends javax.swing.JFrame {

    /**
     * Creates new form Licencia
     */
    public CostosLicencia() {
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

        labelModuloLicencias = new javax.swing.JLabel();
        comboVigencia = new javax.swing.JComboBox<>();
        labelVigencia = new javax.swing.JLabel();
        comboDiscapacitado = new javax.swing.JComboBox<>();
        labelDiscapacitado = new javax.swing.JLabel();
        comboRegresar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        tablaCostosLicencia = new javax.swing.JScrollPane();
        tablaPrecioLicencia = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelModuloLicencias.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelModuloLicencias.setText("Módulo de Licencias");

        comboVigencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Año", "2 Años", "3 Años", " " }));

        labelVigencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelVigencia.setText("Vigencia");

        comboDiscapacitado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboDiscapacitado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        comboDiscapacitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDiscapacitadoActionPerformed(evt);
            }
        });

        labelDiscapacitado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDiscapacitado.setText("¿Es discapacitado?");

        comboRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboRegresar.setText("Regresar");
        comboRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRegresarActionPerformed(evt);
            }
        });

        botonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        tablaCostosLicencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tablaPrecioLicencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaPrecioLicencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1 Año",  new Double(600.0),  new Double(200.0)},
                {"2 Años",  new Double(900.0),  new Double(500.0)},
                {"3 Años",  new Double(1100.0),  new Double(700.0)}
            },
            new String [] {
                "Vigencia", "Costo normal", "Costo discapacitado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaCostosLicencia.setViewportView(tablaPrecioLicencia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboDiscapacitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(labelVigencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(comboRegresar)
                        .addGap(26, 26, 26)
                        .addComponent(botonAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(labelModuloLicencias))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDiscapacitado)
                            .addComponent(tablaCostosLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelModuloLicencias)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelVigencia))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDiscapacitado)
                    .addComponent(comboDiscapacitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(tablaCostosLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboRegresar)
                    .addComponent(botonAceptar))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboDiscapacitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDiscapacitadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDiscapacitadoActionPerformed

    private void comboRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRegresarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(CostosLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CostosLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CostosLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CostosLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CostosLicencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JComboBox<String> comboDiscapacitado;
    private javax.swing.JButton comboRegresar;
    private javax.swing.JComboBox<String> comboVigencia;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDiscapacitado;
    private javax.swing.JLabel labelModuloLicencias;
    private javax.swing.JLabel labelVigencia;
    private javax.swing.JScrollPane tablaCostosLicencia;
    private javax.swing.JTable tablaPrecioLicencia;
    // End of variables declaration//GEN-END:variables
}
