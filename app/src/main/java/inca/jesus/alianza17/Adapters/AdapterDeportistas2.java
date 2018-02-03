package inca.jesus.alianza17.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import inca.jesus.alianza17.Activities.RecyclerViewOnItemClickListener2;
import inca.jesus.alianza17.Clases.Deportista;
import inca.jesus.alianza17.R;


public class AdapterDeportistas2 extends RecyclerView.Adapter<AdapterDeportistas2.ViewHolder> {
    private Context context;
    private List<Deportista> my_Data;
    private RecyclerViewOnItemClickListener2 recyclerViewOnItemClickListener;
    boolean o1=false,o2=false;


    public AdapterDeportistas2(Context context, List<Deportista> my_Data, RecyclerViewOnItemClickListener2
            recyclerViewOnItemClickListener) {
        this.context = context;
        this.my_Data = my_Data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;

    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nombre;
        public TextView creador;
        public TextView estado;
        public LinearLayout l1;
        public LinearLayout l2;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nombre=(TextView)itemView.findViewById(R.id.card_nom_de);
            creador=(TextView)itemView.findViewById(R.id.card_creador_de);
            estado=(TextView)itemView.findViewById(R.id.card_estado_de);
            l1=(LinearLayout)itemView.findViewById(R.id.modulo_Informacion);
            l2=(LinearLayout)itemView.findViewById(R.id.modulo_evaluaciones);
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    public AdapterDeportistas2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_deportista2,parent,false);
        return new AdapterDeportistas2.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(AdapterDeportistas2.ViewHolder holder, final int position) {

        holder.nombre.setText(my_Data.get(position).getNom()+" "+my_Data.get(position).getApe());
        holder.creador.setText(my_Data.get(position).getCreador());
        holder.estado.setText(my_Data.get(position).getEstado());

        holder.l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<my_Data.size();i++){
                  my_Data.get(i).setSs(0);
                }
                my_Data.get(position).setSs(1);
                o1=true;
                notifyDataSetChanged();
            }
        });

        holder.l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<my_Data.size();i++){
                    my_Data.get(i).setSs(0);
                }
                my_Data.get(position).setSs(1);
                o2=true;
                notifyDataSetChanged();
            }
        });

       /* holder.puntaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                View dialoglayout4 = inflater.inflate(R.layout.info_deportista, null);

                final TextView nom=(TextView)dialoglayout4.findViewById(R.id.info2_nombress);
                final TextView ape=(TextView)dialoglayout4.findViewById(R.id.info2_apellido);
                final TextView fecha=(TextView)dialoglayout4.findViewById(R.id.info2_fecha_nac);
                final TextView telefono=(TextView)dialoglayout4.findViewById(R.id.info2_telefono);
                final TextView correo=(TextView)dialoglayout4.findViewById(R.id.info2_correoo);
                final TextView liga=(TextView)dialoglayout4.findViewById(R.id.info_liga);
                final TextView categoria=(TextView)dialoglayout4.findViewById(R.id.info_categoria);

                nom.setText(my_Data.get(position).getNom());
                ape.setText(my_Data.get(position).getApe());
                fecha.setText("F.N: "+my_Data.get(position).getF_nac());
                telefono.setText("Telefono: "+my_Data.get(position).getTelf());
                correo.setText("Correo: "+my_Data.get(position).getEmail());
                liga.setText("Liga: "+my_Data.get(position).getLiga());
                categoria.setText("Categoria: "+my_Data.get(position).getCate());

                AlertDialog.Builder builder4 = new AlertDialog.Builder(context);
                builder4.setView(dialoglayout4);
                builder4.show();
            }
        });*/
    }
    @Override
    public int getItemCount() {
        return my_Data.size();
    }

    public int RecuSelect(){
        int n=0;
        for(int i=0;i<my_Data.size();i++){
            if( my_Data.get(i).getSs()==1){
                n=my_Data.get(i).getId();
            }
        }
        return n;
    }



    public boolean isO1() {
        return o1;
    }

    public void setO1(boolean o1) {
        this.o1 = o1;
    }

    public boolean isO2() {
        return o2;
    }

    public void setO2(boolean o2) {
        this.o2 = o2;
    }
}

