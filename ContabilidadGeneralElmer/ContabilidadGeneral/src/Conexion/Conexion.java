package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dalton
 */
/*public class Conexion {
//recordar que estaban privadas

    public static Connection con;
//recordar que estaban privadas
    public static void conectar(Connection con) {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sic",
                    "semitas", "semita");
        } catch (SQLException | ClassNotFoundException
                | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Connection getConexion(Connection con) {
        if (con == null) {
            conectar(con);
        }
        return con;
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}*/
