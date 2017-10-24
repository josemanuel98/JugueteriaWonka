package org.jwonkafx.core;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jwonkafx.db.ConexionSQLServer;
import org.jwonkafx.model.Cliente;
import org.jwonkafx.model.Persona;
public class ControladorCliente 
{
    public void Insert(Cliente c) throws Exception
    {
        String sql = "{call pa_insCliente(?, ?, ?, ?, " +
                                              "?, ?, ?, ?, " +
                                              "?, ?, ?, ?, " +
                                              "?, ?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt= connSQLServer.abrir().prepareCall(sql);
        cstmt.setString(1, c.getPersona().getNombre());
        cstmt.setString(2, c.getPersona().getApellidoPaterno());
        cstmt.setString(3, c.getPersona().getApellidoMaterno());
        cstmt.setString(4, c.getPersona().getGenero());
        cstmt.setString(5, c.getPersona().getRfc());
        cstmt.setString(6, c.getPersona().getCurp());
        cstmt.setString(7, c.getPersona().getFechaNacimiento());
        cstmt.setString(8, c.getPersona().getCp());
        cstmt.setString(10, c.getPersona().getFotografia());
        cstmt.setString(9, c.getPersona().getDomicilio());
        cstmt.setString(11, c.getEmail());
        cstmt.setString(12, c.getTelefono());
        cstmt.registerOutParameter(13,java.sql.Types.INTEGER);
        cstmt.registerOutParameter(14,java.sql.Types.INTEGER);
        cstmt.executeUpdate();
        c.getPersona().setIdPersona(cstmt.getInt(13));
        c.setId(cstmt.getInt(14));
        cstmt.close();
        connSQLServer.cerrar();
    }
    public void Update(Cliente c) throws Exception
    {
        String sql = "{call pa_actCliente (?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        cstmt.setInt(1, c.getPersona().getIdPersona());
        cstmt.setString(2, c.getPersona().getNombre());
        cstmt.setString(3, c.getPersona().getApellidoPaterno());
        cstmt.setString(4, c.getPersona().getApellidoMaterno());
        cstmt.setString(5, c.getPersona().getGenero());
        cstmt.setString(6, c.getPersona().getRfc());
        cstmt.setString(7, c.getPersona().getCurp());
        cstmt.setString(8, c.getPersona().getFechaNacimiento());
        cstmt.setString(9, c.getPersona().getCp());
        cstmt.setString(10, c.getPersona().getDomicilio());
        cstmt.setString(11, c.getPersona().getFotografia());
        cstmt.setString(12, c.getEmail());
        cstmt.setString(13, c.getTelefono());
        cstmt.executeUpdate();
        cstmt.close();
        connSQLServer.cerrar();   
    }
    public void Delete(int idCliente) throws Exception
    {
        String sql = "{call pa_delCliente (?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        cstmt.setInt(1, idCliente);
        cstmt.executeUpdate();
        cstmt.close();
        connSQLServer.cerrar();
    }
    public ObservableList<Cliente> getAll(String filtro) throws Exception
    {
        String sql = "SELECT * FROM V_Cliente";
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
        Cliente c = null;
        Persona p = null;
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        PreparedStatement pstmt = connSQLServer.abrir().prepareCall(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next())
        {
            p = new Persona();
            p.setApellidoMaterno(rs.getString("ApellidoMaterno"));
            p.setApellidoPaterno(rs.getString("ApellidoPaterno"));
            p.setCp(rs.getString("Cp"));
            p.setCurp(rs.getString("Curp"));
            p.setDomicilio(rs.getString("Domicilio"));
            p.setFechaNacimiento(rs.getString("FechaNacimiento"));
            p.setFotografia(rs.getString("Fotografia"));
            p.setGenero(rs.getString("Genero"));
            p.setIdPersona(rs.getInt("IdPersona"));
            p.setNombre(rs.getString("Nombre"));
            p.setRfc(rs.getString("Rfc"));
            c = new Cliente();
            c.setActivo(rs.getInt("Activo"));
            c.setEmail(rs.getString("Email"));
            c.setId(rs.getInt("IdCliente"));
            c.setPersona(p);
            c.setTelefono(rs.getString("Telefono"));
            clientes.add(c);
        }
        rs.close();
        pstmt.close();
        return clientes;
    }
}