package Controlador;

import Vista.VCliente_Tiendas;
import Modelo.*;
import Vista.Controlador.CCliente_Tiendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlTiendas implements ActionListener {

    private VCliente_Tiendas vistaTiendas;
    private CCliente_Tiendas CvistaTiendas;
    private Tiendas1 modeloTiendas;

    public ctrlTiendas(VCliente_Tiendas vistaTiendas, Tiendas1 modeloTiendas, CCliente_Tiendas CvistaTiendas) {
        this.modeloTiendas = modeloTiendas;
        this.vistaTiendas = vistaTiendas;
        this.CvistaTiendas = CvistaTiendas;
        this.vistaTiendas.btnAgregar_CL.addActionListener(this);
        this.vistaTiendas.btnEliminar_TN.addActionListener(this);
        this.vistaTiendas.btnModificar_CL.addActionListener(this);
        this.CvistaTiendas.btnAgregar_CL.addActionListener(this);
        this.CvistaTiendas.btnEliminar_TN.addActionListener(this);
        this.CvistaTiendas.btnModificar_CL.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ////////////////Admin///////////////////////////////////////////////////////
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
                    modeloTiendas.Agregar(modeloTiendas);
                    modeloTiendas.MostrarTabla(vistaTiendas);
                }
            }
        }
        if (e.getSource() == vistaTiendas.btnEliminar_TN) {
            System.out.println("clic eliminar");
            modeloTiendas.Eliminar(vistaTiendas);
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
                    modeloTiendas.Actualizar(vistaTiendas);
                    modeloTiendas.MostrarTabla(vistaTiendas);
                }
            }

        }
        ///////////////Controlador////////////////////////////////////////////////////////

        if (e.getSource() == CvistaTiendas.btnAgregar_CL) {
            String texto1 = CvistaTiendas.txtNombre_CL.getText();
            String texto2 = CvistaTiendas.txtDireccion.getText();
            String texto3 = CvistaTiendas.txtReferencia.getText();
            String texto4 = CvistaTiendas.txtCorreo_CL.getText();
            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto4.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                } else {
                    modeloTiendas.setTien_Nombre(CvistaTiendas.txtNombre_CL.getText());
                    modeloTiendas.setTien_Direccion(CvistaTiendas.txtDireccion.getText());
                    modeloTiendas.setTien_ReferenciasLDireccion(CvistaTiendas.txtReferencia.getText());
                    modeloTiendas.setTien_Correo(CvistaTiendas.txtCorreo_CL.getText());
                    modeloTiendas.CAgregar(modeloTiendas);
                    modeloTiendas.CMostrarTabla(CvistaTiendas);
                }
            }
        }
        if (e.getSource() == CvistaTiendas.btnEliminar_TN) {
            System.out.println("clic eliminar");
            modeloTiendas.CEliminar(CvistaTiendas);
            modeloTiendas.CMostrarTabla(CvistaTiendas);
        }
        if (e.getSource() == CvistaTiendas.btnModificar_CL) {
            String texto1 = CvistaTiendas.txtNombre_CL.getText();
            String texto2 = CvistaTiendas.txtDireccion.getText();
            String texto3 = CvistaTiendas.txtReferencia.getText();
            String texto4 = CvistaTiendas.txtCorreo_CL.getText();
            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto4.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                } else {
                    modeloTiendas.CActualizar(CvistaTiendas);
                    modeloTiendas.CMostrarTabla(CvistaTiendas);
                }
            }

        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
