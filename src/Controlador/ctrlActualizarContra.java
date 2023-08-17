package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;

public class ctrlActualizarContra implements ActionListener{

    private usuarios modeloContra;
    private NuevoContra vistaContra;
    private ctrlEncriptacion encript;
    
    public ctrlActualizarContra(usuarios modeloContra, NuevoContra vistaContra){
        this.modeloContra = modeloContra;
        this.vistaContra = vistaContra;
        this.encript = new ctrlEncriptacion(); // Inicializar la variable encript
        this.vistaContra.btnEnviar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaContra.btnEnviar) {
            modeloContra.setUsr_nombre(vistaContra.txtUsuario.getText());
            modeloContra.setUsr_contra(encript.convertirSHA256(vistaContra.txtContrasenia.getText()));
            modeloContra.ActualizarContra(modeloContra);
            vistaContra.dispose();
        } else {
        }
    }
}

