package org.jwonkafx.core;
import java.sql.CallableStatement;
import org.jwonkafx.db.ConexionSQLServer;
import org.jwonkafx.model.DetalleVenta;
import org.jwonkafx.model.FormadePago;
import org.jwonkafx.model.Venta;
public class ControladorVenta
{
    public void InsertV(Venta v, DetalleVenta dv) throws Exception
    {
        FormadePago fp = new FormadePago();
        /*                                  1  2*/
        String sql = "{call pa_insFormaPago(?, ?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt= connSQLServer.abrir().prepareCall(sql);
        cstmt.setString(1, v.getFP().getDescripcion());
        cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
        cstmt.executeUpdate();
        fp.setIdFormadePago(cstmt.getInt(2));
        v.setFP(fp);
        cstmt.close();
        connSQLServer.cerrar();
        /*                             1  2  3  4  5*/
        String sq = "{call pa_insVenta(?, ?, ?, ?, ?)}";
        ConexionSQLServer connSQLServe = new ConexionSQLServer();
        CallableStatement cstm= connSQLServe.abrir().prepareCall(sq);
        cstm.setString(1, v.getFecha());
        cstm.setInt(2, v.getEmpleado().getIdEmpleado());
        cstm.setInt(3, v.getCliente().getId());
        cstm.setInt(4, v.getFP().getIdFormadePago());
        cstm.registerOutParameter(5, java.sql.Types.INTEGER);
        cstm.executeUpdate();
        v.setIdVenta(cstm.getInt(5));
        cstm.close();
        connSQLServe.cerrar();
        /*                                   1  2  3  4*/
        String s = "{call pa_insVentaDetalle(?, ?, ?, ?)}";
        ConexionSQLServer connSQLServ = new ConexionSQLServer();
        CallableStatement cst= connSQLServ.abrir().prepareCall(s);
        cst.setInt(1, dv.getCantidadProducto());
        cst.setInt(2, dv.getPrecio());
        cst.setInt(3, v.getIdVenta());
        cst.setInt(4, dv.getProducto().getIdProducto());
        cst.close();
        connSQLServ.cerrar();
    }
}