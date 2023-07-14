
//El paquete al que pertenece nuestra clase de conexión
package Modelo; // <- Editar por su paquete

//Importamos la libreria JDBC
import java.sql.*;

//Creación de la clase de conexión (la cual tiene el mismo nombre del archivo de la clase)
public class CConexion { // <- Editar por el nombre del archivo de la clase
   
    //Creación del metodo de conexión que retorna la conexión
    public static Connection getConexion(){
        try {
            try {
             //Cadena de conexión
        String conexionUrl  = "jdbc:sqlserver://localhost:54855;" // <- Editar por su puerto de SQL
                            + "databaseName=EXPOdb;" // <- Editar por su base de datos
                            + "user=admin1;"
                            + "password=pass123;" 
                            + "encrypt=true;trustServerCertificate=true";
        
        //Retornamos la conexion
        try{
            //Creamos una variable de tipo Connection, al que le pasamos nuestra cadena de conexion
            Connection conn = DriverManager.getConnection(conexionUrl) ;
            //SI funciona, retornamos la conexion
            return conn;
        }catch(SQLException ex){
            //Si no funciona, imprimimos en consola el error y retornamos un valor nulo
            System.out.println(ex.toString());
            return null;
            }
        } 
        catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        } catch (Exception epa) {
            System.out.println("Error de conexion" + epa.toString());
            return null;
        }
        
        
        
        
    }
}