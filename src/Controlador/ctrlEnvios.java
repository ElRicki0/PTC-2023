package Controlador;

import Modelo.BitacoraDistribuciones;
import Vista.VRutas_Envios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ctrlEnvios implements ActionListener{

    private VRutas_Envios vistaEnvios;
    private BitacoraDistribuciones modeloEnvios;
    
    public ctrlEnvios(VRutas_Envios vistaEnvios, BitacoraDistribuciones modeloEnvios){
        this.modeloEnvios=modeloEnvios;
        this.vistaEnvios=vistaEnvios;
        this.vistaEnvios.btnAgregar.addActionListener(this);
        this.vistaEnvios.btnEliminar.addActionListener(this);
        this.vistaEnvios.btnModificarMP.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vistaEnvios.btnAgregar) {
            modeloEnvios.setFecha_Entrega(vistaEnvios.txtFecha.getText());
            modeloEnvios.setIdEmpleado(vistaEnvios.jcbEmpleado.getSelectedItem().toString());
            modeloEnvios.setIdUsuario(vistaEnvios.jcbUsuario.getSelectedItem().toString());
            modeloEnvios.setIdvehiculo(vistaEnvios.jcbVehiculo.getSelectedItem().toString());
            modeloEnvios.setIdPaqueteria(vistaEnvios.jcbPaquete.getSelectedItem().toString());
            modeloEnvios.setIdEstado(vistaEnvios.jcbEstado.getSelectedItem().toString());
            modeloEnvios.agregar(modeloEnvios, vistaEnvios.jcbEmpleado, vistaEnvios.jcbUsuario, vistaEnvios.jcbVehiculo, vistaEnvios.jcbPaquete, vistaEnvios.jcbEstado);
            modeloEnvios.MostrarTabla(vistaEnvios);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
