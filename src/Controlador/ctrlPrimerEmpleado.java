/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import java.text.ParseException;
import Vista.PrimerEmpleado;
import Vista.PrimerUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class ctrlPrimerEmpleado implements ActionListener {

    private PrimerEmpleado vistaPrimero;
    private EmpleadosM modeloEmpleado;
    private PrimerUsuario vistaUsuarioPM;

    public ctrlPrimerEmpleado(EmpleadosM modeloEmpleados, PrimerEmpleado vistaPrimero, PrimerUsuario vistaUsuarioPM) {
        this.modeloEmpleado = modeloEmpleados;
        this.vistaPrimero = vistaPrimero;
        this.vistaUsuarioPM = vistaUsuarioPM;
        this.vistaPrimero.btnAgregar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto1 = vistaPrimero.txtCorreo.getText();
        String texto2 = vistaPrimero.txtFecha.getText();
        String texto3 = vistaPrimero.txtNombre.getText();
        String texto4 = vistaPrimero.txtTelefono.getText();
        if (e.getSource() == vistaPrimero.btnAgregar) {
            try {
                if (!texto3.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                } else {
                    if (!texto4.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El Numero de telefono solo puede tener numeros");
                    } else {
                        if (texto4.length() == 8) {
                            if (!texto1.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                            } else {
                                String fechaIngresada = texto2; // Tu fecha ingresada en formato "yyyy/MM/dd"
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                                sdf.setLenient(false);
                                try {
                                    sdf.parse(fechaIngresada);
                                    // La fecha es válida
                                    modeloEmpleado.setEmp_nombre(vistaPrimero.txtNombre.getText());
                                    modeloEmpleado.setEmp_correo(vistaPrimero.txtCorreo.getText());
                                    modeloEmpleado.setEmp_direccion(vistaPrimero.txtDireccion.getText());
                                    modeloEmpleado.setEmp_fecha(vistaPrimero.txtFecha.getText());
                                    modeloEmpleado.setEmp_telefono(vistaPrimero.txtTelefono.getText());
                                    modeloEmpleado.setIdGenero(vistaPrimero.jcbGenero.getSelectedItem().toString());
                                    modeloEmpleado.AgregarEmpleado(modeloEmpleado, vistaPrimero.jcbGenero);
                                    vistaPrimero.dispose();
                                    vistaUsuarioPM.INIT();

                                } catch (ParseException we) {
                                    JOptionPane.showMessageDialog(null, "La fecha no es válida");
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "El numero de telefono tiene que ser valido");
                        }
                    }
                }
            } catch (Exception en) {
                System.out.println("erro en control empleado" + en.toString());
            }
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
