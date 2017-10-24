package org.jwonkafx.core;
import java.sql.CallableStatement;
import org.jwonkafx.db.ConexionSQLServer;
import org.jwonkafx.model.Bitacora;
public class ControladorCompra
{
    public void Insert(Bitacora b) throws Exception
    {
        /*                                  1  2*/
        String sql = "{call pa_insBitacora (?, ?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        cstmt.setString(1, b.getFechaAbastecimiento());
        cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
        cstmt.executeUpdate();
        b.setIdBitacora(cstmt.getInt(2));
        cstmt.close();
        connSQLServer.cerrar();
        /*                                       1  2  3  4*/
        String sq = "{call pa_insBitacoraDetalle(?, ?, ?, ?)}";
        ConexionSQLServer connSQLServe = new ConexionSQLServer();
        CallableStatement cstm= connSQLServe.abrir().prepareCall(sq);
        cstm.setInt(1, b.getCantidad());
        cstm.setInt(2, b.getPrecioCompra());
        cstm.setInt(4, b.getIdBitacora());
        cstm.setInt(4, b.getProducto().getIdProducto());
        cstm.close();
        connSQLServer.cerrar();
    }
}
