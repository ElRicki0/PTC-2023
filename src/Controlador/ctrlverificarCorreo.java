/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CConexion;
import Modelo.verificarCorreo;

/**
 *
 * @author Javier
 */
public class ctrlverificarCorreo {

    private verificarCorreo Correo;
    private CConexion conexion;

    public ctrlverificarCorreo(CConexion conexion) {
        this.Correo = new verificarCorreo(conexion);
    }

    public boolean CorreoBD(String correo) {
        return Correo.CorreoExistente(correo);
    }

}
