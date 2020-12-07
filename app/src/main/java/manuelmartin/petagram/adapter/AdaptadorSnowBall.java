package manuelmartin.petagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import manuelmartin.petagram.R;
import manuelmartin.petagram.SnowBall;

public class AdaptadorSnowBall extends RecyclerView.Adapter<AdaptadorSnowBall.PerfilViewHolder> {

    ArrayList<SnowBall> snowBalls;

    public AdaptadorSnowBall(ArrayList<SnowBall> snowBalls){
        this.snowBalls=snowBalls;
    }


    // Inflará el layout y lo pasará al viewholder para que obtenga las views
    @NonNull
    @Override
    public  PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_snowball, parent, false);

        return new PerfilViewHolder(view);
    }

    // Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder perfilViewHolder, int position) {

        final SnowBall snowBall = snowBalls.get(position);
        perfilViewHolder.imgFoto.setImageResource(snowBall.getFoto());
        perfilViewHolder.numberBones.setText(String.valueOf(snowBall.getLikes()));

    }


    @Override
    public int getItemCount() {
        return snowBalls.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView numberBones;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = itemView.findViewById(R.id.imgFoto2);
            numberBones = itemView.findViewById(R.id.numberBones2);
        }
    }
}
