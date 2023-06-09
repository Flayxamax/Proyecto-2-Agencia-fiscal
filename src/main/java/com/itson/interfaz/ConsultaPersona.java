package com.itson.interfaz;

import com.itson.dominio.Persona;
import com.itson.implementaciones.PersonaDAO;
import interfaces.IPersonaDAO;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.ConfiguracionPaginado;

/**
 * Interfaz consulta Persona
 *
 * @author ildex
 */
public class ConsultaPersona extends javax.swing.JFrame {

    /**
     * Creacion de los objetos de persona y personaDao, configuracion del
     * paginado
     */
    private final IPersonaDAO a = new PersonaDAO();
    Persona persona = new Persona();
    private final ConfiguracionPaginado configPaginado;
    private static final Logger LOG = Logger.getLogger(PersonaDAO.class.getName());

    /**
     * Form BusquedaLicencia
     */
    public ConsultaPersona() {
        this.configPaginado = new ConfiguracionPaginado(0, 5);
        initComponents();
        setResizable(false);
    }

    /**
     * Metodo que extraer los datos de las personas en formato de lista
     *
     * @return buscar persona
     */
    private List<Persona> extraerDatosFormularioPersona() {
        String RFC = txtRFC.getText();
        String nombre = txtNombre.getText();
        String ano = txtAno.getText();
        return a.buscarPersonas(configPaginado, RFC, nombre, ano);
    }

