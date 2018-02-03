package inca.jesus.alianza17.Clases;

/**
 * Created by Jesus on 23/08/2017.
 */

public class Detalle {
    String nombre;
    int ptos;

    public Detalle(String nombre, int ptos) {
        this.nombre = nombre;
        this.ptos = ptos;
    }

    public Detalle(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPtos() {
        return ptos;
    }

    public void setPtos(int ptos) {
        this.ptos = ptos;
    }
}
