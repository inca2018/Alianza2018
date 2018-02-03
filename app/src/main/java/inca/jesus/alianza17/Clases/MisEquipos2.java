package inca.jesus.alianza17.Clases;

/**
 * Created by Jesus on 24/07/2017.
 */

public class MisEquipos2 {
    int id;
    String Nombre;
    int ss;
    String Fecha_Creacion;
    int creador;

    public MisEquipos2(int id, String nombre, int ss, String fecha_Creacion, int creador) {
        this.id = id;
        Nombre = nombre;
        this.ss = ss;
        Fecha_Creacion = fecha_Creacion;
        this.creador = creador;
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

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }

    public String getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(String fecha_Creacion) {
        Fecha_Creacion = fecha_Creacion;
    }

    public int getCreador() {
        return creador;
    }

    public void setCreador(int creador) {
        this.creador = creador;
    }
}
