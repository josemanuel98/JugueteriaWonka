package org.jwonkafx.model;
public class Venta
{
    private int IdVenta;
    private String Fecha;
    private Empleado Empleado;
    private Cliente Cliente;
    private FormadePago FP;
    public int getIdVenta()
    {
        return IdVenta;
    }
    public void setIdVenta(int IdVenta)
    {
        this.IdVenta = IdVenta;
    }
    public String getFecha()
    {
        return Fecha;
    }
    public void setFecha(String Fecha)
    {
        this.Fecha = Fecha;
    }
    public Empleado getEmpleado()
    {
        return Empleado;
    }
    public void setEmpleado(Empleado Empleado)
    {
        this.Empleado = Empleado;
    }
    public Cliente getCliente()
    {
        return Cliente;
    }
    public void setCliente(Cliente Cliente)
    {
        this.Cliente = Cliente;
    }
    public FormadePago getFP()
    {
        return FP;
    }
    public void setFP(FormadePago FP)
    {
        this.FP = FP;
    }
}