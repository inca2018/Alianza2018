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
import inca.jesus.alianza17.Clases.MantenimientoUsuarios;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Usuario_Eliminar;

public class AdapterMantUsuarios extends RecyclerView.Adapter<AdapterMantUsuarios.ViewHolder> {
    private Context context;
    private List<MantenimientoUsuarios> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;
    boolean d1=false;
    boolean d2=false;

    public AdapterMantUsuarios(Context context, List<MantenimientoUsuarios> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nom_usuario;
        public LinearLayout op1,op2,op3;


        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            nom_usuario=(TextView)itemView.findViewById(R.id.card_nom_usuario);
            op1=(LinearLayout)itemView.findViewById(R.id.card_opcion_editar);
            op2=(LinearLayout)itemView.findViewById(R.id.card_opcion_eliminar);
            op3=(LinearLayout)itemView.findViewById(R.id.card_opcion_permisos);

        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterMantUsuarios.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mant_usuarios,parent,false);
        return new AdapterMantUsuarios.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(AdapterMantUsuarios.ViewHolder holder, final int position) {

        holder.nom_usuario.setText(my_Data.get(position).getNombre_usuario());
        holder.op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<my_Data.size();i++){
                    my_Data.get(i).setSelect(0);
                }
                my_Data.get(position).setSelect(1);
                d1=true;
                notifyDataSetChanged();


            }
        });

        holder.op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
                builder.setTitle("Eliminar")
                        .setMessage("¿Desea Eliminar Usuario?")
                        .setPositiveButton("SI",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        Eliminar_Usuario(my_Data.get(position).getId());
                                        my_Data.remove(position);
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "Usuario Eliminado", Toast.LENGTH_SHORT).show();
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

        holder.op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<my_Data.size();i++){
                    my_Data.get(i).setSelect2(0);
                }
                my_Data.get(position).setSelect2(1);
                d2=true;
                notifyDataSetChanged();


            }
        });

    }
    @Override
    public int getItemCount() {
        return my_Data.size();
    }
    public int RecuSelect(){
        int n=0;
        for(int i=0;i<my_Data.size();i++){
            if( my_Data.get(i).getSelect()==1){
                n=my_Data.get(i).getId();
            }
        }
        return n;
    }

    public int RecuSelect2(){
        int n=0;
        for(int i=0;i<my_Data.size();i++){
            if( my_Data.get(i).getSelect2()==1){
                n=my_Data.get(i).getId();
            }
        }
        return n;
    }

    public String RecuNombre(){
        String n="";
        for(int i=0;i<my_Data.size();i++){
            if( my_Data.get(i).getSelect2()==1){
                n=my_Data.get(i).getNombre_usuario();
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

    private void Eliminar_Usuario(int i) {
        String id=String.valueOf(i);
        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                     System.out.println("Inca: Usuario Eliminado");
                    } else {
                        System.out.println("Inca: Usuario no Eliminado");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);

                }
            }
        };

        Usuario_Eliminar Server = new Usuario_Eliminar(id, responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(Server);
    }


}
