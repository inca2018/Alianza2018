package inca.jesus.alianza17.Clases;

/**
 * Created by Jesus on 24/07/2017.
 */

public class Fechas {

    int id;
    int id_evento;
    int num;
    int id_opo;
    String f_reali;
    String f_creacion;
    int select;
    int status;
    int creador;


    public static int COD_FECHA=0;
    public Fechas(int id,int id_evento, int num, int id_opo, String f_reali, String f_creacion, int select,int status, int creador) {
        this.id = id;
        this.id_evento=id_evento;
        this.num = num;
        this.id_opo = id_opo;
        this.f_reali = f_reali;
        this.f_creacion = f_creacion;
        this.select = select;
        this.status=status;
        this.creador = creador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getId_opo() {
        return id_opo;
    }

    public void setId_opo(int id_opo) {
        this.id_opo = id_opo;
    }

    public String getF_reali() {
        return f_reali;
    }

    public void setF_reali(String f_reali) {
        this.f_reali = f_reali;
    }

    public String getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(String f_creacion) {
        this.f_creacion = f_creacion;
    }

    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public int getCreador() {
        return creador;
    }

    public void setCreador(int creador) {
        this.creador = creador;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
