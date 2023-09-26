package Controlador;

import Modelo.usuarios;
import Controlador.ctrlEncriptacion;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlPrimerUsuario implements ActionListener {

    private PrimerUsuario vistaPUsuario;
    private usuarios modeloUsuario;
    private LoginPTC login;
    private ctrlEncriptacion encript;

    public ctrlPrimerUsuario(PrimerUsuario vistaPUsuario, usuarios modeloUsuario, LoginPTC login, ctrlEncriptacion encript) {
        this.modeloUsuario = modeloUsuario;
        this.vistaPUsuario = vistaPUsuario;
        this.login = login;
        this.encript = encript;
        this.vistaPUsuario.btnAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==vistaPUsuario.btnAgregar){
//            String texto1 = vistaPUsuario.txtUsuario.getText();
//            String texto2 = vistaPUsuario.txtContrasenia.getText();
//            System.out.println("se da clic en ctrl usuario");
//            modeloUsuario.setUsr_nombre(vistaPUsuario.txtUsuario.getText());
//            modeloUsuario.setUsr_contra(encript.convertirSHA256(vistaPUsuario.txtContrasenia.getText()));
//            modeloUsuario.PMUsuario(modeloUsuario);
//            vistaPUsuario.dispose();
//            login.INIT();
//            
//        }
        if (e.getSource() == vistaPUsuario.btnAgregar) {
            String texto1 = vistaPUsuario.txtUsuario.getText();
            String texto2 = vistaPUsuario.txtContrasenia.getText();

            // Validación del texto1 (nombre de usuario)
            if (texto1.length() > 5 && !texto1.contains(" ")) {

                // Validación del texto2 (contraseña)
                boolean contieneLetras = false;
                boolean contieneNumeros = false;
                boolean contieneSimbolos = false;

                for (char c : texto2.toCharArray()) {
                    if (Character.isLetter(c)) {
                        contieneLetras = true;
                    } else if (Character.isDigit(c)) {
                        contieneNumeros = true;
                    } else {
                        contieneSimbolos = true;
                    }
                }

                if (contieneLetras && contieneNumeros && contieneSimbolos) {
                    // La validación ha pasado, puedes proceder
                    modeloUsuario.setUsr_nombre(texto1);
                    modeloUsuario.setUsr_contra(encript.convertirSHA256(texto2));
                    modeloUsuario.PMUsuario(modeloUsuario);
                    vistaPUsuario.dispose();
                    login.INIT();
                } else {
                    // La contraseña no cumple con los requisitos
                    String mensajeError = "La contraseña no cumple con los requisitos:\n";
                    if (!contieneLetras) {
                        mensajeError += "- Debe contener al menos una letra.\n";
                    }
                    if (!contieneNumeros) {
                        mensajeError += "- Debe contener al menos un número.\n";
                    }
                    if (!contieneSimbolos) {
                        mensajeError += "- Debe contener al menos un símbolo.\n";
                    }

                    // Mostrar un mensaje de error con JOptionPane
                    JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // El texto1 no cumple con los requisitos (por ejemplo, es muy corto)
                JOptionPane.showMessageDialog(null, "El nombre de usuario debe tener al menos 6 caracteres y no contener espacios.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
