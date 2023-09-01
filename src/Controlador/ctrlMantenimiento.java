package Controlador;

import Vista.VMantenimiento;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rnmel
 */
public class ctrlMantenimiento implements ActionListener{

    private VMantenimiento Vista;
    private Mantenimiento Modelo;
    
    public ctrlMantenimiento(VMantenimiento Vista, Mantenimiento Modelo){
        this.Modelo=Modelo;
        this.Vista=Vista;
        this.Vista.btnAgregar.addActionListener(this);
        this.Vista.btnModificarMP.addActionListener(this);
        this.Vista.btnEliminar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Vista.btnAgregar) {
            Modelo.setMecanico(Vista.txtmecanico.getText());
            Modelo.setTFTaller(Vista.txtmecanico.getText());
            Modelo.setIdTaller(Vista.jcbTaller.getSelectedItem().toString());
            Modelo.Agregar(Modelo, Vista.jcbTaller);
            Modelo.Mostrartabla(Vista);
        }
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
