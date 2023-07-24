/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.EmpleadosM;
import Vista.Empleados;
import Vista.PrimerUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlEmpleado implements ActionListener{
    
    private PrimerUsuario vistaPrimero;
    private EmpleadosM modeloEmpleado;
    
    public ctrlEmpleado(PrimerUsuario vistaPrimero, EmpleadosM modeloEmpleados){
        this.modeloEmpleado=modeloEmpleados;
        this.vistaPrimero=vistaPrimero;
        vistaPrimero.btnAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaPrimero.btnAgregar){
            try {       
                                                System.out.println("Se da click");

                modeloEmpleado.setEmp_nombre(vistaPrimero.txtNombre.getText());
                modeloEmpleado.setEmp_correo(vistaPrimero.txtCorreo.getText());
                modeloEmpleado.setEmp_direccion(vistaPrimero.txtDireccion.getText());
                modeloEmpleado.setEmp_fecha(vistaPrimero.txtFecha.getDateFormatString());
                modeloEmpleado.setEmp_telefono(vistaPrimero.txtNombre.getText());
                modeloEmpleado.setIdGenero(vistaPrimero.jcbGenero.getSelectedItem().toString());
            } catch (Exception en) {
                                System.out.println("eror en control empleado" +en.toString());

            }
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
