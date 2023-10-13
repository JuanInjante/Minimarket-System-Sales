package Vista;

import Dao.DaoProveedor;
import Model.Proveedor;
import Utils.Utileria;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FrmProveedor extends javax.swing.JInternalFrame {

    public FrmProveedor() {
        initComponents();
        this.setTitle("Mantenimiento Proveedor");
        this.setFrameIcon(Utileria.IconoImg());

        CampoCodProveedor.setEditable(false);
        jTable3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable3.getSelectedRow();
                    if (selectedRow >= 0) {
                        // Obtén los valores de la fila seleccionada
                        String codigo = jTable3.getValueAt(selectedRow, 0).toString();
                        String nombreEmpresa = jTable3.getValueAt(selectedRow, 1).toString();
                        String nombreContacto = jTable3.getValueAt(selectedRow, 2).toString();
                        String telefono = jTable3.getValueAt(selectedRow, 3).toString();
                        String estado = jTable3.getValueAt(selectedRow, 4).toString();

                        // Rellena los campos de JTextField
                        CampoCodProveedor.setText(codigo);
                        CampoNombreEmpresa.setText(nombreEmpresa);
                        CampoContacto.setText(nombreContacto);
                        CampoTelefono.setText(telefono);
                        CampoEstado.setSelectedItem(estado);
                    }
                }
            }
        });
        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {

        DaoProveedor daoProveedor = new DaoProveedor();
        List<Proveedor> proveedores = daoProveedor.buscarProveedor("", "", null);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre Empresa");
        model.addColumn("Nombre Contacto");
        model.addColumn("Teléfono");
        model.addColumn("Estado");

        for (Proveedor proveedor : proveedores) {
            model.addRow(new Object[]{
                proveedor.getCodProveedor(),
                proveedor.getNombreEmpresa(),
                proveedor.getNombre_contacto(),
                proveedor.getTelefono(),
                proveedor.getEstado()
            });
        }
        jTable3.setModel(model);
    }

    private void limpiarCampos() {
        CampoCodProveedor.setText("");
        CampoNombreEmpresa.setText("");
        CampoContacto.setText("");
        CampoTelefono.setText("");
        CampoEstado.setSelectedItem("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        GuardarProveedor = new javax.swing.JButton();
        ActualizarProveedor = new javax.swing.JButton();
        EliminarProveedor = new javax.swing.JButton();
        BuescarProveedor = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CampoNombreEmpresa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CampoTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CampoContacto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CampoCodProveedor = new javax.swing.JTextField();
        CampoEstado = new javax.swing.JComboBox<>();
        Limpiar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new Fondo();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GuardarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-guardar.jpg"))); // NOI18N
        GuardarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        GuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(GuardarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 50, 50));

        ActualizarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon3.jpg"))); // NOI18N
        ActualizarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ActualizarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(ActualizarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 50, 50));

        EliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-eliminar.jpg"))); // NOI18N
        EliminarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 50, 50));

        BuescarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-buscar.jpg"))); // NOI18N
        BuescarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BuescarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuescarProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(BuescarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 50, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Insertar");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Actualizar");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Eliminar");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Limpiar");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Registro de Proveedores");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        CampoNombreEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNombreEmpresaActionPerformed(evt);
            }
        });
        getContentPane().add(CampoNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 150, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre Empresa");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        getContentPane().add(CampoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Telefono");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        CampoContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoContactoActionPerformed(evt);
            }
        });
        getContentPane().add(CampoContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 150, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contacto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CodProveedor");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        CampoCodProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCodProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(CampoCodProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 150, -1));

        CampoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        CampoEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(CampoEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 150, -1));

        Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icono-limpiar.png"))); // NOI18N
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 50, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Buscar");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, -1, -1));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 770, 230));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoContactoActionPerformed

    private void GuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarProveedorActionPerformed
        String nombreEmpresa = CampoNombreEmpresa.getText();
        String contacto = CampoContacto.getText();
        String telefono = CampoTelefono.getText();

        if (nombreEmpresa.isEmpty() || contacto.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se aceptan campos vacios");
        } else {
            if (telefono.length() != 9) {
                JOptionPane.showMessageDialog(this, "El número de teléfono debe contener solo 9 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!telefono.matches("\\d{1,9}")) {
                JOptionPane.showMessageDialog(this, "El número de teléfono debe contener solo dígitos y tener un máximo de 9 caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!nombreEmpresa.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "El campo de nombre de empresa debe contener solo letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!contacto.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "El campo de contacto debe contener solo letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {

                DaoProveedor daoProveedor = new DaoProveedor();

                int resultado = daoProveedor.insertarProveedor(nombreEmpresa, contacto, telefono);

                if (resultado == 1) {
                    JOptionPane.showMessageDialog(this, "Proveedor insertado correctamente");
                    cargarDatosEnTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al insertar proveedor");
                }
            }
        }
    }//GEN-LAST:event_GuardarProveedorActionPerformed

    private void ActualizarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarProveedorActionPerformed

        String codigo = CampoCodProveedor.getText();
        String nombreEmpresa = CampoNombreEmpresa.getText();
        String nombreContacto = CampoContacto.getText();
        String telefono = CampoTelefono.getText();
        String estadoStr = CampoEstado.getSelectedItem().toString();

        if (codigo.isEmpty() || nombreEmpresa.isEmpty() || nombreContacto.isEmpty() || telefono.isEmpty() || estadoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ningún campo debe estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int codProveedor = Integer.parseInt(codigo);

                byte estado = 1;
                if (estadoStr.equals("Activo")) {
                    estado = 1;
                } else if (estadoStr.equals("Inactivo")) {
                    estado = 0;
                } else {
                    JOptionPane.showMessageDialog(this, "Valor de estado no válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return; // Sal del método si el estado no es válido.
                }

                Proveedor proveedor = new Proveedor(codProveedor, nombreEmpresa, nombreContacto, telefono, estado);
                DaoProveedor daoProveedor = new DaoProveedor();

                int resultado = daoProveedor.actualizarProveedor(proveedor);

                if (resultado == 1) {
                    JOptionPane.showMessageDialog(this, "Proveedor actualizado correctamente.");
                    cargarDatosEnTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el proveedor.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El código de proveedor debe ser un número válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_ActualizarProveedorActionPerformed

    private void EliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProveedorActionPerformed
        int filaSeleccionada = jTable3.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un proveedor para eliminar.");
            return;
        }
        int codigoProveedor = (int) jTable3.getValueAt(filaSeleccionada, 0);

        DaoProveedor daoProveedor = new DaoProveedor();

        Proveedor proveedor = new Proveedor(codigoProveedor);

        int resultado = daoProveedor.eliminarProveedor(proveedor);

        if (resultado == 1) {
            JOptionPane.showMessageDialog(this, "Proveedor eliminado correctamente.");

            // Recargar los datos en la tabla después de la eliminación.
            cargarDatosEnTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el proveedor.", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_EliminarProveedorActionPerformed

    private void BuescarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuescarProveedorActionPerformed
        String nombreEmpresa = CampoNombreEmpresa.getText();
        String nombreContacto = CampoContacto.getText();
        String estadoStr = CampoEstado.getSelectedItem().toString();
        Byte estado = null;

// Verifica si al menos un campo de búsqueda no está vacío
        if (!nombreEmpresa.isEmpty() || !nombreContacto.isEmpty() || !estadoStr.isEmpty()) {
            if (!estadoStr.isEmpty()) {
                if (estadoStr.equals("Activo")) {
                    estado = 1;
                } else if (estadoStr.equals("Inactivo")) {
                    estado = 0;
                } else {
                    JOptionPane.showMessageDialog(this, "Valor de estado no válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            DaoProveedor daoProveedor = new DaoProveedor();
            List<Proveedor> proveedores = daoProveedor.buscarProveedor(nombreEmpresa, nombreContacto, estado);

            if (proveedores != null) {
                DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
                model.setRowCount(0);
                for (Proveedor proveedor : proveedores) {
                    model.addRow(new Object[]{
                        proveedor.getCodProveedor(),
                        proveedor.getNombreEmpresa(),
                        proveedor.getNombre_contacto(),
                        proveedor.getTelefono(),
                        proveedor.getEstado()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al buscar proveedores.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // Si todos los campos están vacíos, muestra todos los registros
            DaoProveedor daoProveedor = new DaoProveedor();
            List<Proveedor> proveedores = daoProveedor.buscarProveedor(nombreEmpresa, nombreContacto, estado);

            if (proveedores != null) {
                DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
                model.setRowCount(0);
                for (Proveedor proveedor : proveedores) {
                    model.addRow(new Object[]{
                        proveedor.getCodProveedor(),
                        proveedor.getNombreEmpresa(),
                        proveedor.getNombre_contacto(),
                        proveedor.getTelefono(),
                        proveedor.getEstado()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener proveedores.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_BuescarProveedorActionPerformed

    private void CampoNombreEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNombreEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoNombreEmpresaActionPerformed

    private void CampoCodProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCodProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCodProveedorActionPerformed

    private void CampoEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoEstadoActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_LimpiarActionPerformed
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
    private javax.swing.JButton ActualizarProveedor;
    private javax.swing.JButton BuescarProveedor;
    private javax.swing.JTextField CampoCodProveedor;
    private javax.swing.JTextField CampoContacto;
    private javax.swing.JComboBox<String> CampoEstado;
    private javax.swing.JTextField CampoNombreEmpresa;
    private javax.swing.JTextField CampoTelefono;
    private javax.swing.JButton EliminarProveedor;
    private javax.swing.JButton GuardarProveedor;
    private javax.swing.JButton Limpiar;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
