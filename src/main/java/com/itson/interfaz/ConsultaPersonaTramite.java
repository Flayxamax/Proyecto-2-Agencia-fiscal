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
 *
 * @author ildex
 */
public class ConsultaPersonaTramite extends javax.swing.JFrame {
    /**
     * Creacion de los objetos de persona y personaDao, configuracion del paginado
     */
    private final IPersonaDAO a = new PersonaDAO();
    Persona persona = new Persona();
    private final ConfiguracionPaginado configPaginado;
    private static final Logger LOG = Logger.getLogger(PersonaDAO.class.getName());

    /**
     * From BusquedaLicencia
     */
    public ConsultaPersonaTramite() {
        initComponents();
        setResizable(false);
        this.configPaginado = new ConfiguracionPaginado(0, 5);
    }
    /**
     * Metodo que extrae los datos del formulario de la persona mediantye una lista
     * @return busca a las personas y las muestra con sus datos correspondientes
     */
    private List<Persona> extraerDatosFormularioPersona() {
        String RFC = txtRFC.getText();
        String nombre = txtNombre.getText();
        String ano = txtAno.getText();
        return a.buscarPersonas(configPaginado, RFC, nombre, ano);
    }
    /**
     * Metodo que carga la tabla de las personas 
     */
    private void cargarTablaPersona() {
        this.extraerDatosFormularioPersona();
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
     * Metodo que avanza hacia la siguiente pagina con configuracion del paginado
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
     * Metodo que valida la busqueda con los datos de la persona, en caso no exitir dichos parametros lanza un mensaje de error
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

        pnlLogo = new javax.swing.JPanel();
        labelOperacion = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        roundedPanel1 = new utils.RoundedPanel();
        labelBuscarParametros1 = new javax.swing.JLabel();
        labelRFC1 = new javax.swing.JLabel();
        roundedPanel2 = new utils.RoundedPanel();
        txtRFC = new javax.swing.JTextField();
        labelNombreCompleto1 = new javax.swing.JLabel();
        roundedPanel3 = new utils.RoundedPanel();
        txtNombre = new javax.swing.JTextField();
        labelFecha1 = new javax.swing.JLabel();
        roundedPanel4 = new utils.RoundedPanel();
        txtAno = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        btnAvanzar1 = new javax.swing.JButton();
        btnRetroceder1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersona = new javax.swing.JTable();
        botonSiguiente = new javax.swing.JButton();
        lblPersona = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de consultas: Consulta a personas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogo.setBackground(new java.awt.Color(7, 92, 79));

        labelOperacion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelOperacion.setForeground(new java.awt.Color(255, 255, 255));
        labelOperacion.setText("Módulo de reportes: Consulta a personas");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 576, Short.MAX_VALUE)
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

        labelBuscarParametros1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelBuscarParametros1.setForeground(new java.awt.Color(0, 0, 0));
        labelBuscarParametros1.setText("Buscar parametros:");
        roundedPanel1.add(labelBuscarParametros1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        labelRFC1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelRFC1.setForeground(new java.awt.Color(0, 0, 0));
        labelRFC1.setText("RFC");
        roundedPanel1.add(labelRFC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

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

        labelNombreCompleto1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelNombreCompleto1.setForeground(new java.awt.Color(0, 0, 0));
        labelNombreCompleto1.setText("Nombre completo");
        roundedPanel1.add(labelNombreCompleto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

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

        labelFecha1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelFecha1.setForeground(new java.awt.Color(0, 0, 0));
        labelFecha1.setText("Año nacimiento");
        roundedPanel1.add(labelFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

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

        btnBuscar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, -1, 40));

        btnAvanzar1.setText("Avanzar");
        btnAvanzar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzar1ActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnAvanzar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 100, -1));

        btnRetroceder1.setText("Retroceder");
        btnRetroceder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetroceder1ActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnRetroceder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 100, -1));

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

        roundedPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 810, 110));

        botonSiguiente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonSiguiente.setText("Siguiente");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });
        roundedPanel1.add(botonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, -1, -1));

        jPanel1.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 1020, 430));

        lblPersona.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1120, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton que hace funcion de siguiente en el apartado de consultar personas mediante rfc 
     * @param evt accion a realizar
     */
    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        if (tblPersona.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String RFC = tblPersona.getValueAt(tblPersona.getSelectedRow(), 0).toString();
            ReporteTramite v = new ReporteTramite(RFC);
            v.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_botonSiguienteActionPerformed

    /**
     * Boton que regresa a la interfaz Aplicacion
     * @param evt accion a realizar
     */
    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        Aplicacion v = new Aplicacion();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    /**
     *Boton que cambia el cursor "mano" cuando el mouse se posiciona sobre le boton regresar
     * @param evt accion a realizar
     */
    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseEntered

    /**
     * Boton que cambia el cursor por el cursor del defecto cuando el mouse sale del area del boton regresar
     * @param evt accion a realizar
     */
    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseExited

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoActionPerformed

    /**
     * Boton que se encarga de buscar los datos de la persona
     * @param evt accion a realizar
     */
    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        this.validaBusqueda();
        this.cargarTablaPersona();
    }//GEN-LAST:event_btnBuscar1ActionPerformed
/**
 * Boton que avanza a la siguiente tabla
 * @param evt accion a realizar
 */
    private void btnAvanzar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzar1ActionPerformed
        this.avanzarPagina();
    }//GEN-LAST:event_btnAvanzar1ActionPerformed

    /**
     * Boton que retrocede de la tabla
     * @param evt acciona a realizar
     */
    private void btnRetroceder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetroceder1ActionPerformed
        this.retrocederPagina();
    }//GEN-LAST:event_btnRetroceder1ActionPerformed

    /**
     * Campo de texto donde se debe colocar el RFC de la persona
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
    private javax.swing.JButton btnAvanzar1;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JButton btnRetroceder1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscarParametros1;
    private javax.swing.JLabel labelFecha1;
    private javax.swing.JLabel labelNombreCompleto1;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JLabel labelRFC1;
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
