package org.jwonkafx.model;
public class Producto
{
    private int IdProducto;
    private String Nombre;
    private int EdadMinima;
    private int EdadMaxima;
    private String Descripcion;
    private int Precio;
    private int Stock;
    private String Fotografia;
    private int Activo;
    private Marca Marca;
    public int getIdProducto()
    {
        return IdProducto;
    }
    public void setIdProducto(int IdProducto)
    {
        this.IdProducto = IdProducto;
    }
    public String getNombre()
    {
        return Nombre;
    }
    public void setNombre(String Nombre)
    {
        this.Nombre = Nombre;
    }
    public int getEdadMinima()
    {
        return EdadMinima;
    }
    public void setEdadMinima(int EdadMinima)
    {
        this.EdadMinima = EdadMinima;
    }
    public int getEdadMaxima()
    {
        return EdadMaxima;
    }
    public void setEdadMaxima(int EdadMaxima)
    {
        this.EdadMaxima = EdadMaxima;
    }
    public String getDescripcion()
    {
        return Descripcion;
    }
    public void setDescripcion(String Descripcion)
    {
        this.Descripcion = Descripcion;
    }
    public int getPrecio()
    {
        return Precio;
    }
    public void setPrecio(int Precio)
    {
        this.Precio = Precio;
    }
    public int getStock()
    {
        return Stock;
    }
    public void setStock(int Stock)
    {
        this.Stock = Stock;
    }
    public String getFotografia()
    {
        return Fotografia;
    }
    public void setFotografia(String Fotografia)
    {
        this.Fotografia = Fotografia;
    }
    public int getActivo()
    {
        return Activo;
    }
    public void setActivo(int Activo)
    {
        this.Activo = Activo;
    }
    public Marca getMarca()
    {
        return Marca;
    }
    public void setMarca(Marca Marca)
    {
        this.Marca = Marca;
    }
}
