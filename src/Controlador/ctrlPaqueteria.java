package Controlador;

import Modelo.paqueteria;
import Vista.VRutas_Paqueteria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlPaqueteria implements ActionListener{

    private VRutas_Paqueteria vistaPaqueteria;
    private paqueteria modeloPaqueteria;
    
    public ctrlPaqueteria(VRutas_Paqueteria vistaPaqueteria, paqueteria modeloPaqueteria){
        this.modeloPaqueteria=modeloPaqueteria;
        this.vistaPaqueteria=vistaPaqueteria;
        this.vistaPaqueteria.btnAgregar.addActionListener(this);
        this.vistaPaqueteria.btnEliminar.addActionListener(this);
        this.vistaPaqueteria.btnModificarMP.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vistaPaqueteria.btnAgregar) {
            String texto1 = vistaPaqueteria.txtDireccion.getText();
            if (texto1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llenen todos los campos ");
            } else {
                modeloPaqueteria.setPqt_Nombre(vistaPaqueteria.txtNombre.getText());
                modeloPaqueteria.setIdEmpleado(vistaPaqueteria.jcbEmpleado.getSelectedItem().toString());
                modeloPaqueteria.setIdDatosDistribucion(vistaPaqueteria.jcbDistribucion.getSelectedItem().toString());
                modeloPaqueteria.setPaq_Ubicacion(vistaPaqueteria.txtDireccion.getText());
                modeloPaqueteria.Agregar(modeloPaqueteria, vistaPaqueteria.jcbEmpleado, vistaPaqueteria.jcbDistribucion);            
                modeloPaqueteria.Mostrartabla(vistaPaqueteria);
            }            
        }if (e.getSource()==vistaPaqueteria.btnEliminar) {
            modeloPaqueteria.Eliminar(vistaPaqueteria);
            modeloPaqueteria.Mostrartabla(vistaPaqueteria);
            
        }if (e.getSource()==vistaPaqueteria.btnModificarMP) {
            String texto1 = vistaPaqueteria.txtDireccion.getText();
            if (texto1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llenen todos los campos ");
            } else{
                modeloPaqueteria.setIdEmpleado(vistaPaqueteria.jcbEmpleado.getSelectedItem().toString());
                modeloPaqueteria.setIdDatosDistribucion(vistaPaqueteria.jcbDistribucion.getSelectedItem().toString());
                modeloPaqueteria.setPaq_Ubicacion(vistaPaqueteria.txtDireccion.getText());
                modeloPaqueteria.actualizar(modeloPaqueteria, vistaPaqueteria.jcbEmpleado, vistaPaqueteria.jcbDistribucion, vistaPaqueteria);
                modeloPaqueteria.Mostrartabla(vistaPaqueteria);
            }
            
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
