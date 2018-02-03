package inca.jesus.alianza17.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.Eva2;
import inca.jesus.alianza17.R;

/**
 * Created by Jesus on 23/12/2016.
 */
public class AdapterEva2 extends RecyclerView.Adapter<AdapterEva2.ViewHolder>{
    public Context context;
    private List<Eva2> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;

    public AdapterEva2(Context context, List<Eva2> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        public TextView competencia;
        public TextView rival;
        public TextView goles;
        public TextView tiempo;
        public TextView total;



        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            competencia=(TextView)itemView.findViewById(R.id.z_compe);
            rival=(TextView)itemView.findViewById(R.id.z_rival);
            goles=(TextView)itemView.findViewById(R.id.z_goles);
            tiempo=(TextView)itemView.findViewById(R.id.z_t_jugado);
            total=(TextView)itemView.findViewById(R.id.z_total);

        }

        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_eva2,parent,false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.competencia.setText(my_Data.get(position).getCompetencia());
         holder.rival.setText("Rival:"+my_Data.get(position).getRival());
         holder.goles.setText("Goles: "+String.valueOf(my_Data.get(position).getGoles()));
        //  String s =String.valueOf(my_Data.get(position).getTalla_futb());
        // holder.talla.setText("Talla: "+s.substring(0,1)+","+s.substring(1,3)+" m.");
        holder.tiempo.setText("Tiempo Jugado:"+my_Data.get(position).getTiempo_jugado()+" min");
        //holder.total_desem.setText(" "+String.valueOf(my_Data.get(position).getTotal_desem())+"Ptos.");
        holder.total.setText(my_Data.get(position).getTotal_puntos() + " Puntos");
    }

    @Override
    public int getItemCount() {
        return my_Data.size();
    }
}