package Controlador;

import Modelo.vehiculos;
import Vista.VVehiculos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rnmel
 */
public class ctrlVehiculo implements ActionListener {

    private VVehiculos vistaVehiculos;
    private vehiculos modeloVehiculo;

    public ctrlVehiculo(VVehiculos vistaVehiculos, vehiculos modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
        this.vistaVehiculos = vistaVehiculos;
        this.vistaVehiculos.btnAgregar.addActionListener(this);
        this.vistaVehiculos.btnEliminar.addActionListener(this);
        this.vistaVehiculos.btnModificarMP.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaVehiculos.btnAgregar) {
            String texto1 = vistaVehiculos.txtMatricula.getText();
            if (!texto1.matches("P\\w{3}-\\w{3}")) {
                JOptionPane.showMessageDialog(null, "la matricula no es valida.");
            } else {
                if (texto1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seleccione un mecanico válida del ComboBox de bodegas.");
                } else {
                    modeloVehiculo.setVehi_Matricula(vistaVehiculos.txtMatricula.getText());
                    modeloVehiculo.setIdModelo(vistaVehiculos.jcbModelo.getSelectedItem().toString());
                    modeloVehiculo.setIdMantenimineto(vistaVehiculos.jcbMantenimiento.getSelectedItem().toString());
                    modeloVehiculo.Agregar(modeloVehiculo, vistaVehiculos.jcbModelo, vistaVehiculos.jcbMantenimiento);
                    modeloVehiculo.MostrarTabla(vistaVehiculos);
                }
            }
            
        }if (e.getSource()==vistaVehiculos.btnEliminar) {
            modeloVehiculo.Eliminar(vistaVehiculos);
            modeloVehiculo.MostrarTabla(vistaVehiculos);
        }if (e.getSource()==vistaVehiculos.btnModificarMP) {
            String texto1 = vistaVehiculos.txtMatricula.getText();
            if (!texto1.matches("P\\w{3}-\\w{3}")) {
                JOptionPane.showMessageDialog(null, "la matricula no es valida.");
            } else {
                if (texto1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seleccione un mecanico válida del ComboBox de bodegas.");
                } else {
                    modeloVehiculo.setVehi_Matricula(vistaVehiculos.txtMatricula.getText());
                    modeloVehiculo.setIdModelo(vistaVehiculos.jcbModelo.getSelectedItem().toString());
                    modeloVehiculo.setIdMantenimineto(vistaVehiculos.jcbMantenimiento.getSelectedItem().toString());
                    modeloVehiculo.Modificar(modeloVehiculo, vistaVehiculos.jcbModelo, vistaVehiculos.jcbMantenimiento, vistaVehiculos);
                    modeloVehiculo.MostrarTabla(vistaVehiculos);
                }
            }
            
            
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
