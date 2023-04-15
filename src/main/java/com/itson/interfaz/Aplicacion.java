/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package com.itson.interfaz;

import com.itson.implementaciones.PersonaDAO;
import interfaces.IPersonaDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author arace
 */
public class Aplicacion extends javax.swing.JFrame {

    /**
     * Creates new form Aplicacion
     */
    public Aplicacion() {
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

        labelOperacion = new javax.swing.JLabel();
        botonPlacas = new javax.swing.JButton();
        botonLicencias = new javax.swing.JButton();
        labelAgencia = new javax.swing.JLabel();
        botonReportes = new javax.swing.JButton();
        botonConsultas = new javax.swing.JButton();
        botonPersonas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);

        labelOperacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelOperacion.setText("Selecccione la operación a realizar");

        botonPlacas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonPlacas.setText("Módulo de placas");
        botonPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPlacasActionPerformed(evt);
            }
        });

        botonLicencias.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonLicencias.setText("Módulo de licencias");
        botonLicencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLicenciasActionPerformed(evt);
            }
        });

        labelAgencia.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelAgencia.setText("Agencía Fiscal");

        botonReportes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonReportes.setText("Módulo de reportes");
        botonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReportesActionPerformed(evt);
            }
        });

        botonConsultas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonConsultas.setText("Módulo de consultas");
        botonConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultasActionPerformed(evt);
            }
        });

        botonPersonas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonPersonas.setText("Inserción de personas");
        botonPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPersonasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAgencia)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(botonReportes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonPlacas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonConsultas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(439, 439, 439)
                                .addComponent(botonPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelOperacion)
                            .addComponent(botonLicencias, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labelAgencia)
                .addGap(40, 40, 40)
                .addComponent(labelOperacion)
                .addGap(29, 29, 29)
                .addComponent(botonLicencias)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonPlacas)
                    .addComponent(botonPersonas))
                .addGap(21, 21, 21)
                .addComponent(botonConsultas)
                .addGap(18, 18, 18)
                .addComponent(botonReportes)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonLicenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLicenciasActionPerformed
        ConsultaLicencia v = new ConsultaLicencia();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonLicenciasActionPerformed

    private void botonPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPlacasActionPerformed
        ConsultaPlaca v = new ConsultaPlaca();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonPlacasActionPerformed

    private void botonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReportesActionPerformed
        ConsultaPersonaTramite v = new ConsultaPersonaTramite();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonReportesActionPerformed

    private void botonConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultasActionPerformed
        ConsultaPersona v = new ConsultaPersona();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonConsultasActionPerformed

    private void botonPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPersonasActionPerformed
        IPersonaDAO a = new PersonaDAO();
        long numeroPersonas = a.contarPersonas();
        if (numeroPersonas >= 20) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Ya hay más de 20 personas registradas en la base de datos. ¿Quiere volver a ingresarlas?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                a.insertarPersonas();
                JOptionPane.showMessageDialog(null, "Se insertaron 20 personas exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            a.insertarPersonas();
            JOptionPane.showMessageDialog(null, "Se insertaron 20 personas exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonPersonasActionPerformed

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
    //            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (InstantiationException ex) {
    //            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (IllegalAccessException ex) {
    //            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        }
    //        //</editor-fold>
    //
    //        /* Create and display the form */
    //        java.awt.EventQueue.invokeLater(new Runnable() {
    //            public void run() {
    //                new Aplicacion().setVisible(true);
    //            }
    //        });
    //    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConsultas;
    private javax.swing.JButton botonLicencias;
    private javax.swing.JButton botonPersonas;
    private javax.swing.JButton botonPlacas;
    private javax.swing.JButton botonReportes;
    private javax.swing.JLabel labelAgencia;
    private javax.swing.JLabel labelOperacion;
    // End of variables declaration//GEN-END:variables

}
