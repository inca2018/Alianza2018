package inca.jesus.alianza17.Clases;

import java.util.ArrayList;
import java.util.List;


public class MantenimientoCategoria {
    public int id;
    public String Nombre;
    public int status;
    public String F_creacion;
    public String usuario;


    public MantenimientoCategoria(){
    }
    public MantenimientoCategoria(int id, String nombre, int status, String f_creacion, String usuario) {
        this.id = id;
        Nombre = nombre;
        this.status = status;
        F_creacion = f_creacion;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getF_creacion() {
        return F_creacion;
    }

    public void setF_creacion(String f_creacion) {
        F_creacion = f_creacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
