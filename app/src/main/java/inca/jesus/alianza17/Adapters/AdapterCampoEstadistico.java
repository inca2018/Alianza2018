package inca.jesus.alianza17.Adapters;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.Campo;
import inca.jesus.alianza17.Clases.Campo_Estadistico;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.GestionCampo2;
import inca.jesus.alianza17.Clases.Plantel;
import inca.jesus.alianza17.Clases.Posicion;
import inca.jesus.alianza17.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class AdapterCampoEstadistico extends RecyclerView.Adapter<AdapterCampoEstadistico.ViewHolder> {
    private Context context;
    private List<Campo_Estadistico> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;

    AlertDialog da;
    String[] TEMP;
    String[] TEMP2;
    List<Plantel>LISTA_JUGADORES=new ArrayList<>();
    List<GestionCampo2>LISTA_OP=new ArrayList<>();
    String cod_op="";
    String nom_juga="";
    int cod_juga=0;
    int cod_opcion=0;

    public AdapterCampoEstadistico(Context context, List<Campo_Estadistico> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public Button dato;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            dato=(Button)itemView.findViewById(R.id.btn_campo);

        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }
    public AdapterCampoEstadistico.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_campo,parent,false);
        return new AdapterCampoEstadistico.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(AdapterCampoEstadistico.ViewHolder holder, final int position) {

        holder.dato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Dato: "+position, Toast.LENGTH_SHORT).show();
            }
        });
        holder.dato.setText(my_Data.get(position).getDato());
        holder.dato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                final View dialoglayout4 = inflater.inflate(R.layout.gestion_campo_estadistico, null);
                final Spinner sp=(Spinner) dialoglayout4.findViewById(R.id.sp_jugador1);
                final Spinner sp2=(Spinner) dialoglayout4.findViewById(R.id.sp_opciones);
                final Button btn=(Button)dialoglayout4.findViewById(R.id.boton_guardar);
                final AlertDialog.Builder builder4 = new AlertDialog.Builder(context);
                builder4.setView(dialoglayout4);
                da=builder4.show();

                if(LISTA_JUGADORES.size()==0){
                    Listar_Jugadores(sp);
                }
                if(LISTA_JUGADORES.size()!=0){
                    LISTA_JUGADORES.clear();
                    Listar_Jugadores(sp);
                }
                if(LISTA_OP.size()==0){
                    Listar_Opciones(sp2);
                }
                if(LISTA_OP.size()!=0){
                    LISTA_OP.clear();
                    Listar_Opciones(sp2);
                }

                sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        cod_op=TEMP2[pos];
                        System.out.println("Inca Opcion: "+cod_op);
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int posi, long id) {
                        nom_juga=TEMP[posi];
                        System.out.println("Inca : Jugador:"+nom_juga);

                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });


                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       System.out.println("Inca click");

                                for(int i=0;i<LISTA_JUGADORES.size();i++){
                                    if(LISTA_JUGADORES.get(i).getNom_completo()==nom_juga){
                                        cod_juga=LISTA_JUGADORES.get(i).getId();
                                    }
                                }
                        for(int i=0;i<LISTA_OP.size();i++){
                            if(LISTA_OP.get(i).getOp()==cod_op){
                                cod_opcion=LISTA_OP.get(i).getId();
                            }
                        }

                        my_Data.get(position).setOpcion(cod_opcion);
                        my_Data.get(position).setJugador(cod_juga);
                        my_Data.get(position).setDato("X");
                        System.out.println("Inca : btn cod juga: "+my_Data.get(position).getJugador());
                        System.out.println("Inca : btn nom opcion: "+my_Data.get(position).getOpcion());

                        notifyDataSetChanged();
                        da.dismiss();
                    }
                });
            }
        });
    }
    @Override
    public int getItemCount() {
        return my_Data.size();
    }
    private void Listar_Jugadores(final Spinner sp) {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.MIEQUIPO_LISTA_JUGADOR+Campo_Estadistico.COD_EQUIPO_SE)
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
                        LISTA_JUGADORES.add(data);
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

                if(LISTA_JUGADORES.size()==0){
                    System.out.println("Inca : Lista vacia");
                }else{
                    System.out.println("Inca : Lista con datos : ");

                    TEMP=new String[LISTA_JUGADORES.size()];
                    for(int i=0;i<LISTA_JUGADORES.size();i++){
                        TEMP[i]=LISTA_JUGADORES.get(i).getNom_completo();
                    }
                    ArrayAdapter<String> adapter_arr=new ArrayAdapter<>(context,android.R.layout.simple_spinner_dropdown_item,TEMP);
                    sp.setAdapter(adapter_arr);
                }
            }
        };
        task.execute();
    }
    private void Listar_Opciones(final Spinner sp) {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(DataServer.GESTION)
                        .build();
                try{
                    Response response= client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());
                    for(int i=0;i<array.length();i++) {
                        JSONObject object=array.getJSONObject(i);
                        GestionCampo2 data=new GestionCampo2 (
                                object.getInt("ID"),
                                object.getString("POS"));
                        LISTA_OP.add(data);
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

                if(LISTA_OP.size()==0){
                    System.out.println("Inca : Lista vacia");
                }else{
                    System.out.println("Inca : Lista con datos : ");

                    TEMP2=new String[LISTA_OP.size()];
                    for(int i=0;i<LISTA_OP.size();i++){
                        TEMP2[i]=LISTA_OP.get(i).getOp();
                    }
                    ArrayAdapter<String> adapter_arr=new ArrayAdapter<>(context,android.R.layout.simple_spinner_dropdown_item,TEMP2);
                    sp.setAdapter(adapter_arr);
                }
            }
        };
        task.execute();
    }

}
