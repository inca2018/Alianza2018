package inca.jesus.alianza17.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.Eventos;
import inca.jesus.alianza17.Clases.Eventos2;
import inca.jesus.alianza17.Clases.MantenimientoUsuarios;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Activacion;
import inca.jesus.alianza17.ServerConexion.DesActivacion;
import inca.jesus.alianza17.ServerConexion.Usuario_Eliminar;

public class AdapterGestionBarrio extends RecyclerView.Adapter<AdapterGestionBarrio.ViewHolder> {
    private Context context;
    private List<Eventos2> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;
    boolean d1=false;
    boolean d2=false;

    public AdapterGestionBarrio(Context context, List<Eventos2> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nom_barrio;
        public LinearLayout op1,op2;
        public CheckBox check;
        public TextView hab;


        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            nom_barrio=(TextView)itemView.findViewById(R.id.card_barrio_nom);
            op1=(LinearLayout)itemView.findViewById(R.id.card_opcion_postulantes);
            op2=(LinearLayout)itemView.findViewById(R.id.card_opcion_eliminar);
            check=(CheckBox)itemView.findViewById(R.id.check_barrio);
            hab=(TextView)itemView.findViewById(R.id.habilitar);
            
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterGestionBarrio.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mant_barrio,parent,false);
        return new AdapterGestionBarrio.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(final AdapterGestionBarrio.ViewHolder holder, final int position) {

        holder.nom_barrio.setText(my_Data.get(position).getTitulo_evento());
        holder.op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<my_Data.size();i++){
                    my_Data.get(i).setSs(0);
                }
                my_Data.get(position).setSs(1);
                d1=true;
                notifyDataSetChanged();


            }
        });

        holder.op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<my_Data.size();i++){
                    my_Data.get(i).setSs(0);
                }
                my_Data.get(position).setSs(1);
                d2=true;
                notifyDataSetChanged();
            }
        });

        if(my_Data.get(position).getStatus()==1){
            holder.check.setChecked(true);
        }
        if(my_Data.get(position).getStatus()==0){
            holder.check.setChecked(false);
        }
        
        holder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    activar(my_Data.get(position).getId_evento());
                    my_Data.get(position).setStatus(1);
                    holder.hab.setText("Habilitado");
                    notifyDataSetChanged();
                }
                if(isChecked==false){
                    Desactivar(my_Data.get(position).getId_evento());
                    my_Data.get(position).setStatus(0);
                    holder.hab.setText("Deshabilitado");
                    notifyDataSetChanged();
                }
            }
        });
    }

    private void Desactivar(int i) {

        String id=String.valueOf(i);
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Evento DesActivado");
                    } else {
                        System.out.println("Inca: Error en DesActivacion");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);

                }
            }
        };

        DesActivacion Server = new DesActivacion(id, responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(Server);
    }

    private void activar(int i) {

        String id=String.valueOf(i);
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Evento Activado");
                    } else {
                        System.out.println("Inca: Error en Activacion");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);

                }
            }
        };

        Activacion Server = new Activacion(id, responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(Server);

    }

    @Override
    public int getItemCount() {
        return my_Data.size();
    }


    public int RecuSelect(){
        int n=0;
        for(int i=0;i<my_Data.size();i++){
            if( my_Data.get(i).getSs()==1){
                n=my_Data.get(i).getId_evento();
            }
        }
        return n;
    }

    public String RecuNombre(){
        String n="";
        for(int i=0;i<my_Data.size();i++){
            if( my_Data.get(i).getSs()==1){
                n=my_Data.get(i).getTitulo_evento();
            }
        }
        return n;
    }
    public boolean isD1() {
        return d1;
    }
    public boolean isD2() {
        return d2;
    }
    public void setD1(boolean op1) {
        this.d1 = op1;
    }
    public void setD2(boolean op2) {
        this.d2 = op2;
    }

}