    /**
     * Metodo que carga una tablas de las personas mediante una lista
     */
    private void cargarTablaPersona() {
        try {
            List<Persona> listaPersona = this.extraerDatosFormularioPersona();
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPersona.getModel();
            modeloTabla.setRowCount(0);
            for (Persona persona : listaPersona) {
                Calendar fechaNacimiento = persona.getFechaNacimiento();
                Date date = fechaNacimiento.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaN = sdf.format(date);
                Object[] fila = {
                    persona.getRfc(),
                    persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno(),
                    fechaN,
                    persona.getTelefono()
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
        this.cargarTablaPersona();
    }

    /**
     * Metodo que retrocede la pagina con la consifuracion del paginado
     */
    private void retrocederPagina() {
        this.configPaginado.retrocederPagina();
        this.cargarTablaPersona();
    }

    /**
     * Metodo que valida la busqueda con los datos de la persona, en caso no
     * exitir dichos parametros lanza un mensaje de error
     */
    private void validaBusqueda() {
        if (this.extraerDatosFormularioPersona().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado ni una persona con los parametros buscados dentro del sistema", "ERROR", JOptionPane.ERROR_MESSAGE);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlLogo = new javax.swing.JPanel();
        labelOperacion = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        roundedPanel1 = new utils.RoundedPanel();
        labelBuscarParametros = new javax.swing.JLabel();
        labelRFC = new javax.swing.JLabel();
        roundedPanel2 = new utils.RoundedPanel();
        txtRFC = new javax.swing.JTextField();
        labelNombreCompleto = new javax.swing.JLabel();
        roundedPanel3 = new utils.RoundedPanel();
        txtNombre = new javax.swing.JTextField();
        labelFecha = new javax.swing.JLabel();
        roundedPanel4 = new utils.RoundedPanel();
        txtAno = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersona = new javax.swing.JTable();
        btnAvanzar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        lblPersona = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de consultas: Consulta a personas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogo.setBackground(new java.awt.Color(7, 92, 79));

        labelOperacion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelOperacion.setForeground(new java.awt.Color(255, 255, 255));
        labelOperacion.setText("Módulo de consultas: Consulta a personas");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 566, Short.MAX_VALUE)
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

        labelBuscarParametros.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelBuscarParametros.setForeground(new java.awt.Color(0, 0, 0));
        labelBuscarParametros.setText("Buscar parametros:");
        roundedPanel1.add(labelBuscarParametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        labelRFC.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelRFC.setForeground(new java.awt.Color(0, 0, 0));
        labelRFC.setText("RFC");
        roundedPanel1.add(labelRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        roundedPanel2.setBackground(new java.awt.Color(204, 204, 204));
        roundedPanel2.setRoundBottomLeft(50);
        roundedPanel2.setRoundBottomRight(50);
        roundedPanel2.setRoundTopLeft(50);
        roundedPanel2.setRoundTopRight(50);

        txtRFC.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtRFC.setForeground(new java.awt.Color(0, 0, 0));
        txtRFC.setBorder(null);
        txtRFC.setOpaque(false);
        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });
        txtRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRFCKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtRFC, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRFC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        roundedPanel1.add(roundedPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 210, 40));

        labelNombreCompleto.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelNombreCompleto.setForeground(new java.awt.Color(0, 0, 0));
        labelNombreCompleto.setText("Nombre completo");
        roundedPanel1.add(labelNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        roundedPanel3.setBackground(new java.awt.Color(204, 204, 204));
        roundedPanel3.setRoundBottomLeft(50);
        roundedPanel3.setRoundBottomRight(50);
        roundedPanel3.setRoundTopLeft(50);
        roundedPanel3.setRoundTopRight(50);

        txtNombre.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(null);
        txtNombre.setOpaque(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout roundedPanel3Layout = new javax.swing.GroupLayout(roundedPanel3);
        roundedPanel3.setLayout(roundedPanel3Layout);
        roundedPanel3Layout.setHorizontalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundedPanel3Layout.setVerticalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        roundedPanel1.add(roundedPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 420, 40));

        labelFecha.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(0, 0, 0));
        labelFecha.setText("Año nacimiento");
        roundedPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        roundedPanel4.setBackground(new java.awt.Color(204, 204, 204));
        roundedPanel4.setRoundBottomLeft(50);
        roundedPanel4.setRoundBottomRight(50);
        roundedPanel4.setRoundTopLeft(50);
        roundedPanel4.setRoundTopRight(50);

        txtAno.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtAno.setForeground(new java.awt.Color(0, 0, 0));
        txtAno.setBorder(null);
        txtAno.setOpaque(false);
        txtAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoActionPerformed(evt);
            }
        });
        txtAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout roundedPanel4Layout = new javax.swing.GroupLayout(roundedPanel4);
        roundedPanel4.setLayout(roundedPanel4Layout);
        roundedPanel4Layout.setHorizontalGroup(
            roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundedPanel4Layout.setVerticalGroup(
            roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        roundedPanel1.add(roundedPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 150, -1));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, -1, 40));

        tblPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RFC", "Nombres(s)", "Fecha de nacimiento", "Teléfono"
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
        tblPersona.setMaximumSize(new java.awt.Dimension(214748347, 0));
        tblPersona.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPersona.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPersona.setShowGrid(false);
        tblPersona.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPersona);
        if (tblPersona.getColumnModel().getColumnCount() > 0) {
            tblPersona.getColumnModel().getColumn(0).setResizable(false);
            tblPersona.getColumnModel().getColumn(1).setResizable(false);
            tblPersona.getColumnModel().getColumn(2).setResizable(false);
            tblPersona.getColumnModel().getColumn(3).setResizable(false);
        }

        roundedPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 810, 110));

        btnAvanzar.setText("Avanzar");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnAvanzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 100, -1));

        btnRetroceder.setText("Retroceder");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 100, -1));

        botonSiguiente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonSiguiente.setText("Siguiente");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });
        roundedPanel1.add(botonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, -1));

        jPanel1.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 1020, 430));

        lblPersona.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1120, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton que busca a la persona
     *
     * @param evt la accion
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.validaBusqueda();
        this.cargarTablaPersona();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoActionPerformed

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed

    /**
     * Boton siguiente que redirige hacia otra intefaz
     *
     * @param evt la accion a redigir hacia otra interfaz
     */
    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        if (tblPersona.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String RFC = tblPersona.getValueAt(tblPersona.getSelectedRow(), 0).toString();
            HistorialTramite v = new HistorialTramite(RFC);
            v.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    /**
     * Boton que avanza la pagina
     *
     * @param evt acciona a realizar
     */
    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        this.avanzarPagina();
    }//GEN-LAST:event_btnAvanzarActionPerformed

    /**
     * Boton que retrocede la pagina
     *
     * @param evt acciona a realizar
     */
    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        this.retrocederPagina();
    }//GEN-LAST:event_btnRetrocederActionPerformed

    /**
     * Boton que regresa a la Interfaz Aplicacion
     *
     * @param evt la accion de regresar
     */
    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        Aplicacion v = new Aplicacion();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    /**
     * Camnbia el cursor por defecto cuando el mouse entra del ares del boton
     * regresar
     *
     * @param evt
     */
    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseEntered

    /**
     * Camnbia el cursor por defecto cuando el mouse sale del ares del boton
     * regresar
     *
     * @param evt
     */
    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseExited

    /**
     * Campo de texto donde se debe colocar el RFC de la persona
     *
     * @param evt el campo de texto
     */
    private void txtRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyTyped
        char car = evt.getKeyChar();
        if (!Character.isLetterOrDigit(car) && txtRFC.getText().length() >= 13) {
            evt.consume();
        } else if (txtRFC.getText().length() >= 13 && !Character.isDigit(car)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRFCKeyTyped

    /**
     * Campo de texto donde se debe colocar el Nombre de la persona
     *
     * @param evt el campo de texto
     */
    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char car = evt.getKeyChar();
        if (!Character.isLetter(car) && txtNombre.getText().length() >= 300) {
            evt.consume();
        } else if (txtNombre.getText().length() >= 300 && Character.isDigit(car)) {
            evt.consume();
        } else if (Character.isDigit(car)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    /**
     * Campo de texto donde se debe colocar la fecha de nacimiento de la persona
     *
     * @param evt el campo de texto
     */
    private void txtAnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoKeyTyped
        char car = evt.getKeyChar();
        if (!Character.isDigit(car)) {
            evt.consume();
        } else if (txtAno.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAnoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscarParametros;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelNombreCompleto;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JLabel labelRFC;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JPanel pnlLogo;
    private utils.RoundedPanel roundedPanel1;
    private utils.RoundedPanel roundedPanel2;
    private utils.RoundedPanel roundedPanel3;
    private utils.RoundedPanel roundedPanel4;
    private javax.swing.JTable tblPersona;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
