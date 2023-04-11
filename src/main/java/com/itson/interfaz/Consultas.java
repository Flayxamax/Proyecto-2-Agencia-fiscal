
package com.itson.interfaz;
import com.itson.dominio.Persona;
import com.itson.implementaciones.LicenciaDAO;
import com.itson.implementaciones.PersonaDAO;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author aracelyC
 */
public class Consultas extends javax.swing.JFrame {
PersonaDAO a = new PersonaDAO();
LicenciaDAO b = new LicenciaDAO();
    /**
     * Creates new form Consultas
     */
    public Consultas() {
        initComponents();
    }
    private Persona extraerDatos(){
        String RFC = txtRFC.getText();
        Persona persona =a.buscarPersonasRFC(RFC);
        return persona;
        
    }
    private void insertarDatospersonaLicencia() {
        Persona persona = this.extraerDatos();
        lblNombre.setText(persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
        Calendar fechaNacimiento = persona.getFechaNacimiento();
        Date date = fechaNacimiento.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaN = sdf.format(date);
        lblFecha.setText(fechaN);
        LocalDate fechaNacimientoLocal = LocalDate.of(fechaNacimiento.get(Calendar.YEAR),
                fechaNacimiento.get(Calendar.MONTH) + 1,
                fechaNacimiento.get(Calendar.DAY_OF_MONTH));
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(fechaNacimientoLocal, fechaActual).getYears();
        lblEdad.setText(String.valueOf(edad));
    }
    private void insertarDatospersonaPlaca(){
     Persona persona = this.extraerDatos();
        lblNombre.setText("Nombre: " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
        Calendar fechaNacimiento = persona.getFechaNacimiento();
        Date date = fechaNacimiento.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaN = sdf.format(date);
        lblFecha.setText("Fecha de nacimiento: " + fechaN);

        LocalDate fechaNacimientoLocal = LocalDate.of(fechaNacimiento.get(Calendar.YEAR),
                fechaNacimiento.get(Calendar.MONTH) + 1,
                fechaNacimiento.get(Calendar.DAY_OF_MONTH));
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(fechaNacimientoLocal, fechaActual).getYears();
        lblEdad.setText(String.valueOf(edad));
        if (b.validarLicenciaVigente(persona.getRfc()) == true) {
            lblLicencia.setText("Licencia: Vigente");
        } else {
            lblLicencia.setText("Licencia: No vigente");
        }
    }
    private boolean validarEdad() {
        boolean mayorEdad = false;
        String eda = lblEdad.getText();
        int edad = Integer.parseInt(eda);
        return mayorEdad = edad >= 18;
    }

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
                JOptionPane.showMessageDialog(null, "No tiene o no se encontró una licencia vigente para la persona con el RFC: "+txtRFC.getText(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Esta persona no puede tramitar licencia por menor de edad permitida", "Error", JOptionPane.ERROR_MESSAGE);
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

        labelModuloConsulta = new javax.swing.JLabel();
        checkLicencia = new javax.swing.JCheckBox();
        checkPlaca = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblPlacas = new javax.swing.JLabel();
        lblLicencia = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelModuloConsulta.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelModuloConsulta.setText("Modulo de Consultas");

        checkLicencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        checkLicencia.setText("Consulta Licencia");
        checkLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLicenciaActionPerformed(evt);
            }
        });

        checkPlaca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        checkPlaca.setText("Consulta Placas");
        checkPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPlacaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Seleccione consulta a realizar:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Ingrese datos:");

        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Buscar");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("RFC");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setText("Nombre: ");

        lblEdad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEdad.setText("Edad: ");

        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFecha.setText("Fecha de nacimiento: ");

        lblPlacas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPlacas.setText("Placas:");

        lblLicencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLicencia.setText("Licencia: ");

        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))
                            .addComponent(lblNombre)
                            .addComponent(lblEdad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente)
                        .addGap(43, 43, 43)
                        .addComponent(btnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(checkPlaca)
                            .addComponent(checkLicencia)
                            .addComponent(lblFecha)
                            .addComponent(lblPlacas)
                            .addComponent(lblLicencia)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(263, Short.MAX_VALUE)
                .addComponent(labelModuloConsulta)
                .addGap(229, 229, 229))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelModuloConsulta)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkLicencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkPlaca)
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblNombre)
                .addGap(12, 12, 12)
                .addComponent(lblEdad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFecha)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPlacas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLicencia)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSiguiente)
                            .addComponent(btnRegresar))
                        .addGap(21, 21, 21))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLicenciaActionPerformed
      
    }//GEN-LAST:event_checkLicenciaActionPerformed

    private void checkPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPlacaActionPerformed
       
    }//GEN-LAST:event_checkPlacaActionPerformed

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JCheckBox checkLicencia;
    private javax.swing.JCheckBox checkPlaca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelModuloConsulta;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLicencia;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPlacas;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
