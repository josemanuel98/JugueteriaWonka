package org.jwonkafx.core;
import java.sql.CallableStatement;
import org.jwonkafx.db.ConexionSQLServer;
import org.jwonkafx.model.Bitacora;
public class ControladorCompra
{
    public void Insert(Bitacora b) throws Exception
    {
        /*                              1  2  3  4  5  7  8  9  10 11*/
        String sql = "{call pa_insVenta(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt= connSQLServer.abrir().prepareCall(sql);
        cstmt.setString(1, b.getFechaAbastecimiento());
        cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
        b.setIdBitacora(cstmt.getInt(2));
        cstmt.setInt(3, b.getCantidad());
        cstmt.setInt(4, b.getPrecioCompra());
        cstmt.setInt(5, b.getProducto().getIdProducto());
        cstmt.close();
        connSQLServer.cerrar();
    }
}
