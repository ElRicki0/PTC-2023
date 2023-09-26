package Controlador;

import Vista.*;
import Modelo.*;
import Vista.Controlador.CVehiculo_Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthListUI;

public class ctrlModelo implements ActionListener {

    private VVehiculo_Modelo vistaModelo;
    private CVehiculo_Modelo CvistaModelo;
    private Modelos1 modeloModelo;

    public ctrlModelo(VVehiculo_Modelo vistaModelo, Modelos1 modeloModelo, CVehiculo_Modelo CvistaModelo) {
        this.modeloModelo = modeloModelo;
        this.vistaModelo = vistaModelo;
        this.CvistaModelo = CvistaModelo;
        this.vistaModelo.btnAgregar.addActionListener(this);
        this.vistaModelo.btnEliminar.addActionListener(this);
        this.vistaModelo.btnModificarMP.addActionListener(this);
        this.vistaModelo.btnBuscar.addActionListener(this);
        this.vistaModelo.btnRestaurar.addActionListener(this);
        this.CvistaModelo.btnAgregar.addActionListener(this);
        this.CvistaModelo.btnEliminar.addActionListener(this);
        this.CvistaModelo.btnModificarMP.addActionListener(this);
        this.CvistaModelo.btnBuscar.addActionListener(this);
        this.CvistaModelo.btnRestaurar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ////////////Administrador///////////////////////////////////////////////////////////
        if (e.getSource() == vistaModelo.btnAgregar) {
            String texto1 = vistaModelo.txtModelo.getText();
            String texto2 = vistaModelo.txtAnio.getText();
            String texto3 = vistaModelo.txtMarca.getText();

            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El año tiene que ser un número válido");
                } else {
                    int anio = Integer.parseInt(texto2);
                    if (anio < 1980 || anio > 2030) {
                        JOptionPane.showMessageDialog(null, "El año debe estar entre 1980 y 2030");
                    } else {
                        if (!texto1.matches("[a-zA-Z ]+")) {
                            JOptionPane.showMessageDialog(null, "El modelo solo puede contener letras y espacios");
                        } else {
                            if (!texto3.matches("[a-zA-Z ]+")) {
                                JOptionPane.showMessageDialog(null, "La marca solo puede contener letras y espacios");
                            } else {
                                modeloModelo.setModelo(vistaModelo.txtModelo.getText());
                                modeloModelo.setMo_anio(Integer.parseInt(vistaModelo.txtAnio.getText()));
                                modeloModelo.setMarcavehiculo(vistaModelo.txtMarca.getText());
                                modeloModelo.Agregar(modeloModelo, vistaModelo);
                                modeloModelo.MostrarTabla(vistaModelo);
                            }
                        }
                    }
                }
            }

        }
        if (e.getSource() == vistaModelo.btnEliminar) {
            modeloModelo.Eliminar(vistaModelo);
            modeloModelo.MostrarTabla(vistaModelo);
        }
        if (e.getSource() == vistaModelo.btnModificarMP) {
            String texto1 = vistaModelo.txtModelo.getText();
            String texto2 = vistaModelo.txtAnio.getText();
            String texto3 = vistaModelo.txtMarca.getText();

            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El año tiene que ser un número válido");
                } else {
                    int anio = Integer.parseInt(texto2);
                    if (anio < 1980 || anio > 2030) {
                        JOptionPane.showMessageDialog(null, "El año debe estar entre 1980 y 2030");
                    } else {
                        if (!texto1.matches("[a-zA-Z ]+")) {
                            JOptionPane.showMessageDialog(null, "El modelo solo puede contener letras y espacios");
                        } else {
                            if (!texto3.matches("[a-zA-Z ]+")) {
                                JOptionPane.showMessageDialog(null, "La marca solo puede contener letras y espacios");
                            } else {
                                modeloModelo.Editar(vistaModelo);
                                modeloModelo.MostrarTabla(vistaModelo);
                            }
                        }
                    }
                }
            }

        }
        if (e.getSource() == vistaModelo.btnRestaurar) {
            modeloModelo.MostrarTabla(vistaModelo);
        }
        if (e.getSource() == vistaModelo.btnBuscar) {
            modeloModelo.Buscador(vistaModelo);
        }

        //////////Contrlador/////////////////////////////////////////////////////////////
        if (e.getSource() == CvistaModelo.btnAgregar) {
            String texto1 = CvistaModelo.txtModelo.getText();
            String texto2 = CvistaModelo.txtAnio.getText();
            String texto3 = CvistaModelo.txtMarca.getText();

            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El año tiene que ser un número válido");
                } else {
                    int anio = Integer.parseInt(texto2);
                    if (anio < 1980 || anio > 2030) {
                        JOptionPane.showMessageDialog(null, "El año debe estar entre 1980 y 2030");
                    } else {
                        if (!texto1.matches("[a-zA-Z ]+")) {
                            JOptionPane.showMessageDialog(null, "El modelo solo puede contener letras y espacios");
                        } else {
                            if (!texto3.matches("[a-zA-Z ]+")) {
                                JOptionPane.showMessageDialog(null, "La marca solo puede contener letras y espacios");
                            } else {
                                modeloModelo.setModelo(CvistaModelo.txtModelo.getText());
                                modeloModelo.setMo_anio(Integer.parseInt(CvistaModelo.txtAnio.getText()));
                                modeloModelo.setMarcavehiculo(CvistaModelo.txtMarca.getText());
                                modeloModelo.CAgregar(modeloModelo, CvistaModelo);
                                modeloModelo.CMostrarTabla(CvistaModelo);
                            }
                        }
                    }
                }
            }

        }
        if (e.getSource() == CvistaModelo.btnEliminar) {
            modeloModelo.CEliminar(CvistaModelo);
            modeloModelo.CMostrarTabla(CvistaModelo);
        }
        if (e.getSource() == CvistaModelo.btnModificarMP) {
            String texto1 = CvistaModelo.txtModelo.getText();
            String texto2 = CvistaModelo.txtAnio.getText();
            String texto3 = CvistaModelo.txtMarca.getText();

            if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El año tiene que ser un número válido");
                } else {
                    int anio = Integer.parseInt(texto2);
                    if (anio < 1980 || anio > 2030) {
                        JOptionPane.showMessageDialog(null, "El año debe estar entre 1980 y 2030");
                    } else {
                        if (!texto1.matches("[a-zA-Z ]+")) {
                            JOptionPane.showMessageDialog(null, "El modelo solo puede contener letras y espacios");
                        } else {
                            if (!texto3.matches("[a-zA-Z ]+")) {
                                JOptionPane.showMessageDialog(null, "La marca solo puede contener letras y espacios");
                            } else {
                                modeloModelo.CEditar(CvistaModelo);
                                modeloModelo.CMostrarTabla(CvistaModelo);
                            }
                        }
                    }
                }
            }

        }
        if (e.getSource() == CvistaModelo.btnRestaurar) {
            modeloModelo.CMostrarTabla(CvistaModelo);
        }
        if (e.getSource() == CvistaModelo.btnBuscar) {
            modeloModelo.CBuscador(CvistaModelo);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
