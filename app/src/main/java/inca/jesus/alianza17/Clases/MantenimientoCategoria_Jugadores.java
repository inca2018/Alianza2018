package inca.jesus.alianza17.Clases;

import java.util.ArrayList;
import java.util.List;


public class MantenimientoCategoria_Jugadores {
    public int id;
    public int id_categoria;
    public int id_jugadores;
    public String F_creacion;
    public int id_usuario;

    public static final List<MantenimientoCategoria_Jugadores> LISTA_ENLACE=new ArrayList<>();
    public MantenimientoCategoria_Jugadores(int id, int id_categoria, int id_jugadores, String f_creacion, int id_usuario) {
        this.id = id;
        this.id_categoria = id_categoria;
        this.id_jugadores = id_jugadores;
        F_creacion = f_creacion;
        this.id_usuario = id_usuario;
    }
    public MantenimientoCategoria_Jugadores(){

   }


    static{
        LISTA_ENLACE.add(new MantenimientoCategoria_Jugadores(1,1,1,"18/05/2017",1));
        LISTA_ENLACE.add(new MantenimientoCategoria_Jugadores(2,1,2,"18/05/2017",1));
        LISTA_ENLACE.add(new MantenimientoCategoria_Jugadores(3,2,3,"18/05/2017",1));
        LISTA_ENLACE.add(new MantenimientoCategoria_Jugadores(4,2,4,"18/05/2017",1));
        LISTA_ENLACE.add(new MantenimientoCategoria_Jugadores(5,3,5,"18/05/2017",1));
        LISTA_ENLACE.add(new MantenimientoCategoria_Jugadores(6,3,6,"18/05/2017",1));
        LISTA_ENLACE.add(new MantenimientoCategoria_Jugadores(7,4,7,"18/05/2017",1));
        LISTA_ENLACE.add(new MantenimientoCategoria_Jugadores(8,4,8,"18/05/2017",1));
        LISTA_ENLACE.add(new MantenimientoCategoria_Jugadores(9,5,9,"18/05/2017",1));
        LISTA_ENLACE.add(new MantenimientoCategoria_Jugadores(10,5,10,"18/05/2017",1));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_jugadores() {
        return id_jugadores;
    }

    public void setId_jugadores(int id_jugadores) {
        this.id_jugadores = id_jugadores;
    }

    public String getF_creacion() {
        return F_creacion;
    }

    public void setF_creacion(String f_creacion) {
        F_creacion = f_creacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
