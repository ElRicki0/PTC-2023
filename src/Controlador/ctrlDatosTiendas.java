package Controlador;

import Vista.VCliente_DatosTiendas;
import Modelo.*;
import Vista.Usuario.UTiendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlDatosTiendas implements ActionListener{

    private VCliente_DatosTiendas vistaDatos;
    private UTiendas vistaDatosU;
    private DatosTiendas modeloDatos;
    
    public ctrlDatosTiendas(VCliente_DatosTiendas vistaDatos, DatosTiendas modeloDatos, UTiendas vistaDatosU){
        this.modeloDatos=modeloDatos;
        this.vistaDatos=vistaDatos;
        this.vistaDatosU=vistaDatosU;
        this.vistaDatos.btnAgregar_CL.addActionListener(this);
        this.vistaDatos.btnEliminar_TN.addActionListener(this);
        this.vistaDatos.btnModificar_CL.addActionListener(this);
        this.vistaDatos.btnRestablecer.addActionListener(this);
        this.vistaDatos.btnBuscarcmx.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vistaDatos.btnAgregar_CL) {
            String texto1 = vistaDatos.txtEncargado.getText();
            String texto2 = vistaDatos.txtTelefono.getText();
            if (texto1.isEmpty()||texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto1.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                } else {
                    if (!texto2.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El telefono solo pueden ir numeros");
                    } else {
                        if (texto2.length()==8) {
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
            
            
        }if (e.getSource()==vistaDatos.btnEliminar_TN) {
            modeloDatos.eliminar(vistaDatos);
            modeloDatos.MostrarTabla(vistaDatos);
        }if (e.getSource()==vistaDatos.btnModificar_CL) {
            String texto1 = vistaDatos.txtEncargado.getText();
            String texto2 = vistaDatos.txtTelefono.getText();
            if (texto1.isEmpty()||texto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto1.matches("[a-z A-Z]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");
                } else {
                    if (!texto2.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "El telefono solo pueden ir numeros");
                    } else {
                        if (texto2.length()==8) {
                            modeloDatos.setDT_NumeroTelefono(vistaDatos.txtTelefono.getText());
                            modeloDatos.setDT_PersonaDestinatario(vistaDatos.txtEncargado.getText());
                            modeloDatos.setIdCliente(vistaDatos.jcbCliente.getSelectedItem().toString());
                            modeloDatos.setIdTienda(vistaDatos.jcbTienda.getSelectedItem().toString());
                            modeloDatos.modificar(vistaDatos, modeloDatos, vistaDatos.jcbCliente, vistaDatos.jcbTienda);
                            modeloDatos.MostrarTabla(vistaDatos);
                        } else {
                            JOptionPane.showMessageDialog(null, "El telefono tiene que ser valido");
                        }
                    }
                }
            }
            
        }if (e.getSource()==vistaDatos.btnBuscarcmx) {
            modeloDatos.BuscadorCMB(vistaDatos);
        }if (e.getSource()==vistaDatos.btnRestablecer) {
            modeloDatos.MostrarTabla(vistaDatos);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
