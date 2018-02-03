package inca.jesus.alianza17.Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus on 26/12/2016.
 */

public class Eventos {

    private int id_evento;
    private String titulo_evento;

    private String f_creacion;
    private String f_ejecucion;
    private int status;
    private String usuario;

   public Eventos(){
    }
    public Eventos(int id_evento, String titulo_evento, String f_creacion, String f_ejecucion,int status, String usuario) {
        this.id_evento = id_evento;
        this.titulo_evento = titulo_evento;

        this.f_creacion = f_creacion;
        this.f_ejecucion = f_ejecucion;
        this.status=status;
        this.usuario = usuario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getTitulo_evento() {
        return titulo_evento;
    }

    public void setTitulo_evento(String titulo_evento) {
        this.titulo_evento = titulo_evento;
    }



    public String getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(String f_creacion) {
        this.f_creacion = f_creacion;
    }

    public String getF_ejecucion() {
        return f_ejecucion;
    }

    public void setF_ejecucion(String f_ejecucion) {
        this.f_ejecucion = f_ejecucion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
