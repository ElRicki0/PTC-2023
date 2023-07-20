package Controlador;

import Modelo.productos;
import Vista.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlProducto implements  ActionListener{

    private productos modeloProductos;
    private Producto vistaProducto;
    
    public ctrlProducto(productos modeloProducto, Producto vistaProducto) {
        this.modeloProductos=modeloProducto;
        this.vistaProducto=vistaProducto;
        this.vistaProducto.btnAgregar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaProducto.btnAgregar)
        {
            System.out.println("SE DA CLIC");
            modeloProductos.setProd_nombre(vistaProducto.txtNombre_pdt.getText());
            modeloProductos.setIdMarca(vistaProducto.jcbMarca_pdt.getSelectedItem().toString());
            modeloProductos.setProd_unidades(Integer.parseInt(vistaProducto.txtUnidades_pdt.getText()));
            modeloProductos.setProd_preciounitario(vistaProducto.txtPrecioUnitario_pdt.getText());
            modeloProductos.setIdBodega(vistaProducto.jcbBodega.getSelectedItem().toString());
            
            modeloProductos.AgregarProducto(modeloProductos);
        }
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
