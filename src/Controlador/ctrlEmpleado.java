package Controlador;

import Modelo.EmpleadosM;
import Vista.VEmpleados;
import Vista.VEmpleados_Tipos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.ThaiBuddhistEra;
import javax.swing.JOptionPane;

public class ctrlEmpleado implements ActionListener {

    private VEmpleados vistaEmpleado;
    private EmpleadosM modeloEmpleado;

    public ctrlEmpleado(VEmpleados vistaEmpleado, EmpleadosM modeloEmpleado) {
        this.vistaEmpleado = vistaEmpleado;
        this.modeloEmpleado = modeloEmpleado;
        this.vistaEmpleado.btnAgregar.addActionListener(this);
        this.vistaEmpleado.btnEliminar.addActionListener(this);
        this.vistaEmpleado.btnModificarMP.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaEmpleado.btnAgregar) {
            String texto1 = vistaEmpleado.txtNombre_emp.getText();
            String texto2 = vistaEmpleado.txtTelefono_emp.getText();
            String texto3 = vistaEmpleado.txtCorreo_emp.getText();

            try {

                if (!texto1.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                } else {
                    if (!texto2.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El Numero de telefono solo puede tener numeros");
                    } else {
                        if (texto2.length() == 8) {
                            if (!texto3.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                            } else {
                                modeloEmpleado.setEmp_nombre(vistaEmpleado.txtNombre_emp.getText());
                                modeloEmpleado.setEmp_fecha(vistaEmpleado.txtFN_emp.getText());
                                modeloEmpleado.setEmp_direccion(vistaEmpleado.txtDireccion_emp.getText());
                                modeloEmpleado.setEmp_telefono(vistaEmpleado.txtTelefono_emp.getText());
                                modeloEmpleado.setEmp_correo(vistaEmpleado.txtCorreo_emp.getText());
                                modeloEmpleado.setIdGenero(vistaEmpleado.jcbGenero.getSelectedItem().toString());
                                modeloEmpleado.MAgregarEmpleado(modeloEmpleado, vistaEmpleado.jcbGenero, vistaEmpleado.jcbTipo);
                                modeloEmpleado.MostrarEmpleados(vistaEmpleado);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El Numero de telefono tiene que tener 8 digitos");
                        }
                    }
                }

            } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "ERROR EN EL control empleado " + ae.toString());
            }
        }
        if (e.getSource() == vistaEmpleado.btnEliminar) {
            try {
                modeloEmpleado.eliminar(vistaEmpleado);
                modeloEmpleado.MostrarEmpleados(vistaEmpleado);
            } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "Seleccione un empleado para eliminar");
            }

        }
        if (e.getSource() == vistaEmpleado.btnModificarMP) {

            String texto1 = vistaEmpleado.txtNombre_emp.getText();
            String texto2 = vistaEmpleado.txtTelefono_emp.getText();
            String texto3 = vistaEmpleado.txtCorreo_emp.getText();

            try {

                if (!texto1.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                } else {
                    if (!texto2.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El Numero de telefono solo puede tener numeros");
                    } else {
                        if (texto2.length() == 8) {
                            if (!texto3.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                            } else {
                                modeloEmpleado.setEmp_nombre(vistaEmpleado.txtNombre_emp.getText());
                                modeloEmpleado.setEmp_fecha(vistaEmpleado.txtFN_emp.getText());
                                modeloEmpleado.setEmp_direccion(vistaEmpleado.txtDireccion_emp.getText());
                                modeloEmpleado.setEmp_telefono(vistaEmpleado.txtTelefono_emp.getText());
                                modeloEmpleado.setEmp_correo(vistaEmpleado.txtCorreo_emp.getText());
                                modeloEmpleado.setIdGenero(vistaEmpleado.jcbGenero.getSelectedItem().toString());
                                modeloEmpleado.actualizar(modeloEmpleado, vistaEmpleado.jcbGenero, vistaEmpleado.jcbTipo, vistaEmpleado);
                                modeloEmpleado.MostrarEmpleados(vistaEmpleado);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El Numero de telefono Tiene que ser valido");
                        }
                    }
                }

            } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "ERROR EN EL control empleado " + ae.toString());
            }

        }

//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
