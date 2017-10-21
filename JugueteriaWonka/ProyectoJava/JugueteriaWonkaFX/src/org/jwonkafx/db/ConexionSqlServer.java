/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Josem
 */
public class ConexionSqlServer {
    String url;
    String userName;
    String password;
    
    //Este objeto nos sirve para gestionar la conexion con SQL Server
    Connection conn;
    
    /**
       *Este metodo sirve para abrir una conexion con Sql Server.
       * @return
       * @throws Exception
    */
    
    public Connection open() throws Exception{
            //Establecemos el Nombre de usuario:
            userName = "sa";
            //Establecemos el Password:
            password = "Eco41910894";
            //Establecemos la URL de conexion:
            url = "jdbc:sqlserver://127.0.0.1:1434; databaseName=JugueteriaWonka";
            
            //Registramos el driver JDBC de Microsoft SQL Server
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, userName, password);
            
            return conn;
    }
    
    public void close(){
        if(conn == null){
            return;
        }
        try{
            conn.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            conn = null;
        }
    }
}
