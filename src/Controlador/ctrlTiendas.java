package Controlador;

import Vista.VTiendas;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlTiendas implements ActionListener {
        private VTiendas  vistaTiendas;
        private Tiendas modeloTiendas;

        public ctrlTiendas (VTiendas  vistaTiendas, Tiendas modeloTiendas){
            this.modeloTiendas=modeloTiendas;
            this.vistaTiendas=vistaTiendas;
            this.vistaTiendas.btnAgregar_CL.addActionListener(this);
            this.vistaTiendas.btnEliminar_TN.addActionListener(this);
            this.vistaTiendas.btnModificar_CL.addActionListener(this);
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vistaTiendas.btnAgregar_CL) {
            modeloTiendas.setTien_nombre(vistaTiendas.txtNombre_CL.getText());
            modeloTiendas.setTien_direccion(vistaTiendas.txtDireccion.getText());
            modeloTiendas.setTien_ReferenciasLDireccion(vistaTiendas.txtReferencia.getText());
            modeloTiendas.setTien_Correo(vistaTiendas.txtCorreo_CL.getText());
            modeloTiendas.agregar(modeloTiendas);
            modeloTiendas.MostrarTabla(vistaTiendas);
        }if (e.getSource()==vistaTiendas.btnEliminar_TN) {
            System.out.println("clic eliminar");
            modeloTiendas.eliminar(vistaTiendas);
            modeloTiendas.MostrarTabla(vistaTiendas);
        }if (e.getSource()==vistaTiendas.btnModificar_CL) {
            modeloTiendas.actualizar(vistaTiendas);
            modeloTiendas.MostrarTabla(vistaTiendas);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
