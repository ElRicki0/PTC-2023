package Controlador;

import Modelo.DatosDistribucion;
import Vista.Producto;
import Vista.VDatosDis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlDatosDistribucion implements ActionListener{
    
    private VDatosDis Vista;
    private DatosDistribucion Modelo;
    public ctrlDatosDistribucion(VDatosDis Vista, DatosDistribucion Modelo){
        this.Modelo=Modelo;
        this.Vista=Vista;
        this.Vista.btnAgregar1.addActionListener(this);
        this.Vista.btnEliminar1.addActionListener(this);
        this.Vista.btnModificarMP1.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Vista.btnAgregar1) {
            String texto1 = Vista.txtNombreDis.getText();
            String texto2 = Vista.txtCantidad.getText();
            if (texto1.isEmpty() || texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            }else{
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "En cantidad solo pueden ir numeros  ");
                } else {
                    Modelo.setDaDis_Nombre(Vista.txtNombreDis.getText());
                    Modelo.setIdProducto(Vista.jcbProducto.getSelectedItem().toString());
                    Modelo.setCantidadProducto(Integer.parseInt(Vista.txtCantidad.getText()));
                    Modelo.setIdEmpleado(Vista.jcbEmpleado.getSelectedItem().toString());
                    Modelo.Agregar(Modelo, Vista.jcbProducto, Vista.jcbEmpleado);
                    Modelo.Mostrartabla(Vista);
                }
            }
            
            
        }if (e.getSource()==Vista.btnEliminar1) {
            Modelo.Eliminar(Vista);
            Modelo.Mostrartabla(Vista);
            
        }if (e.getSource()==Vista.btnModificarMP1) {
            Modelo.setDaDis_Nombre(Vista.txtNombreDis.getText());
            Modelo.setCantidadProducto(Integer.parseInt(Vista.txtCantidad.getText()));
            Modelo.Actualizar(Vista, Modelo, Vista.jcbProducto, Vista.jcbEmpleado);
            Modelo.Mostrartabla(Vista);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
