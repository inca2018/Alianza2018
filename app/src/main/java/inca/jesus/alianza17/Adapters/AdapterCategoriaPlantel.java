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
import inca.jesus.alianza17.Clases.CategoriaPlantel;
import inca.jesus.alianza17.Clases.Deportista;
import inca.jesus.alianza17.R;


public class AdapterCategoriaPlantel extends RecyclerView.Adapter<AdapterCategoriaPlantel.ViewHolder> {
    private Context context;
    private List<CategoriaPlantel> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;

    public AdapterCategoriaPlantel(Context context, List<CategoriaPlantel> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nom_dep;


        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            nom_dep=(TextView)itemView.findViewById(R.id.card_nom_categoria);
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterCategoriaPlantel.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_categorias_plantel,parent,false);
        return new AdapterCategoriaPlantel.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(AdapterCategoriaPlantel.ViewHolder holder, final int position) {

        holder.nom_dep.setText(my_Data.get(position).getNombre_Categoria());

    }

    @Override
    public int getItemCount() {
        return my_Data.size();
    }

}
