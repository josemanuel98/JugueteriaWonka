package org.jwonkafx.model;
public class Persona 
{
    private int idPersona;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String genero; 
    private String rfc;
    private String curp; 
    private String fechaNacimiento;
    private String cp;
    private String fotografia;		
    private String domicilio; 
    public int getIdPersona()
    {
        return idPersona;
    }
    public void setIdPersona(int idPersona)
    {
        this.idPersona = idPersona;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getApellidoPaterno() 
    {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno)
    {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno()
    {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno)
    {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getGenero()
    {
        return genero;
    }
    public void setGenero(String genero)
    {
        this.genero = genero;
    }
    public String getRfc()
    {
        return rfc;
    }
    public void setRfc(String rfc)
    {
        this.rfc = rfc;
    }
    public String getCurp()
    {
        return curp;
    }
    public void setCurp(String curp)
    {
        this.curp = curp;
    }
    public String getFechaNacimiento()
    {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getCp()
    {
        return cp;
    }
    public void setCp(String cp)
    {
        this.cp = cp;
    }
    public String getFotografia()
    {
        return fotografia;
    }
    public void setFotografia(String fotografia)
    {
        this.fotografia = fotografia;
    }
    public String getDomicilio()
    {
        return domicilio;
    }
    public void setDomicilio(String domicilio)
    {
        this.domicilio = domicilio;
    }
}