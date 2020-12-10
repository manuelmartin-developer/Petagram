package manuelmartin.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import manuelmartin.petagram.R;
import manuelmartin.petagram.pojo.Mascota;

public class FavoritosAdaptador extends RecyclerView.Adapter<FavoritosAdaptador.FavoritosViewHolder> {

    ArrayList <Mascota> mascotas;
    Activity activity;

    public FavoritosAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }


    @NonNull
    @Override
    public FavoritosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascota, parent, false);

        return new FavoritosAdaptador.FavoritosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritosAdaptador.FavoritosViewHolder favoritosViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);

        favoritosViewHolder.imgfoto.setImageResource(mascota.getFoto());
        favoritosViewHolder.tvNombre.setText(mascota.getNombre());
        favoritosViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));
    }



    @Override
    public int getItemCount() {
        return 0;
    }

    public static class FavoritosViewHolder extends RecyclerView.ViewHolder{


        private ImageView   imgfoto;
        private TextView    tvNombre;
        private ImageButton btnLikes;
        public  TextView    tvLikes;

        public FavoritosViewHolder(@NonNull View itemView) {
            super(itemView);

            imgfoto     = itemView.findViewById(R.id.imgFoto);
            tvNombre    = itemView.findViewById(R.id.tvNombre);
            btnLikes    = itemView.findViewById(R.id.btnLike);
            tvLikes     = itemView.findViewById(R.id.tvLikes);
        }
    }
}
