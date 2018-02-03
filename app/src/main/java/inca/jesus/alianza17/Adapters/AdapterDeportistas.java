package inca.jesus.alianza17.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.R;
import inca.jesus.alianza17.Clases.Deportista;


public class AdapterDeportistas extends RecyclerView.Adapter<AdapterDeportistas.ViewHolder> {
    private Context context;
    private List<Deportista> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;

    public AdapterDeportistas(Context context, List<Deportista> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nom_dep;
        public TextView ape_dep;
        public TextView puntaje;


        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            nom_dep=(TextView)itemView.findViewById(R.id.nom_dep);
            ape_dep=(TextView) itemView.findViewById(R.id.ape_dep);
            puntaje=(TextView)itemView.findViewById(R.id.Total_dep);

        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterDeportistas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_deportista,parent,false);
        return new AdapterDeportistas.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(AdapterDeportistas.ViewHolder holder, final int position) {

        holder.nom_dep.setText(my_Data.get(position).getNom()+" "+my_Data.get(position).getApe());
        holder.ape_dep.setText("Registrado por: "+my_Data.get(position).getCreador());
        holder.puntaje.setText(my_Data.get(position).getPuntaje()+" Ptos.");

    }

    @Override
    public int getItemCount() {
        return my_Data.size();
    }

}
