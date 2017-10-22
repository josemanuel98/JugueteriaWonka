package org.jwonkafx.model;
public class DetalleVenta
{
    private int IdDetalleVenta;
    private int CantidadProducto;
    private int Precio;
    private Venta Venta;
    private Producto Producto;
    public int getIdDetalleVenta()
    {
        return IdDetalleVenta;
    }
    public void setIdDetalleVenta(int IdDetalleVenta)
    {
        this.IdDetalleVenta = IdDetalleVenta;
    }
    public int getCantidadProducto()
    {
        return CantidadProducto;
    }
    public void setCantidadProducto(int CantidadProducto)
    {
        this.CantidadProducto = CantidadProducto;
    }
    public int getPrecio()
    {
        return Precio;
    }
    public void setPrecio(int Precio)
    {
        this.Precio = Precio;
    }
    public Venta getVenta()
    {
        return Venta;
    }
    public void setVenta(Venta Venta)
    {
        this.Venta = Venta;
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
