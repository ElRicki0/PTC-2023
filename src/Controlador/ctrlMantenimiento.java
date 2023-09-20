package Controlador;

import Vista.VVehiculo_Mantenimiento;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.midi.MidiSystem;
import javax.swing.JOptionPane;

/**
 *
 * @author rnmel
 */
public class ctrlMantenimiento implements ActionListener{

    private VVehiculo_Mantenimiento Vista;
    private Mantenimiento Modelo;
    
    public ctrlMantenimiento(VVehiculo_Mantenimiento Vista, Mantenimiento Modelo){
        this.Modelo=Modelo;
        this.Vista=Vista;
        this.Vista.btnAgregar.addActionListener(this);
        this.Vista.btnModificarMP.addActionListener(this);
        this.Vista.btnEliminar.addActionListener(this);
        this.Vista.btnRestaurar.addActionListener(this);
        this.Vista.btnBuscar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Vista.btnAgregar) {
            String texto1 = Vista.txtmecanico.getText();
            String texto2 = Vista.txtTelefono.getText();
            if (texto1.isEmpty() || texto2.isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El numero no puede tener letras");
                } else {
                    if (texto2.length()==8) {
                        if (!texto1.matches("[a-z A-Z]+")) {
                            JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");                                 
                        } else {
                            Modelo.setMecanico(Vista.txtmecanico.getText());
                            Modelo.setTFTaller(Vista.txtTelefono.getText());
                            Modelo.setIdTaller(Vista.jcbTaller.getSelectedItem().toString());
                            Modelo.Agregar(Modelo, Vista.jcbTaller);
                            Modelo.Mostrartabla(Vista);
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "El numero de telefono tiene que ser valido");    
                    }
                }
            }
        }if (e.getSource()==Vista.btnEliminar){
            Modelo.Eliminar(Vista);
            Modelo.Mostrartabla(Vista);
        }if (e.getSource()==Vista.btnModificarMP) {
            String texto1 = Vista.txtmecanico.getText();
            String texto2 = Vista.txtTelefono.getText();
            if (texto1.isEmpty() || texto2.isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            } else {
                if (!texto2.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El numero no puede tener letras");
                } else {
                    if (texto2.length()==8) {
                        if (!texto1.matches("[a-z A-Z]+")) {
                            JOptionPane.showMessageDialog(null, "El nombre solo pueden ir letras");                                 
                        } else {
                            Modelo.setMecanico(Vista.txtmecanico.getText());
                            Modelo.setTFTaller(Vista.txtTelefono.getText());
                            Modelo.setIdTaller(Vista.jcbTaller.getSelectedItem().toString());
                            Modelo.Editar(Modelo, Vista.jcbTaller, Vista);
                            Modelo.Mostrartabla(Vista);
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "El numero de telefono tiene que ser valido");    
                    }
                }
            }            
        }if (e.getSource()==Vista.btnRestaurar) {
            Modelo.Mostrartabla(Vista);
        }if (e.getSource()==Vista.btnBuscar) {
            Modelo.Buscador(Vista);
        }
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
