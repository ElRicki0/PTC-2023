package Controlador;

import Vista.VDatosTiendas;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlDatosTiendas implements ActionListener{

    private VDatosTiendas vistaDatos;
    private DatosTiendas modeloDatos;
    
    public ctrlDatosTiendas(VDatosTiendas vistaDatos, DatosTiendas modeloDatos){
        this.modeloDatos=modeloDatos;
        this.vistaDatos=vistaDatos;
        this.vistaDatos.btnAgregar_CL.addActionListener(this);
        this.vistaDatos.btnEliminar_TN.addActionListener(this);
        this.vistaDatos.btnModificar_CL.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vistaDatos.btnAgregar_CL) {
            modeloDatos.setDT_NumeroTelefono(vistaDatos.txtTelefono.getText());
            modeloDatos.setDT_PersonaDestinatario(vistaDatos.txtEncargado.getText());
            modeloDatos.setIdCliente(vistaDatos.jcbCliente.getSelectedItem().toString());
            modeloDatos.setIdTienda(vistaDatos.jcbTienda.getSelectedItem().toString());
            modeloDatos.Agregar(modeloDatos, vistaDatos.jcbCliente, vistaDatos.jcbTienda);
            modeloDatos.MostrarTabla(vistaDatos);
        }if (e.getSource()==vistaDatos.btnEliminar_TN) {
            modeloDatos.eliminar(vistaDatos);
            modeloDatos.MostrarTabla(vistaDatos);
        }if (e.getSource()==vistaDatos.btnModificar_CL) {
            modeloDatos.setDT_NumeroTelefono(vistaDatos.txtTelefono.getText());
            modeloDatos.setDT_PersonaDestinatario(vistaDatos.txtEncargado.getText());
//            modeloDatos.setIdCliente(vistaDatos.jcbCliente.getSelectedItem().toString());
//            modeloDatos.setIdTienda(vistaDatos.jcbTienda.getSelectedItem().toString());
            modeloDatos.modificar(vistaDatos, modeloDatos, vistaDatos.jcbCliente, vistaDatos.jcbTienda);
            modeloDatos.MostrarTabla(vistaDatos);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
