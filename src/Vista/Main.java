/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.CConexion;
import Modelo.productos;
import Modelo.usuarios;
import javax.swing.ImageIcon;
import desplazable.Desface;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rnmel
 */
public class Main extends javax.swing.JFrame {

    Desface desplace;
    public Main() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Vista/Iconos/CASA.png")).getImage());

        rsscalelabel.RSScaleLabel.setScaleLabel(txtLogo, "src/Vista/Iconos/logo.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(Casaicon, "src/Vista/Iconos/hogar.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(Productoicon, "src/Vista/Iconos/bolso.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(Clienteicon, "src/Vista/Iconos/usuario.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(Bitacoraicon, "src/Vista/Iconos/libreta.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(Trabajadoricon, "src/Vista/Iconos/obrero.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(Rutaicon, "src/Vista/Iconos/entrega.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(Bodegaicon, "src/Vista/Iconos/almacenamiento.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(txtBarras, "src/Vista/Iconos/lista.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(icoCarro, "src/Vista/Iconos/vehiculo.png");
        
        desplace = new Desface();
        
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MenuPlegable = new javax.swing.JPanel();
        btnCasa = new Vista.PanelCurvas();
        Casaicon = new javax.swing.JLabel();
        txtCasa = new javax.swing.JLabel();
        txtLogo = new javax.swing.JLabel();
        txtBarras = new javax.swing.JLabel();
        btnProducto = new Vista.PanelCurvas();
        Productoicon = new javax.swing.JLabel();
        txtproducto = new javax.swing.JLabel();
        btnTrabajador = new Vista.PanelCurvas();
        Trabajadoricon = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JLabel();
        btnBodega = new Vista.PanelCurvas();
        Bodegaicon = new javax.swing.JLabel();
        txtBodega = new javax.swing.JLabel();
        btnBitacora = new Vista.PanelCurvas();
        Bitacoraicon = new javax.swing.JLabel();
        txtBitacora = new javax.swing.JLabel();
        btnCliente = new Vista.PanelCurvas();
        Clienteicon = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        btnRuta = new Vista.PanelCurvas();
        Rutaicon = new javax.swing.JLabel();
        txtRuta = new javax.swing.JLabel();
        btnVehiculos = new Vista.PanelCurvas();
        icoCarro = new javax.swing.JLabel();
        txtCliente2 = new javax.swing.JLabel();
        btnSalir = new Vista.PanelCurvas();
        logOut = new javax.swing.JLabel();
        txtBitacora1 = new javax.swing.JLabel();
        Nombrelbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 850));
        setMinimumSize(new java.awt.Dimension(1080, 850));
        setPreferredSize(new java.awt.Dimension(1080, 850));
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 850));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(230, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 810));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuPlegable.setBackground(new java.awt.Color(64, 81, 115));
        MenuPlegable.setMaximumSize(new java.awt.Dimension(230, 900));
        MenuPlegable.setMinimumSize(new java.awt.Dimension(230, 900));
        MenuPlegable.setPreferredSize(new java.awt.Dimension(230, 900));
        MenuPlegable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCasa.setBackground(new java.awt.Color(64, 81, 115));
        btnCasa.setRoundBottomLeft(25);
        btnCasa.setRoundBottomRight(25);
        btnCasa.setRoundTopLeft(25);
        btnCasa.setRoundTopRight(25);
        btnCasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCasaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCasaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCasaMouseExited(evt);
            }
        });

        txtCasa.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        txtCasa.setForeground(new java.awt.Color(255, 255, 255));
        txtCasa.setText("Inicio");

        javax.swing.GroupLayout btnCasaLayout = new javax.swing.GroupLayout(btnCasa);
        btnCasa.setLayout(btnCasaLayout);
        btnCasaLayout.setHorizontalGroup(
            btnCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCasaLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(txtCasa)
                .addGap(18, 18, 18)
                .addComponent(Casaicon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        btnCasaLayout.setVerticalGroup(
            btnCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCasaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnCasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Casaicon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        MenuPlegable.add(btnCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 230, -1));
        MenuPlegable.add(txtLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        txtBarras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBarrasMouseClicked(evt);
            }
        });
        MenuPlegable.add(txtBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 53, 53));

        btnProducto.setBackground(new java.awt.Color(64, 81, 115));
        btnProducto.setRoundBottomLeft(25);
        btnProducto.setRoundBottomRight(25);
        btnProducto.setRoundTopLeft(25);
        btnProducto.setRoundTopRight(25);
        btnProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductoMouseExited(evt);
            }
        });

        txtproducto.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        txtproducto.setForeground(new java.awt.Color(255, 255, 255));
        txtproducto.setText("Productos");

        javax.swing.GroupLayout btnProductoLayout = new javax.swing.GroupLayout(btnProducto);
        btnProducto.setLayout(btnProductoLayout);
        btnProductoLayout.setHorizontalGroup(
            btnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnProductoLayout.createSequentialGroup()
                .addGap(0, 59, Short.MAX_VALUE)
                .addComponent(txtproducto)
                .addGap(18, 18, 18)
                .addComponent(Productoicon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        btnProductoLayout.setVerticalGroup(
            btnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnProductoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Productoicon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        MenuPlegable.add(btnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, 50));

        btnTrabajador.setBackground(new java.awt.Color(64, 81, 115));
        btnTrabajador.setRoundBottomLeft(25);
        btnTrabajador.setRoundBottomRight(25);
        btnTrabajador.setRoundTopLeft(25);
        btnTrabajador.setRoundTopRight(25);
        btnTrabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrabajadorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrabajadorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrabajadorMouseExited(evt);
            }
        });

        txtEmpleado.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        txtEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        txtEmpleado.setText("Empleados");

        javax.swing.GroupLayout btnTrabajadorLayout = new javax.swing.GroupLayout(btnTrabajador);
        btnTrabajador.setLayout(btnTrabajadorLayout);
        btnTrabajadorLayout.setHorizontalGroup(
            btnTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTrabajadorLayout.createSequentialGroup()
                .addGap(0, 58, Short.MAX_VALUE)
                .addComponent(txtEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Trabajadoricon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        btnTrabajadorLayout.setVerticalGroup(
            btnTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTrabajadorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Trabajadoricon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        MenuPlegable.add(btnTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, 50));

        btnBodega.setBackground(new java.awt.Color(64, 81, 115));
        btnBodega.setRoundBottomLeft(25);
        btnBodega.setRoundBottomRight(25);
        btnBodega.setRoundTopLeft(25);
        btnBodega.setRoundTopRight(25);
        btnBodega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBodegaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBodegaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBodegaMouseExited(evt);
            }
        });

        txtBodega.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        txtBodega.setForeground(new java.awt.Color(255, 255, 255));
        txtBodega.setText("Bodegas");

        javax.swing.GroupLayout btnBodegaLayout = new javax.swing.GroupLayout(btnBodega);
        btnBodega.setLayout(btnBodegaLayout);
        btnBodegaLayout.setHorizontalGroup(
            btnBodegaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBodegaLayout.createSequentialGroup()
                .addGap(0, 76, Short.MAX_VALUE)
                .addComponent(txtBodega)
                .addGap(18, 18, 18)
                .addComponent(Bodegaicon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        btnBodegaLayout.setVerticalGroup(
            btnBodegaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBodegaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnBodegaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bodegaicon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        MenuPlegable.add(btnBodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, -1));

        btnBitacora.setBackground(new java.awt.Color(64, 81, 115));
        btnBitacora.setRoundBottomLeft(25);
        btnBitacora.setRoundBottomRight(25);
        btnBitacora.setRoundTopLeft(25);
        btnBitacora.setRoundTopRight(25);
        btnBitacora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBitacoraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBitacoraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBitacoraMouseExited(evt);
            }
        });

        txtBitacora.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        txtBitacora.setForeground(new java.awt.Color(255, 255, 255));
        txtBitacora.setText("Bitacora");

        javax.swing.GroupLayout btnBitacoraLayout = new javax.swing.GroupLayout(btnBitacora);
        btnBitacora.setLayout(btnBitacoraLayout);
        btnBitacoraLayout.setHorizontalGroup(
            btnBitacoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBitacoraLayout.createSequentialGroup()
                .addGap(0, 78, Short.MAX_VALUE)
                .addComponent(txtBitacora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bitacoraicon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        btnBitacoraLayout.setVerticalGroup(
            btnBitacoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBitacoraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnBitacoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bitacoraicon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        MenuPlegable.add(btnBitacora, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, -1, -1));

        btnCliente.setBackground(new java.awt.Color(64, 81, 115));
        btnCliente.setRoundBottomLeft(25);
        btnCliente.setRoundBottomRight(25);
        btnCliente.setRoundTopLeft(25);
        btnCliente.setRoundTopRight(25);
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClienteMouseExited(evt);
            }
        });

        txtCliente.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        txtCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente.setText("Cliente");

        javax.swing.GroupLayout btnClienteLayout = new javax.swing.GroupLayout(btnCliente);
        btnCliente.setLayout(btnClienteLayout);
        btnClienteLayout.setHorizontalGroup(
            btnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnClienteLayout.createSequentialGroup()
                .addGap(0, 81, Short.MAX_VALUE)
                .addComponent(txtCliente)
                .addGap(25, 25, 25)
                .addComponent(Clienteicon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnClienteLayout.setVerticalGroup(
            btnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clienteicon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        MenuPlegable.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 230, -1));

        btnRuta.setBackground(new java.awt.Color(64, 81, 115));
        btnRuta.setRoundBottomLeft(25);
        btnRuta.setRoundBottomRight(25);
        btnRuta.setRoundTopLeft(25);
        btnRuta.setRoundTopRight(25);
        btnRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRutaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRutaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRutaMouseExited(evt);
            }
        });

        txtRuta.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        txtRuta.setForeground(new java.awt.Color(255, 255, 255));
        txtRuta.setText("Rutas");

        javax.swing.GroupLayout btnRutaLayout = new javax.swing.GroupLayout(btnRuta);
        btnRuta.setLayout(btnRutaLayout);
        btnRutaLayout.setHorizontalGroup(
            btnRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRutaLayout.createSequentialGroup()
                .addGap(0, 101, Short.MAX_VALUE)
                .addComponent(txtRuta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Rutaicon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        btnRutaLayout.setVerticalGroup(
            btnRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRutaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rutaicon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        MenuPlegable.add(btnRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, -1, -1));

        btnVehiculos.setBackground(new java.awt.Color(64, 81, 115));
        btnVehiculos.setRoundBottomLeft(25);
        btnVehiculos.setRoundBottomRight(25);
        btnVehiculos.setRoundTopLeft(25);
        btnVehiculos.setRoundTopRight(25);
        btnVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVehiculosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVehiculosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVehiculosMouseExited(evt);
            }
        });

        icoCarro.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        icoCarro.setForeground(new java.awt.Color(255, 255, 255));

        txtCliente2.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        txtCliente2.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente2.setText("Vehiculos");

        javax.swing.GroupLayout btnVehiculosLayout = new javax.swing.GroupLayout(btnVehiculos);
        btnVehiculos.setLayout(btnVehiculosLayout);
        btnVehiculosLayout.setHorizontalGroup(
            btnVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVehiculosLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(txtCliente2)
                .addGap(18, 18, 18)
                .addComponent(icoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnVehiculosLayout.setVerticalGroup(
            btnVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icoCarro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVehiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCliente2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        MenuPlegable.add(btnVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 230, 53));

        btnSalir.setBackground(new java.awt.Color(64, 81, 115));
        btnSalir.setRoundBottomLeft(25);
        btnSalir.setRoundBottomRight(25);
        btnSalir.setRoundTopLeft(25);
        btnSalir.setRoundTopRight(25);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });

        txtBitacora1.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        txtBitacora1.setForeground(new java.awt.Color(255, 153, 153));
        txtBitacora1.setText("Cerrar secion");

        javax.swing.GroupLayout btnSalirLayout = new javax.swing.GroupLayout(btnSalir);
        btnSalir.setLayout(btnSalirLayout);
        btnSalirLayout.setHorizontalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalirLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(txtBitacora1)
                .addGap(18, 18, 18)
                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnSalirLayout.setVerticalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnSalirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBitacora1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        MenuPlegable.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, 230, 53));

        jPanel1.add(MenuPlegable, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 0, 230, 810));

        Nombrelbl.setText("-----");
        jPanel1.add(Nombrelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 90, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBarrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBarrasMouseClicked
        if (MenuPlegable.getX()==-150) {
            desplace.desplazarDerecha(MenuPlegable, MenuPlegable.getX(), 0, 15, 10);
        } else if(MenuPlegable.getX() == 0) {
            desplace.desplazarIzquierda(MenuPlegable, MenuPlegable.getX(), -150, 15, 10);
        }

    }//GEN-LAST:event_txtBarrasMouseClicked

    //BTN_REACCION_CURSOR////////////////////////////////////////////////////////////
    private void btnCasaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCasaMouseExited
        btnCasa.setBackground(new Color(64,81,115));  
    }//GEN-LAST:event_btnCasaMouseExited

    private void btnCasaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCasaMouseEntered
        btnCasa.setBackground(new Color(45,40,37));   

    }//GEN-LAST:event_btnCasaMouseEntered

    private void btnProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseEntered
        btnProducto.setBackground(new Color(45,40,37));      
    }//GEN-LAST:event_btnProductoMouseEntered

    private void btnProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseExited
        btnProducto.setBackground(new Color(64,81,115));
    }//GEN-LAST:event_btnProductoMouseExited

    private void btnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseExited
        btnCliente.setBackground(new Color(64,81,115));
    }//GEN-LAST:event_btnClienteMouseExited

    private void btnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseEntered
        btnCliente.setBackground(new Color(45,40,37));
    }//GEN-LAST:event_btnClienteMouseEntered

    private void btnBitacoraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBitacoraMouseExited
        btnBitacora.setBackground(new Color(64,81,115));
    }//GEN-LAST:event_btnBitacoraMouseExited

    private void btnBitacoraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBitacoraMouseEntered
        btnBitacora.setBackground(new Color(45,40,37));
    }//GEN-LAST:event_btnBitacoraMouseEntered

    private void btnTrabajadorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrabajadorMouseExited
        btnTrabajador.setBackground(new Color(64,81,115));
    }//GEN-LAST:event_btnTrabajadorMouseExited

    private void btnTrabajadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrabajadorMouseEntered
        btnTrabajador.setBackground(new Color(45,40,37));
    }//GEN-LAST:event_btnTrabajadorMouseEntered

    private void btnRutaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRutaMouseExited
        btnRuta.setBackground(new Color(64,81,115));
    }//GEN-LAST:event_btnRutaMouseExited

    private void btnRutaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRutaMouseEntered
        btnRuta.setBackground(new Color(45,40,37));
    }//GEN-LAST:event_btnRutaMouseEntered

    private void btnBodegaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodegaMouseExited
        btnBodega.setBackground(new Color(64,81,115));
    }//GEN-LAST:event_btnBodegaMouseExited

    private void btnBodegaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodegaMouseEntered
        btnBodega.setBackground(new Color(45,40,37));
    }//GEN-LAST:event_btnBodegaMouseEntered

    //BTN_MOVIMIENTO///////////////////////////////////////////////////////////////
    private void btnCasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCasaMouseClicked
        
    }//GEN-LAST:event_btnCasaMouseClicked

    private void btnProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseClicked
        int resultado = 0;
        String sql = "select idBodega from tbBodegas";
        try {
            Statement sta = CConexion.getConexion().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if (rs.next()) {
                resultado = 1;
                if (resultado == 1) {
                    VProducto vista = new VProducto();
                    vista.NIT();
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Agrege una bodega para continuar");
            }

        } catch (Exception oe) {
            JOptionPane.showMessageDialog(null, "error boton producto//bodega" + oe.toString());
        }

//        VProducto producto = new VProducto();
//        producto.NIT();
//        this.dispose();
    }//GEN-LAST:event_btnProductoMouseClicked

    private void btnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseClicked
        VCliente vista= new VCliente();
        vista.INIT();
        this.dispose();
    }//GEN-LAST:event_btnClienteMouseClicked

    private void btnBitacoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBitacoraMouseClicked
        VBitacora bitacora = new VBitacora();
        bitacora.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBitacoraMouseClicked

    private void btnTrabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrabajadorMouseClicked
        VEmpleados empleados = new VEmpleados();
        empleados.INIT();
        this.dispose();
    }//GEN-LAST:event_btnTrabajadorMouseClicked

    private void btnRutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRutaMouseClicked
        int resultado = 0;
        String sql = "select idProducto from tbProductos";
        try {
            Statement sta = CConexion.getConexion().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if (rs.next()) {
                resultado = 1;
                if (resultado == 1) {
                    VRutas_DatosDis vista = new VRutas_DatosDis();
                    vista.INIT();
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Agrege un producto para continuar");
            }

        } catch (Exception oe) {
            JOptionPane.showMessageDialog(null, "error 1" + oe.toString());
        }
    }//GEN-LAST:event_btnRutaMouseClicked

    private void btnBodegaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodegaMouseClicked
        VBodega bodegas = new VBodega();
        bodegas.INIT();
        this.dispose();
    }//GEN-LAST:event_btnBodegaMouseClicked

    private void btnVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVehiculosMouseClicked
        VVehiculo_Taller vista =new VVehiculo_Taller();
        vista.INIT();
        this.dispose();
    }//GEN-LAST:event_btnVehiculosMouseClicked

    private void btnVehiculosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVehiculosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVehiculosMouseEntered

    private void btnVehiculosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVehiculosMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVehiculosMouseExited

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // [64,81,115]
        LoginPTC vista = new LoginPTC();
        vista.INIT();
        this.dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setBackground(new Color(102,0,0));
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited

        btnSalir.setBackground(new Color(64,81,115));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirMouseExited

    /**
     * @param args the command line arguments
     */
    private String NombreUsr;
    
    public void NombreUsr(String NombreUsr){
        this.NombreUsr=NombreUsr;
        Nombrelbl.setText(NombreUsr);
    }
    
    public void INIT(){
        Main main= new Main();
        main.setVisible(true);
//        txtNombre.setText(modelo.getNombreUsr());
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bitacoraicon;
    private javax.swing.JLabel Bodegaicon;
    private javax.swing.JLabel Casaicon;
    private javax.swing.JLabel Clienteicon;
    private javax.swing.JPanel MenuPlegable;
    private javax.swing.JLabel Nombrelbl;
    private javax.swing.JLabel Productoicon;
    private javax.swing.JLabel Rutaicon;
    private javax.swing.JLabel Trabajadoricon;
    private Vista.PanelCurvas btnBitacora;
    private Vista.PanelCurvas btnBodega;
    private Vista.PanelCurvas btnCasa;
    private Vista.PanelCurvas btnCliente;
    private Vista.PanelCurvas btnProducto;
    private Vista.PanelCurvas btnRuta;
    private Vista.PanelCurvas btnSalir;
    private Vista.PanelCurvas btnTrabajador;
    private Vista.PanelCurvas btnVehiculos;
    private javax.swing.JLabel icoCarro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logOut;
    private javax.swing.JLabel txtBarras;
    private javax.swing.JLabel txtBitacora;
    private javax.swing.JLabel txtBitacora1;
    private javax.swing.JLabel txtBodega;
    private javax.swing.JLabel txtCasa;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtCliente2;
    private javax.swing.JLabel txtEmpleado;
    private javax.swing.JLabel txtLogo;
    private javax.swing.JLabel txtRuta;
    private javax.swing.JLabel txtproducto;
    // End of variables declaration//GEN-END:variables
}
