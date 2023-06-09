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
import interfaces.IPersonaDAO;
import interfaces.IPlacaDAO;
import java.awt.Cursor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.Validadores;

/**
 * Formulario de renovación de placas
 *
 * @author arace
 */
public class RenovacionPlacas extends javax.swing.JFrame {

    private final IPersonaDAO a = new PersonaDAO();
    private final CostoTramite b = new CostoTramite();
    private final IPlacaDAO d = new PlacaDAO();
    private static final Logger LOG = Logger.getLogger(PlacaDAO.class.getName());
    private final String rfc;
    private final Validadores validadores = new Validadores();

    /**
     * Form RenovacionPlacas
     *
     * @param rfc de la persona
     */
    public RenovacionPlacas(String rfc) {
        initComponents();
        setResizable(false);
        this.rfc = rfc;
        this.insertarDatosPersona();
    }

    /**
     * Metodo que inserta los datos de la persona
     */
    private void insertarDatosPersona() {
        Persona persona = this.a.buscarPersonasRFC(rfc);
        lblPersona.setText("Persona: " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
    }

    /**
     * Metodo que carga la tabla de los automoviles mediante la placa
     *
     * @param placa de los autos
     */
    private void cargarTablaAuto(String placa) {
        Persona persona = a.buscarPersonasRFC(rfc);
        try {
            List<Automovil> listaAuto = d.buscarPlacaAutomovilL(placa, persona);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblAuto.getModel();
            modeloTabla.setRowCount(0);
            for (Automovil auto : listaAuto) {
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

    /**
     * Metodo que valida los datos de la placa, al momento de insertar los datos
     * de la persona se hace la validacion y en caso de algun error, mostrar un
     * mensaje de error
     */
    private void validaPlaca() {
        Persona persona = a.buscarPersonasRFC(rfc);
        if (txtPlaca.getText().equals("   -   ")) {
            JOptionPane.showMessageDialog(null, "El campo de texto de placa está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (d.buscarPlacaAutomovil(txtPlaca.getText(), persona) == null) {
            JOptionPane.showMessageDialog(null, "La placa ingresada no ha sido encontrado en el sistema", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            this.cargarTablaAuto(txtPlaca.getText());
        }
    }

    /**
     * Metodo que inserta los datos de la placa para su renovacion
     */
    private void insertarPlaca() {
        Persona persona = a.buscarPersonasRFC(rfc);
        Automovil auto = d.buscarPlacaAutomovil(txtPlaca.getText(), persona);
        Double costo = b.placaUsado;
        String placa = d.generarPlaca();
        d.insertarTramitePlacasUsado(persona, auto, placa, costo);
        JOptionPane.showMessageDialog(null, "Se ha renovado la placa para el vehiculo:\n"
                + "Placa: " + placa + "\n"
                + "No. Serie: " + auto.getSerie() + "\n"
                + "Marca: " + auto.getMarca() + "\n"
                + "Linea: " + auto.getLinea() + "\n"
                + "Color: " + auto.getColor() + "\n"
                + "Modelo: " + auto.getModelo() + "", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAuto = new javax.swing.JTable();
        botonAceptar = new javax.swing.JButton();
        labelIngresarPlacas = new javax.swing.JLabel();
        roundedPanel2 = new utils.RoundedPanel();
        txtPlaca = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        lblPersona = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de placas: Renovación placa");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogo.setBackground(new java.awt.Color(7, 92, 79));

        labelOperacion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelOperacion.setForeground(new java.awt.Color(255, 255, 255));
        labelOperacion.setText("Módulo de placas: Renovación placa");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
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

        getContentPane().add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 90));

        jPanel1.setBackground(new java.awt.Color(15, 153, 139));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setRoundBottomLeft(50);
        roundedPanel1.setRoundBottomRight(50);
        roundedPanel1.setRoundTopLeft(50);
        roundedPanel1.setRoundTopRight(50);
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAuto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serie", "Marca", "Línea", "Color", "Modelo"
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
        tblAuto.setShowGrid(false);
        tblAuto.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblAuto);
        if (tblAuto.getColumnModel().getColumnCount() > 0) {
            tblAuto.getColumnModel().getColumn(0).setResizable(false);
            tblAuto.getColumnModel().getColumn(1).setResizable(false);
            tblAuto.getColumnModel().getColumn(2).setResizable(false);
            tblAuto.getColumnModel().getColumn(3).setResizable(false);
            tblAuto.getColumnModel().getColumn(4).setResizable(false);
        }

        roundedPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 600, 39));

        botonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        roundedPanel1.add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        labelIngresarPlacas.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        labelIngresarPlacas.setForeground(new java.awt.Color(0, 0, 0));
        labelIngresarPlacas.setText("Ingrese placas");
        roundedPanel1.add(labelIngresarPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, 40));

        roundedPanel2.setBackground(new java.awt.Color(204, 204, 204));
        roundedPanel2.setRoundBottomLeft(50);
        roundedPanel2.setRoundBottomRight(50);
        roundedPanel2.setRoundTopLeft(50);
        roundedPanel2.setRoundTopRight(50);

        txtPlaca.setBorder(null);
        txtPlaca.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("AAA-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPlaca.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtPlaca.setOpaque(false);

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        roundedPanel1.add(roundedPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 220, 40));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, 40));

        jPanel1.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 690, 330));

        lblPersona.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 770, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton que inserta la placa
     *
     * @param evt accion a realizar
     */
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        Persona persona = a.buscarPersonasRFC(rfc);
        if (txtPlaca.getText().equals("   -   ")) {
            JOptionPane.showMessageDialog(null, "El campo de texto de placa está vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (d.buscarPlacaAutomovil(txtPlaca.getText(), persona) == null) {
            JOptionPane.showMessageDialog(null, "La placa ingresada no ha sido encontrado en el sistema", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            this.insertarPlaca();
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    /**
     * Boton que busca la palca y la valida
     *
     * @param evt accion a realizar
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.validaPlaca();
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * Boton que regresa a la interfaz Costos de placas
     *
     * @param evt accion a realizar
     */
    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        CostosPlacas v = new CostosPlacas(rfc);
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    /**
     * Boton que cambia el cursor "mano" cuando el mouse se posiciona sobre le
     * boton regresar
     *
     * @param evt accion a realizar
     */
    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseEntered

    /**
     * Boton que cambia el cursor por el cursor por defecto cuando el mouse sale
     * del area del boton regresar
     *
     * @param evt evento del mouse
     */
    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIngresarPlacas;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JPanel pnlLogo;
    private utils.RoundedPanel roundedPanel1;
    private utils.RoundedPanel roundedPanel2;
    private javax.swing.JTable tblAuto;
    private javax.swing.JFormattedTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
