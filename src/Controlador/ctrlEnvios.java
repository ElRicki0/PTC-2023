package Controlador;

import Modelo.BitacoraDistribuciones;
import Vista.Controlador.CMain_Rutas;
import Vista.Controlador.CRutas_Envios;
import Vista.Repartidor.REnvios;
import Vista.VMain_Rutas;
import Vista.VRutas_Envios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlEnvios implements ActionListener {

    private VRutas_Envios vistaEnvios;
    private VMain_Rutas vistaM;
    private CMain_Rutas vistaC;
    private CRutas_Envios CvistaEnvios;
    private REnvios RvistaEnvios;
    private BitacoraDistribuciones modeloEnvios;

    public ctrlEnvios(VRutas_Envios vistaEnvios, VMain_Rutas vistaM, CMain_Rutas vistaC, BitacoraDistribuciones modeloEnvios, REnvios RvistaEnvios, CRutas_Envios CvistaEnvios) {
        this.modeloEnvios = modeloEnvios;
        this.vistaEnvios = vistaEnvios;
        this.vistaM = vistaM;
        this.vistaC = vistaC;
        this.RvistaEnvios = RvistaEnvios;
        this.CvistaEnvios = CvistaEnvios;
        this.vistaEnvios.btnAgregar.addActionListener(this);
        this.vistaEnvios.btnEliminar.addActionListener(this);
        this.vistaEnvios.btnModificarMP.addActionListener(this);
        this.vistaM.btnBuscar.addActionListener(this);
        this.vistaM.btnRestaurar.addActionListener(this);
        this.vistaC.btnBuscar.addActionListener(this);
        this.vistaC.btnRestaurar.addActionListener(this);
        this.CvistaEnvios.btnAgregar.addActionListener(this);
        this.CvistaEnvios.btnEliminar.addActionListener(this);
        this.CvistaEnvios.btnModificarMP.addActionListener(this);
        this.RvistaEnvios.btnModificarMP.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //////////////Adminitrador/////////////////////////////////////////////////////////
        if (e.getSource() == vistaEnvios.btnAgregar) {
            String texto1 = vistaEnvios.txtFecha.getText();
            String regex = "\\d{4}-\\d{2}-\\d{2}";

            if (texto1.matches(regex)) {
                modeloEnvios.setFecha_Entrega(texto1);
                modeloEnvios.setIdEmpleado(vistaEnvios.jcbEmpleado.getSelectedItem().toString());
                modeloEnvios.setIdUsuario(vistaEnvios.jcbUsuario.getSelectedItem().toString());
                modeloEnvios.setIdvehiculo(vistaEnvios.jcbVehiculo.getSelectedItem().toString());
                modeloEnvios.setIdPaqueteria(vistaEnvios.jcbPaquete.getSelectedItem().toString());
                modeloEnvios.setIdEstado(vistaEnvios.jcbEstado.getSelectedItem().toString());
                modeloEnvios.Agregar(modeloEnvios, vistaEnvios.jcbEmpleado, vistaEnvios.jcbUsuario, vistaEnvios.jcbVehiculo, vistaEnvios.jcbPaquete, vistaEnvios.jcbEstado);
                modeloEnvios.MostrarTabla(vistaEnvios);
            } else {
                JOptionPane.showMessageDialog(null, "la fecha tiene que tener la estructura de ''año-mes-dia''");
            }

        }
        if (e.getSource() == vistaEnvios.btnEliminar) {
            modeloEnvios.Eliminar(vistaEnvios);
            modeloEnvios.MostrarTabla(vistaEnvios);
        }
        if (e.getSource() == vistaEnvios.btnModificarMP) {
            String texto1 = vistaEnvios.txtFecha.getText();
            String regex = "\\d{4}-\\d{2}-\\d{2}";

            if (texto1.matches(regex)) {
                modeloEnvios.setFecha_Entrega(texto1);
                modeloEnvios.setIdEmpleado(vistaEnvios.jcbEmpleado.getSelectedItem().toString());
                modeloEnvios.setIdUsuario(vistaEnvios.jcbUsuario.getSelectedItem().toString());
                modeloEnvios.setIdvehiculo(vistaEnvios.jcbVehiculo.getSelectedItem().toString());
                modeloEnvios.setIdPaqueteria(vistaEnvios.jcbPaquete.getSelectedItem().toString());
                modeloEnvios.setIdEstado(vistaEnvios.jcbEstado.getSelectedItem().toString());
                modeloEnvios.Editar(modeloEnvios, vistaEnvios.jcbEmpleado, vistaEnvios.jcbUsuario, vistaEnvios.jcbVehiculo, vistaEnvios.jcbPaquete, vistaEnvios.jcbEstado, vistaEnvios);
                modeloEnvios.MostrarTabla(vistaEnvios);
            } else {
                JOptionPane.showMessageDialog(null, "la fecha tiene que tener la estructura de ''año-mes-dia''");
            }
        }
        if (e.getSource()==vistaM.btnBuscar) {
            modeloEnvios.BuscarTablaM(vistaM);
        }
        if (e.getSource()==vistaM.btnRestaurar) {
            modeloEnvios.MostrarTablaM(vistaM);
        }
        ///////////////Controlador////////////////////////////////////////////////////////
        if (e.getSource() == CvistaEnvios.btnAgregar) {
            String texto1 = CvistaEnvios.txtFecha.getText();
            String regex = "\\d{4}-\\d{2}-\\d{2}";

            if (texto1.matches(regex)) {
                modeloEnvios.setFecha_Entrega(texto1);
                modeloEnvios.setIdEmpleado(CvistaEnvios.jcbEmpleado.getSelectedItem().toString());
                modeloEnvios.setIdUsuario(CvistaEnvios.jcbUsuario.getSelectedItem().toString());
                modeloEnvios.setIdvehiculo(CvistaEnvios.jcbVehiculo.getSelectedItem().toString());
                modeloEnvios.setIdPaqueteria(CvistaEnvios.jcbPaquete.getSelectedItem().toString());
                modeloEnvios.setIdEstado(vistaEnvios.jcbEstado.getSelectedItem().toString());
                modeloEnvios.CAgregar(modeloEnvios, CvistaEnvios.jcbEmpleado, CvistaEnvios.jcbUsuario, CvistaEnvios.jcbVehiculo, CvistaEnvios.jcbPaquete, CvistaEnvios.jcbEstado);
                modeloEnvios.CMostrarTabla(CvistaEnvios);
            } else {
                JOptionPane.showMessageDialog(null, "la fecha tiene que tener la estructura de ''año-mes-dia''");
            }

        }
        if (e.getSource() == CvistaEnvios.btnEliminar) {
            modeloEnvios.CEliminar(CvistaEnvios);
            modeloEnvios.CMostrarTabla(CvistaEnvios);
        }
        if (e.getSource() == vistaEnvios.btnModificarMP) {
            String texto1 = vistaEnvios.txtFecha.getText();
            String regex = "\\d{4}-\\d{2}-\\d{2}";

            if (texto1.matches(regex)) {
                modeloEnvios.setFecha_Entrega(texto1);
                modeloEnvios.setIdEmpleado(CvistaEnvios.jcbEmpleado.getSelectedItem().toString());
                modeloEnvios.setIdUsuario(CvistaEnvios.jcbUsuario.getSelectedItem().toString());
                modeloEnvios.setIdvehiculo(CvistaEnvios.jcbVehiculo.getSelectedItem().toString());
                modeloEnvios.setIdPaqueteria(CvistaEnvios.jcbPaquete.getSelectedItem().toString());
                modeloEnvios.setIdEstado(CvistaEnvios.jcbEstado.getSelectedItem().toString());
                modeloEnvios.CEditar(modeloEnvios, CvistaEnvios.jcbEmpleado, CvistaEnvios.jcbUsuario, CvistaEnvios.jcbVehiculo, CvistaEnvios.jcbPaquete, CvistaEnvios.jcbEstado, CvistaEnvios);
                modeloEnvios.CMostrarTabla(CvistaEnvios);
            } else {
                JOptionPane.showMessageDialog(null, "la fecha tiene que tener la estructura de ''año-mes-dia''");
            }
        }
        if (e.getSource()==vistaC.btnBuscar) {
            modeloEnvios.BuscarTablaMC(vistaC);
        }
        if (e.getSource()==vistaC.btnRestaurar) {
            modeloEnvios.CMostrarTablaMC(vistaC);
        }
    ////////////////Repartidor///////////////////////////////////////////////////////
        if (e.getSource()==RvistaEnvios.btnModificarMP) {
            modeloEnvios.setIdEstado(RvistaEnvios.jcbEstado.getSelectedItem().toString());
            modeloEnvios.REditar(modeloEnvios, vistaEnvios.jcbEstado, RvistaEnvios);
            modeloEnvios.RMostrarTabla(RvistaEnvios);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
