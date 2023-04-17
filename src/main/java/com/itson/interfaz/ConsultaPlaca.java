package com.itson.interfaz;

import com.itson.dominio.Persona;
import com.itson.implementaciones.LicenciaDAO;
import com.itson.implementaciones.PersonaDAO;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import utils.Validadores;

/**
 * Interfaz consulta de placas
 * @author aracelyC
 */
public class ConsultaPlaca extends javax.swing.JFrame {

    PersonaDAO a = new PersonaDAO();
    LicenciaDAO b = new LicenciaDAO();
    private final Validadores validadores = new Validadores();

    /**
     * From ConsultaPlaca
     */
    public ConsultaPlaca() {
        initComponents();
        setResizable(false);
        this.validadOperacion();
    }

    private void validadOperacion() {
        if (lblNombreI.getText().isBlank()) {
            btnSiguiente.setEnabled(false);
        } else {
            btnSiguiente.setEnabled(true);
        }
    }
    /**
     * Metodo que extrae los datos del formulario de la persona mediante el RFC
     * @return persona
     */
    private Persona extraerDatosFormulario() {
        String RFC = txtRFC.getText();
        Persona persona = a.buscarPersonasRFC(RFC);
        return persona;
    }
    /**
     * Metodo que inserta los datos de la persona mediante teclado
     */
    private void insertarDatospersona() {
        Persona persona = this.extraerDatosFormulario();
        lblNombreI.setText(persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
        lblTelefonoI.setText(persona.getTelefono());
        Calendar fechaNacimiento = persona.getFechaNacimiento();
        Date date = fechaNacimiento.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaN = sdf.format(date);
        lblFechaNI.setText(fechaN);

        LocalDate fechaNacimientoLocal = LocalDate.of(fechaNacimiento.get(Calendar.YEAR),
                fechaNacimiento.get(Calendar.MONTH) + 1,
                fechaNacimiento.get(Calendar.DAY_OF_MONTH));
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(fechaNacimientoLocal, fechaActual).getYears();
        lblEdadI.setText(String.valueOf(edad));
        if (b.validarLicenciaVigente(persona.getRfc()) == true) {
            lblLicencia.setText("Licencia: Vigente");
        } else {
            lblLicencia.setText("Licencia: No vigente");
        }
    }
    /**
     * Metodo que valida la edad de la persona
     * @return la edad
     */
    private boolean validarEdad() {
        boolean mayorEdad = false;
        String eda = lblEdadI.getText();
        int edad = Integer.parseInt(eda);
        return mayorEdad = edad >= 18;
    }
    /**
     * Metodo que valida los datos de la persona, en caso de no ingrese un RFC y la edad correspondiente, lanza un mensaje de error
     */
    private void validaDatosPersona() {
        if (txtRFC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No has ingresado un RFC a consultar", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (a.validarPersonaRFC(txtRFC.getText()) != true) {
            JOptionPane.showMessageDialog(null, "El RFC ingresado no es valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (this.validarEdad() == true) {
            if (b.validarLicenciaVigente(txtRFC.getText()) == true) {
                CostosPlacas v = new CostosPlacas(txtRFC.getText());
                v.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No tiene o no se encontró una licencia vigente para la persona con el RFC: " + txtRFC.getText(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Esta persona no puede tramitar licencia por menor de edad permitida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Metodo que valida la busqueda con los datos de la persona, en caso no exitir, no haberse ingresado o no es valido los parametros lanza un mensaje de error
     */
    private void validaDatosBuscar(){
        if (txtRFC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ha ingresado un RFC a consultar", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (a.validarPersonaRFC(txtRFC.getText()) != true) {
            JOptionPane.showMessageDialog(null, "El RFC ingresado no es valido", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!validadores.validaRfc(txtRFC.getText())) {
            this.insertarDatospersona();
            this.validadOperacion();
        } else {
            JOptionPane.showMessageDialog(null, "El RFC ingresado no es valido", "Error", JOptionPane.ERROR_MESSAGE);
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
        labelOperacion1 = new javax.swing.JLabel();
        roundedPanel2 = new utils.RoundedPanel();
        txtRFC = new javax.swing.JTextField();
        roundedPanel3 = new utils.RoundedPanel();
        lblNombre = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblFechaN = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblFechaNI = new javax.swing.JLabel();
        lblNombreI = new javax.swing.JLabel();
        lblEdadI = new javax.swing.JLabel();
        lblTelefonoI = new javax.swing.JLabel();
        lblLicencia = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de placas: busqueda persona");
        setAutoRequestFocus(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogo.setBackground(new java.awt.Color(7, 92, 79));

        labelOperacion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelOperacion.setForeground(new java.awt.Color(255, 255, 255));
        labelOperacion.setText("Módulo de placas: busqueda persona");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(39, 39, 39))
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar)
                    .addComponent(labelOperacion))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 90));

        jPanel1.setBackground(new java.awt.Color(15, 153, 139));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setRoundBottomLeft(50);
        roundedPanel1.setRoundBottomRight(50);
        roundedPanel1.setRoundTopLeft(50);
        roundedPanel1.setRoundTopRight(50);
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelOperacion1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelOperacion1.setText("RFC");
        roundedPanel1.add(labelOperacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 40));

        roundedPanel2.setBackground(new java.awt.Color(204, 204, 204));
        roundedPanel2.setRoundBottomLeft(50);
        roundedPanel2.setRoundBottomRight(50);
        roundedPanel2.setRoundTopLeft(50);
        roundedPanel2.setRoundTopRight(50);

        txtRFC.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        txtRFC.setBorder(null);
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
                .addComponent(txtRFC, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel2Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        roundedPanel1.add(roundedPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 310, 40));

        roundedPanel3.setBackground(new java.awt.Color(204, 255, 204));
        roundedPanel3.setRoundBottomLeft(50);
        roundedPanel3.setRoundBottomRight(50);
        roundedPanel3.setRoundTopLeft(50);
        roundedPanel3.setRoundTopRight(50);

        lblNombre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        lblEdad.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblEdad.setText("Edad:");

        lblFechaN.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblFechaN.setText("Fecha de nacimiento:");

        lblTelefono.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblTelefono.setText("Teléfono:");

        lblFechaNI.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        lblNombreI.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        lblEdadI.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        lblTelefonoI.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        lblLicencia.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblLicencia.setText("Licencia:");

        javax.swing.GroupLayout roundedPanel3Layout = new javax.swing.GroupLayout(roundedPanel3);
        roundedPanel3.setLayout(roundedPanel3Layout);
        roundedPanel3Layout.setHorizontalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel3Layout.createSequentialGroup()
                        .addComponent(lblEdad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEdadI))
                    .addGroup(roundedPanel3Layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreI))
                    .addGroup(roundedPanel3Layout.createSequentialGroup()
                        .addComponent(lblTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTelefonoI))
                    .addGroup(roundedPanel3Layout.createSequentialGroup()
                        .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblLicencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFechaN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFechaNI)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        roundedPanel3Layout.setVerticalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTelefonoI, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel3Layout.createSequentialGroup()
                        .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombre)
                            .addComponent(lblNombreI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEdad)
                            .addComponent(lblEdadI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFechaN)
                            .addComponent(lblFechaNI, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTelefono)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLicencia)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        roundedPanel1.add(roundedPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 410, 240));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, -1, -1));

        jPanel1.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 520, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 690, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton que busca los datos
     * @param evt accion a realizar
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.validaDatosBuscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * Boton que manda a la siguiente interfaz
     * @param evt acciona a realizar
     */
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        this.validaDatosPersona();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    /**
     * Boton que regresa a la interfaz Aplicacion
     * @param evt 
     */
    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        Aplicacion v = new Aplicacion();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    /**
     * Cambia el cursor al estilo "mano" cuando el mouse se posiciona sobre el botón de regresar.
     * @param evt evento del mouse
     */
    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseEntered

    /**
     * Cambia el cursor al cursor por defecto cuando el mouse sale del área del botón de regresar.
     * @param evt evento del mouse
     */
    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseExited

    
    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed

    /**
     * Campo de texto donde se le agrega el RFC de la persona
     * @param evt campo de texto 
     */
    private void txtRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyTyped
        char car = evt.getKeyChar();
        if (!Character.isLetterOrDigit(car) && txtRFC.getText().length() >= 13) {
            evt.consume();
        } else if (txtRFC.getText().length() >= 13 && !Character.isDigit(car)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRFCKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JLabel labelOperacion1;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEdadI;
    private javax.swing.JLabel lblFechaN;
    private javax.swing.JLabel lblFechaNI;
    private javax.swing.JLabel lblLicencia;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreI;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoI;
    private javax.swing.JPanel pnlLogo;
    private utils.RoundedPanel roundedPanel1;
    private utils.RoundedPanel roundedPanel2;
    private utils.RoundedPanel roundedPanel3;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
