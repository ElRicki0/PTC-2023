package Controlador;

import Vista.VCliente_DatosTiendas;
import Modelo.*;
import Vista.Controlador.CCliente_DatosTiendas;
import Vista.Repartidor.RTiendas;
import Vista.Usuario.UTiendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlDatosTiendas implements ActionListener {

    private VCliente_DatosTiendas vistaDatos;
    private CCliente_DatosTiendas CvistaDatos;
    private RTiendas RvistaDatos;
    private UTiendas UvistaDatos;
    private DatosTiendas modeloDatos;

    public ctrlDatosTiendas(VCliente_DatosTiendas vistaDatos, DatosTiendas modeloDatos, CCliente_DatosTiendas CvistaDatos, RTiendas RvistaDatos, UTiendas UvistaDatos) {
        this.modeloDatos = modeloDatos;
        this.vistaDatos = vistaDatos;
        this.CvistaDatos = CvistaDatos;
        this.RvistaDatos = RvistaDatos;
        this.UvistaDatos = UvistaDatos;
    ///////////Admin////////////////////////////////////////////////////////////
        this.vistaDatos.btnAgregar_CL.addActionListener(this);
        this.vistaDatos.btnEliminar_TN.addActionListener(this);
        this.vistaDatos.btnModificar_CL.addActionListener(this);
        this.vistaDatos.btnRestablecer.addActionListener(this);
        this.vistaDatos.btnBuscarcmx.addActionListener(this);
    ///////////Controlador////////////////////////////////////////////////////////////
        this.CvistaDatos.btnAgregar_CL.addActionListener(this);
        this.CvistaDatos.btnEliminar_TN.addActionListener(this);
        this.CvistaDatos.btnModificar_CL.addActionListener(this);
        this.CvistaDatos.btnRestablecer.addActionListener(this);
        this.CvistaDatos.btnBuscarcmx.addActionListener(this);
    ///////////repartidor////////////////////////////////////////////////////////////
        this.RvistaDatos.btnRestablecer.addActionListener(this);
        this.RvistaDatos.btnBuscarcmx.addActionListener(this);
    ///////////Usuario////////////////////////////////////////////////////////////
        this.UvistaDatos.btnRestablecer.addActionListener(this);
        this.UvistaDatos.btnBuscarcmx.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //////////////Administrador/////////////////////////////////////////////////////////
        if (e.getSource() == vistaDatos.btnAgregar_CL) {
            String texto1 = vistaDatos.txtEncargado.getText();
            String texto2 = vistaDatos.txtTelefono.getText();
            if (texto1.isEmpty() || texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto1.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                } else {
                    if (!texto2.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El telefono solo pueden ir numeros");
                    } else {
                        if (texto2.length() == 8) {
                            modeloDatos.setDT_NumeroTelefono(vistaDatos.txtTelefono.getText());
                            modeloDatos.setDT_PersonaDestinatario(vistaDatos.txtEncargado.getText());
                            modeloDatos.setIdCliente(vistaDatos.jcbCliente.getSelectedItem().toString());
                            modeloDatos.setIdTienda(vistaDatos.jcbTienda.getSelectedItem().toString());
                            modeloDatos.Agregar(modeloDatos, vistaDatos.jcbCliente, vistaDatos.jcbTienda);
                            modeloDatos.MostrarTabla(vistaDatos);
                        } else {
                            JOptionPane.showMessageDialog(null, "El telefono tiene que ser valido");
                        }
                    }
                }
            }
        }
        if (e.getSource() == vistaDatos.btnEliminar_TN) {
            modeloDatos.Eliminar(vistaDatos);
            modeloDatos.MostrarTabla(vistaDatos);
        }
        if (e.getSource() == vistaDatos.btnModificar_CL) {
            String texto1 = vistaDatos.txtEncargado.getText();
            String texto2 = vistaDatos.txtTelefono.getText();
            if (texto1.isEmpty() || texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto1.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                } else {
                    if (!texto2.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El telefono solo pueden ir numeros");
                    } else {
                        if (texto2.length() == 8) {
                            modeloDatos.setDT_NumeroTelefono(vistaDatos.txtTelefono.getText());
                            modeloDatos.setDT_PersonaDestinatario(vistaDatos.txtEncargado.getText());
                            modeloDatos.setIdCliente(vistaDatos.jcbCliente.getSelectedItem().toString());
                            modeloDatos.setIdTienda(vistaDatos.jcbTienda.getSelectedItem().toString());
                            modeloDatos.Modificar(vistaDatos, modeloDatos, vistaDatos.jcbCliente, vistaDatos.jcbTienda);
                            modeloDatos.MostrarTabla(vistaDatos);
                        } else {
                            JOptionPane.showMessageDialog(null, "El telefono tiene que ser valido");
                        }
                    }
                }
            }

        }
        if (e.getSource() == vistaDatos.btnBuscarcmx) {
            modeloDatos.ABuscador(vistaDatos);
        }
        if (e.getSource() == vistaDatos.btnRestablecer) {
            modeloDatos.MostrarTabla(vistaDatos);
        }

        ////////////////Controlador///////////////////////////////////////////////////////
        if (e.getSource() == CvistaDatos.btnAgregar_CL) {
            String texto1 = CvistaDatos.txtEncargado.getText();
            String texto2 = CvistaDatos.txtTelefono.getText();
            if (texto1.isEmpty() || texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto1.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                } else {
                    if (!texto2.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El telefono solo pueden ir numeros");
                    } else {
                        if (texto2.length() == 8) {
                            modeloDatos.setDT_NumeroTelefono(CvistaDatos.txtTelefono.getText());
                            modeloDatos.setDT_PersonaDestinatario(CvistaDatos.txtEncargado.getText());
                            modeloDatos.setIdCliente(CvistaDatos.jcbCliente.getSelectedItem().toString());
                            modeloDatos.setIdTienda(CvistaDatos.jcbTienda.getSelectedItem().toString());
                            modeloDatos.CAgregar(modeloDatos, CvistaDatos.jcbCliente, CvistaDatos.jcbTienda);
                            modeloDatos.CMostrarTabla(CvistaDatos);
                        } else {
                            JOptionPane.showMessageDialog(null, "El telefono tiene que ser valido");
                        }
                    }
                }
            }
        }
        if (e.getSource() == CvistaDatos.btnEliminar_TN) {
            modeloDatos.CEliminar(CvistaDatos);
            modeloDatos.CMostrarTabla(CvistaDatos);
        }
        if (e.getSource() == CvistaDatos.btnModificar_CL) {
            String texto1 = CvistaDatos.txtEncargado.getText();
            String texto2 = CvistaDatos.txtTelefono.getText();
            if (texto1.isEmpty() || texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto1.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                } else {
                    if (!texto2.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El telefono solo pueden ir numeros");
                    } else {
                        if (texto2.length() == 8) {
                            modeloDatos.setDT_NumeroTelefono(CvistaDatos.txtTelefono.getText());
                            modeloDatos.setDT_PersonaDestinatario(CvistaDatos.txtEncargado.getText());
                            modeloDatos.setIdCliente(CvistaDatos.jcbCliente.getSelectedItem().toString());
                            modeloDatos.setIdTienda(CvistaDatos.jcbTienda.getSelectedItem().toString());
                            modeloDatos.CModificar(CvistaDatos, modeloDatos, CvistaDatos.jcbCliente, CvistaDatos.jcbTienda);
                            modeloDatos.CMostrarTabla(CvistaDatos);
                        } else {
                            JOptionPane.showMessageDialog(null, "El telefono tiene que ser valido");
                        }
                    }
                }
            }

        }
        if (e.getSource() == CvistaDatos.btnBuscarcmx) {
            modeloDatos.CBuscador(CvistaDatos);
        }
        if (e.getSource() == CvistaDatos.btnRestablecer) {
            modeloDatos.CMostrarTabla(CvistaDatos);
        }
    ///////////////repartidor////////////////////////////////////////////////////////
        if (e.getSource() == RvistaDatos.btnBuscarcmx) {
            modeloDatos.RBuscador(RvistaDatos);
        }
        if (e.getSource() == RvistaDatos.btnRestablecer) {
            modeloDatos.RMostrarTabla(RvistaDatos);
        }
    ///////////////usuario////////////////////////////////////////////////////////
        if (e.getSource() == UvistaDatos.btnBuscarcmx) {
            modeloDatos.UBuscador(UvistaDatos);
        }
        if (e.getSource() == UvistaDatos.btnRestablecer) {
            modeloDatos.UMostrarTabla(UvistaDatos);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
