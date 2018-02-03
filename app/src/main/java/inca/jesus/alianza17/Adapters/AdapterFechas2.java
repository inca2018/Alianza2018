package inca.jesus.alianza17.Adapters;

import android.content.Context;
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
import inca.jesus.alianza17.Clases.Fechas;
import inca.jesus.alianza17.R;


public class AdapterFechas2 extends RecyclerView.Adapter<AdapterFechas2.ViewHolder> {
    private Context context;
    private List<Fechas> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;
    private boolean Select=false , Select2=false;

    public AdapterFechas2(Context context, List<Fechas> my_Data, RecyclerViewOnItemClickListener2
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

    public AdapterFechas2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_fechas,parent,false);
        return new AdapterFechas2.ViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(final AdapterFechas2.ViewHolder holder, final int position) {
        holder.nom_fechas.setText("Fecha N° "+my_Data.get(position).getNum());
        holder.fecha.setText("Ejecución: "+my_Data.get(position).getF_reali());

        if(my_Data.get(position).getStatus()==0){
        if(my_Data.get(position).getSelect()==0){
             holder.foto.setImageResource(R.mipmap.ic_check_off);
             holder.texto.setText("Inactivo");
         }else{
             holder.foto.setImageResource(R.mipmap.ic_check_on);
             holder.texto.setText("Activo");
         }

        }else{

            holder.foto.setImageResource(R.mipmap.ic_registrado_icon);
            holder.texto.setText("Reporte");

        }

        holder.linea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(my_Data.get(position).getStatus()==1){

                    Fechas.COD_FECHA=my_Data.get(position).getId();
                    my_Data.get(position).setStatus(2);
                    Select2=true;
                    notifyDataSetChanged();
                }else{
                    if(my_Data.get(position).getSelect()==1){
                        Fechas.COD_FECHA=my_Data.get(position).getId();
                        my_Data.get(position).setStatus(1);
                        Select=true;
                        System.out.println("Inca: moviemiento "+Fechas.COD_FECHA);
                        notifyDataSetChanged();
                    }else{
                        Toast.makeText(context, "Solicitar Activación al Administrador!", Toast.LENGTH_SHORT).show();
                    }
                }
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

    public int Recu(){
        int a=0;

        for(int i=0;i<my_Data.size();i++){
         if(my_Data.get(i).getStatus()==1){
             a=my_Data.get(i).getId();
         }
        }
        return a;
    }

    public int Recu2(){
        int a=0;

        for(int i=0;i<my_Data.size();i++){
            if(my_Data.get(i).getStatus()==2){
                a=my_Data.get(i).getId();
            }
        }
        return a;
    }

    public boolean isSelect2() {
        return Select2;
    }

    public void setSelect2(boolean select2) {
        Select2 = select2;
    }
}
