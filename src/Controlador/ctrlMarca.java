package Controlador;

import Modelo.MarcaProductos;
import Vista.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlMarca implements ActionListener{
    
    private MarcaProductos modeloMarca;
    private Producto        vistaMarca;
    
    public ctrlMarca(MarcaProductos modeloMarca, Producto vistaMarca){
        this.modeloMarca= modeloMarca;
        this.vistaMarca=vistaMarca;
        this.vistaMarca.btnAgregarMC.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vistaMarca.btnAgregarMC) 
        {
            modeloMarca.setMP_correo(vistaMarca.txtCorreosMC.getText());
            modeloMarca.setMP_NumeroContacto(vistaMarca.txtNumeroMC.getText());
            modeloMarca.setMP_nombre(vistaMarca.txtNombreMC.getText());
            modeloMarca.AgregarMarca(modeloMarca);
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
