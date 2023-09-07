package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlBodega implements ActionListener {

    private Bodega vistaBodega;
    private Bodegas modeloBodegas;

    public ctrlBodega(Bodega vistaBodega, Bodegas modeloBodegas) {
        this.modeloBodegas = modeloBodegas;
        this.vistaBodega = vistaBodega;
        this.vistaBodega.btnAgregar.addActionListener(this);
        this.vistaBodega.btnEliminar.addActionListener(this);
        this.vistaBodega.btnModificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaBodega.btnAgregar) {
            String texto1 = vistaBodega.txtNombre_bdg.getText();
            String texto2 = vistaBodega.txtDireccion_bdg.getText();
            String texto3 = vistaBodega.txtCorreo_bdg.getText();

            if (!texto1.isEmpty() || !texto2.isEmpty() || !texto3.isEmpty()) {

                modeloBodegas.setBdg_nombre(vistaBodega.txtNombre_bdg.getText());
                modeloBodegas.setBdg_ubicacion(vistaBodega.txtDireccion_bdg.getText());
                modeloBodegas.setBdg_correo(vistaBodega.txtCorreo_bdg.getText());
                modeloBodegas.AgregarBodega(modeloBodegas);
                modeloBodegas.MostrarBodega(vistaBodega);
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
                modeloBodegas.ActualizarBodega(vistaBodega);
                modeloBodegas.MostrarBodega(vistaBodega);
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            }

        }
    }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}
