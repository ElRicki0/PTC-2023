package Vista.Usuario;

import Vista.*;
import Controlador.ctrlMarca;
import Controlador.ctrlProducto;
import Modelo.productos;
import Modelo.CConexion;
import Modelo.MarcaProductos;
import Vista.Controlador.CProducto;
import Vista.Repartidor.RProducto;
import javax.swing.ImageIcon;
import desplazable.Desface;
import java.awt.Color;
import java.awt.TextField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UProducto extends javax.swing.JFrame {

    
     
        productos ModeloProductos= new productos();
        VProducto_Marca Pmarca= new VProducto_Marca();
        
        
    
    Desface desplace;
    public UProducto() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Vista/Iconos/CASA.png")).getImage());

        rsscalelabel.RSScaleLabel.setScaleLabel(txtLogo, "src/Vista/Iconos/logo.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(Casaicon, "src/Vista/Iconos/hogar.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(Productoicon, "src/Vista/Iconos/bolso.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(Clienteicon, "src/Vista/Iconos/usuario.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(Rutaicon, "src/Vista/Iconos/entrega.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(txtBarras, "src/Vista/Iconos/lista.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(icoCarro, "src/Vista/Iconos/vehiculo.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(icoCarro, "src/Vista/Iconos/vehiculo.png");
        
        desplace = new Desface();
        
        this.setLocationRelativeTo(null);        
        transpareciaBoton();
            
       
        ModeloProductos.RellenarBuscadorCBX(jcbBuscador);

    }
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        modificar1 = new Vista.PanelCurvas();
        btnActualizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jcbBuscador = new javax.swing.JComboBox<>();
        panelCurvas3 = new Vista.PanelCurvas();
        btnCXBuscar = new javax.swing.JButton();
        MenuPlegable = new javax.swing.JPanel();
        btnCasa = new Vista.PanelCurvas();
        Casaicon = new javax.swing.JLabel();
        txtCasa = new javax.swing.JLabel();
        txtLogo = new javax.swing.JLabel();
        txtBarras = new javax.swing.JLabel();
        btnProducto = new Vista.PanelCurvas();
        Productoicon = new javax.swing.JLabel();
        txtproducto = new javax.swing.JLabel();
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
        txtBitacora2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 760));
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 760));

        jPanel1.setBackground(new java.awt.Color(246, 234, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpProductos.setBackground(new java.awt.Color(246, 234, 204));
        jpProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(172, 147, 110));

        tbProductos.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProductos.setFocusable(false);
        tbProductos.setRowHeight(30);
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProductos);

        jpProductos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 70, 970, 460));

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Productos");
        jpProductos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 260, 41));

        modificar1.setBackground(new java.awt.Color(172, 147, 110));
        modificar1.setRoundBottomLeft(25);
        modificar1.setRoundBottomRight(25);
        modificar1.setRoundTopLeft(25);
        modificar1.setRoundTopRight(25);

        btnActualizar.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout modificar1Layout = new javax.swing.GroupLayout(modificar1);
        modificar1.setLayout(modificar1Layout);
        modificar1Layout.setHorizontalGroup(
            modificar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        modificar1Layout.setVerticalGroup(
            modificar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modificar1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpProductos.add(modificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, -1, -1));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Buscar:");
        jpProductos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 100, 41));

        jcbBuscador.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jpProductos.add(jcbBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 240, 40));

        panelCurvas3.setBackground(new java.awt.Color(172, 147, 110));
        panelCurvas3.setRoundBottomLeft(25);
        panelCurvas3.setRoundBottomRight(25);
        panelCurvas3.setRoundTopLeft(25);
        panelCurvas3.setRoundTopRight(25);

        btnCXBuscar.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnCXBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnCXBuscar.setText("Buscar");
        btnCXBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCXBuscarMouseClicked(evt);
            }
        });
        btnCXBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCXBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCurvas3Layout = new javax.swing.GroupLayout(panelCurvas3);
        panelCurvas3.setLayout(panelCurvas3Layout);
        panelCurvas3Layout.setHorizontalGroup(
            panelCurvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCurvas3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCXBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelCurvas3Layout.setVerticalGroup(
            panelCurvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCurvas3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCXBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpProductos.add(panelCurvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 120, 40));

        jPanel1.add(jpProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 1000, 730));

        MenuPlegable.setBackground(new java.awt.Color(64, 81, 115));
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

        MenuPlegable.add(btnCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 230, -1));
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

        MenuPlegable.add(btnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, 50));

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
                .addGap(0, 86, Short.MAX_VALUE)
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

        MenuPlegable.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 230, -1));

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

        MenuPlegable.add(btnRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, -1, -1));

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

        MenuPlegable.add(btnVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 230, 53));

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

        txtBitacora2.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        txtBitacora2.setForeground(new java.awt.Color(255, 153, 153));
        txtBitacora2.setText("Cerrar secion");

        javax.swing.GroupLayout btnSalirLayout = new javax.swing.GroupLayout(btnSalir);
        btnSalir.setLayout(btnSalirLayout);
        btnSalirLayout.setHorizontalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalirLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(txtBitacora2)
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
                .addComponent(txtBitacora2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        MenuPlegable.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, -1, -1));

        jPanel1.add(MenuPlegable, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 0, 230, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
        
    }//GEN-LAST:event_tbProductosMouseClicked

    private void btnCXBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCXBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCXBuscarActionPerformed

    private void btnCXBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCXBuscarMouseClicked
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre","Marca","Unidades","Precio C/U", "Bodega"});
        try {
            Statement st= CConexion.getConexion().createStatement();
//                String SQL ="select tbProductos.idProducto, tbProductos.Prod_Nombre, tbMarcaProductos.MP_Nombre, tbProductos.Prod_Unidades, tbProductos.Prod_PrecioUnitario, tbBodegas.bdg_nombre"+
//                    " from tbProductos inner join tbMarcaProductos  on tbProductos.id_MP = tbMarcaProductos.id_MP inner join tbBodegas on tbProductos.idBodega = tbBodegas.idBodega";
            
            String SQL="select tbProductos.idProducto, tbProductos.Prod_Nombre, tbMarcaProductos.MP_Nombre, tbProductos.Prod_Unidades, tbProductos.Prod_PrecioUnitario, tbBodegas.bdg_nombre\n" +
            "from tbProductos inner join tbMarcaProductos  on tbProductos.id_MP = tbMarcaProductos.id_MP inner join tbBodegas on tbProductos.idBodega = tbBodegas.idBodega where MP_Nombre='"+jcbBuscador.getSelectedItem()+"'";
            
            
            
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("idProducto"), rs.getString("Prod_Nombre"), rs.getString("MP_Nombre"), rs.getInt("Prod_Unidades"), rs.getFloat("Prod_PrecioUnitario"), rs.getString("bdg_nombre")});
            }
            tbProductos.setModel(modelo);            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error 3"+e.getMessage());                
        }
    }//GEN-LAST:event_btnCXBuscarMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnCasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCasaMouseClicked
        UMain vista = new UMain();
        vista.INIT();
        this.dispose();
    }//GEN-LAST:event_btnCasaMouseClicked

    private void btnCasaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCasaMouseEntered
        btnCasa.setBackground(new Color(45,40,37));
    }//GEN-LAST:event_btnCasaMouseEntered

    private void btnCasaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCasaMouseExited
        btnCasa.setBackground(new Color(64,81,115));
    }//GEN-LAST:event_btnCasaMouseExited

    private void txtBarrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBarrasMouseClicked
        if (MenuPlegable.getX()==-150) {
            desplace.desplazarDerecha(MenuPlegable, MenuPlegable.getX(), 0, 15, 10);
        } else if(MenuPlegable.getX() == 0) {
            desplace.desplazarIzquierda(MenuPlegable, MenuPlegable.getX(), -150, 15, 10);
        }
    }//GEN-LAST:event_txtBarrasMouseClicked

    private void btnProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseClicked
        
    }//GEN-LAST:event_btnProductoMouseClicked

    private void btnProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseEntered
        btnProducto.setBackground(new Color(45,40,37));
    }//GEN-LAST:event_btnProductoMouseEntered

    private void btnProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseExited
        btnProducto.setBackground(new Color(64,81,115));
    }//GEN-LAST:event_btnProductoMouseExited

    private void btnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseClicked
        UTiendas vista= new UTiendas();
        vista.INIT();
        this.dispose();
    }//GEN-LAST:event_btnClienteMouseClicked

    private void btnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseEntered
        btnCliente.setBackground(new Color(45,40,37));
    }//GEN-LAST:event_btnClienteMouseEntered

    private void btnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseExited
        btnCliente.setBackground(new Color(64,81,115));
    }//GEN-LAST:event_btnClienteMouseExited

    private void btnRutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRutaMouseClicked
        UEnvios rutas = new UEnvios();
        rutas.INIT();
        this.dispose();
    }//GEN-LAST:event_btnRutaMouseClicked

    private void btnRutaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRutaMouseEntered
        btnRuta.setBackground(new Color(45,40,37));
    }//GEN-LAST:event_btnRutaMouseEntered

    private void btnRutaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRutaMouseExited
        btnRuta.setBackground(new Color(64,81,115));
    }//GEN-LAST:event_btnRutaMouseExited

    private void btnVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVehiculosMouseClicked
        UVehiculos vista = new UVehiculos();
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
    
            
    public void INIT(){
        VProducto vista=new VProducto();
        CProducto Cvista= new CProducto();
        RProducto Rvista= new RProducto();
        UProducto Uvista= new UProducto();
        ModeloProductos.UMostrarProductos(Uvista);
        ctrlProducto ctrl = new ctrlProducto(ModeloProductos, vista, Cvista, Rvista, Uvista);
        Uvista.setVisible(true);
    }
    
    public void transpareciaBoton(){
        
        btnCXBuscar.setOpaque(false);
        btnCXBuscar.setContentAreaFilled(false);
        btnCXBuscar.setBorderPainted(false);
        
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
            java.util.logging.Logger.getLogger(UProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Casaicon;
    private javax.swing.JLabel Clienteicon;
    private javax.swing.JPanel MenuPlegable;
    private javax.swing.JLabel Productoicon;
    private javax.swing.JLabel Rutaicon;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnCXBuscar;
    private Vista.PanelCurvas btnCasa;
    private Vista.PanelCurvas btnCliente;
    private Vista.PanelCurvas btnProducto;
    private Vista.PanelCurvas btnRuta;
    private Vista.PanelCurvas btnSalir;
    private Vista.PanelCurvas btnVehiculos;
    private javax.swing.JLabel icoCarro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JComboBox<String> jcbBuscador;
    public javax.swing.JPanel jpProductos;
    private javax.swing.JLabel logOut;
    private Vista.PanelCurvas modificar1;
    private Vista.PanelCurvas panelCurvas3;
    public javax.swing.JTable tbProductos;
    private javax.swing.JLabel txtBarras;
    private javax.swing.JLabel txtBitacora2;
    private javax.swing.JLabel txtCasa;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtCliente2;
    private javax.swing.JLabel txtLogo;
    private javax.swing.JLabel txtRuta;
    private javax.swing.JLabel txtproducto;
    // End of variables declaration//GEN-END:variables
}
