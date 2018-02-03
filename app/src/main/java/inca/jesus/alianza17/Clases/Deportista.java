package inca.jesus.alianza17.Clases;

import android.os.Parcel;
import android.os.Parcelable;

public class Deportista implements Parcelable {
    public int id;
    public String nom;
    public String ape;
    public String f_nac;
    public String lug;
    public String naciona;
    public String email;
    public String club;
    public String apod;
    public String liga;
    public String cate;
    public String estado;
    public int telf;
    public int puntaje;
    public String creador;
    public int ss;

    public Deportista(){

    };
    public Deportista(int id,String nom, String ape, String f_nac,String naciona, String lug, String email, String club, String apod, String liga, String cate, String estado, int telf, int puntaje,String creador,int ss) {
        this.id=id;
        this.nom = nom;
        this.ape = ape;
        this.f_nac = f_nac;
        this.naciona=naciona;
        this.lug = lug;
        this.email = email;
        this.club = club;
        this.apod = apod;
        this.liga = liga;
        this.cate = cate;
        this.estado = estado;
        this.telf = telf;
        this.puntaje = puntaje;
        this.creador = creador;
        this.ss=ss;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getApe() {
        return ape;
    }
    public void setApe(String ape) {
        this.ape = ape;
    }
    public String getF_nac() {
        return f_nac;
    }
    public void setF_nac(String f_nac) {
        this.f_nac = f_nac;
    }
    public String getLug() {
        return lug;
    }
    public void setLug(String lug) {
        this.lug = lug;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getClub() {
        return club;
    }
    public void setClub(String club) {
        this.club = club;
    }
    public String getApod() {
        return apod;
    }
    public void setApod(String apod) {
        this.apod = apod;
    }
    public String getLiga() {
        return liga;
    }
    public void setLiga(String liga) {
        this.liga = liga;
    }
    public String getCate() {
        return cate;
    }
    public void setCate(String cate) {
        this.cate = cate;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getTelf() {
        return telf;
    }
    public void setTelf(int telf) {
        this.telf = telf;
    }
    public int getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getNaciona() {
        return naciona;
    }

    public void setNaciona(String naciona) {
        this.naciona = naciona;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    protected Deportista(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        ape = in.readString();
        f_nac = in.readString();
        naciona=in.readString();
        lug = in.readString();
        email = in.readString();
        club = in.readString();
        apod = in.readString();
        liga = in.readString();
        cate = in.readString();
        estado = in.readString();
        telf = in.readInt();
        puntaje = in.readInt();
        creador=in.readString();
        ss=in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(ape);
        dest.writeString(f_nac);
        dest.writeString(naciona);
        dest.writeString(lug);
        dest.writeString(email);
        dest.writeString(club);
        dest.writeString(apod);
        dest.writeString(liga);
        dest.writeString(cate);
        dest.writeString(estado);
        dest.writeInt(telf);
        dest.writeInt(puntaje);
        dest.writeString(creador);
        dest.writeInt(ss);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Deportista> CREATOR = new Parcelable.Creator<Deportista>() {
        @Override
        public Deportista createFromParcel(Parcel in) {
            return new Deportista(in);
        }

        @Override
        public Deportista[] newArray(int size) {
            return new Deportista[size];
        }
    };
}