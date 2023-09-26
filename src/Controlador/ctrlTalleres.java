package Controlador;

import Modelo.talleres;
import Vista.Controlador.CVehiculo_Taller;
import Vista.VVehiculo_Taller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlTalleres implements ActionListener {

    private VVehiculo_Taller vistaTaller;
    private CVehiculo_Taller CvistaTaller;
    private talleres modeloTaller;

    public ctrlTalleres(VVehiculo_Taller vistaTaller, talleres modeloTaller, CVehiculo_Taller CvistaTaller) {
        this.modeloTaller = modeloTaller;
        this.vistaTaller = vistaTaller;
        this.CvistaTaller = CvistaTaller;
        this.vistaTaller.btnAgregar.addActionListener(this);
        this.vistaTaller.btnEliminar.addActionListener(this);
        this.vistaTaller.btnModificarMP.addActionListener(this);
        this.vistaTaller.btnRestaurar.addActionListener(this);
        this.vistaTaller.btnClasificar.addActionListener(this);
        this.CvistaTaller.btnAgregar.addActionListener(this);
        this.CvistaTaller.btnEliminar.addActionListener(this);
        this.CvistaTaller.btnModificarMP.addActionListener(this);
        this.CvistaTaller.btnRestaurar.addActionListener(this);
        this.CvistaTaller.btnClasificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ///////////Administrador////////////////////////////////////////////////////////////
        if (e.getSource() == vistaTaller.btnAgregar) {
            String texto1 = vistaTaller.txtNombre.getText();
            String texto2 = vistaTaller.txtTelefono.getText();
            String texto3 = vistaTaller.txtCorreo.getText();
            String texto4 = vistaTaller.txtDuenio.getText();

            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El telefono solo pueden ir numeros");
                } else {
                    if (!texto1.matches("[a-z A-Z]+") && texto4.matches("[a-z A-Z]+")) {
                        JOptionPane.showMessageDialog(null, "Los nombres solo pueden ir letras");
                    } else {
                        if (texto2.length() == 8) {
                            if (!texto3.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                            } else {
                                modeloTaller.setTall_Nombre(vistaTaller.txtNombre.getText());
                                modeloTaller.setTall_Telefono(vistaTaller.txtTelefono.getText());
                                modeloTaller.setTall_Correo(vistaTaller.txtCorreo.getText());
                                modeloTaller.setTall_Dueño(vistaTaller.txtDuenio.getText());
                                modeloTaller.Agregar(modeloTaller, vistaTaller);
                                modeloTaller.llenarJCBDuenio(vistaTaller.jcbDuenio);
                                modeloTaller.MostratTabla(vistaTaller);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El telefono tiene que ser valido");
                        }
                    }
                }
            }

        }
        if (e.getSource() == vistaTaller.btnEliminar) {
            modeloTaller.Eliminar(vistaTaller);
            modeloTaller.MostratTabla(vistaTaller);
        }
        if (e.getSource() == vistaTaller.btnModificarMP) {
            String texto1 = vistaTaller.txtNombre.getText();
            String texto2 = vistaTaller.txtTelefono.getText();
            String texto3 = vistaTaller.txtCorreo.getText();
            String texto4 = vistaTaller.txtDuenio.getText();

            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El telefono solo pueden ir numeros");
                } else {
                    if (!texto1.matches("[a-z A-Z]+") && texto4.matches("[a-z A-Z]+")) {
                        JOptionPane.showMessageDialog(null, "Los nombres solo pueden ir letras");
                        System.out.println("" + texto1.toString());
                        System.out.println("" + texto4.toString());
                    } else {
                        if (texto2.length() == 8) {
                            if (!texto3.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                            } else {
                                modeloTaller.Editar(vistaTaller);
                                modeloTaller.llenarJCBDuenio(vistaTaller.jcbDuenio);
                                modeloTaller.MostratTabla(vistaTaller);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El telefono tiene que ser valido");
                        }
                    }
                }
            }

        }
        if (e.getSource() == vistaTaller.btnClasificar) {
            modeloTaller.Clasificar(vistaTaller);
        }
        if (e.getSource() == vistaTaller.btnRestaurar) {
            modeloTaller.MostratTabla(vistaTaller);
        }
        ////////////////Controlador///////////////////////////////////////////////////////
        if (e.getSource() == CvistaTaller.btnAgregar) {
            String texto1 = CvistaTaller.txtNombre.getText();
            String texto2 = CvistaTaller.txtTelefono.getText();
            String texto3 = CvistaTaller.txtCorreo.getText();
            String texto4 = CvistaTaller.txtDuenio.getText();

            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El telefono solo pueden ir numeros");
                } else {
                    if (!texto1.matches("[a-z A-Z]+") && texto4.matches("[a-z A-Z]+")) {
                        JOptionPane.showMessageDialog(null, "Los nombres solo pueden ir letras");
                    } else {
                        if (texto2.length() == 8) {
                            if (!texto3.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                            } else {
                                modeloTaller.setTall_Nombre(CvistaTaller.txtNombre.getText());
                                modeloTaller.setTall_Telefono(CvistaTaller.txtTelefono.getText());
                                modeloTaller.setTall_Correo(CvistaTaller.txtCorreo.getText());
                                modeloTaller.setTall_Dueño(CvistaTaller.txtDuenio.getText());
                                modeloTaller.CAgregar(modeloTaller, CvistaTaller);
                                modeloTaller.CllenarJCBDuenio(CvistaTaller.jcbDuenio);
                                modeloTaller.CMostratTabla(CvistaTaller);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El telefono tiene que ser valido");
                        }
                    }
                }
            }

        }
        if (e.getSource() == CvistaTaller.btnEliminar) {
            modeloTaller.CEliminar(CvistaTaller);
            modeloTaller.CMostratTabla(CvistaTaller);
        }
        if (e.getSource() == CvistaTaller.btnModificarMP) {
            String texto1 = CvistaTaller.txtNombre.getText();
            String texto2 = CvistaTaller.txtTelefono.getText();
            String texto3 = CvistaTaller.txtCorreo.getText();
            String texto4 = CvistaTaller.txtDuenio.getText();

            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El telefono solo pueden ir numeros");
                } else {
                    if (!texto1.matches("[a-z A-Z]+") && texto4.matches("[a-z A-Z]+")) {
                        JOptionPane.showMessageDialog(null, "Los nombres solo pueden ir letras");
                        System.out.println("" + texto1.toString());
                        System.out.println("" + texto4.toString());
                    } else {
                        if (texto2.length() == 8) {
                            if (!texto3.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                                JOptionPane.showMessageDialog(null, "El correo electronico tiene que ser valido");
                            } else {
                                modeloTaller.CEditar(CvistaTaller);
                                modeloTaller.CllenarJCBDuenio(CvistaTaller.jcbDuenio);
                                modeloTaller.CMostratTabla(CvistaTaller);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El telefono tiene que ser valido");
                        }
                    }
                }
            }

        }
        if (e.getSource() == CvistaTaller.btnClasificar) {
            modeloTaller.CClasificar(CvistaTaller);
        }
        if (e.getSource() == vistaTaller.btnRestaurar) {
            modeloTaller.CMostratTabla(CvistaTaller);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
