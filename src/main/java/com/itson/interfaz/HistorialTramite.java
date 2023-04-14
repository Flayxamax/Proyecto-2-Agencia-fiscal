/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.interfaz;

import com.itson.dominio.Automovil;
import com.itson.dominio.Licencia;
import com.itson.dominio.Persona;
import com.itson.dominio.Placa;
import com.itson.implementaciones.LicenciaDAO;
import com.itson.implementaciones.PersonaDAO;
import com.itson.implementaciones.PlacaDAO;
import com.itson.implementaciones.VehiculoDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import utils.ConfiguracionPaginado;

/**
 *
 * @author ildex
 */
public class HistorialTramite extends javax.swing.JFrame {

    PersonaDAO a = new PersonaDAO();
    private final ConfiguracionPaginado configPaginado;
    private static final Logger LOG = Logger.getLogger(LicenciaDAO.class.getName());
    LicenciaDAO b = new LicenciaDAO();
    PlacaDAO c = new PlacaDAO();
    VehiculoDAO d = new VehiculoDAO();
    private final String rfc;

    /**
     * Creates new form HistorialTramite
     *
     * @param rfc
     */
    public HistorialTramite(String rfc) {
        initComponents();
        this.configPaginado = new ConfiguracionPaginado(0, 3);
        this.rfc = rfc;
        this.insertarDatosPersona();
        this.cargarTablaLicencia();
        this.cargarTablaPlaca();
        this.cargarTablaVehiculo();
    }

