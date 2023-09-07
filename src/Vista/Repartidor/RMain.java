/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Repartidor;

import Vista.Controlador.*;
import Vista.*;
import javax.swing.ImageIcon;
import desplazable.Desface;
import java.awt.Color;

/**
 *
 * @author rnmel
 */
public class RMain extends javax.swing.JFrame {

    Desface desplace;
    public RMain() {
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
        btnProducto = new Vista.PanelCurvas();
        Productoicon = new javax.swing.JLabel();
        txtproducto = new javax.swing.JLabel();
        btnCliente = new Vista.PanelCurvas();
        Clienteicon = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        btnTrabajador = new Vista.PanelCurvas();
        Trabajadoricon = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JLabel();
        btnRuta = new Vista.PanelCurvas();
        Rutaicon = new javax.swing.JLabel();
        txtRuta = new javax.swing.JLabel();
        btnBitacora = new Vista.PanelCurvas();
        Bitacoraicon = new javax.swing.JLabel();
        txtBitacora = new javax.swing.JLabel();
        txtLogo = new javax.swing.JLabel();
        btnBodega = new Vista.PanelCurvas();
        Bodegaicon = new javax.swing.JLabel();
        txtBodega = new javax.swing.JLabel();
        txtBarras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 760));
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 760));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        txtCasa.setForeground(new java.awt.Color(45, 40, 37));
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
        txtproducto.setForeground(new java.awt.Color(45, 40, 37));
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

        MenuPlegable.add(btnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 230, 50));

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
        txtCliente.setForeground(new java.awt.Color(45, 40, 37));
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
        txtEmpleado.setForeground(new java.awt.Color(45, 40, 37));
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

        MenuPlegable.add(btnTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 230, -1));

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
        txtRuta.setForeground(new java.awt.Color(45, 40, 37));
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

        MenuPlegable.add(btnRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 230, -1));

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
        txtBitacora.setForeground(new java.awt.Color(45, 40, 37));
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

        MenuPlegable.add(btnBitacora, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 230, -1));
        MenuPlegable.add(txtLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

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
        txtBodega.setForeground(new java.awt.Color(45, 40, 37));
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

        MenuPlegable.add(btnBodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 230, -1));

        txtBarras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBarrasMouseClicked(evt);
            }
        });
        MenuPlegable.add(txtBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 53, 53));

        jPanel1.add(MenuPlegable, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 0, 230, 760));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Repartidor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

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
        txtCasa.setForeground(new Color(45,40,37));
    }//GEN-LAST:event_btnCasaMouseExited

    private void btnCasaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCasaMouseEntered
        btnCasa.setBackground(new Color(45,40,37));        
        txtCasa.setForeground(Color.white);

    }//GEN-LAST:event_btnCasaMouseEntered

    private void btnProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseEntered
        btnProducto.setBackground(new Color(45,40,37));        
        txtproducto.setForeground(Color.white);
    }//GEN-LAST:event_btnProductoMouseEntered

    private void btnProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseExited
        btnProducto.setBackground(new Color(64,81,115));        
        txtproducto.setForeground(new Color(45,40,37));
    }//GEN-LAST:event_btnProductoMouseExited

    private void btnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseExited
        btnCliente.setBackground(new Color(64,81,115));        
        txtCliente.setForeground(new Color(45,40,37));
    }//GEN-LAST:event_btnClienteMouseExited

    private void btnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseEntered
        btnCliente.setBackground(new Color(45,40,37));        
        txtCliente.setForeground(Color.white);
    }//GEN-LAST:event_btnClienteMouseEntered

    private void btnBitacoraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBitacoraMouseExited
        btnBitacora.setBackground(new Color(64,81,115));        
        txtBitacora.setForeground(new Color(45,40,37));
    }//GEN-LAST:event_btnBitacoraMouseExited

    private void btnBitacoraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBitacoraMouseEntered
        btnBitacora.setBackground(new Color(45,40,37));        
        txtBitacora.setForeground(Color.white);
    }//GEN-LAST:event_btnBitacoraMouseEntered

    private void btnTrabajadorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrabajadorMouseExited
        btnTrabajador.setBackground(new Color(64,81,115));        
        txtEmpleado.setForeground(new Color(45,40,37));
    }//GEN-LAST:event_btnTrabajadorMouseExited

    private void btnTrabajadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrabajadorMouseEntered
        btnTrabajador.setBackground(new Color(45,40,37));        
        txtEmpleado.setForeground(Color.white);
    }//GEN-LAST:event_btnTrabajadorMouseEntered

    private void btnRutaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRutaMouseExited
        btnRuta.setBackground(new Color(64,81,115));        
        txtRuta.setForeground(new Color(45,40,37));
    }//GEN-LAST:event_btnRutaMouseExited

    private void btnRutaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRutaMouseEntered
        btnRuta.setBackground(new Color(45,40,37));        
        txtRuta.setForeground(Color.white);
    }//GEN-LAST:event_btnRutaMouseEntered

    private void btnBodegaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodegaMouseExited
        btnBodega.setBackground(new Color(64,81,115));        
        txtBodega.setForeground(new Color(45,40,37));
    }//GEN-LAST:event_btnBodegaMouseExited

    private void btnBodegaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodegaMouseEntered
        btnBodega.setBackground(new Color(45,40,37));        
        txtBodega.setForeground(Color.white);
    }//GEN-LAST:event_btnBodegaMouseEntered

    //BTN_MOVIMIENTO///////////////////////////////////////////////////////////////
    private void btnCasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCasaMouseClicked
        
    }//GEN-LAST:event_btnCasaMouseClicked

    private void btnProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoMouseClicked
        VProducto producto = new VProducto();
        producto.NIT();
      //  producto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProductoMouseClicked

    private void btnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseClicked
        VCliente cl= new VCliente();
        cl.INIT();
        this.dispose();
    }//GEN-LAST:event_btnClienteMouseClicked

    private void btnBitacoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBitacoraMouseClicked
        Bitacora bitacora = new Bitacora();
        bitacora.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBitacoraMouseClicked

    private void btnTrabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrabajadorMouseClicked
        VEmpleados empleados = new VEmpleados();
        empleados.INIT();
        this.dispose();
    }//GEN-LAST:event_btnTrabajadorMouseClicked

    private void btnRutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRutaMouseClicked
        VDatosDis rutas = new VDatosDis();
        rutas.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRutaMouseClicked

    private void btnBodegaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodegaMouseClicked
        Bodega bodegas = new Bodega();
        bodegas.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBodegaMouseClicked

    /**
     * @param args the command line arguments
     */
    public void INIT(){
        RMain main= new RMain();
        main.setVisible(true);
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
            java.util.logging.Logger.getLogger(RMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JLabel Productoicon;
    private javax.swing.JLabel Rutaicon;
    private javax.swing.JLabel Trabajadoricon;
    private Vista.PanelCurvas btnBitacora;
    private Vista.PanelCurvas btnBodega;
    private Vista.PanelCurvas btnCasa;
    private Vista.PanelCurvas btnCliente;
    private Vista.PanelCurvas btnProducto;
    private Vista.PanelCurvas btnRuta;
    private Vista.PanelCurvas btnTrabajador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtBarras;
    private javax.swing.JLabel txtBitacora;
    private javax.swing.JLabel txtBodega;
    private javax.swing.JLabel txtCasa;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtEmpleado;
    private javax.swing.JLabel txtLogo;
    private javax.swing.JLabel txtRuta;
    private javax.swing.JLabel txtproducto;
    // End of variables declaration//GEN-END:variables
}
