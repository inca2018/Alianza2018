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
import inca.jesus.alianza17.Clases.Eventos_Camp;
import inca.jesus.alianza17.Clases.MantenimientoCategoria;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Categoria_Eliminar;

public class AdapterEventos_Camp extends RecyclerView.Adapter<AdapterEventos_Camp.ViewHolder> {
    private Context context;
    private List<Eventos_Camp> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;
    private boolean Select=false,Select2=false;

    public AdapterEventos_Camp(Context context, List<Eventos_Camp> my_Data, RecyclerViewOnItemClickListener2
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
            nom=(TextView)itemView.findViewById(R.id.card_ev_nom);
            op1=(LinearLayout)itemView.findViewById(R.id.card_ev_editar);
            op2=(LinearLayout)itemView.findViewById(R.id.card_ev_eliminar);
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterEventos_Camp.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_eventos_camp,parent,false);
        return new AdapterEventos_Camp.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(AdapterEventos_Camp.ViewHolder holder, final int position) {
        holder.nom.setText(my_Data.get(position).getNombre_Evento().toString());

        holder.op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<my_Data.size();i++){
                    my_Data.get(i).setSelect(0);
                }
                my_Data.get(position).setSelect(1);
                Select=true;
                notifyDataSetChanged();
            }
        });

        holder.op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<my_Data.size();i++){
                    my_Data.get(i).setSelect(0);
                }
                my_Data.get(position).setSelect(1);
                Select2=true;
                notifyDataSetChanged();
            }
        });

        holder.nom.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                View dialoglayout4 = inflater.inflate(R.layout.info_evento_camp, null);
                final TextView a1=(TextView)dialoglayout4.findViewById(R.id.info_ev_nom);
                final TextView a2=(TextView)dialoglayout4.findViewById(R.id.info_ev_inicio);
                final TextView a3=(TextView)dialoglayout4.findViewById(R.id.info_ev_fin);
                final TextView a4=(TextView)dialoglayout4.findViewById(R.id.info_ev_cantidad);
                final TextView a5=(TextView)dialoglayout4.findViewById(R.id.info_ev_creador);
                final TextView a6=(TextView)dialoglayout4.findViewById(R.id.info_ev_equipo);
                final TextView a7=(TextView)dialoglayout4.findViewById(R.id.info_ev_f_creacion);

                a1.setText(my_Data.get(position).getNombre_Evento());
                a2.setText(my_Data.get(position).getF_inicio());
                a3.setText(my_Data.get(position).getF_final());
                //a4.setText(String.valueOf(my_Data.get(position).getNum_fechas()));
                a5.setText(my_Data.get(position).getCreador());
                a6.setText(my_Data.get(position).getEquipo_asignado());
                a7.setText(my_Data.get(position).getF_creacion());

                AlertDialog.Builder builder4 = new AlertDialog.Builder(context);
                builder4.setView(dialoglayout4);
                builder4.show();
            }
        });
      /*
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
                                        //Eliminar_Categoria(my_Data.get(position).getId());
                                        //my_Data.remove(position);
                                        //notifyDataSetChanged();
                                        //Toast.makeText(context, "Categoria Eliminada", Toast.LENGTH_SHORT).show();

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
        */
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

    public boolean isSelect2() {
        return Select2;
    }

    public void setSelect2(boolean select2) {
        Select2 = select2;
    }
}
