/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.interfaz;

import com.itson.dominio.Automovil;
import com.itson.dominio.CostoTramite;
import com.itson.dominio.Persona;
import com.itson.implementaciones.PersonaDAO;
import com.itson.implementaciones.PlacaDAO;
import com.itson.implementaciones.VehiculoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author arace
 */
public class RegistroAuto extends javax.swing.JFrame {

    private final String rfc;
    PersonaDAO a = new PersonaDAO();
    VehiculoDAO b = new VehiculoDAO();
    PlacaDAO c = new PlacaDAO();
    CostoTramite d = new CostoTramite();

    /**
     * Creates new form RegistroPlacas
     * @param rfc
     */
    public RegistroAuto(String rfc) {
        initComponents();
        this.rfc = rfc;
        this.insertarDatosPersona();
    }

    private void insertarDatosPersona() {
        Persona persona = this.a.buscarPersonasRFC(rfc);
        lblPersona.setText("Persona: " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno()+c.generarPlaca());
    }

    private Automovil extraerDatosFormulario() {
        String serie = txtSerie.getText();
        String marca = txtMarca.getText();
        String linea = txtLinea.getText();
        String color = txtColor.getText();
        Integer modelo = Integer.valueOf(txtModelo.getText());
        Automovil auto = new Automovil();
        auto.setSerie(serie);
        auto.setMarca(marca);
        auto.setLinea(linea);
        auto.setColor(color);
        auto.setModelo(modelo);
        return auto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelRegistro = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtLinea = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        labelModelo = new javax.swing.JLabel();
        labelSerie = new javax.swing.JLabel();
        labelColor = new javax.swing.JLabel();
        labelLinea = new javax.swing.JLabel();
        labelMarca = new javax.swing.JLabel();
        botonRegristrar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        lblPersona = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRegistro.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelRegistro.setText("Registro Auto");
        getContentPane().add(labelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 27, -1, -1));
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 350, 25));
        getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 350, 25));
        getContentPane().add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 350, 25));
        getContentPane().add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 350, 25));

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 350, 25));

        labelModelo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelModelo.setText("Modelo");
        getContentPane().add(labelModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        labelSerie.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelSerie.setText("Serie");
        getContentPane().add(labelSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        labelColor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelColor.setText("Color");
        getContentPane().add(labelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        labelLinea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelLinea.setText("Linea");
        getContentPane().add(labelLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        labelMarca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelMarca.setText("Marca");
        getContentPane().add(labelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        botonRegristrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonRegristrar.setText("Registrar");
        botonRegristrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegristrarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegristrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, -1, -1));

        botonRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, -1, -1));

        lblPersona.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegristrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegristrarActionPerformed
        Persona persona = a.buscarPersonasRFC(rfc);
        Automovil auto = this.extraerDatosFormulario();
        Double costo = d.placaNuevo;
        String placa = c.generarPlaca();
        b.registrarVehiculoPersona(auto, persona);
        c.insertarTramitePlacasNuevo(persona, auto, placa, costo);
        JOptionPane.showMessageDialog(null, "Se ha registrado el vehiculo:\n"
                + "Placa: "+placa+""
                        + "No. Serie: "+auto.getSerie()+"\n"
                                + "Marca: "+auto.getMarca()+"\n"
                                        + "Linea: "+auto.getLinea()+"\n"
                                                + "Color: "+auto.getColor()+"\n"
                                                        + "Modelo: "+auto.getModelo()+"", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonRegristrarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed
//
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
//            java.util.logging.Logger.getLogger(RegistroAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RegistroAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RegistroAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RegistroAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegistroAuto().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton botonRegristrar;
    private javax.swing.JLabel labelColor;
    private javax.swing.JLabel labelLinea;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelModelo;
    private javax.swing.JLabel labelRegistro;
    private javax.swing.JLabel labelSerie;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables

}
