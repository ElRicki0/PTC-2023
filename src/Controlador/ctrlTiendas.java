package Controlador;

import Vista.VCliente_Tiendas;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlTiendas implements ActionListener {

    private VCliente_Tiendas vistaTiendas;
    private Tiendas1 modeloTiendas;

    public ctrlTiendas(VCliente_Tiendas vistaTiendas, Tiendas1 modeloTiendas) {
        this.modeloTiendas = modeloTiendas;
        this.vistaTiendas = vistaTiendas;
        this.vistaTiendas.btnAgregar_CL.addActionListener(this);
        this.vistaTiendas.btnEliminar_TN.addActionListener(this);
        this.vistaTiendas.btnModificar_CL.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaTiendas.btnAgregar_CL) {
            String texto1 = vistaTiendas.txtNombre_CL.getText();
            String texto2 = vistaTiendas.txtDireccion.getText();
            String texto3 = vistaTiendas.txtReferencia.getText();
            String texto4 = vistaTiendas.txtCorreo_CL.getText();
            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto4.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                } else {
                    modeloTiendas.setTien_Nombre(vistaTiendas.txtNombre_CL.getText());
                    modeloTiendas.setTien_Direccion(vistaTiendas.txtDireccion.getText());
                    modeloTiendas.setTien_ReferenciasLDireccion(vistaTiendas.txtReferencia.getText());
                    modeloTiendas.setTien_Correo(vistaTiendas.txtCorreo_CL.getText());
                    modeloTiendas.agregar(modeloTiendas);
                    modeloTiendas.MostrarTabla(vistaTiendas);
                }
            }
        }
        if (e.getSource() == vistaTiendas.btnEliminar_TN) {
            System.out.println("clic eliminar");
            modeloTiendas.eliminar(vistaTiendas);
            modeloTiendas.MostrarTabla(vistaTiendas);
        }
        if (e.getSource() == vistaTiendas.btnModificar_CL) {
            String texto1 = vistaTiendas.txtNombre_CL.getText();
            String texto2 = vistaTiendas.txtDireccion.getText();
            String texto3 = vistaTiendas.txtReferencia.getText();
            String texto4 = vistaTiendas.txtCorreo_CL.getText();
            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto4.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                } else {
                    modeloTiendas.actualizar(vistaTiendas);
                    modeloTiendas.MostrarTabla(vistaTiendas);
                }
            }

        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
