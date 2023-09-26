package Controlador;

import Modelo.clientes;
import Vista.Controlador.CCliente;
import Vista.VCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rnmel
 */
public class ctrlCliente implements ActionListener {

    private clientes modeloClientes;
    private VCliente vistaCliente;
    private CCliente CvistaCliente;

    public ctrlCliente(clientes modeloClientes, VCliente vistaCliente, CCliente CvistaCliente) {
        this.modeloClientes = modeloClientes;
        this.vistaCliente = vistaCliente;
        this.CvistaCliente = CvistaCliente;
        this.vistaCliente.btnAgregar_CL.addActionListener(this);
        this.vistaCliente.btnEliminar_CL.addActionListener(this);
        this.vistaCliente.btnModificar_CL.addActionListener(this);
        this.CvistaCliente.btnAgregar_CL.addActionListener(this);
        this.CvistaCliente.btnEliminar_CL.addActionListener(this);
        this.CvistaCliente.btnModificar_CL.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCliente.btnAgregar_CL) {
            //////////////Admin/////////////////////////////////////////////////////////
            String texto1 = vistaCliente.txtNombre_CL.getText();
            String texto2 = vistaCliente.txtEdad_CL.getText();
            String texto3 = vistaCliente.txtTelefono_CL.getText();
            String texto4 = vistaCliente.txtCorreo_CL.getText();
            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "La edad  no es valida");
                } else {
                    if (!texto3.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El Numero de telefono solo puede tener numeros");
                    } else {
                        if (texto3.length() == 8) {
                            if (!texto4.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                            } else {
                                if (!texto1.matches("[a-z A-Z]+")) {
                                    JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                                } else {
                                    modeloClientes.setClie_Nombre(vistaCliente.txtNombre_CL.getText());
                                    modeloClientes.setClie_Edad(Integer.parseInt(vistaCliente.txtEdad_CL.getText()));
                                    modeloClientes.setClie_telefono(vistaCliente.txtTelefono_CL.getText());
                                    modeloClientes.setClie_correo(vistaCliente.txtCorreo_CL.getText());
                                    modeloClientes.setIdGenero(vistaCliente.jcbGenero_CL.getSelectedItem().toString());
                                    modeloClientes.AgregarCliente(modeloClientes, vistaCliente.jcbGenero_CL);
                                    modeloClientes.MostrarTabla(vistaCliente);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El numero de telefono tiene que ser valido");
                        }
                    }
                }
            }
        }
        if (e.getSource() == vistaCliente.btnEliminar_CL) {
            modeloClientes.eliminar(vistaCliente);
            modeloClientes.MostrarTabla(vistaCliente);
        }
        if (e.getSource() == vistaCliente.btnModificar_CL) {

            String texto1 = vistaCliente.txtNombre_CL.getText();
            String texto2 = vistaCliente.txtEdad_CL.getText();
            String texto3 = vistaCliente.txtTelefono_CL.getText();
            String texto4 = vistaCliente.txtCorreo_CL.getText();
            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "La edad  no es valida");
                } else {
                    if (!texto3.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El Numero de telefono solo puede tener numeros");
                    } else {
                        if (texto3.length() == 8) {
                            if (!texto4.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                            } else {
                                modeloClientes.setClie_Nombre(vistaCliente.txtNombre_CL.getText());
                                modeloClientes.setClie_Edad(Integer.parseInt(vistaCliente.txtEdad_CL.getText()));
                                modeloClientes.setClie_telefono(vistaCliente.txtTelefono_CL.getText());
                                modeloClientes.setClie_correo(vistaCliente.txtCorreo_CL.getText());
                                modeloClientes.Editar(vistaCliente, modeloClientes, vistaCliente.jcbGenero_CL);
                                modeloClientes.MostrarTabla(vistaCliente);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El numero de telefono tiene que ser valido");
                        }
                    }
                }
            }
        }
        

        ///////////////Controlador////////////////////////////////////////////////////////
         if (e.getSource() == CvistaCliente.btnAgregar_CL) {
            String texto1 = CvistaCliente.txtNombre_CL.getText();
            String texto2 = CvistaCliente.txtEdad_CL.getText();
            String texto3 = CvistaCliente.txtTelefono_CL.getText();
            String texto4 = CvistaCliente.txtCorreo_CL.getText();
            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "La edad  no es valida");
                } else {
                    if (!texto3.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El Numero de telefono solo puede tener numeros");
                    } else {
                        if (texto3.length() == 8) {
                            if (!texto4.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                            } else {
                                if (!texto1.matches("[a-z A-Z]+")) {
                                    JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                                } else {
                                    modeloClientes.setClie_Nombre(CvistaCliente.txtNombre_CL.getText());
                                    modeloClientes.setClie_Edad(Integer.parseInt(CvistaCliente.txtEdad_CL.getText()));
                                    modeloClientes.setClie_telefono(CvistaCliente.txtTelefono_CL.getText());
                                    modeloClientes.setClie_correo(CvistaCliente.txtCorreo_CL.getText());
                                    modeloClientes.setIdGenero(CvistaCliente.jcbGenero_CL.getSelectedItem().toString());
                                    modeloClientes.CAgregarCliente(modeloClientes, CvistaCliente.jcbGenero_CL);
                                    modeloClientes.CMostrarTabla(CvistaCliente);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El numero de telefono tiene que ser valido");
                        }
                    }
                }
            }
        }
        if (e.getSource() == CvistaCliente.btnEliminar_CL) {
            modeloClientes.CEliminar(CvistaCliente);
            modeloClientes.CMostrarTabla(CvistaCliente);
        }
        if (e.getSource() == CvistaCliente.btnModificar_CL) {

            String texto1 = CvistaCliente.txtNombre_CL.getText();
            String texto2 = CvistaCliente.txtEdad_CL.getText();
            String texto3 = CvistaCliente.txtTelefono_CL.getText();
            String texto4 = CvistaCliente.txtCorreo_CL.getText();
            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "La edad  no es valida");
                } else {
                    if (!texto3.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El Numero de telefono solo puede tener numeros");
                    } else {
                        if (texto3.length() == 8) {
                            if (!texto4.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                            } else {
                                modeloClientes.setClie_Nombre(CvistaCliente.txtNombre_CL.getText());
                                modeloClientes.setClie_Edad(Integer.parseInt(CvistaCliente.txtEdad_CL.getText()));
                                modeloClientes.setClie_telefono(CvistaCliente.txtTelefono_CL.getText());
                                modeloClientes.setClie_correo(CvistaCliente.txtCorreo_CL.getText());
                                modeloClientes.CEditar(CvistaCliente, modeloClientes, CvistaCliente.jcbGenero_CL);
                                modeloClientes.CMostrarTabla(CvistaCliente);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El numero de telefono tiene que ser valido");
                        }
                    }
                }
            }
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}
}

