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
import interfaces.IPersonaDAO;
import interfaces.ITramiteDAO;
import java.awt.Cursor;
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
import javax.swing.JOptionPane;
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
 * Interfaz reporte de tramite
 *
 * @author ildex
 */
public class ReporteTramite extends javax.swing.JFrame {

    private final IPersonaDAO a = new PersonaDAO();
    private final ConfiguracionPaginado configPaginado;
    private static final Logger LOG = Logger.getLogger(LicenciaDAO.class.getName());
    private final ITramiteDAO b = new TramiteDAO();
    private final String rfc;

    /**
     * Form HistorialTramite
     *
     * @param rfc de la persona
     */
    public ReporteTramite(String rfc) {
        initComponents();
        setResizable(false);
        this.configPaginado = new ConfiguracionPaginado(0, 5);
        this.rfc = rfc;
        this.insertarDatosPersona();
        LocalDate fechaActual = LocalDate.now();
        LocalDate minFecha = LocalDate.of(1900, 01, 01);
        dpHasta.getSettings().setDateRangeLimits(minFecha, fechaActual);
        dpDesde.getComponentDateTextField().setEnabled(false);
        dpHasta.getComponentDateTextField().setEnabled(false);
    }

    /**
     * Metodo que inserta los datos de la persona
     */
    private void insertarDatosPersona() {
        Persona persona = this.a.buscarPersonasRFC(rfc);
        lblPersona.setText("Persona: " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
    }

    /**
     * Metodo que obtiene la fecha desde en el reporte de tramite
     *
     * @return la fecha desde que se hiso el tramite
     */
    private Date sacarFechaDesde() {
        LocalDate fechaD = this.dpDesde.getDate();
        Date fechaDesde = new Date(fechaD.getYear() - 1900, fechaD.getMonthValue() - 1, fechaD.getDayOfMonth());
        return fechaDesde;
    }

    /**
     * Metodo obtiene la fecha hasta en el reporte de tramite
     *
     * @return la fecha hasta que se hiso el tramite
     */
    private Date sacarFechaHasta() {
        LocalDate fechaH = this.dpHasta.getDate();
        Date fechaHasta = new Date(fechaH.getYear() - 1900, fechaH.getMonthValue() - 1, fechaH.getDayOfMonth());
        return fechaHasta;
    }

    /**
     * Metodo que indica que tipo de tramite desea hacer el reporte
     *
     * @return
     */
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

    /**
     * Metodo que carga la tabla de la licencia
     */
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

    /**
     * Metodo que avanza hacia la siguiente pagina con configuracion del
     * paginado
     */
    private void avanzarPagina() {
        this.configPaginado.avanzarPagina();
        this.cargarTablaLicencia();
    }

    /**
     * Metodo que retrocede la pagina con configuracion del paginado
     */
    private void retrocederPagina() {
        this.configPaginado.retrocederPagina();
        this.cargarTablaLicencia();
    }

    /**
     * Metodo que se encarga de la generacion del reporte en PDF
     */
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
     * Metodo que valida todos los datos de la busqueda
     */
    private void validaBusqueda() {
        Persona persona = a.buscarPersonasRFC(rfc);
        if (b.buscarTramites(configPaginado, persona, this.tipo(), this.sacarFechaDesde(), this.sacarFechaHasta()) == null) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado trámites con los parametros buscados", "ERROR", JOptionPane.ERROR_MESSAGE);
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

        pnlLogo = new javax.swing.JPanel();
        labelOperacion = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        roundedPanel1 = new utils.RoundedPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramite = new javax.swing.JTable();
        dpDesde = new com.github.lgooddatepicker.components.DatePicker();
        jLabel5 = new javax.swing.JLabel();
        dpHasta = new com.github.lgooddatepicker.components.DatePicker();
        jLabel6 = new javax.swing.JLabel();
        cbTramite = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        botonReporte = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAvanzar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        lblPersona1 = new javax.swing.JLabel();
        lblPersona = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de reportes: Generar reporte");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogo.setBackground(new java.awt.Color(7, 92, 79));

        labelOperacion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelOperacion.setForeground(new java.awt.Color(255, 255, 255));
        labelOperacion.setText("Módulo de reportes: Generar reporte");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
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

        getContentPane().add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 90));

