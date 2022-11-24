/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.areshop.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Michelle
 */
public class Conexion {
    /**
     * Obtiene una conexión hacia la base de datos utilizando los parámetros proporcionados.
     * @return La conexión inicializada hacia la base de datos.
     */

    public static Connection obtener() {
        Connection con = null;

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost/areshop?user=root&passwodr=");

        } catch (SQLException ex) {
            System.out.println("Conexion no establecida");
        }
        return con;
    }

}
