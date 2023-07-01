
//El paquete al que pertenece nuestra clase de conexión
package Controlador; // <- Editar por su paquete

//Importamos la libreria JDBC
import java.sql.*;

//Creación de la clase de conexión (la cual tiene el mismo nombre del archivo de la clase)
public class ConexionSQL { // <- Editar por el nombre del archivo de la clase
   
    //Creación del metodo de conexión que retorna la conexión
    public static Connection getConexion(){
        
         //Cadena de conexión
        String conexionUrl  = "jdbc:sqlserver://localhost:****;" // <- Editar por su puerto de SQL
                            + "databaseName=*****;" // <- Editar por su base de datos
                            + "user=sa;"
                            + "password=itr2023;" 
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
}
