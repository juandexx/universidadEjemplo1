/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccsesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "universidadulp";
    private static final String USUARIO = "root";
    private static String PASSWORD = "";

    private static Connection connection;

    //metodo contstructor private conexino vacio    
    private Conexion() {
    }

    public static Connection getConexion() {
        if (connection == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                //preparacion de la coneccion  con la Base de Datos
                connection = DriverManager.getConnection(URL + DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + USUARIO + "&password=" + PASSWORD);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error al conectarse a la BD " + ex.getMessage());
            } catch (ClassNotFoundException ex) {

                JOptionPane.showMessageDialog(null, "Error al cargar los Drivers" + ex.getMessage());

            }
        }
        return connection;
    }
}
