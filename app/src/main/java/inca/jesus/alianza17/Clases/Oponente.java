package inca.jesus.alianza17.Clases;

/**
 * Created by Jesus on 24/07/2017.
 */

public class Oponente {

    int id;
    String Nombres;
    String Distrito;
    int Select;
    int creador;
    String F_creacion;

    public Oponente(int id, String nombres, String distrito, int select, int creador, String f_creacion) {
        this.id = id;
        Nombres = nombres;
        Distrito = distrito;
        Select = select;
        this.creador = creador;
        F_creacion = f_creacion;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        Distrito = distrito;
    }

    public int getSelect() {
        return Select;
    }

    public void setSelect(int select) {
        Select = select;
    }

    public int getCreador() {
        return creador;
    }

    public void setCreador(int creador) {
        this.creador = creador;
    }

    public String getF_creacion() {
        return F_creacion;
    }

    public void setF_creacion(String f_creacion) {
        F_creacion = f_creacion;
    }

}
