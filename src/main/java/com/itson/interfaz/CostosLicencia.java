/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.interfaz;

import com.itson.dominio.CostoTramite;
import com.itson.dominio.Persona;
import com.itson.implementaciones.LicenciaDAO;
import com.itson.implementaciones.PersonaDAO;
import interfaces.ILicenciaDAO;
import interfaces.IPersonaDAO;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Interfaz consulta licencia
 *
 * @author arace
 */
public class CostosLicencia extends javax.swing.JFrame {

    private final IPersonaDAO a = new PersonaDAO();
    private final CostoTramite b = new CostoTramite();
    private final ILicenciaDAO c = new LicenciaDAO();
    private final String rfc;

    /**
     * costos de licencia que requiere del rfc para insertar los datos de la
     * persona
     *
     * @param rfc de la persona
     */
    public CostosLicencia(String rfc) {
        this.rfc = rfc;
        initComponents();
        setResizable(false);
        this.insertarDatosPersona();
        this.insertarDatosTablaCosto();
    }

    /**
     * Metodo que inserta loa datos de la persona
     */
    private void insertarDatosPersona() {
        Persona persona = this.a.buscarPersonasRFC(rfc);
        lblPersona.setText("Persona: " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
    }

    /**
     * Metodo que inserta los daros de la tabla de costos
     */
    private void insertarDatosTablaCosto() {
        DefaultTableModel tblCosto = (DefaultTableModel) tblPrecioLicencia.getModel();
        tblPrecioLicencia.setModel(tblCosto);
        tblCosto.addRow(new Object[]{"1 año", b.licencia1N, b.licencia1D});
        tblCosto.addRow(new Object[]{"2 años", b.licencia2N, b.licencia2D});
        tblCosto.addRow(new Object[]{"3 años", b.licencia3N, b.licencia3D});
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
        lblVigencia = new javax.swing.JLabel();
        cmbVigencia = new javax.swing.JComboBox<>();
        lblDiscapacitado = new javax.swing.JLabel();
        jcbDiscapacidad = new javax.swing.JCheckBox();
        tablaCostosLicencia = new javax.swing.JScrollPane();
        tblPrecioLicencia = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        lblPersona = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de licencias: Tramitar licencia");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogo.setBackground(new java.awt.Color(7, 92, 79));

        labelOperacion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        labelOperacion.setForeground(new java.awt.Color(255, 255, 255));
        labelOperacion.setText("Módulo de licencias: Tramitar licencia");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
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

        lblVigencia.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblVigencia.setForeground(new java.awt.Color(0, 0, 0));
        lblVigencia.setText("Vigencia");
        roundedPanel1.add(lblVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        cmbVigencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        roundedPanel1.add(cmbVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 52, -1));

        lblDiscapacitado.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblDiscapacitado.setForeground(new java.awt.Color(0, 0, 0));
        lblDiscapacitado.setText("¿Es discapacitado?");
        roundedPanel1.add(lblDiscapacitado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        jcbDiscapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDiscapacidadActionPerformed(evt);
            }
        });
        roundedPanel1.add(jcbDiscapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, 25));

        tablaCostosLicencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblPrecioLicencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblPrecioLicencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vigencia", "Costo normal", "Costo discapacitado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class
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
        tblPrecioLicencia.getTableHeader().setReorderingAllowed(false);
        tablaCostosLicencia.setViewportView(tblPrecioLicencia);
        if (tblPrecioLicencia.getColumnModel().getColumnCount() > 0) {
            tblPrecioLicencia.getColumnModel().getColumn(0).setResizable(false);
            tblPrecioLicencia.getColumnModel().getColumn(1).setResizable(false);
            tblPrecioLicencia.getColumnModel().getColumn(2).setResizable(false);
        }

        roundedPanel1.add(tablaCostosLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 420, 73));

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        roundedPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        jPanel1.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 520, 420));

        lblPersona.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 690, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton que acepta la vigencia de la licencia, deacuerdo a la opcion que
     * indique, debido a que cada anio tiene un costo diferene al igual si
     * selecciona la opcion de discaapcitado o no
     *
     * @param evt la accion de acptar
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Persona persona = this.a.buscarPersonasRFC(rfc);
        String opcion = cmbVigencia.getSelectedItem().toString();

        int vigencia = 0;
        switch (opcion) {
            case "1":
                vigencia = 1;
                break;
            case "2":
                vigencia = 2;
                break;
            case "3":
                vigencia = 3;
                break;
        }

        int estadoDiscapacidad = 0;
        String estado = "NORMAL";
        Double costo = 0.0;

        if (jcbDiscapacidad.isSelected()) {
            estadoDiscapacidad = 1;
            estado = "DISCAPACITADO";
        }

        switch (vigencia) {
            case 1:
                if (estadoDiscapacidad == 1) {
                    costo = b.licencia1D;
                } else {
                    costo = b.licencia1N;
                }
                break;
            case 2:
                if (estadoDiscapacidad == 1) {
                    costo = b.licencia2D;
                } else {
                    costo = b.licencia2N;
                }
                break;
            case 3:
                if (estadoDiscapacidad == 1) {
                    costo = b.licencia3D;
                } else {
                    costo = b.licencia3N;
                }
                break;
        }

        c.insertarTramiteLicencia(persona, costo, vigencia, estadoDiscapacidad);
        JOptionPane.showMessageDialog(null, "Se ha generado una licencia con estos datos:\n"
                + "Persona: " + persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + "\n"
                + "Vigencia (años): " + vigencia + "\n"
                + "Tipo: " + estado + "", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jcbDiscapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDiscapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDiscapacidadActionPerformed

    /**
     * Boton que regresa a consulta licencia
     *
     * @param evt accion a realizar
     */
    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        ConsultaLicencia v = new ConsultaLicencia();
        v.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarMouseClicked

    /**
     * Cambia el cursor "mano" cuando el mouse se posiciona sobre le boton
     * regresar
     *
     * @param evt accion a realizar
     */
    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnRegresarMouseEntered

    /**
     * Cambia el cursor al cursor por defecto cuando el mouse sale del área del
     * botón de regresar.
     *
     * @param evt evento del mouse
     */
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
//            java.util.logging.Logger.getLogger(CostosLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CostosLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CostosLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CostosLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CostosLicencia().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JComboBox<String> cmbVigencia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox jcbDiscapacidad;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JLabel lblDiscapacitado;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JLabel lblVigencia;
    private javax.swing.JPanel pnlLogo;
    private utils.RoundedPanel roundedPanel1;
    private javax.swing.JScrollPane tablaCostosLicencia;
    private javax.swing.JTable tblPrecioLicencia;
    // End of variables declaration//GEN-END:variables
}
