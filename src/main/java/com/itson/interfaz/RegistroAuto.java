/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.interfaz;

import com.itson.dominio.Automovil;
import com.itson.dominio.Persona;
import com.itson.dominio.Vehiculo;
import java.sql.Connection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author arace
 */
public class RegistroAuto extends javax.swing.JFrame {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_ProyectoBDA_jar_1.0-SNAPSHOTPU");
    EntityManager em = emFactory.createEntityManager();
    
    /**
     * Creates new form RegistroPlacas
     */
    public RegistroAuto(java.awt.Frame parent, Vehiculo vh) {
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

        labelRegistro = new javax.swing.JLabel();
        textoModelo = new javax.swing.JTextField();
        textoSerie = new javax.swing.JTextField();
        textoColor = new javax.swing.JTextField();
        textoLinea = new javax.swing.JTextField();
        textoMarca = new javax.swing.JTextField();
        labelModelo = new javax.swing.JLabel();
        labelSerie = new javax.swing.JLabel();
        labelColor = new javax.swing.JLabel();
        labelLinea = new javax.swing.JLabel();
        labelMarca = new javax.swing.JLabel();
        botonRegristrar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelRegistro.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelRegistro.setText("Registro Auto");

        labelModelo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelModelo.setText("Modelo");

        labelSerie.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelSerie.setText("Serie");

        labelColor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelColor.setText("Color");

        labelLinea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelLinea.setText("Linea");

        labelMarca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelMarca.setText("Marca");

        botonRegristrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonRegristrar.setText("Registrar");
        botonRegristrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegristrarActionPerformed(evt);
            }
        });

        botonRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelModelo)
                            .addComponent(labelSerie)
                            .addComponent(labelColor)
                            .addComponent(labelLinea)
                            .addComponent(labelMarca))
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoModelo)
                            .addComponent(textoSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(textoColor)
                            .addComponent(textoLinea)
                            .addComponent(textoMarca)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(botonRegresar)
                        .addGap(40, 40, 40)
                        .addComponent(botonRegristrar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelRegistro)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelRegistro)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelModelo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSerie))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelColor)
                    .addComponent(textoColor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLinea)
                    .addComponent(textoLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMarca)
                    .addComponent(textoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegristrar)
                    .addComponent(botonRegresar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegristrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegristrarActionPerformed
      EntityManager em = emFactory.createEntityManager();

        em.getTransaction().begin();

        Vehiculo vh = new Vehiculo(){};
        
        vh.setModelo(textoModelo.getText());
        vh.setSerie(textoSerie.getText());
        vh.setColor(textoColor.getText());
        vh.setLinea(textoLinea.getText());
        vh.setMarca(textoMarca.getText());

        // Guarda la entidad en la base de datos
        em.persist(vh);

        // Confirma la transacción
        em.getTransaction().commit();

        // Cierra el EntityManager
        em.close();

   
    
           
       
    }//GEN-LAST:event_botonRegristrarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRegresarActionPerformed
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
    private javax.swing.JTextField textoColor;
    private javax.swing.JTextField textoLinea;
    private javax.swing.JTextField textoMarca;
    private javax.swing.JTextField textoModelo;
    private javax.swing.JTextField textoSerie;
    // End of variables declaration//GEN-END:variables

}
