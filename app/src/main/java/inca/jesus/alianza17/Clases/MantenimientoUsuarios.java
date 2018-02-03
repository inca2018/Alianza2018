package inca.jesus.alianza17.Clases;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import inca.jesus.alianza17.Fragments.FragmentUsuarios;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MantenimientoUsuarios implements Parcelable {
    public int  id;
    public String nombre_usuario;
    public int tipo_usuario;
    public String pass_usuario;
    public String correo_usuario;
    public String usuario;
    public int select,select2;
    public String fecha;


    public MantenimientoUsuarios(int id, String nombre_usuario, int tipo_usuario, String pass_usuario, String correo_usuario, String usuario,int select,int select2,String fecha) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.tipo_usuario = tipo_usuario;
        this.pass_usuario = pass_usuario;
        this.correo_usuario = correo_usuario;
        this.usuario = usuario;
        this.select=select;
        this.select2=select2;
        this.fecha=fecha;
    }
    public MantenimientoUsuarios(){

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    public int getTipo_usuario() {
        return tipo_usuario;
    }
    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
    public String getPass_usuario() {
        return pass_usuario;
    }
    public void setPass_usuario(String pass_usuario) {
        this.pass_usuario = pass_usuario;
    }
    public String getCorreo_usuario() {
        return correo_usuario;
    }
    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public int getSelect2() {
        return select2;
    }

    public void setSelect2(int select2) {
        this.select2 = select2;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    protected MantenimientoUsuarios(Parcel in) {
        id = in.readInt();
        nombre_usuario = in.readString();
        tipo_usuario = in.readInt();
        pass_usuario = in.readString();
        correo_usuario = in.readString();
        usuario = in.readString();

    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre_usuario);
        dest.writeInt(tipo_usuario);
        dest.writeString(pass_usuario);
        dest.writeString(correo_usuario);
        dest.writeString(usuario);

    }
    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MantenimientoUsuarios> CREATOR = new Parcelable.Creator<MantenimientoUsuarios>() {
        @Override
        public MantenimientoUsuarios createFromParcel(Parcel in) {
            return new MantenimientoUsuarios(in);
        }

        @Override
        public MantenimientoUsuarios[] newArray(int size) {
            return new MantenimientoUsuarios[size];
        }
    };

}