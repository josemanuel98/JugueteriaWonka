package org.jwonkafx.model;
public class Usuario
{
    private int idUsuario;
    private String password;
    private String userName;
    private int activo;
    public int getIdUsuario()
    {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario)
    {
        this.idUsuario = idUsuario;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public int getActivo()
    {
        return activo;
    }
    public void setActivo(int activo)
    {
        this.activo = activo;
    }    
}
