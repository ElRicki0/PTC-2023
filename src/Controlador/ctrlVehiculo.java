package Controlador;

import Modelo.vehiculos;
import Vista.VVehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rnmel
 */
public class ctrlVehiculo implements ActionListener {

    private VVehiculo vistaVehiculos;
    private vehiculos modeloVehiculo;

    public ctrlVehiculo(VVehiculo vistaVehiculos, vehiculos modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
        this.vistaVehiculos = vistaVehiculos;
        this.vistaVehiculos.btnAgregar.addActionListener(this);
        this.vistaVehiculos.btnEliminar.addActionListener(this);
        this.vistaVehiculos.btnModificarMP.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaVehiculos.btnAgregar) {
            modeloVehiculo.setVehi_Matricula(vistaVehiculos.txtMatricula.getText());
            modeloVehiculo.setIdModelo(vistaVehiculos.jcbModelo.getSelectedItem().toString());
            modeloVehiculo.setIdMantenimineto(vistaVehiculos.jcbMantenimiento.getSelectedItem().toString());
            modeloVehiculo.Agregar(modeloVehiculo, vistaVehiculos.jcbModelo, vistaVehiculos.jcbMantenimiento);
            modeloVehiculo.MostrarTabla(vistaVehiculos);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
