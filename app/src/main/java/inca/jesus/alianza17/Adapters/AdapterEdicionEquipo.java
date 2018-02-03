package inca.jesus.alianza17.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Jugadores_Plantel;
import inca.jesus.alianza17.Clases.MisEquipos2;
import inca.jesus.alianza17.Clases.Plantel;
import inca.jesus.alianza17.Clases.Posicion;
import inca.jesus.alianza17.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class AdapterEdicionEquipo extends RecyclerView.Adapter<AdapterEdicionEquipo.ViewHolder> {
    private Context context;
    private List<Plantel> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;

    String[] TEMP;
    String[] TEMP2;
    String NomSeleccion;
    int numSelect;
    int CodSeleccion;

    public AdapterEdicionEquipo(Context context, List<Plantel> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nom_dep;
        public Spinner sp,sp2;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            nom_dep=(TextView)itemView.findViewById(R.id.card_nom_edit);
            sp=(Spinner)itemView.findViewById(R.id.card_spinner_edit);
            sp2=(Spinner)itemView.findViewById(R.id.card_spinner_num);
            listar_Num(sp2);
            listar_Posiciones(sp);
            this.setIsRecyclable (false);
         }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterEdicionEquipo.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_editar_pos_equipo,parent,false);
        return new AdapterEdicionEquipo.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(final AdapterEdicionEquipo.ViewHolder holder, final int position) {

        holder.nom_dep.setText(my_Data.get(position).getNom_completo().toString());

        holder.sp.setSelection(my_Data.get(position).getSelect()-1);
        holder.sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                NomSeleccion=Posicion.LISTA_POS.get(pos).getNombre();
                CodSeleccion=Posicion.LISTA_POS.get(pos).getId();
                my_Data.get(position).setSelect(CodSeleccion);
                System.out.println("Inca: Nombre"+NomSeleccion+"  cod: "+CodSeleccion);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        holder.sp2.setSelection(my_Data.get(position).getNum());
        holder.sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                numSelect= Integer.parseInt(TEMP2[pos]);
                my_Data.get(position).setNum(numSelect);
                System.out.println("Inca: Codigo num: "+numSelect);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void listar_Num(Spinner sp2) {
        TEMP2=new String[26];
        System.out.println("Inca Lista NUM:");

        for(int i=0;i<26;i++){
            TEMP2[i]=String.valueOf(i);
            System.out.println("Inca i:"+i);
            System.out.println("Inca tam:"+TEMP2.length);
        }
        ArrayAdapter<String> adapter_arr=new ArrayAdapter<>(context,android.R.layout.simple_spinner_dropdown_item,TEMP2);
        sp2.setAdapter(adapter_arr);

    }
    private void listar_Posiciones(Spinner spp) {
                 if(Posicion.LISTA_POS.size()==0){
                     System.out.println("Inca : Lista 0");
                 }else{
                     System.out.println("Inca : Lista mayor 1");

                     TEMP=new String[Posicion.LISTA_POS.size()];
                     for(int i=0;i<Posicion.LISTA_POS.size();i++){
                         TEMP[i]=Posicion.LISTA_POS.get(i).getNombre();
                     }
                     ArrayAdapter<String> adapter_arr=new ArrayAdapter<>(context,android.R.layout.simple_spinner_dropdown_item,TEMP);
                     spp.setAdapter(adapter_arr);
                 }
    }
    @Override
    public int getItemCount() {
        return my_Data.size();
    }
}
