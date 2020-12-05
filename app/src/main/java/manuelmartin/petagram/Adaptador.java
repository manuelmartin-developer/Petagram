package manuelmartin.petagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MascotasViewHolder> {

    // Declaración de variables y objetos
    ArrayList <Mascota> mascotas;

    // Método Constructor

    public Adaptador(ArrayList <Mascota> mascotas){
        this.mascotas=mascotas;
    }


    // va a inflar el layout y lo pasará al viewHolder para que él obtenga cada view.
    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascota, parent, false);
        return new MascotasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder mascotasViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotasViewHolder.imgfoto.setImageResource(mascota.getFoto());
        mascotasViewHolder.tvNombre.setText(mascota.getNombre());
        mascotasViewHolder.numberBones.setText(String.valueOf(mascota.getLikes()));


    }

    // Devuelve la cantidad de elementos que contiene la lista

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgfoto;
        private TextView tvNombre, numberBones;

        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);

            imgfoto = itemView.findViewById(R.id.imgFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            numberBones = itemView.findViewById(R.id.numberBones);

        }
    }
}
