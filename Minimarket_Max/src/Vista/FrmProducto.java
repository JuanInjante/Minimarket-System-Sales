package Vista;

import Dao.DaoProducto;
import Model.Producto;
import Utils.Utileria;
import java.awt.Graphics;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmProducto extends javax.swing.JInternalFrame {

    public FrmProducto() {
        initComponents();
        this.setTitle("Mantenimiento Producto");
        this.setFrameIcon(Utileria.IconoImg());

        CampoCodProducto.setEditable(false);
        jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable2.getSelectedRow();
                    if (selectedRow >= 0) {
                        // Obtén los valores de la fila seleccionada
                        String codproducto = getCellValueAsString(selectedRow, 0);
                        String codproveedor = getCellValueAsString(selectedRow, 1);
                        String codcategoria = getCellValueAsString(selectedRow, 2);
                        String nombre = getCellValueAsString(selectedRow, 3);
                        String descripcion = getCellValueAsString(selectedRow, 4);
                        String fechaven = getCellValueAsString(selectedRow, 5);
                        String fechacrea = getCellValueAsString(selectedRow, 6);
                        String fechamodi = getCellValueAsString(selectedRow, 7);
                        String unidadmedi = getCellValueAsString(selectedRow, 8);
                        String estado = getCellValueAsString(selectedRow, 9);
                        // Rellena los campos de JTextField

                        CampoCodProducto.setText(codproducto);
                        CampoCodProveedor.setText(codproveedor);
                        CampoCategoria.setText(codcategoria);
                        CampoNombre.setText(nombre);
                        CampoDescripcion.setText(descripcion);
                        CampoFechVencim.setText(fechaven);
                        CampoFechCrea.setText(fechacrea);
                        CampoFechModif.setText(fechamodi);
                        CampoUnidadMed.setText(unidadmedi);
                        CampoEstado.setSelectedItem(estado);
                    }
                }
            }
        });
        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {

        DaoProducto daoProducto = new DaoProducto();
        List<Producto> proveedores = daoProducto.listarProductos();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CodProducto");
        model.addColumn("CodProveedor");
        model.addColumn("CodCategoria");
        model.addColumn("Nombre");
        model.addColumn("Descripcion");
        model.addColumn("Fecha de Vencimiento");
        model.addColumn("Fecha de Creacion");
        model.addColumn("Fecha de Modificacion");
        model.addColumn("Unidad de Medida");
        model.addColumn("Estado");

        for (Producto produc : proveedores) {
            model.addRow(new Object[]{
                produc.getCodProducto(),
                produc.getCodProveedor(),
                produc.getCodCategoria(),
                produc.getNombre(),
                produc.getDescripcion(),
                produc.getFecha_vencimiento(),
                produc.getFecha_creacion(),
                produc.getFecha_modificacion(),
                produc.getUnidadMedida(),
                produc.getEstado()
            });
        }
        jTable2.setModel(model);
    }

    private String getCellValueAsString(int row, int column) {
        Object value = jTable2.getValueAt(row, column);
        return (value != null) ? value.toString() : "";
    }

    private void limpiarCampos() {
        CampoCodProducto.setText("");
        CampoCodProveedor.setText("");
        CampoCategoria.setText("");
        CampoNombre.setText("");
        CampoDescripcion.setText("");
        CampoFechVencim.setText("");
        CampoFechCrea.setText("");
        CampoFechModif.setText("");
        CampoUnidadMed.setText("");
        CampoEstado.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Actualizar = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CampoCodProveedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        CampoCodProducto = new javax.swing.JTextField();
        CampoDescripcion = new javax.swing.JTextField();
        CampoCategoria = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        CampoFechVencim = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        CampoFechCrea = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        CampoFechModif = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        CampoUnidadMed = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        CampoEstado = new javax.swing.JComboBox<>();
        Insertar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Eliminar = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new Fondo();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon3.jpg"))); // NOI18N
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, 50, 50));

        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-buscar.jpg"))); // NOI18N
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 50, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Actualizar");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Limpiar");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        CampoCodProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCodProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(CampoCodProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 100, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CodCategoria");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descripcion");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));
        getContentPane().add(CampoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 100, -1));

        CampoCodProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCodProductoActionPerformed(evt);
            }
        });
        getContentPane().add(CampoCodProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 100, -1));

        CampoDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(CampoDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 100, -1));

        CampoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(CampoCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CodProducto");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CodProveedor");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Producto");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Fecha de Vencimiento");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        CampoFechVencim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoFechVencimActionPerformed(evt);
            }
        });
        getContentPane().add(CampoFechVencim, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 100, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Fecha de Creacion");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        CampoFechCrea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoFechCreaActionPerformed(evt);
            }
        });
        getContentPane().add(CampoFechCrea, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 100, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Fecha de Modificacion");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        CampoFechModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoFechModifActionPerformed(evt);
            }
        });
        getContentPane().add(CampoFechModif, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 100, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Unidad de Medida");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        CampoUnidadMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoUnidadMedActionPerformed(evt);
            }
        });
        getContentPane().add(CampoUnidadMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 100, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Estado");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        CampoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(CampoEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 100, -1));

        Insertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-guardar.jpg"))); // NOI18N
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });
        getContentPane().add(Insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 50, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Insertar");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Eliminar");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-eliminar.jpg"))); // NOI18N
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 50, 50));

        Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icono-limpiar.png"))); // NOI18N
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 260, 50, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Buscar");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 920, 220));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoCodProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCodProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCodProductoActionPerformed

    private void CampoDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDescripcionActionPerformed

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        String codProveedor = CampoCodProveedor.getText();
        String codCategoria = CampoCategoria.getText();
        String nombre = CampoNombre.getText();
        String descripcion = CampoDescripcion.getText();
        String fecha = CampoFechVencim.getText();
        String unidadMedida = CampoUnidadMed.getText();

        if (codProveedor.isEmpty() || codCategoria.isEmpty() || nombre.isEmpty()
                || descripcion.isEmpty() || fecha.isEmpty() || unidadMedida.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se aceptan campos vacios");
        } else {
            if (!codProveedor.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "El codigo del porveedor debe contener solo numeros validos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!codCategoria.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "El codigo del porveedor debe contener solo numeros validos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!nombre.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "El campo nombre solo debe de contener letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!descripcion.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "El campo nombre solo debe de contener letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
                JOptionPane.showMessageDialog(this, "El formato de la fecha de contrato debe ser yyyy-MM-dd", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!unidadMedida.matches("^\\d*\\.?\\d+\\s*(kg|g|lb|oz)?$")) {
                JOptionPane.showMessageDialog(this, "El campo de medida no es válido. Ejemplos válidos: '12 kg', '3.5 lb', '500 g', etc.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);

                String fecha_vencimiento = fecha;

                DaoProducto daoProducto = new DaoProducto();

                int codProveInt = Integer.parseInt(codProveedor);
                int codCatInt = Integer.parseInt(codCategoria);
                int resultado = daoProducto.insertarProducto(codProveInt, codCatInt, nombre,
                        descripcion, fecha_vencimiento, unidadMedida);
                if (resultado == 1) {
                    JOptionPane.showMessageDialog(this, "Proveedor insertado correctamente");
                    cargarDatosEnTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al insertar proveedor");
                }
            }
        }
    }//GEN-LAST:event_InsertarActionPerformed

    private void CampoFechVencimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoFechVencimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoFechVencimActionPerformed

    private void CampoFechCreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoFechCreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoFechCreaActionPerformed

    private void CampoFechModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoFechModifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoFechModifActionPerformed

    private void CampoUnidadMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoUnidadMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoUnidadMedActionPerformed

    private void CampoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCategoriaActionPerformed

    private void CampoCodProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCodProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCodProveedorActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_LimpiarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        String codproducto = CampoCodProducto.getText();
        String coproveedor = CampoCodProveedor.getText();
        String codcategoria = CampoCategoria.getText();
        String nombre = CampoNombre.getText();
        String descripcion = CampoDescripcion.getText();
        String fecha = CampoFechVencim.getText();
        String fechacrea = CampoFechCrea.getText();
        String fechamodi = CampoFechModif.getText();
        String unidadMedida = CampoUnidadMed.getText();
        String estadoSTR = CampoEstado.getSelectedItem().toString();

        if (codproducto.isEmpty() || coproveedor.isEmpty() || codcategoria.isEmpty() || nombre.isEmpty()
                || descripcion.isEmpty() || fecha.isEmpty() || fechacrea.isEmpty() || 
                unidadMedida.isEmpty() || estadoSTR.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ningún campo debe estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int codProducto = Integer.parseInt(codproducto);
                int codProveedor = Integer.parseInt(coproveedor);
                int codCategoria = Integer.parseInt(codcategoria);
                byte estado = 1;

                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha_vencimiento = null;
                Date fecha_creacion = null;
                Date fecha_modificacion = null;
                try {
                    fecha_vencimiento = formato.parse(fecha);
                    fecha_creacion = formato.parse(fechacrea);
                    fecha_modificacion = formato.parse(fechamodi);
                } catch (ParseException e) {
                    System.out.println("Error en la conversion de las fechas");

                }

                DaoProducto daoProducto = new DaoProducto();

                if (estadoSTR.equals("Activo")) {
                    estado = 1;
                } else if (estadoSTR.equals("Inactivo")) {
                    estado = 0;
                } else {
                    JOptionPane.showMessageDialog(this, "Valor de estado no válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return; // Sal del método si el estado no es válido.
                }

                Producto prod = new Producto(codProducto, codProveedor, codCategoria, nombre, descripcion, fecha_vencimiento,
                        fecha_creacion, fecha_modificacion, unidadMedida, estado);
                DaoProducto dp = new DaoProducto();

                int resultado = dp.actualizarProducto(prod);

                if (resultado == 1) {
                    JOptionPane.showMessageDialog(this, "Producto actualizado correctamente.");

                    cargarDatosEnTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El código de producto debe ser un número válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int filaSeleccionada = jTable2.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un producto para eliminar.");
            return;
        }
        int codProducto = (int) jTable2.getValueAt(filaSeleccionada, 0);

        DaoProducto daoProducto = new DaoProducto();

        Producto p = new Producto(codProducto);

        int resultado = daoProducto.eliminarProducto(p);

        if (resultado == 1) {
            JOptionPane.showMessageDialog(this, "Proveedor eliminado correctamente.");

            // Recargar los datos en la tabla después de la eliminación.
            cargarDatosEnTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el proveedor.", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        String nombre = CampoNombre.getText();
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

            DaoProducto daoProducto = new DaoProducto();

            List<Producto> productos = daoProducto.buscarProductos(nombre, estado);

            if (productos != null) {
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.setRowCount(0);
                for (Producto producto : productos) {
                    model.addRow(new Object[]{
                        producto.getCodProducto(),
                        producto.getCodProveedor(),
                        producto.getCodCategoria(),
                        producto.getNombre(),
                        producto.getDescripcion(),
                        producto.getFecha_vencimiento(),
                        producto.getFecha_creacion(),
                        producto.getFecha_modificacion(),
                        producto.getUnidadMedida(),
                        producto.getEstado()});
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al buscar proveedores.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // Si todos los campos están vacíos, muestra todos los registros
            DaoProducto dp = new DaoProducto();
            
             List<Producto> productos = dp.buscarProductos(nombre, estado);

            if (productos != null) {
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.setRowCount(0);
                for (Producto producto : productos) {
                    model.addRow(new Object[]{
                        producto.getCodProducto(),
                        producto.getCodProveedor(),
                        producto.getCodCategoria(),
                        producto.getNombre(),
                        producto.getDescripcion(),
                        producto.getFecha_vencimiento(),
                        producto.getFecha_creacion(),
                        producto.getFecha_modificacion(),
                        producto.getUnidadMedida(),
                        producto.getEstado()});
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener los prouctos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_BuscarActionPerformed

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
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField CampoCategoria;
    private javax.swing.JTextField CampoCodProducto;
    private javax.swing.JTextField CampoCodProveedor;
    private javax.swing.JTextField CampoDescripcion;
    private javax.swing.JComboBox<String> CampoEstado;
    private javax.swing.JTextField CampoFechCrea;
    private javax.swing.JTextField CampoFechModif;
    private javax.swing.JTextField CampoFechVencim;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JTextField CampoUnidadMed;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Insertar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
