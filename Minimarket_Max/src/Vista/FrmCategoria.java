package Vista;

import Dao.DaoCategoria;
import Model.Categoria;
import Utils.Utileria;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmCategoria extends javax.swing.JInternalFrame {

    public FrmCategoria() {
        initComponents();
        this.setTitle("Mantenimiento Cliente");
        this.setFrameIcon(Utileria.IconoImg());
        CampoCod.setEditable(false);
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow >= 0) {
                        // Obtén los valores de la fila seleccionada
                        String codigo = jTable1.getValueAt(selectedRow, 0).toString();
                        String nombre = jTable1.getValueAt(selectedRow, 1).toString();
                        String estado = jTable1.getValueAt(selectedRow, 2).toString();

                        // Rellena los campos de JTextField
                        CampoCod.setText(codigo);
                        CampoNombre.setText(nombre);
                        CampoEstado.setSelectedItem(estado);
                    }
                }
            }
        });
        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {

        DaoCategoria daocategoria = new DaoCategoria();
        List<Categoria> proveedores = daocategoria.buscarCategoria("", null);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Estado");

        for (Categoria categoria : proveedores) {
            model.addRow(new Object[]{
                categoria.getCodCategoria(),
                categoria.getNombre(),
                categoria.getEstado()
            });
        }
        jTable1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CampoCod = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Insertar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Eliminar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        Modificar = new javax.swing.JButton();
        CampoEstado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new Fondo();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CodCategoria");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        CampoCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCodActionPerformed(evt);
            }
        });
        getContentPane().add(CampoCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 149, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Insertar");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        Insertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-guardar.jpg"))); // NOI18N
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });
        getContentPane().add(Insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 40, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        CampoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNombreActionPerformed(evt);
            }
        });
        getContentPane().add(CampoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 149, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Eliminar");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, -1, -1));

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-eliminar.jpg"))); // NOI18N
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 40, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Buscar");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, -1, -1));

        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-buscar.jpg"))); // NOI18N
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 40, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Modificar");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, -1, -1));

        Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon3.jpg"))); // NOI18N
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 40, 40));

        CampoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(CampoEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 100, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Registro de Categoria");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 830, 170));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCodActionPerformed

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        String nombre = CampoNombre.getText();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se aceptan campos vacios");
        } else {
            if (!nombre.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "El campo de nombre de la categoria debe contener solo letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {

                DaoCategoria categoria = new DaoCategoria();

                int resultado = categoria.insertarCategoria(nombre);

                if (resultado == 1) {
                    JOptionPane.showMessageDialog(this, "Categoria insertado correctamente");
                    cargarDatosEnTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al insertar categoria");
                }
            }
        }
    }//GEN-LAST:event_InsertarActionPerformed

    private void CampoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoNombreActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una categoria para eliminar.");
            return;
        }
        int codigoPersona = (int) jTable1.getValueAt(filaSeleccionada, 0);

        DaoCategoria categoria = new DaoCategoria();

        Categoria c = new Categoria(codigoPersona);

        int resultado = categoria.eliminarCategoria(c);

        if (resultado == 1) {
            JOptionPane.showMessageDialog(this, "Proveedor eliminado correctamente.");

            // Recargar los datos en la tabla después de la eliminación.
            cargarDatosEnTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el proveedor.", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        String nombre= CampoNombre.getText();
        String estadoStr = CampoEstado.getSelectedItem().toString();
        Byte estado = null;

        if (!nombre.isEmpty() || !estadoStr.isEmpty()) {
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

            DaoCategoria daoCategoria = new DaoCategoria();
            List<Categoria> categorias = daoCategoria.buscarCategoria(nombre, estado);

            if (categorias != null) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Categoria cat : categorias) {
                    model.addRow(new Object[]{
                        cat.getCodCategoria(),
                        cat.getNombre(),
                        cat.getEstado()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al buscar proveedores.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // Si todos los campos están vacíos, muestra todos los registros
            DaoCategoria categoria = new DaoCategoria();
            List<Categoria> categorias = categoria.buscarCategoria(nombre, estado);

            if (categorias != null) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Categoria c : categorias) {
                    model.addRow(new Object[]{
                        c.getCodCategoria(),
                        c.getNombre(),
                        c.getEstado()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener proveedores.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_BuscarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        String codigo = CampoCod.getText();
        String nombre = CampoNombre.getText();
        String estadoStr = CampoEstado.getSelectedItem().toString();

        if (codigo.isEmpty() || nombre.isEmpty() || estadoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ningún campo debe estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int codPersona = Integer.parseInt(codigo);

                byte estado = 1;
                if (estadoStr.equals("Activo")) {
                    estado = 1;
                } else if (estadoStr.equals("Inactivo")) {
                    estado = 0;
                } else {
                    JOptionPane.showMessageDialog(this, "Valor de estado no válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return; // Sal del método si el estado no es válido.
                }

                Categoria categoria = new Categoria(codPersona, nombre, estado);
                DaoCategoria daoCategoria = new DaoCategoria();

                int resultado = daoCategoria.actualizarCategoria(categoria);

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
    }//GEN-LAST:event_ModificarActionPerformed
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
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField CampoCod;
    private javax.swing.JComboBox<String> CampoEstado;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Insertar;
    private javax.swing.JButton Modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
