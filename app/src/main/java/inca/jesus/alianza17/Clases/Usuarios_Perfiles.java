package inca.jesus.alianza17.Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus on 07/07/2017.
 */

public class Usuarios_Perfiles {
    public int id;
    public String Nom_tipo;
    public int status;
    public String creacion;

    public static final List<Usuarios_Perfiles> LIST_TIPOS=new ArrayList<>();
    public Usuarios_Perfiles(int id, String nom_tipo, int status, String creacion) {
        this.id = id;
        this.Nom_tipo = nom_tipo;
        this.status=status;
        this.creacion=creacion;
    }
    public Usuarios_Perfiles(){

    }
    static {

        LIST_TIPOS.add(new Usuarios_Perfiles(1,"Administrador",0,"05:30 07/07/2017"));
        LIST_TIPOS.add(new Usuarios_Perfiles(2,"Scouter",0,"05:30 07/07/2017"));
        LIST_TIPOS.add(new Usuarios_Perfiles(3,"Entrenador",0,"05:30 07/07/2017"));
        LIST_TIPOS.add(new Usuarios_Perfiles(4,"Nutricionista",0,"05:30 07/07/2017"));
        LIST_TIPOS.add(new Usuarios_Perfiles(5,"Psicologo",0,"05:30 07/07/2017"));

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom_tipo() {
        return Nom_tipo;
    }
    public void setNom_tipo(String nom_tipo) {
        Nom_tipo = nom_tipo;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getCreacion() {
        return creacion;
    }
    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }
}
