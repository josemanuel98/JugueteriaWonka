package org.jwonkafx.core;
import java.sql.CallableStatement;
import org.jwonkafx.db.ConexionSQLServer;
import org.jwonkafx.model.DetalleVenta;
import org.jwonkafx.model.Venta;
public class ControladorVenta
{
    public void InsertV(Venta v, DetalleVenta dv) throws Exception
    {
        /*                              1  2  3  4  5  7  8  9  10 11*/
        String sql = "{call pa_insVenta(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt= connSQLServer.abrir().prepareCall(sql);
        cstmt.setString(1, v.getFP().getDescripcion());
        cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
        v.getFP().setIdFormadePago(cstmt.getInt(2));
        cstmt.setInt(3, v.getFP().getIdFormadePago());
        cstmt.setString(4, v.getFecha());
        cstmt.setInt(5, v.getEmpleado().getIdEmpleado());
        cstmt.setInt(6, v.getCliente().getId());
        cstmt.registerOutParameter(7, java.sql.Types.INTEGER);
        v.setIdVenta(cstmt.getInt(7));
        cstmt.setInt(8, dv.getCantidadProducto());
        cstmt.setInt(9, dv.getPrecio());
        cstmt.setInt(10, dv.getVenta().getIdVenta());
        cstmt.setInt(11, dv.getProducto().getIdProducto());
        cstmt.close();
        connSQLServer.cerrar();
    }
}