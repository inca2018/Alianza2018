package inca.jesus.alianza17.Clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus on 23/06/2017.
 */

public class MisEquipos implements Parcelable {

    public int Id;
    public String Nombre_Categoria;
    public List<JugadorMiEquipo> ListaJugadoresCateg;


    public static final List<JugadorMiEquipo> ListaTempEquipo=new ArrayList<JugadorMiEquipo>();
    public static final MisEquipos MiEquipoTemp=new MisEquipos();



    public static final List<MisEquipos> ListaMisEquipo=new ArrayList<MisEquipos>();

    public MisEquipos(){

    }
    public MisEquipos(int id, String nombre_Categoria, List<JugadorMiEquipo> listaJugadoresCateg) {
        Id = id;
        Nombre_Categoria = nombre_Categoria;
        ListaJugadoresCateg = listaJugadoresCateg;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre_Categoria() {
        return Nombre_Categoria;
    }

    public void setNombre_Categoria(String nombre_Categoria) {
        Nombre_Categoria = nombre_Categoria;
    }

    public List<JugadorMiEquipo> getListaJugadoresCateg() {
        return ListaJugadoresCateg;
    }

    public void setListaJugadoresCateg(List<JugadorMiEquipo> listaJugadoresCateg) {
        ListaJugadoresCateg = listaJugadoresCateg;
    }

    protected MisEquipos(Parcel in) {
        Id = in.readInt();
        Nombre_Categoria = in.readString();
        if (in.readByte() == 0x01) {
            ListaJugadoresCateg = new ArrayList<JugadorMiEquipo>();
            in.readList(ListaJugadoresCateg, Jugadores_Plantel.class.getClassLoader());
        } else {
            ListaJugadoresCateg = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeString(Nombre_Categoria);
        if (ListaJugadoresCateg == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(ListaJugadoresCateg);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MisEquipos> CREATOR = new Parcelable.Creator<MisEquipos>() {
        @Override
        public MisEquipos createFromParcel(Parcel in) {
            return new MisEquipos(in);
        }

        @Override
        public MisEquipos[] newArray(int size) {
            return new MisEquipos[size];
        }
    };
}