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
import java.awt.Cursor;
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
     *
     * @param rfc
     */
    public RegistroAuto(String rfc) {
        initComponents();
        setResizable(false);
        this.rfc = rfc;
        this.insertarDatosPersona();
    }

    private void insertarDatosPersona() {
        Persona persona = this.a.buscarPersonasRFC(rfc);
        lblPersona.setText("Persona: " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
    }

    private Automovil extraerDatosFormulario() {
        String serie = txtSerie.getText().toUpperCase();
        String marca = txtMarca.getText().toUpperCase();
        String linea = txtLinea.getText().toUpperCase();
        String color = txtColor.getText().toUpperCase();
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

        pnlLogo = new javax.swing.JPanel();
        labelOperacion = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        roundedPanel1 = new utils.RoundedPanel();
        labelSerie = new javax.swing.JLabel();
        txtSerie = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        labelMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        labelLinea = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        labelColor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        labelModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        botonRegristrar = new javax.swing.JButton();
        lblPersona = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de placas: Registrar vehículo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogo.setBackground(new java.awt.Color(7, 92, 79));

        labelOperacion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelOperacion.setForeground(new java.awt.Color(255, 255, 255));
        labelOperacion.setText("Módulo de placas: Registrar vehículo");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
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

        getContentPane().add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 90));

        jPanel1.setBackground(new java.awt.Color(15, 153, 139));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setRoundBottomLeft(50);
        roundedPanel1.setRoundBottomRight(50);
        roundedPanel1.setRoundTopLeft(50);
        roundedPanel1.setRoundTopRight(50);
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSerie.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelSerie.setForeground(new java.awt.Color(0, 0, 0));
        labelSerie.setText("Serie");
        roundedPanel1.add(labelSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        txtSerie.setBorder(null);
        txtSerie.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtSerie.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("AAA-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtSerie.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtSerie.setOpaque(false);
        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
            }
        });
        roundedPanel1.add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 290, 30));
        roundedPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 160, -1));

        labelMarca.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelMarca.setForeground(new java.awt.Color(0, 0, 0));
        labelMarca.setText("Marca");
        roundedPanel1.add(labelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        txtMarca.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(0, 0, 0));
        txtMarca.setBorder(null);
        txtMarca.setOpaque(false);
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        roundedPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 290, 25));
        roundedPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 290, 10));

        labelLinea.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelLinea.setForeground(new java.awt.Color(0, 0, 0));
        labelLinea.setText("Linea");
        roundedPanel1.add(labelLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        txtLinea.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtLinea.setForeground(new java.awt.Color(0, 0, 0));
        txtLinea.setBorder(null);
        txtLinea.setOpaque(false);
        roundedPanel1.add(txtLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 290, -1));
        roundedPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 290, 10));

        labelColor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelColor.setForeground(new java.awt.Color(0, 0, 0));
        labelColor.setText("Color");
        roundedPanel1.add(labelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        txtColor.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtColor.setForeground(new java.awt.Color(0, 0, 0));
        txtColor.setBorder(null);
        txtColor.setOpaque(false);
        roundedPanel1.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 290, -1));
        roundedPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 290, 10));

        labelModelo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelModelo.setForeground(new java.awt.Color(0, 0, 0));
        labelModelo.setText("Modelo");
        roundedPanel1.add(labelModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        txtModelo.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(0, 0, 0));
        txtModelo.setBorder(null);
        txtModelo.setOpaque(false);
        roundedPanel1.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 290, -1));
        roundedPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 290, 10));

        botonRegristrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonRegristrar.setText("Registrar");
        botonRegristrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegristrarActionPerformed(evt);
            }
        });
        roundedPanel1.add(botonRegristrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, -1, -1));

        jPanel1.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 520, 550));

        lblPersona.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 690, 660));

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
                + "Placa: " + placa + "\n"
                + "No. Serie: " + auto.getSerie() + "\n"
                + "Marca: " + auto.getMarca() + "\n"
                + "Linea: " + auto.getLinea() + "\n"
                + "Color: " + auto.getColor() + "\n"
                + "Modelo: " + auto.getModelo() + "", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        Aplicacion v = new Aplicacion();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonRegristrarActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        CostosPlacas v = new CostosPlacas(rfc);
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseEntered

    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseExited

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerieActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegristrar;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelColor;
    private javax.swing.JLabel labelLinea;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelModelo;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JLabel labelSerie;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JPanel pnlLogo;
    private utils.RoundedPanel roundedPanel1;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JFormattedTextField txtSerie;
    // End of variables declaration//GEN-END:variables

}
