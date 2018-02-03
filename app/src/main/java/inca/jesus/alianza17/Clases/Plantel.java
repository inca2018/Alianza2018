package inca.jesus.alianza17.Clases;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Jesus on 20/07/2017.
 */

public class Plantel {
    int id;
    int id_origen;
    String nom_completo;
    String f_naci;
    int edad;
    int dni;
    String nacionalidad;
    String domicilio;
    String localidad;
    int telef;
    String email;
    String f_ingreso;
    int select;
    int num;

    public static final List<Plantel> LISTA_TEMP=new ArrayList<>();
    public Plantel(){

    }

    static{
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.MIEQUIPO_LISTA_JUGADOR+Campo_Estadistico.COD_EVENTO)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Plantel data=new Plantel (
                                object.getInt("ID"),
                                object.getInt("OP_ORIGEN"),
                                object.getString("OP_NOMBRES"),
                                object.getString("OP_F_NACI"),
                                object.getInt("OP_EDAD"),
                                object.getInt("OP_DNI"),
                                object.getString("OP_NACIONALIDAD"),
                                object.getString("OP_DOMICILIO"),
                                object.getString("OP_LOCALIDAD"),
                                object.getInt("OP_TELEFONO"),
                                object.getString("OP_EMAIL"),
                                object.getString("OP_FECHA_INGRESO"),
                                object.getInt("OP_SS"),
                                object.getInt("NUM"));
                        LISTA_TEMP.add(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    System.out.println("Inca ERROR IO:"+e);
                }catch (JSONException e){
                    System.out.println("Inca JSON:"+e);
                }
                return null;
            }
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }
            protected void onPostExecute(Void aVoid){

            }
        };
        task.execute();

    }
    public Plantel(int id, int id_origen, String nom_completo, String f_naci, int edad, int dni, String nacionalidad, String domicilio, String localidad, int telef, String email, String f_ingreso, int select,int num) {
        this.id = id;
        this.id_origen = id_origen;
        this.nom_completo = nom_completo;
        this.f_naci = f_naci;
        this.edad = edad;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.telef = telef;
        this.email = email;
        this.f_ingreso = f_ingreso;
        this.select = select;
        this.num=num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_origen() {
        return id_origen;
    }

    public void setId_origen(int id_origen) {
        this.id_origen = id_origen;
    }

    public String getNom_completo() {
        return nom_completo;
    }

    public void setNom_completo(String nom_completo) {
        this.nom_completo = nom_completo;
    }

    public String getF_naci() {
        return f_naci;
    }

    public void setF_naci(String f_naci) {
        this.f_naci = f_naci;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getTelef() {
        return telef;
    }

    public void setTelef(int telef) {
        this.telef = telef;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getF_ingreso() {
        return f_ingreso;
    }

    public void setF_ingreso(String f_ingreso) {
        this.f_ingreso = f_ingreso;
    }


    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
