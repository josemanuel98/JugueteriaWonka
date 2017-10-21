/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.core;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jwonkafx.db.ConexionSqlServer;
import org.jwonkafx.model.Cliente;
import org.jwonkafx.model.Persona;

/**
 *
 * @author Josem
 */
public class ClienteController {
    public void add(Cliente cliente) throws Exception {
        //Se define la consulta que invoca al procedimiento almacenado
        String sql = "{ CALL uspInsertarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        //Instanciamos un obj de conexion con SQL Server
        ConexionSqlServer conn = new ConexionSqlServer();
        
        try(
            //Abrimos la conexion con SQL Server y generamos un objeto para invocar al procedimiento almacenado
            CallableStatement cstmt = conn.open().prepareCall(sql);){
            //Se establecen los valores de los parametros
            cstmt.setString(1, cliente.getPersona().getNombre());
            cstmt.setString(2, cliente.getPersona().getPaterno());
            cstmt.setString(3, cliente.getPersona().getMaterno());
            cstmt.setString(4, cliente.getPersona().getGenero());
            cstmt.setString(5, cliente.getPersona().getRfc());
            cstmt.setString(6, cliente.getPersona().getCurp());
            cstmt.setString(7, cliente.getPersona().getFechaNacimiento());
            cstmt.setString(8, cliente.getPersona().getCodigoPostal());
            cstmt.setString(9, cliente.getPersona().getFotografia());
            cstmt.setString(10, cliente.getPersona().getDomicilio());
            cstmt.setString(11, cliente.getEmail());
            cstmt.setString(12, cliente.getTelefono());
        
            //Registramos los parametros de salida
            cstmt.registerOutParameter(13, java.sql.Types.INTEGER);
            cstmt.registerOutParameter(14, java.sql.Types.INTEGER);
        
            //Se ejecuta la sentencia
            cstmt.executeUpdate();
        
            //Se obtienen los ID´s generados y los guardamos en el objeto cliente
            cliente.getPersona().setIdPersona(cstmt.getInt(13));
            cliente.setIdCliente(cstmt.getInt(14));
        
            //Se cierra la conexion
            cstmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
    
    public void update(Cliente cliente) throws Exception {
        //Se define la consulta que invoca al procedimiento almacenado
        String sql = "{CALL uspActualizarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        //Instanciamos un obj de conexion con SQL Server
        ConexionSqlServer conn = new ConexionSqlServer();
        
        //Abrimos la conexion con SQL Server y generamos un objeto para invocar al procedimiento almacenado
        
        CallableStatement cstmt = conn.open().prepareCall(sql);
        
        //Se establecen los valores de los parametros
        cstmt.setString(1, cliente.getPersona().getNombre());
        cstmt.setString(2, cliente.getPersona().getPaterno());
        cstmt.setString(3, cliente.getPersona().getMaterno());
        cstmt.setString(4, cliente.getPersona().getGenero());
        cstmt.setString(5, cliente.getPersona().getRfc());
        cstmt.setString(6, cliente.getPersona().getCurp());
        cstmt.setString(7, cliente.getPersona().getFechaNacimiento());
        cstmt.setString(8, cliente.getPersona().getCodigoPostal());
        cstmt.setString(9, cliente.getPersona().getFotografia());
        cstmt.setString(10, cliente.getPersona().getDomicilio());
        cstmt.setString(11, cliente.getEmail());
        cstmt.setString(12, cliente.getTelefono());
        cstmt.setInt(13, cliente.getPersona().getIdPersona());
        cstmt.setInt(14, cliente.getIdCliente());
        cstmt.setInt(15, cliente.getActivo());
        
        //Se ejecuta la sentencia
        cstmt.executeUpdate();
        
        //Se cierra la conexion
        cstmt.close();
        conn.close();
    }
    
    public void delete(int idCliente) throws Exception {
        //Se define la consulta que invoca al procedimiento almacenado
        String sql = "{ CALL uspEliminarCliente(?) }";
        //Instanciamos un obj de conexion con SQL Server
        ConexionSqlServer conn = new ConexionSqlServer();
        
        //Abrimos la conexion con SQL Server y generamos un objeto para invocar al procedimiento almacenado
        
        CallableStatement cstmt = conn.open().prepareCall(sql);
        
        //Se establecen los valores de los parametros
        cstmt.setInt(1, idCliente);
        
        //Se ejecuta la sentencia
        cstmt.executeUpdate();
        
        //Se cierra la conexion
        cstmt.close();
        conn.close();
    }
    
    public ObservableList<Cliente> getAll(String filter) throws Exception {
        String sql = "SELECT * FROM V_Cliente";
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
        Cliente cliente;
        Persona persona = null;
        
        //Instanciamos un obj de conexxion con SQL Server
        ConexionSqlServer conn = new ConexionSqlServer();
        
        //Abrimos la conexion con SQL Server y generamos un objeto para ejecutar la consulta
        PreparedStatement pstmt = conn.open().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            cliente  = new Cliente();
            cliente.setPersona(new Persona(
                    rs.getString("Nombre"), rs.getString("ApellidoPaterno"), rs.getString("ApellidoMaterno"), rs.getInt("IdPersona"),
                    rs.getString("Genero"), rs.getString("Rfc"), rs.getString("Curp"), rs.getString("Cp"), rs.getString("Fotografia"),
                    rs.getString("Domicilio"), rs.getString("FechaNacimientol")
            ));

            cliente.setIdCliente(rs.getInt("IdCliente"));
            cliente.setTelefono(rs.getString("Telefono"));
            cliente.setEmail(rs.getString("Email"));
            cliente.setActivo(rs.getInt("Activo"));
            
            
            clientes.add(cliente);
        }
        
        return clientes;
    }
}
