/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Utils.PanelFondo;
import Utils.Utileria;
import javax.swing.JInternalFrame;

/**
 *
 * @author juan_
 */
public class FrmMenu extends javax.swing.JFrame {

    private FrmProveedor frmProveedor = new FrmProveedor();
    private FrmProducto frmProductos = new FrmProducto();
    private FrmIventario frmIventario = new FrmIventario();
    private FrmVenta frmVenta = new FrmVenta();
    private FrmCliente frmCliente = new FrmCliente();
    private FrmPersona frmPersona = new FrmPersona();
    private FrmCategoria frmCategoria =  new FrmCategoria();

    public FrmMenu() {
        initComponents();

        jPanelPrincipal.setBorder(new PanelFondo());
        this.setExtendedState(FrmMenu.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setTitle("Menu Principal");
        setIconImage(Utileria.Icono());
    }

    private void AbrirFormulario(JInternalFrame form) {
        if (!form.isVisible()) {
            jPanelPrincipal.add(form);
            form.setLocation(200, 40);
            form.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Configuracion = new javax.swing.JMenu();
        CerrarSesion = new javax.swing.JMenuItem();
        Mantenimiento = new javax.swing.JMenu();
        ProductosMenu = new javax.swing.JMenuItem();
        ClientesMenu = new javax.swing.JMenuItem();
        InventarioMenu = new javax.swing.JMenuItem();
        ProveedorMenu = new javax.swing.JMenuItem();
        PersonaMenu = new javax.swing.JMenuItem();
        CategoriaMenu = new javax.swing.JMenuItem();
        Ventas = new javax.swing.JMenu();
        NuevaVentaMenu = new javax.swing.JMenuItem();
        DetalleVentaMenu = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        ConsultarMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        Configuracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-config.png"))); // NOI18N
        Configuracion.setText("Configuracion");
        Configuracion.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N

        CerrarSesion.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N
        CerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-close.png"))); // NOI18N
        CerrarSesion.setText("Cerrar Sesion");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        Configuracion.add(CerrarSesion);

        jMenuBar1.add(Configuracion);

        Mantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-option.png"))); // NOI18N
        Mantenimiento.setText("Mantenimiento");
        Mantenimiento.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N

        ProductosMenu.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N
        ProductosMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-products.jpg"))); // NOI18N
        ProductosMenu.setText("Productos");
        ProductosMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductosMenuActionPerformed(evt);
            }
        });
        Mantenimiento.add(ProductosMenu);

        ClientesMenu.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N
        ClientesMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-customer.jpg"))); // NOI18N
        ClientesMenu.setText("Clientes");
        ClientesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesMenuActionPerformed(evt);
            }
        });
        Mantenimiento.add(ClientesMenu);

        InventarioMenu.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N
        InventarioMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-inventario.jpg"))); // NOI18N
        InventarioMenu.setText("Inventario");
        InventarioMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioMenuActionPerformed(evt);
            }
        });
        Mantenimiento.add(InventarioMenu);

        ProveedorMenu.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N
        ProveedorMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-proveedor.jpg"))); // NOI18N
        ProveedorMenu.setText("Proveedor");
        ProveedorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedorMenuActionPerformed(evt);
            }
        });
        Mantenimiento.add(ProveedorMenu);

        PersonaMenu.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N
        PersonaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-persona.png"))); // NOI18N
        PersonaMenu.setText("Persona");
        PersonaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonaMenuActionPerformed(evt);
            }
        });
        Mantenimiento.add(PersonaMenu);

        CategoriaMenu.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N
        CategoriaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icono-categoria.png"))); // NOI18N
        CategoriaMenu.setText("Categoria");
        CategoriaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriaMenuActionPerformed(evt);
            }
        });
        Mantenimiento.add(CategoriaMenu);

        jMenuBar1.add(Mantenimiento);

        Ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-cart.png"))); // NOI18N
        Ventas.setText("Ventas");

        NuevaVentaMenu.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N
        NuevaVentaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-cart-add.png"))); // NOI18N
        NuevaVentaMenu.setText("Nueva Venta");
        NuevaVentaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaVentaMenuActionPerformed(evt);
            }
        });
        Ventas.add(NuevaVentaMenu);

        DetalleVentaMenu.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N
        DetalleVentaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-detalleventa.png"))); // NOI18N
        DetalleVentaMenu.setText("Detalle Venta");
        DetalleVentaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetalleVentaMenuActionPerformed(evt);
            }
        });
        Ventas.add(DetalleVentaMenu);

        jMenuBar1.add(Ventas);

        Consultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-query.png"))); // NOI18N
        Consultas.setText("Consultas");
        Consultas.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N

        ConsultarMenu.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 12)); // NOI18N
        ConsultarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon-find_search.png"))); // NOI18N
        ConsultarMenu.setText("Consultar");
        ConsultarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarMenuActionPerformed(evt);
            }
        });
        Consultas.add(ConsultarMenu);

        jMenuBar1.add(Consultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void ProductosMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductosMenuActionPerformed
        AbrirFormulario(frmProductos);
    }//GEN-LAST:event_ProductosMenuActionPerformed

    private void ClientesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesMenuActionPerformed
        AbrirFormulario(frmCliente);
    }//GEN-LAST:event_ClientesMenuActionPerformed

    private void InventarioMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioMenuActionPerformed
        AbrirFormulario(frmIventario);
    }//GEN-LAST:event_InventarioMenuActionPerformed

    private void NuevaVentaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaVentaMenuActionPerformed
        AbrirFormulario(frmVenta);
    }//GEN-LAST:event_NuevaVentaMenuActionPerformed

    private void DetalleVentaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetalleVentaMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DetalleVentaMenuActionPerformed

    private void ConsultarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConsultarMenuActionPerformed

    private void ProveedorMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedorMenuActionPerformed
        AbrirFormulario(frmProveedor);
    }//GEN-LAST:event_ProveedorMenuActionPerformed

    private void PersonaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonaMenuActionPerformed
        AbrirFormulario(frmPersona);
    }//GEN-LAST:event_PersonaMenuActionPerformed

    private void CategoriaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaMenuActionPerformed
        AbrirFormulario(frmCategoria);
    }//GEN-LAST:event_CategoriaMenuActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CategoriaMenu;
    private javax.swing.JMenuItem CerrarSesion;
    private javax.swing.JMenuItem ClientesMenu;
    private javax.swing.JMenu Configuracion;
    private javax.swing.JMenuItem ConsultarMenu;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenuItem DetalleVentaMenu;
    private javax.swing.JMenuItem InventarioMenu;
    private javax.swing.JMenu Mantenimiento;
    private javax.swing.JMenuItem NuevaVentaMenu;
    private javax.swing.JMenuItem PersonaMenu;
    private javax.swing.JMenuItem ProductosMenu;
    private javax.swing.JMenuItem ProveedorMenu;
    private javax.swing.JMenu Ventas;
    private javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JDesktopPane jPanelPrincipal;
    // End of variables declaration//GEN-END:variables
}
