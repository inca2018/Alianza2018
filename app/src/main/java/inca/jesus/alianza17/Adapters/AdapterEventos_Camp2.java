package inca.jesus.alianza17.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.Eventos_Camp;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.ServerConexion.Categoria_Eliminar;

public class AdapterEventos_Camp2 extends RecyclerView.Adapter<AdapterEventos_Camp2.ViewHolder> {
    private Context context;
    private List<Eventos_Camp> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;
    private boolean Select=false;

    public AdapterEventos_Camp2(Context context, List<Eventos_Camp> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nom,crea,eq;
        public LinearLayout op1,op2;
        public ImageView foto;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nom=(TextView)itemView.findViewById(R.id.card_ev_nom);
            crea=(TextView)itemView.findViewById(R.id.card_ev_creacion);
            eq=(TextView)itemView.findViewById(R.id.card_ev_equipo);
            op1=(LinearLayout)itemView.findViewById(R.id.card_ev_editar);
            foto=(ImageView)itemView.findViewById(R.id.foto_evento_camp);

        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterEventos_Camp2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_eventos_camp2,parent,false);
        return new AdapterEventos_Camp2.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(AdapterEventos_Camp2.ViewHolder holder, final int position) {
        holder.nom.setText(my_Data.get(position).getNombre_Evento().toString());
        holder.crea.setText(my_Data.get(position).getF_creacion().toString());
        holder.eq.setText("Equipo: "+my_Data.get(position).getEquipo_asignado());
        if(my_Data.get(position).getFoto()==""){
        }else{
            String ruta="http://alianza2.esy.es/alianza/imagenes/"+my_Data.get(position).getFoto();
            Glide.with(context).load(ruta).into(holder.foto);
        }

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


}
