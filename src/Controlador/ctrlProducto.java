package Controlador;

import Modelo.productos;
import Vista.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlProducto implements  ActionListener{

    private productos modeloProductos;
    private Producto vistaProducto;
    
    public ctrlProducto(productos modeloProducto, Producto vistaProducto) {
        this.modeloProductos=modeloProducto;
        this.vistaProducto=vistaProducto;
        this.vistaProducto.btnAgregar.addActionListener(this);
        this.vistaProducto.btnEliminar.addActionListener(this);
        this.vistaProducto.btnModificar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaProducto.btnAgregar) {
    String texto1 = vistaProducto.txtNombre_pdt.getText();
    String texto2 = vistaProducto.txtPrecioUnitario_pdt.getText();
    String texto3 = vistaProducto.txtUnidades_pdt.getText();

    try {
        if (!texto2.matches("\\d+")) {
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
        }if(e.getSource()==vistaProducto.btnEliminar){
            try {
            modeloProductos.EliminarProducto(vistaProducto);
            modeloProductos.MostrarProductos(vistaProducto);
        } catch (Exception ae) {
            JOptionPane.showMessageDialog(null, "seleccione un producto a eliminar");                        
        }
            
        }if(e.getSource()==vistaProducto.btnModificar){
            try {
            modeloProductos.Actualizarproducto(vistaProducto);
            modeloProductos.MostrarProductos(vistaProducto);
        } catch (Exception ee) {            
            JOptionPane.showMessageDialog(null, "seleccione un producto a editar");                       

        }
        }        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
