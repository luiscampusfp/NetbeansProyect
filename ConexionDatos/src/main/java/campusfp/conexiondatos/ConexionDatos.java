/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package campusfp.conexiondatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rayleigh
 */
public class ConexionDatos {

    public static void getDataTable(String tabla) throws SQLException {

        // Establecemos la conexión con la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "");

// Creamos una sentencia SQL
        Statement stmt = con.createStatement();

// Ejecutamos la sentencia y obtenemos los resultados en un objeto ResultSet
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tabla);

// Obtenemos la cantidad de columnas del ResultSet
        int columnCount = rs.getMetaData().getColumnCount();

// Recorremos el ResultSet y mostramos los datos de cada fila
        while (rs.next()) {
            // Recorremos cada columna y mostramos su valor
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + " | ");
            }
            System.out.println();
        }

    }
}
