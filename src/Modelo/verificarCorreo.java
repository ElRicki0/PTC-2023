/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Javier
 */
public class verificarCorreo {

    private CConexion conex;

    public verificarCorreo(CConexion conex) {
        this.conex = conex;
    }

    public boolean CorreoExistente(String correo) {
        try {
            String query = "SELECT COUNT(*) FROM tbEmpleados WHERE emp_correo = ?";
            PreparedStatement statement = conex.getConexion().prepareStatement(query);
            statement.setString(1, correo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int contador = resultSet.getInt(1);
                return contador > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
