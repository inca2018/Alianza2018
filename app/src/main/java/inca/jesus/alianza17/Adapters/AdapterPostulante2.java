package inca.jesus.alianza17.Adapters;

import android.app.AlertDialog;
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
import inca.jesus.alianza17.Clases.DataServer;
import inca.jesus.alianza17.Clases.Postulante;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Post_Eliminar;
import inca.jesus.alianza17.ServerConexion.Usuario_Eliminar;


/**
 * Created by Jesus on 23/12/2016.
 */
public class AdapterPostulante2 extends RecyclerView.Adapter<AdapterPostulante2.ViewHolder>{
    public Context context;
    private List<Postulante> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;

    public AdapterPostulante2(Context context, List<Postulante> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        public TextView num_inc;
        public TextView nombres;
        LinearLayout eliminar,info;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            num_inc=(TextView)itemView.findViewById(R.id.x_cod_registro);
            nombres=(TextView)itemView.findViewById(R.id.x_nom);
            eliminar=(LinearLayout)itemView.findViewById(R.id.card_post_eliminar);
            info=(LinearLayout)itemView.findViewById(R.id.card_post_info);

        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_postulantes,parent,false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.nombres.setText(my_Data.get(position).getNombres()+" "+my_Data.get(position).getApellidos());
        holder.num_inc.setText(my_Data.get(position).getNum_incripcion());

        holder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                View dialoglayout4 = inflater.inflate(R.layout.info_post, null);

                final TextView d1=(TextView)dialoglayout4.findViewById(R.id.ff_1);
                final TextView d2=(TextView)dialoglayout4.findViewById(R.id.ff_2);
                final TextView d3=(TextView)dialoglayout4.findViewById(R.id.ff_3);
                final TextView d4=(TextView)dialoglayout4.findViewById(R.id.ff_4);
                final TextView d5=(TextView)dialoglayout4.findViewById(R.id.ff_5);
                final TextView d6=(TextView)dialoglayout4.findViewById(R.id.ff_6);
                final TextView d7=(TextView)dialoglayout4.findViewById(R.id.ff_7);
                final TextView d8=(TextView)dialoglayout4.findViewById(R.id.ff_8);
                final TextView d9=(TextView)dialoglayout4.findViewById(R.id.ff_9);
                final TextView d10=(TextView)dialoglayout4.findViewById(R.id.ff_10);
                final TextView d11=(TextView)dialoglayout4.findViewById(R.id.ff_11);

                d1.setText(my_Data.get(position).getNum_incripcion().toString());
                d2.setText(my_Data.get(position).getNombres().toString());
                d3.setText(my_Data.get(position).getApellidos().toString());
                d4.setText(my_Data.get(position).getF_nacimiento().toString());
                d5.setText(String.valueOf(my_Data.get(position).getEdad()));
                d6.setText(my_Data.get(position).getCategoria().toString());
                d7.setText(my_Data.get(position).getDomicilio().toString());

                d9.setText(String.valueOf(my_Data.get(position).getTelefono()));
                d10.setText(my_Data.get(position).getEmail().toString());
                d11.setText(my_Data.get(position).getPosicion().toString());

                AlertDialog.Builder builder4 = new AlertDialog.Builder(context);
                builder4.setView(dialoglayout4);
                builder4.show();
            }
        });

        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
                builder.setTitle("Eliminar")
                        .setMessage("¿Desea Eliminar Postulante?")
                        .setPositiveButton("SI",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        Eliminar_Postulante(my_Data.get(position).getId());
                                        my_Data.remove(position);
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "Postulante Eliminado Exitosamente!", Toast.LENGTH_SHORT).show();
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

    private void Eliminar_Postulante(int id) {
        String d1= String.valueOf(DataServer.COD_EVENTO);
        String d2=String.valueOf(id);

        com.android.volley.Response.Listener<String> responseListener = new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        System.out.println("Inca: Post Eliminado");
                    } else {
                        System.out.println("Inca: Post no Eliminado");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Inca: error "+ e);
                }
            }
        };

        Post_Eliminar Server = new Post_Eliminar(d1,d2, responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(Server);

    }

    @Override
    public int getItemCount() {
        return my_Data.size();
    }
}