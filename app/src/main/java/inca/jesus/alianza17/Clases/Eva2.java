package inca.jesus.alianza17.Clases;

/**
 * Created by Jesus on 22/03/2017.
 */

public class Eva2 {
    int id;
    String competencia;
    String rival;
    int goles;
    int tiempo_jugado;
    int total_puntos;


    public Eva2(int id, String competencia, String rival, int goles, int tiempo_jugado, int total_puntos) {
        this.id = id;
        this.competencia = competencia;
        this.rival = rival;
        this.goles = goles;
        this.tiempo_jugado = tiempo_jugado;
        this.total_puntos = total_puntos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getRival() {
        return rival;
    }

    public void setRival(String rival) {
        this.rival = rival;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getTiempo_jugado() {
        return tiempo_jugado;
    }

    public void setTiempo_jugado(int tiempo_jugado) {
        this.tiempo_jugado = tiempo_jugado;
    }

    public int getTotal_puntos() {
        return total_puntos;
    }

    public void setTotal_puntos(int total_puntos) {
        this.total_puntos = total_puntos;
    }
}
