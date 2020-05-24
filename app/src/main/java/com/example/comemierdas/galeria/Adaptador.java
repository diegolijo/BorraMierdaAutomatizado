package com.example.comemierdas.galeria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comemierdas.BD.Archivo;
import com.example.comemierdas.R;

import java.util.List;


public class Adaptador extends RecyclerView.Adapter<Adaptador.PedidosViewHolder> implements View.OnClickListener {


    private List<Archivo> archivoList;
    private View.OnClickListener listener;

    public Adaptador(List<Archivo> pedidoList) {
        this.archivoList = pedidoList;
    }


    @NonNull
    @Override
    public PedidosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        //contruimos ViewHolder para el return
        Context context = parent.getContext();
        int layoutId = R.layout.;
        LayoutInflater infater = LayoutInflater.from(context);
        boolean velocidad = false;
        View view = infater.inflate(layoutId, parent, velocidad);

        // evento
        view.setOnClickListener(this);


        return new PedidosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidosViewHolder holder, int position) {

        holder.asignarDatos(archivoList.get(position));

        //  String texto = pedidoList.get(position).producto + " " + pedidoList.get(position).categoria;
        //   holder.textViewPedidos.setText(texto);

    }

    @Override
    public int getItemCount() {
        return archivoList.size();
    }


    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }


    public void evento(View.OnClickListener listener) {
        this.listener = listener;
    }


    public class PedidosViewHolder extends RecyclerView.ViewHolder {
        TextView textViewPedidos;

        public PedidosViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPedidos = itemView.findViewById(R.id.textViewRow);
        }


        void asignarDatos(Pedido pedido) {
            String mensajePedido = "Pedido:\n" + pedido.producto + " (" + pedido.categoria + ")\n" + pedido.cantidade + "Pcs\nDireccion:\n" + pedido.cidade + "\n" + pedido.rua;
            textViewPedidos.setText(mensajePedido);
        }


    }


}