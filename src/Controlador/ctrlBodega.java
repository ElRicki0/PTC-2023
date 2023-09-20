package Controlador;

import Modelo.*;
import Vista.*;
import Vista.Controlador.CBodega;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlBodega implements ActionListener {

    private VBodega vistaBodega;
    private CBodega CvistaBodega;
    private Bodegas modeloBodegas;

    public ctrlBodega(VBodega vistaBodega, Bodegas modeloBodegas, CBodega CvistaBodega) {
        this.modeloBodegas = modeloBodegas;
        this.vistaBodega = vistaBodega;
        this.CvistaBodega = CvistaBodega;
        this.vistaBodega.btnAgregar.addActionListener(this);
        this.vistaBodega.btnEliminar.addActionListener(this);
        this.vistaBodega.btnModificar.addActionListener(this);
        this.CvistaBodega.btnAgregar.addActionListener(this);
        this.CvistaBodega.btnEliminar.addActionListener(this);
        this.CvistaBodega.btnModificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaBodega.btnAgregar) {
            String texto1 = vistaBodega.txtNombre_bdg.getText();
            String texto2 = vistaBodega.txtDireccion_bdg.getText();
            String texto3 = vistaBodega.txtCorreo_bdg.getText();

            if (!texto1.isEmpty() || !texto2.isEmpty() || !texto3.isEmpty()) {
                if (!texto3.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                } else {
                    modeloBodegas.setBdg_nombre(vistaBodega.txtNombre_bdg.getText());
                    modeloBodegas.setBdg_ubicacion(vistaBodega.txtDireccion_bdg.getText());
                    modeloBodegas.setBdg_correo(vistaBodega.txtCorreo_bdg.getText());
                    modeloBodegas.AgregarBodega(modeloBodegas);
                    modeloBodegas.MostrarBodega(vistaBodega);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            }
        }
        if (e.getSource() == vistaBodega.btnEliminar) {
            modeloBodegas.EliminarBodega(vistaBodega);
            modeloBodegas.MostrarBodega(vistaBodega);
        }
        if (e.getSource() == vistaBodega.btnModificar) {
            String texto1 = vistaBodega.txtNombre_bdg.getText();
            String texto2 = vistaBodega.txtDireccion_bdg.getText();
            String texto3 = vistaBodega.txtCorreo_bdg.getText();

            if (!texto1.isEmpty() || !texto2.isEmpty() || !texto3.isEmpty()) {
                if (!texto3.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                } else {
                    modeloBodegas.ActualizarBodega(vistaBodega);
                    modeloBodegas.MostrarBodega(vistaBodega);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            }

        }
//////////////////////////////Controlador/////////////////////////////////////////////////////        
        if (e.getSource() == CvistaBodega.btnAgregar) {
            String texto1 = CvistaBodega.txtNombre_bdg.getText();
            String texto2 = CvistaBodega.txtDireccion_bdg.getText();
            String texto3 = CvistaBodega.txtCorreo_bdg.getText();

            if (!texto1.isEmpty() || !texto2.isEmpty() || !texto3.isEmpty()) {
                if (!texto3.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                } else {
                    modeloBodegas.setBdg_nombre(CvistaBodega.txtNombre_bdg.getText());
                    modeloBodegas.setBdg_ubicacion(CvistaBodega.txtDireccion_bdg.getText());
                    modeloBodegas.setBdg_correo(CvistaBodega.txtCorreo_bdg.getText());
                    modeloBodegas.CAgregarBodega(modeloBodegas);
                    modeloBodegas.CMostrarBodega(CvistaBodega);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            }
        }
        if (e.getSource() == CvistaBodega.btnEliminar) {
            modeloBodegas.CEliminarBodega(CvistaBodega);
            modeloBodegas.CMostrarBodega(CvistaBodega);
        }
        if (e.getSource() == CvistaBodega.btnModificar) {
            String texto1 = CvistaBodega.txtNombre_bdg.getText();
            String texto2 = CvistaBodega.txtDireccion_bdg.getText();
            String texto3 = CvistaBodega.txtCorreo_bdg.getText();

            if (!texto1.isEmpty() || !texto2.isEmpty() || !texto3.isEmpty()) {
                if (!texto3.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                } else {
                    modeloBodegas.CActualizarBodega(CvistaBodega);
                    modeloBodegas.CMostrarBodega(CvistaBodega);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            }

        }
    }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}
