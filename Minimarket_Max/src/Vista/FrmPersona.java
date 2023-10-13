package Vista;

import Dao.DaoPersona;
import Model.Persona;
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

public class FrmPersona extends javax.swing.JInternalFrame {

    public FrmPersona() {
        initComponents();
        this.setTitle("Mantenimiento Cliente");
        this.setFrameIcon(Utileria.IconoImg());
        CampoCodPersona.setEditable(false);
        CampoSalt.setEditable(false);
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow >= 0) {
                        // Obtén los valores de la fila seleccionada
                        String codPersona = jTable1.getValueAt(selectedRow, 0).toString();
                        String codigo = jTable1.getValueAt(selectedRow, 1).toString();
                        String nombre = jTable1.getValueAt(selectedRow, 2).toString();
                        String ap_pat = jTable1.getValueAt(selectedRow, 3).toString();
                        String ap_mat = jTable1.getValueAt(selectedRow, 4).toString();
                        String dni = jTable1.getValueAt(selectedRow, 5).toString();
                        String fecha_contrato = jTable1.getValueAt(selectedRow, 6).toString();
                        String salario = jTable1.getValueAt(selectedRow, 7).toString();
                        String ususario = jTable1.getValueAt(selectedRow, 8).toString();
                        String contrasena = jTable1.getValueAt(selectedRow, 9).toString();
                        String salt = jTable1.getValueAt(selectedRow, 10).toString();
                        String cargo = jTable1.getValueAt(selectedRow, 11).toString();
                        String estado = jTable1.getValueAt(selectedRow, 12).toString();

                        // Rellena los campos de JTextField
                        CampoCodPersona.setText(codPersona);
                        CampoCodigo.setText(codigo);
                        CampoNombre.setText(nombre);
                        CampoApPat.setText(ap_pat);
                        CampoApMat.setText(ap_mat);
                        CampoDni.setText(dni);
                        CampoFechContrato.setText(fecha_contrato);
                        CampoSalario.setText(salario);
                        CampoUsuario.setText(ususario);
                        CampoContrasena.setText(contrasena);
                        CampoSalt.setText(salt);
                        CampoCargo.setText(cargo);
                        CampoEstado.setSelectedItem(estado);
                    }
                }
            }
        });
        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {

        DaoPersona daoPersona = new DaoPersona();
        List<Persona> personas = daoPersona.listarPersonas();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo Persona");
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Apellido Paterno");
        model.addColumn("Apellido Materno");
        model.addColumn("DNI");
        model.addColumn("Fecha de Contrato");
        model.addColumn("Salario");
        model.addColumn("Usuario");
        model.addColumn("Contrasena");
        model.addColumn("Salt");
        model.addColumn("Cargo");
        model.addColumn("Estado");

        for (Persona personad : personas) {
            model.addRow(new Object[]{
                personad.getCodPersona(),
                personad.getCodigo(),
                personad.getNombre(),
                personad.getAp_pat(),
                personad.getAp_mat(),
                personad.getDni(),
                personad.getFechaContrato(),
                personad.getSalario(),
                personad.getUsuario(),
                personad.getContrasena(),
                personad.getSalt(),
                personad.getCargo(),
                personad.getEstado()
            });
        }
        jTable1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CampoCodPersona = new javax.swing.JTextField();
        CampoCodigo = new javax.swing.JTextField();
        CampoNombre = new javax.swing.JTextField();
        CampoApPat = new javax.swing.JTextField();
        CampoApMat = new javax.swing.JTextField();
        CampoFechContrato = new javax.swing.JTextField();
        CampoSalario = new javax.swing.JTextField();
        CampoContrasena = new javax.swing.JTextField();
        CampoUsuario = new javax.swing.JTextField();
        CampoCargo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        InsertarPersona = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        ActualizarPersona = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        BuscarPersona = new javax.swing.JButton();
        EliminarPerosna = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        CampoDni = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        CampoEstado = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        CampoSalt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new Fondo();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Personas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CodPersona");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Codigo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido Paterno");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apellido Materno");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha Contrato");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Usuario");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contraseña");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cargo");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Salario");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, 20));
        getContentPane().add(CampoCodPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 111, -1));
        getContentPane().add(CampoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 159, 111, -1));
        getContentPane().add(CampoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 111, -1));
        getContentPane().add(CampoApPat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 111, -1));
        getContentPane().add(CampoApMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 111, -1));
        getContentPane().add(CampoFechContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 103, -1));
        getContentPane().add(CampoSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 103, -1));
        getContentPane().add(CampoContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 103, -1));
        getContentPane().add(CampoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 103, -1));
        getContentPane().add(CampoCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 103, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Insertar");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, -1, -1));

        InsertarPersona.setBackground(new java.awt.Color(30, 30, 30));
        InsertarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-guardar.jpg"))); // NOI18N
        InsertarPersona.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        InsertarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarPersonaActionPerformed(evt);
            }
        });
        getContentPane().add(InsertarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 50, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Actualizar");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, -1, -1));

        ActualizarPersona.setBackground(new java.awt.Color(30, 30, 30));
        ActualizarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon3.jpg"))); // NOI18N
        ActualizarPersona.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ActualizarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarPersonaActionPerformed(evt);
            }
        });
        getContentPane().add(ActualizarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, 50, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Buscar");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 220, -1, -1));

        BuscarPersona.setBackground(new java.awt.Color(30, 30, 30));
        BuscarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-buscar.jpg"))); // NOI18N
        BuscarPersona.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BuscarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarPersonaActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 210, 50, 40));

        EliminarPerosna.setBackground(new java.awt.Color(30, 30, 30));
        EliminarPerosna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-eliminar.jpg"))); // NOI18N
        EliminarPerosna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarPerosna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarPerosnaActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarPerosna, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 150, 50, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Eliminar");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 160, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("DNI");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));
        getContentPane().add(CampoDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 111, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Estado");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        CampoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(CampoEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 100, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Salt");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, -1, -1));
        getContentPane().add(CampoSalt, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 103, -1));

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
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 1140, 210));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1170, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarPersonaActionPerformed
        String codigo = CampoCodigo.getText();
        String nombre = CampoNombre.getText();
        String ap_pat = CampoApPat.getText();
        String ap_mat = CampoApPat.getText();
        String dni = CampoDni.getText();
        String fechacontrato = CampoFechContrato.getText();
        String salario = CampoSalario.getText();
        String usuario = CampoUsuario.getText();
        String contrasena = CampoContrasena.getText();
        String cargo = CampoCargo.getText();

        if (codigo.isEmpty() || nombre.isEmpty() || ap_pat.isEmpty()
                || ap_mat.isEmpty() || dni.isEmpty() || fechacontrato.isEmpty() || salario.isEmpty()
                || usuario.isEmpty() || contrasena.isEmpty() || cargo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se aceptan campos vacios");
        } else {
            if (!dni.matches("\\d{1,8}")) {
                JOptionPane.showMessageDialog(this, "El DNI debe contener solo 8 dígitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (dni.length() != 8) {
                JOptionPane.showMessageDialog(this, "El formato de la fecha de contrato debe ser yyyy-MM-dd", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!fechacontrato.matches("\\d{4}-\\d{2}-\\d{2}")) {
                JOptionPane.showMessageDialog(this, "El formato de la fecha de contrato debe ser yyyy-MM-dd", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!salario.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "El salario debe ser un número válido (sin letras ni caracteres especiales,)", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!nombre.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "El campo de nombre debe contener solo letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!ap_pat.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "El campo de apellido paterno debe contener solo letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!ap_mat.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "El campo de apellido materno debe contener solo letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!cargo.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "El campo de cargo debe contener solo letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);

                String fechaSQL = fechacontrato;
                DaoPersona daoPersona = new DaoPersona();

                int dniInt = Integer.parseInt(dni);
                int salarioInt = Integer.parseInt(salario);
                int resultado = daoPersona.insertarPersona(codigo, nombre, ap_pat, ap_mat, dniInt, fechaSQL, salarioInt, usuario, contrasena, cargo);
                if (resultado == 1) {
                    JOptionPane.showMessageDialog(this, "Proveedor insertado correctamente");
                    cargarDatosEnTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al insertar proveedor");
                }
            }
        }
    }//GEN-LAST:event_InsertarPersonaActionPerformed

    private void ActualizarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarPersonaActionPerformed
        String codpersona = CampoCodPersona.getText();
        String codigo = CampoCodigo.getText();
        String nombre = CampoNombre.getText();
        String ap_pat = CampoApPat.getText();
        String ap_mat = CampoApMat.getText();
        String DNI = CampoDni.getText();
        String fecha = CampoFechContrato.getText();
        String SALARIO = CampoSalario.getText();
        String usuario = CampoUsuario.getText();
        String contrasena = CampoContrasena.getText();
        String cargo = CampoCargo.getText();
        String saltStr = CampoSalt.getText();
        String estadoStr = CampoEstado.getSelectedItem().toString();

        if (codpersona.isEmpty() || codigo.isEmpty() || nombre.isEmpty() || ap_pat.isEmpty()
                || ap_mat.isEmpty() || DNI.isEmpty() || fecha.isEmpty() || SALARIO.isEmpty()
                || usuario.isEmpty() || cargo.isEmpty() || estadoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ningún campo debe estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                int codPersona = Integer.parseInt(codpersona);
                int dni = Integer.parseInt(DNI);
                int salario = Integer.parseInt(SALARIO);
                byte estado = 1;

                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaContrato = null;

                try {
                    fechaContrato = formato.parse(fecha);
                } catch (ParseException e) {
                    System.out.println("Error en la conversion dela fecha");

                }

                byte[] salt = saltStr.getBytes();
                DaoPersona daoPersona = new DaoPersona();

                if (estadoStr.equals("Activo")) {
                    estado = 1;
                } else if (estadoStr.equals("Inactivo")) {
                    estado = 0;
                } else {
                    JOptionPane.showMessageDialog(this, "Valor de estado no válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return; // Sal del método si el estado no es válido.
                }

                Persona persona = new Persona(codPersona, codigo, nombre, ap_pat, ap_mat, dni,
                        fechaContrato, salario, usuario, contrasena, salt, cargo, estado);
                DaoPersona dp = new DaoPersona();

                int resultado = dp.actualizarPersona(persona);

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
    }//GEN-LAST:event_ActualizarPersonaActionPerformed

    private void BuscarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarPersonaActionPerformed
        String codigo = CampoCodigo.getText();
        String nombre = CampoNombre.getText();
        String ap_pat = CampoApPat.getText();
        String ap_mat = CampoApMat.getText();
        String DNI = CampoDni.getText();
        String estadoStr = CampoEstado.getSelectedItem().toString();
        Byte estado = null;

// Verifica si al menos un campo de búsqueda no está vacío
        if (!codigo.isEmpty() || !nombre.isEmpty() || !ap_pat.isEmpty() || !ap_mat.isEmpty() || !DNI.isEmpty() || !estadoStr.isEmpty()) {
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

            DaoPersona daoPersona = new DaoPersona();
            int dni = Integer.parseInt(DNI);

            List<Persona> personas = daoPersona.buscarPersonas(codigo, nombre, ap_pat, ap_mat, dni, estado);

            if (personas != null) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Persona persona : personas) {
                    model.addRow(new Object[]{
                        persona.getCodPersona(),
                        persona.getCodigo(),
                        persona.getNombre(),
                        persona.getAp_pat(),
                        persona.getAp_mat(),
                        persona.getDni(),
                        persona.getFechaContrato(),
                        persona.getSalario(),
                        persona.getUsuario(),
                        persona.getContrasena(),
                        persona.getSalt(),
                        persona.getCargo(),
                        persona.getEstado()});
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al buscar proveedores.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // Si todos los campos están vacíos, muestra todos los registros
            DaoPersona daoPersona = new DaoPersona();
            int dni = Integer.parseInt(DNI);
            List<Persona> personas = daoPersona.buscarPersonas(codigo, nombre, ap_pat, ap_mat, dni, estado);

            if (personas != null) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (Persona persona : personas) {
                    model.addRow(new Object[]{
                        persona.getCodPersona(),
                        persona.getCodigo(),
                        persona.getNombre(),
                        persona.getAp_pat(),
                        persona.getAp_mat(),
                        persona.getDni(),
                        persona.getFechaContrato(),
                        persona.getSalario(),
                        persona.getUsuario(),
                        persona.getContrasena(),
                        persona.getSalt(),
                        persona.getCargo(),
                        persona.getEstado()});
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener proveedores.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_BuscarPersonaActionPerformed

    private void EliminarPerosnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarPerosnaActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un proveedor para eliminar.");
            return;
        }
        int codPersona = (int) jTable1.getValueAt(filaSeleccionada, 0);

        DaoPersona daoPersona = new DaoPersona();

        Persona persona = new Persona(codPersona);

        int resultado = daoPersona.eliminarPersona(persona);

        if (resultado == 1) {
            JOptionPane.showMessageDialog(this, "Proveedor eliminado correctamente.");

            // Recargar los datos en la tabla después de la eliminación.
            cargarDatosEnTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el proveedor.", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_EliminarPerosnaActionPerformed

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
    private javax.swing.JButton ActualizarPersona;
    private javax.swing.JButton BuscarPersona;
    private javax.swing.JTextField CampoApMat;
    private javax.swing.JTextField CampoApPat;
    private javax.swing.JTextField CampoCargo;
    private javax.swing.JTextField CampoCodPersona;
    private javax.swing.JTextField CampoCodigo;
    private javax.swing.JTextField CampoContrasena;
    private javax.swing.JTextField CampoDni;
    private javax.swing.JComboBox<String> CampoEstado;
    private javax.swing.JTextField CampoFechContrato;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JTextField CampoSalario;
    private javax.swing.JTextField CampoSalt;
    private javax.swing.JTextField CampoUsuario;
    private javax.swing.JButton EliminarPerosna;
    private javax.swing.JButton InsertarPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
