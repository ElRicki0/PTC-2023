package Controlador;

import Modelo.TiposEmpleados;
import Vista.Controlador.CEmpleados_Tipos;
import Vista.VEmpleados_Tipos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlTiposEmpleados implements ActionListener {

    private VEmpleados_Tipos vistaTEmpleados;
    private CEmpleados_Tipos CvistaTEmpleados;
    private TiposEmpleados modeloTEmpleados;

    public ctrlTiposEmpleados(VEmpleados_Tipos vistaTEmpleados, TiposEmpleados modeloTEmpleados, CEmpleados_Tipos CvistaTEmpleados) {
        this.vistaTEmpleados = vistaTEmpleados;
        this.CvistaTEmpleados = CvistaTEmpleados;
        this.modeloTEmpleados = modeloTEmpleados;
        this.vistaTEmpleados.btnAgregar.addActionListener(this);
        this.vistaTEmpleados.btnEliminar.addActionListener(this);
        this.vistaTEmpleados.btnModificarMP.addActionListener(this);
        this.CvistaTEmpleados.btnAgregar.addActionListener(this);
        this.CvistaTEmpleados.btnEliminar.addActionListener(this);
        this.CvistaTEmpleados.btnModificarMP.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaTEmpleados.btnAgregar) {
            String texto = vistaTEmpleados.txtNombre_TE.getText();
            String texto1 = vistaTEmpleados.txtDescripcion_TE.getText();
            if (!texto.matches("[a-z A-Z]+")) {
                JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
            } else {
                if (!texto1.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "La descripcion solo pueden ir letras");

                } else {

                    modeloTEmpleados.setTipo_Emp(vistaTEmpleados.txtNombre_TE.getText());
                    modeloTEmpleados.setDescripcion_Emp(vistaTEmpleados.txtDescripcion_TE.getText());
                    modeloTEmpleados.agregar(modeloTEmpleados);
                    modeloTEmpleados.MostrarTEmpleados(vistaTEmpleados);
                }
            }
        }
        if (e.getSource() == vistaTEmpleados.btnEliminar) {
            modeloTEmpleados.eliminar(vistaTEmpleados);
            modeloTEmpleados.MostrarTEmpleados(vistaTEmpleados);
        }
        if (e.getSource() == vistaTEmpleados.btnModificarMP) {
            modeloTEmpleados.actualizar(vistaTEmpleados);
            modeloTEmpleados.MostrarTEmpleados(vistaTEmpleados);
        }
        
        ///////////////////////////Controlador/////////////////////////////////////////////
        if (e.getSource() == CvistaTEmpleados.btnAgregar) {
            String texto = CvistaTEmpleados.txtNombre_TE.getText();
            String texto1 = CvistaTEmpleados.txtDescripcion_TE.getText();
            if (!texto.matches("[a-z A-Z]+")) {
                JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
            } else {
                if (!texto1.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "La descripcion solo pueden ir letras");

                } else {

                    modeloTEmpleados.setTipo_Emp(CvistaTEmpleados.txtNombre_TE.getText());
                    modeloTEmpleados.setDescripcion_Emp(CvistaTEmpleados.txtDescripcion_TE.getText());
                    modeloTEmpleados.agregar(modeloTEmpleados);
                    modeloTEmpleados.CMostrarTEmpleados(CvistaTEmpleados);
                }
            }
        }
        if (e.getSource() == CvistaTEmpleados.btnEliminar) {
            modeloTEmpleados.Celiminar(CvistaTEmpleados);
            modeloTEmpleados.CMostrarTEmpleados(CvistaTEmpleados);
        }
        if (e.getSource() == CvistaTEmpleados.btnModificarMP) {
            modeloTEmpleados.Cactualizar(CvistaTEmpleados);
            modeloTEmpleados.CMostrarTEmpleados(CvistaTEmpleados);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
