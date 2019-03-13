/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelotabla.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ilichh1
 */
public class UsuarioConnection {
    private static final String DATABASE_URL = "localhost";
    private static final String DATABASE_PORT = "8889"; // 3306 por default..
    private static final String DATABASE_NAME = "refrescos";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "root";
    
    private static Connection DB_CONNECTION = null;
    
    public static Connection getDataBaseConnection() {
        if (DB_CONNECTION == null) {
            initConnection();
            return DB_CONNECTION;
        }
        return DB_CONNECTION;
    }
    
    private static void initConnection() {
        try {
            // Intento de conexión
            String stringConnection = "jdbc:mysql://"
                                    + DATABASE_URL + ":" + DATABASE_PORT
                                    + "/" + DATABASE_NAME
                                    + "?user=" + DATABASE_USERNAME
                                    + "&password=" + DATABASE_PASSWORD;

            DB_CONNECTION = DriverManager.getConnection(stringConnection);

        } catch (SQLException ex) {
            // Manejar errores
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("NO SE PUDO CONECTAR A LA BASE DE DATOS.");
        }
    }
    
}