    private void insertarDatosPersona() {
        Persona persona = this.a.buscarPersonasRFC(rfc);
        lblPersona.setText("Persona: " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
    }

    private void cargarTablaLicencia() {
        Persona persona = a.buscarPersonasRFC(rfc);
        try {
            List<Licencia> listaLicencia = b.consultaLicencias(configPaginado, persona);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblLicencias.getModel();
            modeloTabla.setRowCount(0);
            for (Licencia licencia : listaLicencia) {
                Calendar fechaNacimiento = licencia.getFechaEmision();
                Date date = fechaNacimiento.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaE = sdf.format(date);
                Object[] fila = {
                    licencia.getTipoLicencia(),
                    licencia.getVigencia(),
                    licencia.getCosto(),
                    fechaE
                };
                modeloTabla.addRow(fila);
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    private void cargarTablaPlaca() {
        Persona persona = a.buscarPersonasRFC(rfc);
        try {
            List<Placa> listaPlaca = c.consultaPlacas(configPaginado, persona);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPlacas.getModel();
            modeloTabla.setRowCount(0);
            for (Placa placa : listaPlaca) {
                Calendar fechaNacimiento = placa.getFechaEmision();
                Date date = fechaNacimiento.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaE = sdf.format(date);
                Object[] fila = {
                    placa.getPlaca(),
                    placa.getEstado(),
                    placa.getCosto(),
                    placa.getAutomovil().getSerie(),
                    fechaE
                };
                modeloTabla.addRow(fila);
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    private void cargarTablaVehiculo() {
        Persona persona = a.buscarPersonasRFC(rfc);
        try {
            List<Automovil> listaAutomovil = d.consultaVehiculos(configPaginado, persona);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblVehiculos.getModel();
            modeloTabla.setRowCount(0);
            for (Automovil auto : listaAutomovil) {
                Object[] fila = {
                    auto.getSerie(),
                    auto.getMarca(),
                    auto.getLinea(),
                    auto.getColor(),
                    auto.getModelo()
                };
                modeloTabla.addRow(fila);
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    private void avanzarPagina() {
        this.configPaginado.avanzarPagina();
        this.cargarTablaLicencia();
    }

    private void retrocederPagina() {
        this.configPaginado.retrocederPagina();
        this.cargarTablaLicencia();
    }

    private void avanzarPaginaP() {
        this.configPaginado.avanzarPagina();
        this.cargarTablaPlaca();
    }

    private void retrocederPaginaP() {
        this.configPaginado.retrocederPagina();
        this.cargarTablaPlaca();
    }

    private void avanzarPaginaV() {
        this.configPaginado.avanzarPagina();
        this.cargarTablaVehiculo();
    }

    private void retrocederPaginaV() {
        this.configPaginado.retrocederPagina();
        this.cargarTablaVehiculo();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLicencias = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPlacas = new javax.swing.JTable();
        botonRegresar = new javax.swing.JButton();
        lblPersona = new javax.swing.JLabel();
        btnAvanzar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        btnAvanzarP = new javax.swing.JButton();
        btnRetrocederP = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        btnAvanzarV = new javax.swing.JButton();
        btnRetrocederV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Historial Tramites");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Módulo de consultas");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Licencias");

        tblLicencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "Vigencia", "Costo", "Fecha emisión"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLicencias.setShowGrid(true);
        tblLicencias.setShowHorizontalLines(false);
        tblLicencias.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblLicencias);
        if (tblLicencias.getColumnModel().getColumnCount() > 0) {
            tblLicencias.getColumnModel().getColumn(0).setResizable(false);
            tblLicencias.getColumnModel().getColumn(1).setResizable(false);
            tblLicencias.getColumnModel().getColumn(2).setResizable(false);
            tblLicencias.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Placas");

        tblPlacas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Placa", "Estado", "Costo", "Num. serie vehículo", "Fecha emisión"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPlacas.setShowHorizontalLines(false);
        tblPlacas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblPlacas);
        if (tblPlacas.getColumnModel().getColumnCount() > 0) {
            tblPlacas.getColumnModel().getColumn(0).setResizable(false);
            tblPlacas.getColumnModel().getColumn(1).setResizable(false);
            tblPlacas.getColumnModel().getColumn(2).setResizable(false);
            tblPlacas.getColumnModel().getColumn(3).setResizable(false);
            tblPlacas.getColumnModel().getColumn(4).setResizable(false);
        }

        botonRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        lblPersona.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnAvanzar.setText("Avanzar");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });

        btnRetroceder.setText("Retroceder");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });

        btnAvanzarP.setText("Avanzar");
        btnAvanzarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarPActionPerformed(evt);
            }
        });

        btnRetrocederP.setText("Retroceder");
        btnRetrocederP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederPActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Vehículos");

        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Num. serie", "Marca", "Línea", "Color", "Modelo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculos.setShowGrid(true);
        tblVehiculos.setShowHorizontalLines(false);
        tblVehiculos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblVehiculos);
        if (tblVehiculos.getColumnModel().getColumnCount() > 0) {
            tblVehiculos.getColumnModel().getColumn(0).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(1).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(2).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(3).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(4).setResizable(false);
        }

        btnAvanzarV.setText("Avanzar");
        btnAvanzarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarVActionPerformed(evt);
            }
        });

        btnRetrocederV.setText("Retroceder");
        btnRetrocederV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(138, 138, 138)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnRetrocederP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnAvanzarP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnRetrocederV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnAvanzarV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(botonRegresar))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(lblPersona))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(btnRetroceder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnAvanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGap(0, 245, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(lblPersona)
                .addGap(63, 63, 63)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRetroceder)
                    .addComponent(btnAvanzar))
                .addGap(53, 53, 53)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRetrocederP)
                    .addComponent(btnAvanzarP))
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRetrocederV)
                    .addComponent(btnAvanzarV))
                .addGap(74, 74, 74)
                .addComponent(botonRegresar)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        this.avanzarPagina();
    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        this.retrocederPagina();
    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void btnAvanzarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarPActionPerformed
        this.avanzarPaginaP();
    }//GEN-LAST:event_btnAvanzarPActionPerformed

    private void btnRetrocederPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederPActionPerformed
        this.retrocederPaginaP();
    }//GEN-LAST:event_btnRetrocederPActionPerformed

    private void btnAvanzarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarVActionPerformed
        this.avanzarPaginaV();
    }//GEN-LAST:event_btnAvanzarVActionPerformed

    private void btnRetrocederVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederVActionPerformed
        this.retrocederPaginaV();
    }//GEN-LAST:event_btnRetrocederVActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        ConsultaPersona v = new ConsultaPersona();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

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
//            java.util.logging.Logger.getLogger(HistorialTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HistorialTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HistorialTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HistorialTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HistorialTramite().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnAvanzarP;
    private javax.swing.JButton btnAvanzarV;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btnRetrocederP;
    private javax.swing.JButton btnRetrocederV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JTable tblLicencias;
    private javax.swing.JTable tblPlacas;
    private javax.swing.JTable tblVehiculos;
    // End of variables declaration//GEN-END:variables
}
