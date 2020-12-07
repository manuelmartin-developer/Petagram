package manuelmartin.petagram.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import manuelmartin.petagram.adapter.AdaptadorSnowBall;
import manuelmartin.petagram.R;
import manuelmartin.petagram.SnowBall;


public class PerfilFragment extends Fragment {

    //Declaración de variables y objetos

    private RecyclerView listaPerfil;
    private ArrayList<SnowBall> snowballs = new ArrayList<>();

    public AdaptadorSnowBall adaptadorSnowBall;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaPerfil = view.findViewById(R.id.rvPerfil);


        listaPerfil.setLayoutManager(new GridLayoutManager(getContext(),3));

        inicializarAdaptadorPerfil();
        inicializarPerfil();

        return view;
    }


    private void inicializarAdaptadorPerfil (){
        adaptadorSnowBall = new AdaptadorSnowBall(snowballs);
        listaPerfil.setAdapter(adaptadorSnowBall);
    }

    private void inicializarPerfil(){

        snowballs.add(new SnowBall(R.drawable.gato2_2, 3));
        snowballs.add(new SnowBall(R.drawable.gato2_3, 5));
        snowballs.add(new SnowBall(R.drawable.gato2_4, 9));
        snowballs.add(new SnowBall(R.drawable.gato2_5, 12));
        snowballs.add(new SnowBall(R.drawable.gato2_6, 1));
        snowballs.add(new SnowBall(R.drawable.gato2_7, 0));
        snowballs.add(new SnowBall(R.drawable.gato2_8, 5));
        snowballs.add(new SnowBall(R.drawable.gato2_9, 2));
        snowballs.add(new SnowBall(R.drawable.gato2_10, 45));
        snowballs.add(new SnowBall(R.drawable.gato2_11, 8));

    }


}
