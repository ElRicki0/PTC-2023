package Controlador;

import Modelo.paqueteria;
import Vista.Controlador.CRutas_Paqueteria;
import Vista.VRutas_Paqueteria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlPaqueteria implements ActionListener {

    private VRutas_Paqueteria vistaPaqueteria;
    private CRutas_Paqueteria CvistaPaqueteria;
    private paqueteria modeloPaqueteria;

    public ctrlPaqueteria(VRutas_Paqueteria vistaPaqueteria, paqueteria modeloPaqueteria, CRutas_Paqueteria CvistaPaqueteria) {
        this.modeloPaqueteria = modeloPaqueteria;
        this.CvistaPaqueteria = CvistaPaqueteria;
        this.vistaPaqueteria = vistaPaqueteria;
        this.vistaPaqueteria.btnAgregar.addActionListener(this);
        this.vistaPaqueteria.btnEliminar.addActionListener(this);
        this.vistaPaqueteria.btnModificarMP.addActionListener(this);
        this.CvistaPaqueteria.btnAgregar.addActionListener(this);
        this.CvistaPaqueteria.btnEliminar.addActionListener(this);
        this.CvistaPaqueteria.btnModificarMP.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ///////////Administrador////////////////////////////////////////////////////////////
        if (e.getSource() == vistaPaqueteria.btnAgregar) {
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
        }
        if (e.getSource() == vistaPaqueteria.btnEliminar) {
            modeloPaqueteria.Eliminar(vistaPaqueteria);
            modeloPaqueteria.Mostrartabla(vistaPaqueteria);

        }
        if (e.getSource() == vistaPaqueteria.btnModificarMP) {
            String texto1 = vistaPaqueteria.txtDireccion.getText();
            if (texto1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llenen todos los campos ");
            } else {
                modeloPaqueteria.setIdEmpleado(vistaPaqueteria.jcbEmpleado.getSelectedItem().toString());
                modeloPaqueteria.setIdDatosDistribucion(vistaPaqueteria.jcbDistribucion.getSelectedItem().toString());
                modeloPaqueteria.setPaq_Ubicacion(vistaPaqueteria.txtDireccion.getText());
                modeloPaqueteria.Actualizar(modeloPaqueteria, vistaPaqueteria.jcbEmpleado, vistaPaqueteria.jcbDistribucion, vistaPaqueteria);
                modeloPaqueteria.Mostrartabla(vistaPaqueteria);
            }

        }
        ////////Controlador///////////////////////////////////////////////////////////////
        if (e.getSource() == CvistaPaqueteria.btnAgregar) {
            String texto1 = CvistaPaqueteria.txtDireccion.getText();
            if (texto1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llenen todos los campos ");
            } else {
                modeloPaqueteria.setPqt_Nombre(CvistaPaqueteria.txtNombre.getText());
                modeloPaqueteria.setIdEmpleado(CvistaPaqueteria.jcbEmpleado.getSelectedItem().toString());
                modeloPaqueteria.setIdDatosDistribucion(CvistaPaqueteria.jcbDistribucion.getSelectedItem().toString());
                modeloPaqueteria.setPaq_Ubicacion(CvistaPaqueteria.txtDireccion.getText());
                modeloPaqueteria.CAgregar(modeloPaqueteria, CvistaPaqueteria.jcbEmpleado, CvistaPaqueteria.jcbDistribucion);
                modeloPaqueteria.CMostrartabla(CvistaPaqueteria);
            }
        }
        if (e.getSource() == CvistaPaqueteria.btnEliminar) {
            modeloPaqueteria.CEliminar(CvistaPaqueteria);
            modeloPaqueteria.CMostrartabla(CvistaPaqueteria);

        }
        if (e.getSource() == CvistaPaqueteria.btnModificarMP) {
            String texto1 = CvistaPaqueteria.txtDireccion.getText();
            if (texto1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llenen todos los campos ");
            } else {
                modeloPaqueteria.setIdEmpleado(CvistaPaqueteria.jcbEmpleado.getSelectedItem().toString());
                modeloPaqueteria.setIdDatosDistribucion(CvistaPaqueteria.jcbDistribucion.getSelectedItem().toString());
                modeloPaqueteria.setPaq_Ubicacion(CvistaPaqueteria.txtDireccion.getText());
                modeloPaqueteria.CActualizar(modeloPaqueteria, CvistaPaqueteria.jcbEmpleado, CvistaPaqueteria.jcbDistribucion, CvistaPaqueteria);
                modeloPaqueteria.CMostrartabla(CvistaPaqueteria);
            }

        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
