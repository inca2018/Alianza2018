package inca.jesus.alianza17.Clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus on 23/06/2017.
 */

public class CategoriaPlantel implements Parcelable {
    public int Id;
    public String Nombre_Categoria;
    public List<Jugadores_Plantel> ListaJugadoresCateg;
    public CategoriaPlantel(){

    }
    public CategoriaPlantel(int id, String nombre_Categoria, List<Jugadores_Plantel> listaJugadoresCateg) {
        Id = id;
        Nombre_Categoria = nombre_Categoria;
        ListaJugadoresCateg = listaJugadoresCateg;
    }

    public static final List<CategoriaPlantel> ListaCategorias=new ArrayList<CategoriaPlantel>();

    static{
        ListaCategorias.add(new CategoriaPlantel(1,"Categoria 1999", Jugadores_Plantel.CAT99));
        ListaCategorias.add(new CategoriaPlantel(2,"Categoria 2000", Jugadores_Plantel.CAT2000));
        ListaCategorias.add(new CategoriaPlantel(3,"Categoria 2001", Jugadores_Plantel.CAT2001));
        ListaCategorias.add(new CategoriaPlantel(4,"Categoria 2002", Jugadores_Plantel.CAT2002));
        ListaCategorias.add(new CategoriaPlantel(5,"Categoria 2003", Jugadores_Plantel.CAT2003));
        ListaCategorias.add(new CategoriaPlantel(6,"Categoria 2004", Jugadores_Plantel.CAT2004));
        ListaCategorias.add(new CategoriaPlantel(7,"Categoria 2005", Jugadores_Plantel.CAT2005));
        ListaCategorias.add(new CategoriaPlantel(8,"Categoria 2006", Jugadores_Plantel.CAT2006));
        ListaCategorias.add(new CategoriaPlantel(9,"Categoria 2007", Jugadores_Plantel.CAT2007));
        ListaCategorias.add(new CategoriaPlantel(10,"Categoria 2008", Jugadores_Plantel.CAT2008));
        ListaCategorias.add(new CategoriaPlantel(11,"Categoria 2009", Jugadores_Plantel.CAT2009));

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
    public List<Jugadores_Plantel> getListaJugadoresCateg() {
        return ListaJugadoresCateg;
    }
    public void setListaJugadoresCateg(List<Jugadores_Plantel> listaJugadoresCateg) {
        ListaJugadoresCateg = listaJugadoresCateg;
    }


    protected CategoriaPlantel(Parcel in) {
        Id = in.readInt();
        Nombre_Categoria = in.readString();
        if (in.readByte() == 0x01) {
            ListaJugadoresCateg = new ArrayList<Jugadores_Plantel>();
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
    public static final Parcelable.Creator<CategoriaPlantel> CREATOR = new Parcelable.Creator<CategoriaPlantel>() {
        @Override
        public CategoriaPlantel createFromParcel(Parcel in) {
            return new CategoriaPlantel(in);
        }

        @Override
        public CategoriaPlantel[] newArray(int size) {
            return new CategoriaPlantel[size];
        }
    };
}
