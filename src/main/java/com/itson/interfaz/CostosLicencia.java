/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.interfaz;

import com.itson.dominio.CostoTramite;
import com.itson.dominio.Persona;
import com.itson.implementaciones.LicenciaDAO;
import com.itson.implementaciones.PersonaDAO;
import interfaces.ILicenciaDAO;
import interfaces.IPersonaDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arace
 */
public class CostosLicencia extends javax.swing.JFrame {

    IPersonaDAO a = new PersonaDAO();
    CostoTramite b = new CostoTramite();
    ILicenciaDAO c = new LicenciaDAO();
    private final String rfc;

    /**
     * Creates new form Licencia
     *
     * @param rfc
     */
    public CostosLicencia(String rfc) {
        this.rfc = rfc;
        initComponents();
        Persona persona = this.a.buscarPersonasRFC(rfc);
        lblPersona.setText("Persona: " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
        DefaultTableModel tblCosto = (DefaultTableModel) tblPrecioLicencia.getModel();
        tblPrecioLicencia.setModel(tblCosto);
        tblCosto.addRow(new Object[]{"1 año", b.licencia1N, b.licencia1D});
        tblCosto.addRow(new Object[]{"2 años", b.licencia2N, b.licencia2D});
        tblCosto.addRow(new Object[]{"3 años", b.licencia3N, b.licencia3D});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblModuloLicencias = new javax.swing.JLabel();
        cmbVigencia = new javax.swing.JComboBox<>();
        lblVigencia = new javax.swing.JLabel();
        lblDiscapacitado = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        tablaCostosLicencia = new javax.swing.JScrollPane();
        tblPrecioLicencia = new javax.swing.JTable();
        jcbDiscapacidad = new javax.swing.JCheckBox();
        lblPersona = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblModuloLicencias.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblModuloLicencias.setText("Módulo de Licencias");

        cmbVigencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        lblVigencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblVigencia.setText("Vigencia");

        lblDiscapacitado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDiscapacitado.setText("¿Es discapacitado?");

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        tablaCostosLicencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblPrecioLicencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblPrecioLicencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vigencia", "Costo normal", "Costo discapacitado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPrecioLicencia.getTableHeader().setReorderingAllowed(false);
        tablaCostosLicencia.setViewportView(tblPrecioLicencia);
        if (tblPrecioLicencia.getColumnModel().getColumnCount() > 0) {
            tblPrecioLicencia.getColumnModel().getColumn(0).setResizable(false);
            tblPrecioLicencia.getColumnModel().getColumn(1).setResizable(false);
            tblPrecioLicencia.getColumnModel().getColumn(2).setResizable(false);
        }

        jcbDiscapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDiscapacidadActionPerformed(evt);
            }
        });

        lblPersona.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblModuloLicencias)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVigencia)
                                    .addComponent(lblDiscapacitado))
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbDiscapacidad)
                                    .addComponent(cmbVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPersona)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnRegresar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAceptar))
                                .addComponent(tablaCostosLicencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblModuloLicencias)
                .addGap(28, 28, 28)
                .addComponent(lblPersona)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVigencia))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiscapacitado)
                    .addComponent(jcbDiscapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(tablaCostosLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnAceptar))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        ConsultaLicencia v = new ConsultaLicencia();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Persona persona = this.a.buscarPersonasRFC(rfc);
        String opcion = cmbVigencia.getSelectedItem().toString();

        int vigencia = 0;
        switch (opcion) {
            case "1":
                vigencia = 1;
                break;
            case "2":
                vigencia = 2;
                break;
            case "3":
                vigencia = 3;
                break;
        }

        int estadoDiscapacidad = 0;
        String estado = "NORMAL";
        Double costo = 0.0;

        if (jcbDiscapacidad.isSelected()) {
            estadoDiscapacidad = 1;
            estado = "DISCAPACITADO";
        }

        switch (vigencia) {
            case 1:
                if (estadoDiscapacidad == 1) {
                    costo = b.licencia1D;
                } else {
                    costo = b.licencia1N;
                }
                break;
            case 2:
                if (estadoDiscapacidad == 1) {
                    costo = b.licencia2D;
                } else {
                    costo = b.licencia2N;
                }
                break;
            case 3:
                if (estadoDiscapacidad == 1) {
                    costo = b.licencia3D;
                } else {
                    costo = b.licencia3N;
                }
                break;
        }

        c.insertarTramiteLicencia(rfc, costo, vigencia, estadoDiscapacidad);
        JOptionPane.showMessageDialog(null, "Se ha generado una licencia con estos datos:\n"
                + "Persona: " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + "\n"
                + "Vigencia (años): " + vigencia + "\n"
                + "Tipo: " + estado + "", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        Aplicacion a = new Aplicacion();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jcbDiscapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDiscapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDiscapacidadActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CostosLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CostosLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CostosLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CostosLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CostosLicencia().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbVigencia;
    private javax.swing.JCheckBox jcbDiscapacidad;
    private javax.swing.JLabel lblDiscapacitado;
    private javax.swing.JLabel lblModuloLicencias;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JLabel lblVigencia;
    private javax.swing.JScrollPane tablaCostosLicencia;
    private javax.swing.JTable tblPrecioLicencia;
    // End of variables declaration//GEN-END:variables
}
