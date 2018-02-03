package inca.jesus.alianza17.Clases;

/**
 * Created by Jesus on 24/07/2017.
 */

public class Eventos_Camp {
    int id;
    String Nombre_Evento;
    String F_inicio;
    String F_final;

    String Creador;
    String Equipo_asignado;
    String F_creacion;
    String foto;
    int Select;

    public Eventos_Camp(int id, String nombre_Evento, String f_inicio, String f_final, String creador, String equipo_asignado, String f_creacion,String foto, int select) {
        this.id = id;
        Nombre_Evento = nombre_Evento;
        F_inicio = f_inicio;
        F_final = f_final;
        Creador = creador;
        Equipo_asignado = equipo_asignado;
        F_creacion = f_creacion;
        this.foto=foto;
        Select = select;
    }

    public Eventos_Camp(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_Evento() {
        return Nombre_Evento;
    }

    public void setNombre_Evento(String nombre_Evento) {
        Nombre_Evento = nombre_Evento;
    }

    public String getF_inicio() {
        return F_inicio;
    }

    public void setF_inicio(String f_inicio) {
        F_inicio = f_inicio;
    }

    public String getF_final() {
        return F_final;
    }

    public void setF_final(String f_final) {
        F_final = f_final;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCreador() {
        return Creador;
    }

    public void setCreador(String creador) {
        Creador = creador;
    }

    public String getEquipo_asignado() {
        return Equipo_asignado;
    }

    public void setEquipo_asignado(String equipo_asignado) {
        Equipo_asignado = equipo_asignado;
    }

    public String getF_creacion() {
        return F_creacion;
    }

    public void setF_creacion(String f_creacion) {
        F_creacion = f_creacion;
    }

    public int getSelect() {
        return Select;
    }

    public void setSelect(int select) {
        Select = select;
    }
}


