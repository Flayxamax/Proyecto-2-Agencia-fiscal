/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.interfaz;

import com.itson.dominio.Persona;
import com.itson.dominio.TipoTramite;
import com.itson.dominio.Tramite;
import com.itson.implementaciones.LicenciaDAO;
import com.itson.implementaciones.PersonaDAO;
import com.itson.implementaciones.TramiteDAO;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import utils.ConfiguracionPaginado;

/**
 *
 * @author ildex
 */
public class ReporteTramite extends javax.swing.JFrame {

    PersonaDAO a = new PersonaDAO();
    private final ConfiguracionPaginado configPaginado;
    private static final Logger LOG = Logger.getLogger(LicenciaDAO.class.getName());
    TramiteDAO b = new TramiteDAO();
    private final String rfc;

    /**
     * Creates new form HistorialTramite
     *
     * @param rfc
     */
    public ReporteTramite(String rfc) {
        initComponents();
        this.configPaginado = new ConfiguracionPaginado(0, 5);
        this.rfc = rfc;
        this.insertarDatosPersona();
    }

    private void insertarDatosPersona() {
        Persona persona = this.a.buscarPersonasRFC(rfc);
        lblPersona.setText("Persona: " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
    }

    private Date sacarFechaDesde() {
        LocalDate fechaD = this.dpDesde.getDate();
        Date fechaDesde = new Date(fechaD.getYear() - 1900, fechaD.getMonthValue() - 1, fechaD.getDayOfMonth());
        return fechaDesde;
    }

    private Date sacarFechaHasta() {
        LocalDate fechaH = this.dpHasta.getDate();
        Date fechaHasta = new Date(fechaH.getYear() - 1900, fechaH.getMonthValue() - 1, fechaH.getDayOfMonth());
        return fechaHasta;
    }

    private TipoTramite tipo() {
        String opcion = (String) cbTramite.getSelectedItem();
        TipoTramite tipo;
        if (opcion.equals("Licencia")) {
            tipo = TipoTramite.Licencia;
        } else {
            tipo = TipoTramite.Placa;
        }
        return tipo;
    }

    private void cargarTablaLicencia() {
        Persona persona = a.buscarPersonasRFC(rfc);
        try {
            List<Tramite> listaTramite = b.buscarTramites(configPaginado, persona, this.tipo(), this.sacarFechaDesde(), this.sacarFechaHasta());
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblTramite.getModel();
            modeloTabla.setRowCount(0);
            for (Tramite tramite : listaTramite) {
                Calendar fechaNacimiento = tramite.getFechaEmision();
                Date date = fechaNacimiento.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaE = sdf.format(date);
                Object[] fila = {
                    tramite.getTipo(),
                    tramite.getCosto(),
                    fechaE
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

    private void generacionReporte() {
        try {
            Persona persona = a.buscarPersonasRFC(rfc);
            List<Tramite> listaTramite = b.buscarTramites(configPaginado, persona, this.tipo(), this.sacarFechaDesde(), this.sacarFechaHasta());
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile("src/main/resources/reports/ReporteAgenciaFiscal.jasper");
            List<Map<String, Object>> listaParametros = new ArrayList<>();

            for (Tramite tramite : listaTramite) {
                Calendar fechaNacimiento = tramite.getFechaEmision();
                Date date = fechaNacimiento.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaE = sdf.format(date);
                HashMap<String, Object> parametro = new HashMap<>();
                parametro.put("nombrePersona", persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
                parametro.put("tipoTramite", tramite.getTipo().toString());
                parametro.put("costo", tramite.getCosto());
                parametro.put("fechaEmision", fechaE);
                listaParametros.add(parametro);
            }
            JRBeanCollectionDataSource datos = new JRBeanCollectionDataSource(listaParametros);
            JasperPrint informe = JasperFillManager.fillReport(jr, null, datos);
            JasperViewer jv = new JasperViewer(informe, false);
            jv.setVisible(true);
        } catch (JRException e) {
            e.getMessage();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramite = new javax.swing.JTable();
        dpDesde = new com.github.lgooddatepicker.components.DatePicker();
        lblPersona = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dpHasta = new com.github.lgooddatepicker.components.DatePicker();
        jLabel6 = new javax.swing.JLabel();
        cbTramite = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        botonReporte = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAvanzar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Reporte de trámites realizados");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        jLabel2.setText("Módulo de reportes");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLabel3.setText("Tramite");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, 40));

        tblTramite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Tipo", "Costo", "Fecha emisión"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblTramite.setShowGrid(true);
        tblTramite.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTramite);
        if (tblTramite.getColumnModel().getColumnCount() > 0) {
            tblTramite.getColumnModel().getColumn(0).setResizable(false);
            tblTramite.getColumnModel().getColumn(1).setResizable(false);
            tblTramite.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, 120));
        getContentPane().add(dpDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, 30));

        lblPersona.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jLabel5.setText("Desde");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));
        getContentPane().add(dpHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, 30));

        jLabel6.setText("Hasta");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        cbTramite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Licencia", "Placa" }));
        cbTramite.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(cbTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 110, 30));

        jLabel7.setText("Tipo tramite");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        botonRegresar.setText("Regresar");
        botonRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, -1, -1));

        botonReporte.setText("Generar reporte");
        botonReporte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteActionPerformed(evt);
            }
        });
        getContentPane().add(botonReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 485, -1, 40));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, -1, -1));

        btnAvanzar.setText("Avanzar");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAvanzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 100, -1));

        btnRetroceder.setText("Retroceder");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        getContentPane().add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 100, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteActionPerformed
        this.generacionReporte();
    }//GEN-LAST:event_botonReporteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.cargarTablaLicencia();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        this.avanzarPagina();
    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        this.retrocederPagina();
    }//GEN-LAST:event_btnRetrocederActionPerformed

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
//            java.util.logging.Logger.getLogger(ReporteTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ReporteTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ReporteTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ReporteTramite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ReporteTramite().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton botonReporte;
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JComboBox<String> cbTramite;
    private com.github.lgooddatepicker.components.DatePicker dpDesde;
    private com.github.lgooddatepicker.components.DatePicker dpHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JTable tblTramite;
    // End of variables declaration//GEN-END:variables
}
