/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class Conexion {
     private static Connection con;

    private static void conectar() {        
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sic",
                    "semitas", "semita");
        } catch (SQLException | ClassNotFoundException
                | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Connection getConexion() {
        if (con == null) {
            conectar();
        }
        return con;
    }
    
}
