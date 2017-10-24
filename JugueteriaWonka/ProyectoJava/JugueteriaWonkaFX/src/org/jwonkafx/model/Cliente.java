package org.jwonkafx.model;
public class Cliente 
{
    private int id;
    private String email;
    private String telefono;
    private int activo;
    private Persona persona;
    public Cliente()
    {
        persona=new Persona();
    }
    public int getId() {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getTelefono()
    {
        return telefono;
    }
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }
    public int getActivo()
    {
        return activo;
    }
    public void setActivo(int activo)
    {
        this.activo = activo;
    }
    public Persona getPersona()
    {
        return persona;
    }
    public void setPersona(Persona persona)
    {
        this.persona = persona;
    }    
}
