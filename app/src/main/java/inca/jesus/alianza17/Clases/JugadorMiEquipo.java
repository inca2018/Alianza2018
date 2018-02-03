package inca.jesus.alianza17.Clases;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jesus on 23/06/2017.
 */

public class JugadorMiEquipo implements Parcelable {
    public int Id;
    public String Nombres;
    public int DNI;
    public String Fecha_nacimiento;
    public String titular;
    public String Posicion;
    public int Camiseta;

    public JugadorMiEquipo(){

    }

    public JugadorMiEquipo(int id, String nombres, int DNI, String fecha_nacimiento,String titular, String posicion, int camiseta) {
        Id = id;
        Nombres = nombres;
        this.DNI = DNI;
        Fecha_nacimiento = fecha_nacimiento;
        titular=titular;
        Posicion = posicion;
        Camiseta = camiseta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String posicion) {
        Posicion = posicion;
    }

    public int getCamiseta() {
        return Camiseta;
    }

    public void setCamiseta(int camiseta) {
        Camiseta = camiseta;
    }

    protected JugadorMiEquipo(Parcel in) {
        Id = in.readInt();
        Nombres = in.readString();
        DNI = in.readInt();
        Fecha_nacimiento = in.readString();
        titular=in.readString();
        Posicion = in.readString();
        Camiseta = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeString(Nombres);
        dest.writeInt(DNI);
        dest.writeString(Fecha_nacimiento);
        dest.writeString(titular);
        dest.writeString(Posicion);
        dest.writeInt(Camiseta);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<JugadorMiEquipo> CREATOR = new Parcelable.Creator<JugadorMiEquipo>() {
        @Override
        public JugadorMiEquipo createFromParcel(Parcel in) {
            return new JugadorMiEquipo(in);
        }

        @Override
        public JugadorMiEquipo[] newArray(int size) {
            return new JugadorMiEquipo[size];
        }
    };
}