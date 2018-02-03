package inca.jesus.alianza17.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.Eventos;
import inca.jesus.alianza17.Clases.Fechas;
import inca.jesus.alianza17.R;


public class AdapterFechas extends RecyclerView.Adapter<AdapterFechas.ViewHolder> {
    private Context context;
    private List<Fechas> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;
    private boolean Select=false;

    public AdapterFechas(Context context, List<Fechas> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nom_fechas;
        public TextView fecha;
        public ImageView foto;
        public LinearLayout linea;
        public TextView texto;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            nom_fechas=(TextView)itemView.findViewById(R.id.card_fechas_nom);
            fecha=(TextView)itemView.findViewById(R.id.card_fechas_fecha);
            foto=(ImageView)itemView.findViewById(R.id.image_opcion);
            linea=(LinearLayout)itemView.findViewById(R.id.opcion_editable);
            texto=(TextView)itemView.findViewById(R.id.texto_listo);


        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterFechas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_fechas,parent,false);
        return new AdapterFechas.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(final AdapterFechas.ViewHolder holder, final int position) {
        holder.nom_fechas.setText("Fecha N° "+my_Data.get(position).getNum());
        holder.fecha.setText("Ejecución: "+my_Data.get(position).getF_reali());
         if(my_Data.get(position).getSelect()==0){
             holder.foto.setImageResource(R.mipmap.ic_check_off);
             holder.texto.setText("Pendiente");
         }else{
             holder.foto.setImageResource(R.mipmap.ic_check_on);
             holder.texto.setText("Listo");
         }

         holder.linea.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Fechas.COD_FECHA=my_Data.get(position).getId();
                 my_Data.get(position).setSelect(1);
                 Select=true;
                 System.out.println("Inca: moviemiento "+Fechas.COD_FECHA);
                 notifyDataSetChanged();


             }
         });
    }
    @Override
    public int getItemCount() {
        return my_Data.size();
    }

    public boolean isSelect() {
        return Select;
    }

    public void setSelect(boolean select) {
        Select = select;
    }

}
