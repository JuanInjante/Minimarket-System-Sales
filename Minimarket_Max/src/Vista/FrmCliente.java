package Vista;

import Dao.DaoCliente;
import Utils.Utileria;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author EdilsonVill
 */
public class FrmCliente extends javax.swing.JInternalFrame {

    public FrmCliente() {
        initComponents();
        this.setTitle("Mantenimiento Cliente");
        this.setFrameIcon(Utileria.IconoImg());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        CampoAp_pat = new javax.swing.JTextField();
        CampoAp_mat = new javax.swing.JTextField();
        CampoDni = new javax.swing.JTextField();
        CampoTelefono = new javax.swing.JTextField();
        CampoDireccion = new javax.swing.JTextField();
        CampoGenero = new javax.swing.JTextField();
        CampoCorreo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Insertar = new javax.swing.JButton();
        jPanel1 = new Fondo();

        jLabel9.setText("jLabel9");

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ap_pat");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ap_mat");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DNI");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Direcciòn");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Correo");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Genero");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        CampoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNombreActionPerformed(evt);
            }
        });
        getContentPane().add(CampoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 149, -1));
        getContentPane().add(CampoAp_pat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 149, -1));
        getContentPane().add(CampoAp_mat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 149, -1));
        getContentPane().add(CampoDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 149, -1));
        getContentPane().add(CampoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 149, -1));
        getContentPane().add(CampoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 149, -1));
        getContentPane().add(CampoGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 149, -1));
        getContentPane().add(CampoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 149, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Insertar");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Registro de Clientes");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        Insertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-guardar.jpg"))); // NOI18N
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });
        getContentPane().add(Insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoNombreActionPerformed

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        String nombre = CampoNombre.getText();
        String Ap_pat = CampoAp_pat.getText();
        String Ap_mat = CampoAp_mat.getText();
        String DNI = CampoDni.getText();
        String Telefono = CampoTelefono.getText();
        String Direccion = CampoDireccion.getText();
        String Correo = CampoCorreo.getText();
        String Genero = CampoGenero.getText();

        if (nombre.isEmpty() || Ap_pat.isEmpty() || Ap_mat.isEmpty() || DNI.isEmpty() || Telefono.isEmpty() || Direccion.isEmpty() | Correo.isEmpty() | Genero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se aceptan campos vacios");
        } else {
            if (Telefono.length() != 9) {
                JOptionPane.showMessageDialog(this, "El número de teléfono debe contener solo 9 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!Telefono.matches("\\d{1,9}")) {
                JOptionPane.showMessageDialog(this, "El número de teléfono debe contener solo 9 dígitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!DNI.matches("\\d{1,8}")) {
                JOptionPane.showMessageDialog(this, "El número de teléfono debe contener solo 8 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (DNI.length() != 8) {
                JOptionPane.showMessageDialog(this, "El número de Dni debe contener solo 8 dígitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!nombre.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "El campo de nombre de empresa debe contener solo letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!Ap_mat.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "El campo de contacto debe contener solo letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {

                DaoCliente daoCliente = new DaoCliente();

                int DNIInt = Integer.parseInt(DNI);
                int TelefonoInt = Integer.parseInt(Telefono);

                int resultado = daoCliente.insertarCliente(nombre, Ap_pat, Ap_mat, DNIInt, TelefonoInt, Direccion, Correo, Genero);

                if (resultado == 1) {
                    JOptionPane.showMessageDialog(this, "Proveedor insertado correctamente");

                } else {
                    JOptionPane.showMessageDialog(this, "Error al insertar proveedor");
                }
            }
        }

    }//GEN-LAST:event_InsertarActionPerformed

    class Fondo extends JPanel {

        private Image imagen;

        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Img/fondo.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoAp_mat;
    private javax.swing.JTextField CampoAp_pat;
    private javax.swing.JTextField CampoCorreo;
    private javax.swing.JTextField CampoDireccion;
    private javax.swing.JTextField CampoDni;
    private javax.swing.JTextField CampoGenero;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JTextField CampoTelefono;
    private javax.swing.JButton Insertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
