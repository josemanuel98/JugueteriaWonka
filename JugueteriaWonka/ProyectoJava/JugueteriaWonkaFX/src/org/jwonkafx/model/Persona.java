/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.model;

/**
 *
 * @author Josem
 */
public class Persona {

    public Persona(String nombre, String paterno, String materno, int id, String genero, String rfc, String curp, String cp, String foto, String domicilio, String fechaNacimiento) {
        this.Nombre = nombre;
        this.Paterno = paterno;
        this.Materno = materno;
        this.CodigoPostal = cp;
        this.Domicilio = domicilio;
        this.FechaNacimiento = fechaNacimiento;
        this.Fotografia = foto;
        this.Genero = genero;
        this.IdPersona = id;
        this.Rfc = rfc;
        this.Curp = curp;
    }
    
    public Persona(String nombre, String paterno, String materno, String genero, String rfc, String curp, String cp, String foto, String domicilio, String fechaNacimiento) {
        this.Nombre = nombre;
        this.Paterno = paterno;
        this.Materno = materno;
        this.CodigoPostal = cp;
        this.Domicilio = domicilio;
        this.FechaNacimiento = fechaNacimiento;
        this.Fotografia = foto;
        this.Genero = genero;
        this.Rfc = rfc;
        this.Curp = curp;
    }
    
    public Persona(){
        
    }

    /**
     * @return the Materno
     */
    public String getMaterno() {
        return Materno;
    }

    /**
     * @param Materno the Materno to set
     */
    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    /**
     * @return the Activo
     */
    public int getActivo() {
        return Activo;
    }

    /**
     * @param Activo the Activo to set
     */
    public void setActivo(int Activo) {
        this.Activo = Activo;
    }

    /**
     * @return the IdPersona
     */
    public int getIdPersona() {
        return IdPersona;
    }

    /**
     * @param IdPersona the IdPersona to set
     */
    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Paterno
     */
    public String getPaterno() {
        return Paterno;
    }

    /**
     * @param Paterno the Paterno to set
     */
    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    /**
     * @return the Genero
     */
    public String getGenero() {
        return Genero;
    }

    /**
     * @param Genero the Genero to set
     */
    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    /**
     * @return the Rfc
     */
    public String getRfc() {
        return Rfc;
    }

    /**
     * @param Rfc the Rfc to set
     */
    public void setRfc(String Rfc) {
        this.Rfc = Rfc;
    }

    /**
     * @return the Curp
     */
    public String getCurp() {
        return Curp;
    }

    /**
     * @param Curp the Curp to set
     */
    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    /**
     * @return the FechaNacimiento
     */
    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    /**
     * @param FechaNacimiento the FechaNacimiento to set
     */
    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    /**
     * @return the CodigoPostal
     */
    public String getCodigoPostal() {
        return CodigoPostal;
    }

    /**
     * @param CodigoPostal the CodigoPostal to set
     */
    public void setCodigoPostal(String CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    /**
     * @return the Fotografia
     */
    public String getFotografia() {
        return Fotografia;
    }

    /**
     * @param Fotografia the Fotografia to set
     */
    public void setFotografia(String Fotografia) {
        this.Fotografia = Fotografia;
    }

    /**
     * @return the Domicilio
     */
    public String getDomicilio() {
        return Domicilio;
    }

    /**
     * @param Domicilio the Domicilio to set
     */
    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }
    private int IdPersona;
    private String Nombre;
    private String Paterno;
    private String Materno;
    private String Genero;
    private String Rfc;
    private String Curp;
    private String FechaNacimiento;
    private String CodigoPostal;
    private String Fotografia;
    private String Domicilio;
    private int Activo;
}
