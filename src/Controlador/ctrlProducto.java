package Controlador;

import Modelo.productos;
import Vista.*;
import Vista.Controlador.CProducto;
import Vista.Usuario.UProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlProducto implements ActionListener {

    private productos modeloProductos;
    private VProducto vistaProducto;
    private CProducto CvistaProducto;
    private UProducto UvistaProducto;

    public ctrlProducto(productos modeloProducto, VProducto vistaProducto, CProducto CvistaProducto, UProducto UvistaProducto) {
        this.modeloProductos = modeloProducto;
        this.vistaProducto = vistaProducto;
        this.CvistaProducto = CvistaProducto;
        this.UvistaProducto = UvistaProducto;
        /////////////////////////Admin/////////////////////////////////////////////
        this.vistaProducto.btnAgregar.addActionListener(this);
        this.vistaProducto.btnEliminar.addActionListener(this);
        this.vistaProducto.btnModificar.addActionListener(this);
        ////////////////////////Controlador///////////////////////////////////////////////
        this.CvistaProducto.btnAgregar.addActionListener(this);
        this.CvistaProducto.btnEliminar.addActionListener(this);
        this.CvistaProducto.btnModificar.addActionListener(this);
        ////////////////////////Usuario///////////////////////////////////////////////
        this.UvistaProducto.btnActualizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //////////////////////Admin/////////////////////////////////////////////////
        if (e.getSource() == vistaProducto.btnAgregar) {
            String texto1 = vistaProducto.txtNombre_pdt.getText();
            String texto2 = vistaProducto.txtPrecioUnitario_pdt.getText();
            String texto3 = vistaProducto.txtUnidades_pdt.getText();

            try {
                if (!texto2.matches("[0-9.0-9]+")) {
                    JOptionPane.showMessageDialog(null, "El precio solo puede tener números");
                } else if (!texto3.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Las unidades solo pueden tener números");
                } else {
                    System.out.println("SE DA CLIC");
                    modeloProductos.setProd_nombre(vistaProducto.txtNombre_pdt.getText());
                    modeloProductos.setIdMarca(vistaProducto.jcbMarca_pdt.getSelectedItem().toString());
                    modeloProductos.setProd_unidades(Integer.parseInt(vistaProducto.txtUnidades_pdt.getText()));
                    modeloProductos.setProd_preciounitario(vistaProducto.txtPrecioUnitario_pdt.getText());
                    modeloProductos.setIdBodega(vistaProducto.jcbBodega1.getSelectedItem().toString());
                    modeloProductos.AgregarProducto(modeloProductos, vistaProducto.jcbMarca_pdt, vistaProducto.jcbBodega1);
                    modeloProductos.MostrarProductos(vistaProducto);
                }
            } catch (Exception epa) {
                System.out.println("error en control producto: " + epa.toString());
            }
        }
        if (e.getSource() == vistaProducto.btnEliminar) {
            try {
                modeloProductos.EliminarProducto(vistaProducto);
                modeloProductos.MostrarProductos(vistaProducto);
            } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "seleccione un producto a eliminar");
            }

        }
        if (e.getSource() == vistaProducto.btnModificar) {
            String texto1 = vistaProducto.txtNombre_pdt.getText();
            String texto2 = vistaProducto.txtPrecioUnitario_pdt.getText();
            String texto3 = vistaProducto.txtUnidades_pdt.getText();

            try {
                if (!texto2.matches("[0-9.0-9]+")) {
                    JOptionPane.showMessageDialog(null, "El precio solo puede tener números");
                } else if (!texto3.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Las unidades solo pueden tener números");
                } else {
                    System.out.println("SE DA CLIC");
                    modeloProductos.setProd_nombre(vistaProducto.txtNombre_pdt.getText());
                    modeloProductos.setIdMarca(vistaProducto.jcbMarca_pdt.getSelectedItem().toString());
                    modeloProductos.setProd_unidades(Integer.parseInt(vistaProducto.txtUnidades_pdt.getText()));
                    modeloProductos.setProd_preciounitario(vistaProducto.txtPrecioUnitario_pdt.getText());
                    modeloProductos.setIdBodega(vistaProducto.jcbBodega1.getSelectedItem().toString());
                    modeloProductos.Actualizarproducto(vistaProducto, modeloProductos, vistaProducto.jcbMarca_pdt, vistaProducto.jcbBodega1);
                    modeloProductos.MostrarProductos(vistaProducto);
                }
            } catch (Exception epa) {
                System.out.println("error en control producto: " + epa.toString());
            }

        }
        //////////////////////////Controlador/////////////////////////////////////////////
        if (e.getSource() == CvistaProducto.btnAgregar) {
            String texto1 = CvistaProducto.txtNombre_pdt.getText();
            String texto2 = CvistaProducto.txtPrecioUnitario_pdt.getText();
            String texto3 = CvistaProducto.txtUnidades_pdt.getText();

            try {
                if (!texto2.matches("[0-9.0-9]+")) {
                    JOptionPane.showMessageDialog(null, "El precio solo puede tener números");
                } else if (!texto3.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Las unidades solo pueden tener números");
                } else {
                    System.out.println("SE DA CLIC");
                    modeloProductos.setProd_nombre(CvistaProducto.txtNombre_pdt.getText());
                    modeloProductos.setIdMarca(CvistaProducto.jcbMarca_pdt.getSelectedItem().toString());
                    modeloProductos.setProd_unidades(Integer.parseInt(CvistaProducto.txtUnidades_pdt.getText()));
                    modeloProductos.setProd_preciounitario(CvistaProducto.txtPrecioUnitario_pdt.getText());
                    modeloProductos.setIdBodega(CvistaProducto.jcbBodega1.getSelectedItem().toString());
                    modeloProductos.CAgregarProducto(modeloProductos, CvistaProducto.jcbMarca_pdt, CvistaProducto.jcbBodega1);
                    modeloProductos.CMostrarProductos(CvistaProducto);
                }
            } catch (Exception epa) {
                System.out.println("error en control producto: " + epa.toString());
            }
        }
        if (e.getSource() == CvistaProducto.btnEliminar) {
            try {
                modeloProductos.CEliminarProducto(CvistaProducto);
                modeloProductos.CMostrarProductos(CvistaProducto);
            } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "seleccione un producto a eliminar");
            }

        }
        if (e.getSource() == CvistaProducto.btnModificar) {
            String texto1 = CvistaProducto.txtNombre_pdt.getText();
            String texto2 = CvistaProducto.txtPrecioUnitario_pdt.getText();
            String texto3 = CvistaProducto.txtUnidades_pdt.getText();

            try {
                if (!texto2.matches("[0-9.0-9]+")) {
                    JOptionPane.showMessageDialog(null, "El precio solo puede tener números");
                } else if (!texto3.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Las unidades solo pueden tener números");
                } else {
                    System.out.println("SE DA CLIC");
                    modeloProductos.setProd_nombre(CvistaProducto.txtNombre_pdt.getText());
                    modeloProductos.setIdMarca(CvistaProducto.jcbMarca_pdt.getSelectedItem().toString());
                    modeloProductos.setProd_unidades(Integer.parseInt(CvistaProducto.txtUnidades_pdt.getText()));
                    modeloProductos.setProd_preciounitario(CvistaProducto.txtPrecioUnitario_pdt.getText());
                    modeloProductos.setIdBodega(CvistaProducto.jcbBodega1.getSelectedItem().toString());
                    modeloProductos.CActualizarproducto(CvistaProducto, modeloProductos, CvistaProducto.jcbMarca_pdt, CvistaProducto.jcbBodega1);
                    modeloProductos.CMostrarProductos(CvistaProducto);
                }
            } catch (Exception epa) {
                System.out.println("error en control producto: " + epa.toString());
            }

        }
        
        //////////////////////////Usuario/////////////////////////////////////////////
        if (e.getSource() == UvistaProducto.btnActualizar) {
            modeloProductos.UMostrarProductos(UvistaProducto);
        }

//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
