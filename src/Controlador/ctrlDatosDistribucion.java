package Controlador;

import Modelo.DatosDistribucion;
import Vista.Controlador.CRutas_DatosDis;
import Vista.VProducto;
import Vista.VRutas_DatosDis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlDatosDistribucion implements ActionListener {

    private VRutas_DatosDis vistaDistribucion;
    private CRutas_DatosDis CvistaDistribucion;
    private DatosDistribucion modeloDistribucion;

    public ctrlDatosDistribucion(VRutas_DatosDis vistaDistribucion, DatosDistribucion Modelo, CRutas_DatosDis CvistaDistribucion) {
        this.modeloDistribucion = Modelo;
        this.vistaDistribucion = vistaDistribucion;
        this.CvistaDistribucion = CvistaDistribucion;
        this.vistaDistribucion.btnAgregar1.addActionListener(this);
        this.vistaDistribucion.btnEliminar1.addActionListener(this);
        this.vistaDistribucion.btnModificarMP1.addActionListener(this);
        this.CvistaDistribucion.btnAgregar1.addActionListener(this);
        this.CvistaDistribucion.btnEliminar1.addActionListener(this);
        this.CvistaDistribucion.btnModificarMP1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //////////Admiistrador/////////////////////////////////////////////////////////////
        if (e.getSource() == vistaDistribucion.btnAgregar1) {
            String texto1 = vistaDistribucion.txtNombreDis.getText();
            String texto2 = vistaDistribucion.txtCantidad.getText();
            if (texto1.isEmpty() || texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "En cantidad solo pueden ir numeros  ");
                } else {
                    modeloDistribucion.setDaDis_Nombre(vistaDistribucion.txtNombreDis.getText());
                    modeloDistribucion.setIdProducto(vistaDistribucion.jcbProducto.getSelectedItem().toString());
                    modeloDistribucion.setCantidadProducto(Integer.parseInt(vistaDistribucion.txtCantidad.getText()));
                    modeloDistribucion.setIdEmpleado(vistaDistribucion.jcbEmpleado.getSelectedItem().toString());
                    modeloDistribucion.Agregar(modeloDistribucion, vistaDistribucion.jcbProducto, vistaDistribucion.jcbEmpleado);
                    modeloDistribucion.Mostrartabla(vistaDistribucion);
                }
            }

        }
        if (e.getSource() == vistaDistribucion.btnEliminar1) {
            modeloDistribucion.Eliminar(vistaDistribucion);
            modeloDistribucion.Mostrartabla(vistaDistribucion);

        }
        if (e.getSource() == vistaDistribucion.btnModificarMP1) {
            modeloDistribucion.setDaDis_Nombre(vistaDistribucion.txtNombreDis.getText());
            modeloDistribucion.setCantidadProducto(Integer.parseInt(vistaDistribucion.txtCantidad.getText()));
            modeloDistribucion.Actualizar(vistaDistribucion, modeloDistribucion, vistaDistribucion.jcbProducto, vistaDistribucion.jcbEmpleado);
            modeloDistribucion.Mostrartabla(vistaDistribucion);
        }

        ////////////Controlador///////////////////////////////////////////////////////////
        if (e.getSource() == CvistaDistribucion.btnAgregar1) {
            String texto1 = CvistaDistribucion.txtNombreDis.getText();
            String texto2 = CvistaDistribucion.txtCantidad.getText();
            if (texto1.isEmpty() || texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "En cantidad solo pueden ir numeros  ");
                } else {
                    modeloDistribucion.setDaDis_Nombre(CvistaDistribucion.txtNombreDis.getText());
                    modeloDistribucion.setIdProducto(CvistaDistribucion.jcbProducto.getSelectedItem().toString());
                    modeloDistribucion.setCantidadProducto(Integer.parseInt(CvistaDistribucion.txtCantidad.getText()));
                    modeloDistribucion.setIdEmpleado(CvistaDistribucion.jcbEmpleado.getSelectedItem().toString());
                    modeloDistribucion.CAgregar(modeloDistribucion, CvistaDistribucion.jcbProducto, CvistaDistribucion.jcbEmpleado);
                    modeloDistribucion.CMostrartabla(CvistaDistribucion);
                }
            }

        }
        if (e.getSource() == CvistaDistribucion.btnEliminar1) {
            modeloDistribucion.CEliminar(CvistaDistribucion);
            modeloDistribucion.CMostrartabla(CvistaDistribucion);

        }
        if (e.getSource() == CvistaDistribucion.btnModificarMP1) {
            modeloDistribucion.setDaDis_Nombre(CvistaDistribucion.txtNombreDis.getText());
            modeloDistribucion.setCantidadProducto(Integer.parseInt(CvistaDistribucion.txtCantidad.getText()));
            modeloDistribucion.CActualizar(CvistaDistribucion, modeloDistribucion, CvistaDistribucion.jcbProducto, CvistaDistribucion.jcbEmpleado);
            modeloDistribucion.CMostrartabla(CvistaDistribucion);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
