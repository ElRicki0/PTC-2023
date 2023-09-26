package Controlador;

import Vista.VVehiculo_Mantenimiento;
import Modelo.*;
import Vista.Controlador.CVehiculo_Mantenimiento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.midi.MidiSystem;
import javax.swing.JOptionPane;

/**
 *
 * @author rnmel
 */
public class ctrlMantenimiento implements ActionListener {

    private VVehiculo_Mantenimiento vistaMantenimiento;
    private CVehiculo_Mantenimiento CvistaMantenimiento;
    private Mantenimiento modeloMantenimiento;

    public ctrlMantenimiento(VVehiculo_Mantenimiento vistaMantenimiento, Mantenimiento modeloMantenimeinto, CVehiculo_Mantenimiento CvistaMantenimiento) {
        this.modeloMantenimiento = modeloMantenimeinto;
        this.vistaMantenimiento = vistaMantenimiento;
        this.CvistaMantenimiento = CvistaMantenimiento;
        this.vistaMantenimiento.btnAgregar.addActionListener(this);
        this.vistaMantenimiento.btnModificarMP.addActionListener(this);
        this.vistaMantenimiento.btnEliminar.addActionListener(this);
        this.vistaMantenimiento.btnRestaurar.addActionListener(this);
        this.vistaMantenimiento.btnBuscar.addActionListener(this);
        this.CvistaMantenimiento.btnAgregar.addActionListener(this);
        this.CvistaMantenimiento.btnModificarMP.addActionListener(this);
        this.CvistaMantenimiento.btnEliminar.addActionListener(this);
        this.CvistaMantenimiento.btnRestaurar.addActionListener(this);
        this.CvistaMantenimiento.btnBuscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /////Administrador//////////////////////////////////////////////////////////////////
        if (e.getSource() == vistaMantenimiento.btnAgregar) {
            String texto1 = vistaMantenimiento.txtmecanico.getText();
            String texto2 = vistaMantenimiento.txtTelefono.getText();
            if (texto1.isEmpty() || texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El numero no puede tener letras");
                } else {
                    if (texto2.length() == 8) {
                        if (!texto1.matches("[a-z A-Z]+")) {
                            JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                        } else {
                            modeloMantenimiento.setMecanico(vistaMantenimiento.txtmecanico.getText());
                            modeloMantenimiento.setTFTaller(vistaMantenimiento.txtTelefono.getText());
                            modeloMantenimiento.setIdTaller(vistaMantenimiento.jcbTaller.getSelectedItem().toString());
                            modeloMantenimiento.Agregar(modeloMantenimiento, vistaMantenimiento.jcbTaller);
                            modeloMantenimiento.Mostrartabla(vistaMantenimiento);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El numero de telefono tiene que ser valido");
                    }
                }
            }
        }
        if (e.getSource() == vistaMantenimiento.btnEliminar) {
            modeloMantenimiento.Eliminar(vistaMantenimiento);
            modeloMantenimiento.Mostrartabla(vistaMantenimiento);
        }
        if (e.getSource() == vistaMantenimiento.btnModificarMP) {
            String texto1 = vistaMantenimiento.txtmecanico.getText();
            String texto2 = vistaMantenimiento.txtTelefono.getText();
            if (texto1.isEmpty() || texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El numero no puede tener letras");
                } else {
                    if (texto2.length() == 8) {
                        if (!texto1.matches("[a-z A-Z]+")) {
                            JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                        } else {
                            modeloMantenimiento.setMecanico(vistaMantenimiento.txtmecanico.getText());
                            modeloMantenimiento.setTFTaller(vistaMantenimiento.txtTelefono.getText());
                            modeloMantenimiento.setIdTaller(vistaMantenimiento.jcbTaller.getSelectedItem().toString());
                            modeloMantenimiento.Editar(modeloMantenimiento, vistaMantenimiento.jcbTaller, vistaMantenimiento);
                            modeloMantenimiento.Mostrartabla(vistaMantenimiento);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El numero de telefono tiene que ser valido");
                    }
                }
            }
        }
        if (e.getSource() == vistaMantenimiento.btnRestaurar) {
            modeloMantenimiento.Mostrartabla(vistaMantenimiento);
        }
        if (e.getSource() == vistaMantenimiento.btnBuscar) {
            modeloMantenimiento.Buscador(vistaMantenimiento);
        }

        //////////Controlador/////////////////////////////////////////////////////////////
        if (e.getSource() == CvistaMantenimiento.btnAgregar) {
            String texto1 = CvistaMantenimiento.txtmecanico.getText();
            String texto2 = CvistaMantenimiento.txtTelefono.getText();
            if (texto1.isEmpty() || texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El numero no puede tener letras");
                } else {
                    if (texto2.length() == 8) {
                        if (!texto1.matches("[a-z A-Z]+")) {
                            JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                        } else {
                            modeloMantenimiento.setMecanico(CvistaMantenimiento.txtmecanico.getText());
                            modeloMantenimiento.setTFTaller(CvistaMantenimiento.txtTelefono.getText());
                            modeloMantenimiento.setIdTaller(CvistaMantenimiento.jcbTaller.getSelectedItem().toString());
                            modeloMantenimiento.CAgregar(modeloMantenimiento, CvistaMantenimiento.jcbTaller);
                            modeloMantenimiento.CMostrartabla(CvistaMantenimiento);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El numero de telefono tiene que ser valido");
                    }
                }
            }
        }
        if (e.getSource() == CvistaMantenimiento.btnEliminar) {
            modeloMantenimiento.CEliminar(CvistaMantenimiento);
            modeloMantenimiento.CMostrartabla(CvistaMantenimiento);
        }
        if (e.getSource() == CvistaMantenimiento.btnModificarMP) {
            String texto1 = CvistaMantenimiento.txtmecanico.getText();
            String texto2 = CvistaMantenimiento.txtTelefono.getText();
            if (texto1.isEmpty() || texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El numero no puede tener letras");
                } else {
                    if (texto2.length() == 8) {
                        if (!texto1.matches("[a-z A-Z]+")) {
                            JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                        } else {
                            modeloMantenimiento.setMecanico(CvistaMantenimiento.txtmecanico.getText());
                            modeloMantenimiento.setTFTaller(CvistaMantenimiento.txtTelefono.getText());
                            modeloMantenimiento.setIdTaller(CvistaMantenimiento.jcbTaller.getSelectedItem().toString());
                            modeloMantenimiento.CEditar(modeloMantenimiento, CvistaMantenimiento.jcbTaller, CvistaMantenimiento);
                            modeloMantenimiento.CMostrartabla(CvistaMantenimiento);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El numero de telefono tiene que ser valido");
                    }
                }
            }
        }
        if (e.getSource() == CvistaMantenimiento.btnRestaurar) {
            modeloMantenimiento.CMostrartabla(CvistaMantenimiento);
        }
        if (e.getSource() == CvistaMantenimiento.btnBuscar) {
            modeloMantenimiento.CBuscador(CvistaMantenimiento);
        }

//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
