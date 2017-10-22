package org.jwonkafx.core;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jwonkafx.db.ConexionSQLServer;
import org.jwonkafx.model.Marca;
import org.jwonkafx.model.Producto;
public class ControladorProducto
{
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
            p.setNombre(rs.getString("Nombre"));
            p.setEdadMinima(rs.getInt("EdadMinima"));
            p.setEdadMaxima(rs.getInt("EdadMaxima"));
            p.setDescripcion(rs.getString("Descripcion"));
            p.setPrecio(rs.getInt("Precio"));
            p.setStock(rs.getInt("Stock"));
            m = new Marca();
            m.setNombre(rs.getString("Nombre"));
            p.setMarca(m);
            productos.add(p);
        }
        rs.close();
        pstmt.close();
        return productos;
    }
}
