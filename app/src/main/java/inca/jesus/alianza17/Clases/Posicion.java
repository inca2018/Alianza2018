package inca.jesus.alianza17.Clases;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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
 * Created by Jesus on 24/07/2017.
 */

public class Posicion {
    int id;
    String nombre;


    public static final List<Posicion> LISTA_POS=new ArrayList<>();


    static {
        System.out.println("Inka Lista pOSICIONES:");
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.POSICIONES_LISTAR)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        Posicion data=new Posicion (
                                object.getInt("ID_POSICION"),
                                object.getString("NOMBRE_POS")
                        );
                        LISTA_POS.add(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    System.out.println("Inka ERROR:"+e);
                }
                return null;
            }
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            protected void onPostExecute(Void aVoid){
                //TEMP=new String[LISTA_POS.size()];
                //for(int i=0;i<LISTA_POS.size();i++){
                  //  TEMP[i]=LISTA_POS.get(i).getNombre();
                //}
                //ArrayAdapter<String> adapter_arr=new ArrayAdapter<>(context,android.R.layout.simple_spinner_dropdown_item,TEMP);
                //spp.setAdapter(adapter_arr);
            }
        };
        task.execute();
    }
    public Posicion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
