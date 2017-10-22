package org.jwonkafx.model;
public class Bitacora
{
    private int IdBitacora;
    private String FechaAbastecimiento;
    private int IdDetalleBitacora;
    private int Cantidad;
    private int PrecioCompra;
    private Producto Producto;
    public int getIdBitacora()
    {
        return IdBitacora;
    }
    public void setIdBitacora(int IdBitacora)
    {
        this.IdBitacora = IdBitacora;
    }
    public String getFechaAbastecimiento()
    {
        return FechaAbastecimiento;
    }
    public void setFechaAbastecimiento(String FechaAbastecimiento)
    {
        this.FechaAbastecimiento = FechaAbastecimiento;
    }
    public int getIdDetalleBitacora()
    {
        return IdDetalleBitacora;
    }
    public void setIdDetalleBitacora(int IdDetalleBitacora)
    {
        this.IdDetalleBitacora = IdDetalleBitacora;
    }
    public int getCantidad()
    {
        return Cantidad;
    }
    public void setCantidad(int Cantidad)
    {
        this.Cantidad = Cantidad;
    }
    public int getPrecioCompra()
    {
        return PrecioCompra;
    }
    public void setPrecioCompra(int PrecioCompra)
    {
        this.PrecioCompra = PrecioCompra;
    }
    public Producto getProducto()
    {
        return Producto;
    }
    public void setProducto(Producto Producto)
    {
        this.Producto = Producto;
    }
}
