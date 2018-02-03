package inca.jesus.alianza17.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.Postulante;
import inca.jesus.alianza17.Clases.Usuario_Sesion;
import inca.jesus.alianza17.R;


/**
 * Created by Jesus on 23/12/2016.
 */
public class AdapterPostulante extends RecyclerView.Adapter<AdapterPostulante.ViewHolder>{
    public Context context;
    private List<Postulante> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;

    public AdapterPostulante(Context context, List<Postulante> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        public TextView num_inc;
        public TextView apellido;
        public TextView nombres;
        public TextView edad;
        public TextView categoria;
        public TextView posicion;
        public ImageView foto;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            num_inc=(TextView)itemView.findViewById(R.id.x_cod_registro);
            apellido=(TextView)itemView.findViewById(R.id.x_ape);
            nombres=(TextView)itemView.findViewById(R.id.x_nom);
            edad=(TextView)itemView.findViewById(R.id.x_edad);
            categoria=(TextView)itemView.findViewById(R.id.x_cate);
            posicion=(TextView)itemView.findViewById(R.id.x_posi);
            foto=(ImageView)itemView.findViewById(R.id.foto_postulantes);
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_equipos,parent,false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.nombres.setText(my_Data.get(position).getNombres());
        holder.apellido.setText(my_Data.get(position).getApellidos());
        holder.num_inc.setText(my_Data.get(position).getNum_incripcion());
        holder.edad.setText("Edad: "+my_Data.get(position).getEdad());
        holder.categoria.setText("Categ: "+my_Data.get(position).getCategoria());
        holder.posicion.setText("Pos: "+my_Data.get(position).getPosicion());

        String ruta="http://alianza2.esy.es/alianza/imagenes/"+my_Data.get(position).getFoto();
        Glide.with(context).load(ruta).into(holder.foto);

    }

    @Override
    public int getItemCount() {
        return my_Data.size();
    }
}