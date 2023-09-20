package Controlador;

import Modelo.vehiculos;
import Vista.VVehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rnmel
 */
public class ctrlVehiculo implements ActionListener {

    private VVehiculo vista;
    private vehiculos modelo;

    public ctrlVehiculo(VVehiculo vista, vehiculos modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnModificarMP.addActionListener(this);
        this.vista.btnRestaurar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            String texto1 = vista.txtMatricula.getText();

            // Expresión regular para validar la matrícula
            String regex = "^[Pp][0-9A-Fa-f]{3}-[0-9A-Fa-f]{3}$|^[Pp][0-9A-Fa-f]{6}$";

            if (texto1.matches(regex)) {
                // La matrícula es válida, puedes continuar con el código
                modelo.setVehi_Matricula(texto1);
                modelo.setIdModelo(vista.jcbModelo.getSelectedItem().toString());
                modelo.setIdMantenimineto(vista.jcbMantenimiento.getSelectedItem().toString());
                modelo.Agregar(modelo, vista.jcbModelo, vista.jcbMantenimiento, vista);
                modelo.MostrarTabla(vista);
            } else {
                // La matrícula no es válida, muestra un mensaje de error o realiza alguna acción apropiada
                JOptionPane.showMessageDialog(null, "La matrícula no es válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == vista.btnEliminar) {
            modelo.Eliminar(vista);
            modelo.MostrarTabla(vista);
        }
        if (e.getSource() == vista.btnModificarMP) {
            String texto1 = vista.txtMatricula.getText();

            String regex = "^[Pp][0-9A-Fa-f]{3}-[0-9A-Fa-f]{3}$|^[Pp][0-9A-Fa-f]{6}$";
            if (texto1.matches(regex)) {
                modelo.setVehi_Matricula(vista.txtMatricula.getText());
                modelo.setIdModelo(vista.jcbModelo.getSelectedItem().toString());
                modelo.setIdMantenimineto(vista.jcbMantenimiento.getSelectedItem().toString());
                modelo.Actualizar(modelo, vista.jcbModelo, vista.jcbMantenimiento, vista);
                modelo.MostrarTabla(vista);
            } else {
                JOptionPane.showMessageDialog(null, "La matrícula no es válida", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == vista.btnRestaurar) {
            modelo.MostrarTabla(vista);
        }
        if (e.getSource() == vista.btnBuscar) {
            modelo.Buscador(vista);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
