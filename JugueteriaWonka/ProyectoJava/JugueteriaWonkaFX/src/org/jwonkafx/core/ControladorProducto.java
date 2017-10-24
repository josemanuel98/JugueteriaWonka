package org.jwonkafx.core;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jwonkafx.db.ConexionSQLServer;
import org.jwonkafx.model.Marca;
import org.jwonkafx.model.Producto;
public class ControladorProducto
{
    public void Insert(Producto p) throws Exception
    {
        Marca m = new Marca();
        /*                              1  2*/
        String sql = "{call pa_insMarca(?, ?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        cstmt.setString(1, p.getMarca().getNombre());
        cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
        cstmt.executeUpdate();
        m.setIdMarca(cstmt.getInt(2));
        p.setMarca(m);
        cstmt.close();
        connSQLServer.cerrar();
        /*                                1  2  3  4  5  6  7  8  9*/
        String sq = "{call pa_insProducto(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        ConexionSQLServer connSQLServe = new ConexionSQLServer();
        CallableStatement cstm= connSQLServe.abrir().prepareCall(sq);
        cstm.setString(1, p.getNombre());
        cstm.setInt(2, p.getEdadMinima());
        cstm.setInt(3, p.getEdadMaxima());
        cstm.setString(4, p.getDescripcion());
        cstm.setFloat(5, p.getPrecio());
        cstm.setInt(6, p.getStock());
        cstm.setString(7, p.getFotografia());
        cstm.setInt(8, p.getActivo());
        cstm.setInt(9, p.getMarca().getIdMarca());
        cstm.executeUpdate();
        cstm.close();
        connSQLServe.cerrar();
    }
    public void Update(Producto p) throws Exception
    {
        /*                              1  2*/
        String sql = "{call pa_actMarca(?, ?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        cstmt.setString(1, p.getMarca().getNombre());
        cstmt.setInt(2, p.getMarca().getIdMarca());
        cstmt.executeUpdate();
        cstmt.close();
        connSQLServer.cerrar();
        /*                                1  2  3  4  5  6  7  8  9*/
        String sq = "{call pa_actProducto(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        ConexionSQLServer connSQLServe = new ConexionSQLServer();
        CallableStatement cstm= connSQLServe.abrir().prepareCall(sq);
        cstm.setString(1, p.getNombre());
        cstm.setInt(2, p.getEdadMinima());
        cstm.setInt(3, p.getEdadMaxima());
        cstm.setString(4, p.getDescripcion());
        cstm.setFloat(5, p.getPrecio());
        cstm.setInt(6, p.getStock());
        cstm.setString(7, p.getFotografia());
        cstm.setInt(8, p.getActivo());
        cstm.setInt(9, p.getIdProducto());
        cstm.executeUpdate();
        cstm.close();
        connSQLServe.cerrar();
    }
    public void Delete(Producto p) throws Exception
    {
        String sql = "{call pa_delProducto(?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        cstmt.setInt(1, p.getIdProducto());
        cstmt.executeUpdate();
        cstmt.close();
        connSQLServer.cerrar();
    }
    public ObservableList<Producto> getAll(String filtro) throws Exception
    {
        String sql = "SELECT * FROM V_Producto";
        ObservableList<Producto> productos = FXCollections.observableArrayList();
        Producto p = null;
        Marca m = null;
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        PreparedStatement pstmt = connSQLServer.abrir().prepareCall(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next())
        {
            p = new Producto();
            p.setIdProducto(rs.getInt("IdProducto"));
            p.setNombre(rs.getString("Nombre"));
            p.setEdadMinima(rs.getInt("EdadMinima"));
            p.setEdadMaxima(rs.getInt("EdadMaxima"));
            p.setDescripcion(rs.getString("Descripcion"));
            p.setPrecio(rs.getInt("Precio"));
            p.setStock(rs.getInt("Stock"));
            m = new Marca();
            m.setIdMarca(rs.getInt("IdMarca"));
            m.setNombre(rs.getString("NombreM"));
            p.setMarca(m);
            productos.add(p);
        }
        rs.close();
        pstmt.close();
        return productos;
    }
    public ObservableList<Producto> getAl(Producto prod) throws Exception
    {
        Marca m = null;
        Producto p = null;
        ObservableList<Producto> productos = FXCollections.observableArrayList();
        String sql = "{call pa_busqProducto(?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        cstmt.setString(1, prod.getNombre());
        ResultSet rs = cstmt.executeQuery();
        while(rs.next())
        {
            p = new Producto();
            p.setIdProducto(rs.getInt("IdProducto"));
            p.setNombre(rs.getString("Nombre"));
            p.setEdadMinima(rs.getInt("EdadMinima"));
            p.setEdadMaxima(rs.getInt("EdadMaxima"));
            p.setDescripcion(rs.getString("Descripcion"));
            p.setPrecio(rs.getInt("Precio"));
            p.setStock(rs.getInt("Stock"));
            m = new Marca();
            m.setIdMarca(rs.getInt("IdMarca"));
            p.setMarca(m);
            productos.add(p);
        }
        rs.close();
        cstmt.close();
        return productos;
    }
}
