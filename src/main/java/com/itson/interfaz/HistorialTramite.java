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
import java.awt.Cursor;
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
        setResizable(false);
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

        lblPersona = new javax.swing.JLabel();
        pnlLogo = new javax.swing.JPanel();
        labelOperacion = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        roundedPanel1 = new utils.RoundedPanel();
        lblOpcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLicencias = new javax.swing.JTable();
        btnAvanzar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        lblOpcion1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPlacas = new javax.swing.JTable();
        btnAvanzarP = new javax.swing.JButton();
        btnRetrocederP = new javax.swing.JButton();
        lblOpcion2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        btnAvanzarV = new javax.swing.JButton();
        btnRetrocederV = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblPersona1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de consultas: Historial trámite");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPersona.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 123, -1, -1));

        pnlLogo.setBackground(new java.awt.Color(7, 92, 79));

        labelOperacion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelOperacion.setForeground(new java.awt.Color(255, 255, 255));
        labelOperacion.setText("Módulo de consultas: Historial trámite");

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha-izquierda (1).png"))); // NOI18N
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegresarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelOperacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 607, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(42, 42, 42))
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar)
                    .addComponent(labelOperacion))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 90));

        jPanel1.setBackground(new java.awt.Color(15, 153, 139));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setRoundBottomLeft(50);
        roundedPanel1.setRoundBottomRight(50);
        roundedPanel1.setRoundTopLeft(50);
        roundedPanel1.setRoundTopRight(50);
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOpcion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblOpcion.setForeground(new java.awt.Color(0, 0, 0));
        lblOpcion.setText("Licencias");
        roundedPanel1.add(lblOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

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

        roundedPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, 71));

        btnAvanzar.setText("Avanzar");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnAvanzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 100, -1));

        btnRetroceder.setText("Retroceder");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 100, -1));

        lblOpcion1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblOpcion1.setForeground(new java.awt.Color(0, 0, 0));
        lblOpcion1.setText("Vehículos");
        roundedPanel1.add(lblOpcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, -1, -1));

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

        roundedPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 813, 71));

        btnAvanzarP.setText("Avanzar");
        btnAvanzarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarPActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnAvanzarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 100, -1));

        btnRetrocederP.setText("Retroceder");
        btnRetrocederP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederPActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnRetrocederP, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 100, -1));

        lblOpcion2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblOpcion2.setForeground(new java.awt.Color(0, 0, 0));
        lblOpcion2.setText("Placas");
        roundedPanel1.add(lblOpcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

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

        roundedPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, -1, 72));

        btnAvanzarV.setText("Avanzar");
        btnAvanzarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarVActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnAvanzarV, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 600, 100, -1));

        btnRetrocederV.setText("Retroceder");
        btnRetrocederV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederVActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnRetrocederV, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, 100, -1));
        roundedPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 820, 10));
        roundedPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 820, 10));

        jPanel1.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1020, 660));

        lblPersona1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(lblPersona1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1120, 740));

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

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        ConsultaPersona v = new ConsultaPersona();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseEntered

    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseExited

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
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnAvanzarP;
    private javax.swing.JButton btnAvanzarV;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btnRetrocederP;
    private javax.swing.JButton btnRetrocederV;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JLabel lblOpcion;
    private javax.swing.JLabel lblOpcion1;
    private javax.swing.JLabel lblOpcion2;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JLabel lblPersona1;
    private javax.swing.JPanel pnlLogo;
    private utils.RoundedPanel roundedPanel1;
    private javax.swing.JTable tblLicencias;
    private javax.swing.JTable tblPlacas;
    private javax.swing.JTable tblVehiculos;
    // End of variables declaration//GEN-END:variables
}
