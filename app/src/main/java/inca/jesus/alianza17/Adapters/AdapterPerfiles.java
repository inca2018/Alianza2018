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
import inca.jesus.alianza17.Clases.Usuarios_Perfiles;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Perfil_Eliminar;
import inca.jesus.alianza17.ServerConexion.Usuario_Eliminar;

public class AdapterPerfiles extends RecyclerView.Adapter<AdapterPerfiles.ViewHolder> {
    private Context context;
    private List<Usuarios_Perfiles> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;
    boolean  mov=false;

    public AdapterPerfiles(Context context, List<Usuarios_Perfiles> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView p_nom;
        public TextView p_creacion;
        public LinearLayout op1,op2;




        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            p_nom=(TextView)itemView.findViewById(R.id.card_perfil_nom);
            p_creacion=(TextView)itemView.findViewById(R.id.card_perfil_creacion);
            op1=(LinearLayout)itemView.findViewById(R.id.card_perfil_modulos);
            op2=(LinearLayout)itemView.findViewById(R.id.card_perfil_eliminar);


        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterPerfiles.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_perfiles,parent,false);
        return new AdapterPerfiles.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(AdapterPerfiles.ViewHolder holder, final int position) {

        holder.p_nom.setText(my_Data.get(position).getNom_tipo());
        holder.p_creacion.setText("Fecha de Creación : "+my_Data.get(position).getCreacion());



        holder.op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<my_Data.size();i++){
                    my_Data.get(i).setStatus(0);
                }
                my_Data.get(position).setStatus(1);
                mov=true;
                notifyDataSetChanged();
            }
        });

        holder.op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
                builder.setTitle("Eliminar")
                        .setMessage("¿Desea Eliminar Perfil?")
                        .setPositiveButton("SI",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        Eliminar_Perfil(my_Data.get(position).getId());
                                        my_Data.remove(position);
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "Perfil Eliminado", Toast.LENGTH_SHORT).show();
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

    public int recu_perfil(){
        int r=0;

        for(int i=0;i<my_Data.size();i++){
            if(my_Data.get(i).getStatus()==1){
                r=my_Data.get(i).getId();
            }
        }
        return r;
    }


    private void Eliminar_Perfil(int i) {
        String id=String.valueOf(i);
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Perfil Eliminado BD");
                    } else {
                        System.out.println("Inca: Perfil no Eliminado");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);

                }
            }
        };
        Perfil_Eliminar Server = new Perfil_Eliminar(id, responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(Server);

    }


    public boolean isMov() {
        return mov;
    }

    public void setMov(boolean mov) {
        this.mov = mov;
    }
}
