package manuelmartin.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import manuelmartin.petagram.Mascota;
import manuelmartin.petagram.R;
import manuelmartin.petagram.db.ConstructorMascotas;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MascotasViewHolder> {

    // Declaración de variables y objetos
    private Activity activity;
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
        mascotasViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        mascotasViewHolder.btnLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(activity, "Has dado like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);

                mascotasViewHolder.tvLikes.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));

            }
        });
    }

    // Devuelve la cantidad de elementos que contiene la lista

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imgfoto;
        private final TextView tvNombre;
        private final TextView tvLikes;
        private final ImageButton btnLikes;

        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);

            imgfoto     = itemView.findViewById(R.id.imgFoto);
            tvNombre    = itemView.findViewById(R.id.tvNombre);
            tvLikes     = itemView.findViewById(R.id.tvLikes);
            btnLikes    = itemView.findViewById(R.id.btnLike);

        }
    }
}
