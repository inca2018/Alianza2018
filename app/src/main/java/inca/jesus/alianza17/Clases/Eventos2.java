package inca.jesus.alianza17.Clases;

/**
 * Created by Jesus on 26/12/2016.
 */

public class Eventos2 {

    private int id_evento;
    private String titulo_evento;
    private String canti_postulante;
    private String f_creacion;
    private String f_ejecucion;
    private int status;
    private int ss;
    private String usuario;

   public Eventos2(){
    }

    public Eventos2(int id_evento, String titulo_evento, String canti_postulante, String f_creacion, String f_ejecucion, int status, int ss, String usuario) {
        this.id_evento = id_evento;
        this.titulo_evento = titulo_evento;
        this.canti_postulante = canti_postulante;
        this.f_creacion = f_creacion;
        this.f_ejecucion = f_ejecucion;
        this.status = status;
        this.ss = ss;
        this.usuario = usuario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
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

    public String getCanti_postulante() {
        return canti_postulante;
    }

    public void setCanti_postulante(String canti_postulante) {
        this.canti_postulante = canti_postulante;
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
