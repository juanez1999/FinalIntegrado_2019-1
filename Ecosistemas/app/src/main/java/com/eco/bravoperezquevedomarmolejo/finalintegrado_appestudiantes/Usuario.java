package com.eco.bravoperezquevedomarmolejo.finalintegrado_appestudiantes;

public class Usuario {

    private String codigo;
    private String correo;
    private String contra1;
    private String contra2;

    public Usuario(){}

    public Usuario(String codigo,String correo, String contra1, String contra2){
        this.codigo=codigo;
        this.correo=correo;
        this.contra1=contra1;
        this.contra2=contra2;
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
        return contra1;
    }

    public void setContra1(String contra1) {
        this.contra1 = contra1;
    }

    public String getContra2() {
        return contra2;
    }

    public void setContra2(String contra2) {
        this.contra2 = contra2;
    }
}
