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
import inca.jesus.alianza17.Clases.MantenimientoUsuarios;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Categoria_Eliminar;
import inca.jesus.alianza17.ServerConexion.Perfil_Eliminar;

public class AdapterMantCategorias extends RecyclerView.Adapter<AdapterMantCategorias.ViewHolder> {
    private Context context;
    private List<MantenimientoCategoria> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;
    private boolean Select=false;

    public AdapterMantCategorias(Context context, List<MantenimientoCategoria> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nom,creador,fecha;
        public LinearLayout op1,op2;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nom=(TextView)itemView.findViewById(R.id.card_cate_nom);
            creador=(TextView)itemView.findViewById(R.id.card_cate_creador);
            fecha=(TextView)itemView.findViewById(R.id.card_cate_fecha);
            op1=(LinearLayout)itemView.findViewById(R.id.card_cate_editar);
            op2=(LinearLayout)itemView.findViewById(R.id.card_cate_eliminar);

        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterMantCategorias.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mant_categorias,parent,false);
        return new AdapterMantCategorias.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(AdapterMantCategorias.ViewHolder holder, final int position) {
        holder.nom.setText(my_Data.get(position).getNombre().toString());
        holder.creador.setText(my_Data.get(position).getUsuario().toString());
        holder.fecha.setText(my_Data.get(position).getF_creacion().toString());

        holder.op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<my_Data.size();i++){
                    my_Data.get(i).setStatus(0);
                }
                my_Data.get(position).setStatus(1);
                Select=true;
                notifyDataSetChanged();
            }
        });
        holder.op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
                builder.setTitle("Eliminar")
                        .setMessage("Eliminara todos los Jugadores agregado a la Categoria.\n" +
                                "¿Desea Eliminar Categoria?")
                        .setPositiveButton("SI",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Eliminar_Categoria(my_Data.get(position).getId());
                                        my_Data.remove(position);
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "Categoria Eliminada", Toast.LENGTH_SHORT).show();

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
    public int RecuSelect(){
        int n=0;
        for(int i=0;i<my_Data.size();i++){
            if( my_Data.get(i).getStatus()==1){
             n=my_Data.get(i).getId();
            }
        }
        return n;
    }
    public boolean isSelect() {
        return Select;
    }
    public void setSelect(boolean select) {
        Select = select;
    }
    private void Eliminar_Categoria(int i) {
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
        Categoria_Eliminar Server = new Categoria_Eliminar(id, responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(Server);
    }
}
