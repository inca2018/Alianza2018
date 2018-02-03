package inca.jesus.alianza17.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.MantenimientoCategoria;
import inca.jesus.alianza17.Clases.MantenimientoCategoria_Jugadores;
import inca.jesus.alianza17.Clases.MantenimientoJugadores;
import inca.jesus.alianza17.Clases.Plantel;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Perfil_Eliminar;
import inca.jesus.alianza17.ServerConexion.Plantel_Eliminar;

public class AdapterMantJugadores extends RecyclerView.Adapter<AdapterMantJugadores.ViewHolder> {
    private Context context;
    private List<Plantel> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;
    boolean Selecto=false;

    public AdapterMantJugadores(Context context, List<Plantel> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }
    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nom;
        public LinearLayout op1,op2;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nom=(TextView)itemView.findViewById(R.id.card_juga_nom);
            op1=(LinearLayout)itemView.findViewById(R.id.card_juga_editar);
            op2=(LinearLayout)itemView.findViewById(R.id.card_juga_eliminar);
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterMantJugadores.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mant_jugadores,parent,false);
        return new AdapterMantJugadores.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(AdapterMantJugadores.ViewHolder holder, final int position) {

        holder.nom.setText(my_Data.get(position).getNom_completo());

        holder.op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<my_Data.size();i++){
                    my_Data.get(i).setSelect(0);
                }
                my_Data.get(position).setSelect(1);
                Selecto=true;
                notifyDataSetChanged();
            }
        });
        holder.op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
                builder.setTitle("Eliminar")
                        .setMessage("¿Desea Eliminar Jugador?")
                        .setPositiveButton("SI",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Eliminar_Jugador(my_Data.get(position).getId());
                                        my_Data.remove(position);
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "Jugador Eliminado", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setNegativeButton("NO",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {


        return my_Data.size();
    }
    public int recu_Codigo(){
        int r=0;

        for(int i=0;i<my_Data.size();i++){
            if(my_Data.get(i).getSelect()==1){
                r=my_Data.get(i).getId();
            }
        }
        return r;
    }
    public boolean isSelecto() {
        return Selecto;
    }
    public void setSelecto(boolean selecto) {
        Selecto = selecto;
    }
    private void Eliminar_Jugador(int i) {
        String id=String.valueOf(i);
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Jugador Eliminado BD");
                    } else {
                        System.out.println("Inca: Jugador no Eliminado");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);

                }
            }
        };
        Plantel_Eliminar Server = new Plantel_Eliminar(id, responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(Server);

    }


}
