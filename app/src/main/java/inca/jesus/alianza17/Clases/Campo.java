package inca.jesus.alianza17.Clases;


import java.util.ArrayList;
import java.util.List;

public class Campo {
    int cod;
    String dato;
    int cant;

    public static final List<Campo> LISTACAMPO=new ArrayList<Campo>();

    public Campo(int cod, String dato,int cant) {
        this.cod = cod;
        this.dato = dato;
        this.cant=cant;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
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
}
