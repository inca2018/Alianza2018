package inca.jesus.alianza17.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import inca.jesus.alianza17.R;
import inca.jesus.alianza17.Clases.Eventos;
import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;


public class AdapterEventos extends RecyclerView.Adapter<AdapterEventos.ViewHolder> {
    private Context context;
    private List<Eventos> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;

    public AdapterEventos(Context context, List<Eventos> my_Data,RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titulo_evento;
        public TextView cant_postulante;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            titulo_evento=(TextView)itemView.findViewById(R.id.z_nom_evento);
            cant_postulante=(TextView)itemView.findViewById(R.id.z_cantidad_equipo);
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterEventos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_eventos,parent,false);
        return new AdapterEventos.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(AdapterEventos.ViewHolder holder,final int position) {
        holder.titulo_evento.setText(my_Data.get(position).getTitulo_evento());
        if(my_Data.get(position).getStatus()==1){
            holder.cant_postulante.setText("Activo");
        }
        if(my_Data.get(position).getStatus()==0){
            holder.cant_postulante.setText("Inactivo");
        }

        holder.titulo_evento.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                View dialoglayout4 = inflater.inflate(R.layout.info_evento, null);
                final TextView titu=(TextView)dialoglayout4.findViewById(R.id.eve_titulo);
                final TextView fecha_crea=(TextView)dialoglayout4.findViewById(R.id.eve_fecha_creacion);
                final TextView fecha_eje=(TextView)dialoglayout4.findViewById(R.id.eve_fecha_ejecucion);
                final TextView creador=(TextView)dialoglayout4.findViewById(R.id.eve_creador);
                titu.setText(my_Data.get(position).getTitulo_evento());
                fecha_crea.setText("F. Creación: "+my_Data.get(position).getF_creacion());
                fecha_eje.setText("F. Ejecución: "+my_Data.get(position).getF_ejecucion());
                creador.setText("Creador: "+my_Data.get(position).getUsuario());

                AlertDialog.Builder builder4 = new AlertDialog.Builder(context);
                builder4.setView(dialoglayout4);
                builder4.show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return my_Data.size();
    }

}
