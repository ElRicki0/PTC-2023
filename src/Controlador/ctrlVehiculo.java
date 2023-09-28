package Controlador;

import Modelo.vehiculos;
import Vista.Controlador.CVehiculo;
import Vista.Repartidor.RVehiculos;
import Vista.Usuario.UVehiculos;
import Vista.VMain_Vehiculos;
import Vista.VVehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rnmel
 */
public class ctrlVehiculo implements ActionListener {

    private VVehiculo vistaVehiculo;
    private VMain_Vehiculos VistaM;
    private CVehiculo CvistaVehiculo;
    private RVehiculos RvistaVehiculo;
    private UVehiculos UvistaVehiculo;
    private vehiculos modeloVehiculo;

    public ctrlVehiculo(VVehiculo vistaVehiculo, VMain_Vehiculos vistaM,  vehiculos modeloVehiculo, CVehiculo CvistaVehiculo, RVehiculos RvistaVehiculo, UVehiculos UvistaVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
        this.vistaVehiculo = vistaVehiculo;
        this.VistaM = vistaM;
        this.CvistaVehiculo = CvistaVehiculo;
        this.RvistaVehiculo = RvistaVehiculo;
        this.UvistaVehiculo = UvistaVehiculo;
    /////////////Administrador//////////////////////////////////////////////////////////
        this.vistaVehiculo.btnAgregar.addActionListener(this);
        this.vistaVehiculo.btnEliminar.addActionListener(this);
        this.vistaVehiculo.btnModificarMP.addActionListener(this);
        this.vistaVehiculo.btnRestaurar.addActionListener(this);
        this.vistaVehiculo.btnBuscar.addActionListener(this);
        this.VistaM.btnRestaurar.addActionListener(this);
        this.VistaM.btnBuscar.addActionListener(this);
    /////////////Controlador//////////////////////////////////////////////////////////
        this.CvistaVehiculo.btnAgregar.addActionListener(this);
        this.CvistaVehiculo.btnEliminar.addActionListener(this);
        this.CvistaVehiculo.btnModificarMP.addActionListener(this);
        this.CvistaVehiculo.btnRestaurar.addActionListener(this);
        this.CvistaVehiculo.btnBuscar.addActionListener(this);
    /////////////repartidor//////////////////////////////////////////////////////////
        this.RvistaVehiculo.btnRestaurar.addActionListener(this);
        this.RvistaVehiculo.btnBuscar.addActionListener(this);
    /////////////usuario//////////////////////////////////////////////////////////
        this.UvistaVehiculo.btnRestaurar.addActionListener(this);
        this.UvistaVehiculo.btnBuscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    ////////////Adminnistrador///////////////////////////////////////////////////////////
        if (e.getSource() == CvistaVehiculo.btnAgregar) {
            String texto1 = CvistaVehiculo.txtMatricula.getText();

            // Expresión regular para validar la matrícula
            String regex = "^[Pp][0-9A-Fa-f]{3}-[0-9A-Fa-f]{3}$|^[Pp][0-9A-Fa-f]{6}$";

            if (texto1.matches(regex)) {
                // La matrícula es válida, puedes continuar con el código
                modeloVehiculo.setVehi_Matricula(texto1);
                modeloVehiculo.setIdModelo(CvistaVehiculo.jcbModelo.getSelectedItem().toString());
                modeloVehiculo.setIdMantenimineto(CvistaVehiculo.jcbMantenimiento.getSelectedItem().toString());
                modeloVehiculo.CAgregar(modeloVehiculo, CvistaVehiculo.jcbModelo, CvistaVehiculo.jcbMantenimiento, CvistaVehiculo);
                modeloVehiculo.MostrarTabla(vistaVehiculo);
            } else {
                // La matrícula no es válida, muestra un mensaje de error o realiza alguna acción apropiada
                JOptionPane.showMessageDialog(null, "La matrícula no es válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == vistaVehiculo.btnEliminar) {
            modeloVehiculo.Eliminar(vistaVehiculo);
            modeloVehiculo.MostrarTabla(vistaVehiculo);
        }
        if (e.getSource() == vistaVehiculo.btnModificarMP) {
            String texto1 = vistaVehiculo.txtMatricula.getText();

            String regex = "^[Pp][0-9A-Fa-f]{3}-[0-9A-Fa-f]{3}$|^[Pp][0-9A-Fa-f]{6}$";
            if (texto1.matches(regex)) {
                modeloVehiculo.setVehi_Matricula(vistaVehiculo.txtMatricula.getText());
                modeloVehiculo.setIdModelo(vistaVehiculo.jcbModelo.getSelectedItem().toString());
                modeloVehiculo.setIdMantenimineto(vistaVehiculo.jcbMantenimiento.getSelectedItem().toString());
                modeloVehiculo.Actualizar(modeloVehiculo, vistaVehiculo.jcbModelo, vistaVehiculo.jcbMantenimiento, vistaVehiculo);
                modeloVehiculo.MostrarTabla(vistaVehiculo);
            } else {
                JOptionPane.showMessageDialog(null, "La matrícula no es válida", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == vistaVehiculo.btnRestaurar) {
            modeloVehiculo.MostrarTabla(vistaVehiculo);
        }
        if (e.getSource() == vistaVehiculo.btnBuscar) {
            modeloVehiculo.Buscador(vistaVehiculo);
        }
        if (e.getSource() == VistaM.btnBuscar) {
            modeloVehiculo.BuscadorM(VistaM);
        }
        if (e.getSource() == VistaM.btnRestaurar) {
            modeloVehiculo.MostrarTablaM(VistaM);
        }
        //////////////////Controlador/////////////////////////////////////////////////////
        if (e.getSource() == vistaVehiculo.btnAgregar) {
            String texto1 = vistaVehiculo.txtMatricula.getText();

            // Expresión regular para validar la matrícula
            String regex = "^[Pp][0-9A-Fa-f]{3}-[0-9A-Fa-f]{3}$|^[Pp][0-9A-Fa-f]{6}$";

            if (texto1.matches(regex)) {
                // La matrícula es válida, puedes continuar con el código
                modeloVehiculo.setVehi_Matricula(texto1);
                modeloVehiculo.setIdModelo(vistaVehiculo.jcbModelo.getSelectedItem().toString());
                modeloVehiculo.setIdMantenimineto(vistaVehiculo.jcbMantenimiento.getSelectedItem().toString());
                modeloVehiculo.Agregar(modeloVehiculo, vistaVehiculo.jcbModelo, vistaVehiculo.jcbMantenimiento, vistaVehiculo);
                modeloVehiculo.CMostrarTabla(CvistaVehiculo);
            } else {
                // La matrícula no es válida, muestra un mensaje de error o realiza alguna acción apropiada
                JOptionPane.showMessageDialog(null, "La matrícula no es válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == CvistaVehiculo.btnEliminar) {
            modeloVehiculo.CEliminar(CvistaVehiculo);
            modeloVehiculo.CMostrarTabla(CvistaVehiculo);
        }
        if (e.getSource() == CvistaVehiculo.btnModificarMP) {
            String texto1 = CvistaVehiculo.txtMatricula.getText();

            String regex = "^[Pp][0-9A-Fa-f]{3}-[0-9A-Fa-f]{3}$|^[Pp][0-9A-Fa-f]{6}$";
            if (texto1.matches(regex)) {
                modeloVehiculo.setVehi_Matricula(CvistaVehiculo.txtMatricula.getText());
                modeloVehiculo.setIdModelo(CvistaVehiculo.jcbModelo.getSelectedItem().toString());
                modeloVehiculo.setIdMantenimineto(CvistaVehiculo.jcbMantenimiento.getSelectedItem().toString());
                modeloVehiculo.CActualizar(modeloVehiculo, CvistaVehiculo.jcbModelo, CvistaVehiculo.jcbMantenimiento, CvistaVehiculo);
                modeloVehiculo.CMostrarTabla(CvistaVehiculo);
            } else {
                JOptionPane.showMessageDialog(null, "La matrícula no es válida", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == CvistaVehiculo.btnRestaurar) {
            modeloVehiculo.CMostrarTabla(CvistaVehiculo);
        }
        if (e.getSource() == CvistaVehiculo.btnBuscar) {
            modeloVehiculo.CBuscador(CvistaVehiculo);
        }
        ////////////////////Repartidor///////////////////////////////////////////////////
        if (e.getSource() == RvistaVehiculo.btnRestaurar) {
            modeloVehiculo.RMostrarTabla(RvistaVehiculo);
        }
        if (e.getSource() == UvistaVehiculo.btnBuscar) {
            modeloVehiculo.RBuscador(RvistaVehiculo);
        }
        ////////////////////usuario///////////////////////////////////////////////////
        if (e.getSource() == UvistaVehiculo.btnRestaurar) {
            modeloVehiculo.UMostrarTabla(UvistaVehiculo);
        }
        if (e.getSource() == UvistaVehiculo.btnBuscar) {
            modeloVehiculo.UBuscador(UvistaVehiculo);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    

    }
}
