package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes.utils;

public class Usuario {

    private String codigo;
    private String correo;
    private String contrasena;
    public Usuario(){}

    public Usuario(String codigo,String correo, String contra1){
        this.codigo=codigo;
        this.correo=correo;
        this.contrasena=contra1;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra1() {
        return contrasena;
    }

    public void setContra1(String contra1) {
        this.contrasena = contra1;
    }
}