        jPanel1.setBackground(new java.awt.Color(15, 153, 139));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setRoundBottomLeft(50);
        roundedPanel1.setRoundBottomRight(50);
        roundedPanel1.setRoundTopLeft(50);
        roundedPanel1.setRoundTopRight(50);
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Tramite");
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        roundedPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, 40));

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

        roundedPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, 110));
        roundedPanel1.add(dpDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, 30));

        jLabel5.setText("Desde");
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        roundedPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));
        roundedPanel1.add(dpHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, 30));

        jLabel6.setText("Hasta");
        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        roundedPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        cbTramite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Licencia", "Placa" }));
        cbTramite.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roundedPanel1.add(cbTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 110, 30));

        jLabel7.setText("Tipo tramite");
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        roundedPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        botonReporte.setText("Generar reporte");
        botonReporte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteActionPerformed(evt);
            }
        });
        roundedPanel1.add(botonReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, 30));

        btnAvanzar.setText("Avanzar");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnAvanzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 100, -1));

        btnRetroceder.setText("Retroceder");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 100, -1));

        jPanel1.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 720, 420));

        lblPersona1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(lblPersona1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, 30));

        lblPersona.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 820, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que primero que hace es buscar una persona en un sistema a través
     * de su RFC, comprueba si se han ingresado fechas de inicio y fin para la
     * búsqueda. Si no se han ingresado fechas, muestra un mensaje de error.
     *
     * @param evt accion a realizar
     */
    private void botonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteActionPerformed
        Persona persona = a.buscarPersonasRFC(rfc);
        if (dpDesde.getDate() == null) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado una fecha desde", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (dpHasta.getDate() == null) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado una fecha hasta", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (b.buscarTramites(configPaginado, persona, this.tipo(), this.sacarFechaDesde(), this.sacarFechaHasta()) == null) {
            JOptionPane.showMessageDialog(null, "No se puede generar reporte, favor de buscar tramites con los parametros correspondientes", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            this.generacionReporte();
        }
    }//GEN-LAST:event_botonReporteActionPerformed

    /**
     * Método que se ejecuta al hacer clic en el botón de buscar. Verifica que
     * se haya ingresado una fecha desde y una fecha hasta, y llama a los
     * métodos
     *
     * @param evt accion a realizr
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (dpDesde.getDate() == null) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado una fecha desde", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (dpHasta.getDate() == null) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado una fecha hasta", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            this.validaBusqueda();
            this.cargarTablaLicencia();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * Boton que avanza de pagina
     *
     * @param evt accion a realizar
     */
    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        this.avanzarPagina();
    }//GEN-LAST:event_btnAvanzarActionPerformed

    /**
     * Boton que retrocede de pagina
     *
     * @param evt accion a realizar
     */
    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        this.retrocederPagina();
    }//GEN-LAST:event_btnRetrocederActionPerformed

    /**
     * Boton que regresa a persona consulta tramite
     *
     * @param evt accion a realizar
     */
    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        ConsultaPersonaTramite v = new ConsultaPersonaTramite();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    /**
     * Cambia el cursor del estilo "mano" cuando el mouse se posiciona sobre el
     * boton regresar
     *
     * @param evt evento del mouse
     */
    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseEntered

    /**
     * Cambia el cursor al cursor por defecto cuando el mouse sale del área del
     * botón regresar
     *
     * @param evt evento del mouse
     */
    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonReporte;
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JComboBox<String> cbTramite;
    private com.github.lgooddatepicker.components.DatePicker dpDesde;
    private com.github.lgooddatepicker.components.DatePicker dpHasta;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JLabel lblPersona1;
    private javax.swing.JPanel pnlLogo;
    private utils.RoundedPanel roundedPanel1;
    private javax.swing.JTable tblTramite;
    // End of variables declaration//GEN-END:variables
}
