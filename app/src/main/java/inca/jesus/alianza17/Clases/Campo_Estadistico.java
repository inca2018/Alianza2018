package inca.jesus.alianza17.Clases;


import java.util.ArrayList;
import java.util.List;

public class Campo_Estadistico {
    int cod;
    String dato;
    int jugador;
    int opcion;
    int ubicacion;
    int ss;

    public static final List<Campo_Estadistico> LISTACAMPO=new ArrayList<Campo_Estadistico>();
    public static  int COD_EVENTO=0,COD_EQUIPO_SE=0,COD_FECHA=0;

    public Campo_Estadistico(){
    }
    public Campo_Estadistico(int cod, String dato, int jugador, int opcion, int ubicacion, int ss) {
        this.cod = cod;
        this.dato = dato;
        this.jugador = jugador;
        this.opcion = opcion;
        this.ubicacion = ubicacion;
        this.ss = ss;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }
}
