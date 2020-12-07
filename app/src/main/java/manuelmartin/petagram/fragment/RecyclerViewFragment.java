package manuelmartin.petagram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import manuelmartin.petagram.adapter.Adaptador;
import manuelmartin.petagram.Mascota;
import manuelmartin.petagram.R;

public class RecyclerViewFragment extends Fragment {

    //Declaración de variables y objetos
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Asignamos la clase al layout

        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaMascotas = view.findViewById(R.id.rvMascotas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        listaMascotas.setLayoutManager(linearLayoutManager);
        inicializarListaMascotas();
        inicializarAdaptador();


        return view;
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.gato, "Fluffy", 3));
        mascotas.add(new Mascota(R.drawable.gato2, "SnowBall", 1));
        mascotas.add(new Mascota(R.drawable.husky, "Rocky", 6));
        mascotas.add(new Mascota(R.drawable.mapache, "Thief", 4));
        mascotas.add(new Mascota(R.drawable.caniche, "Lanitas", 8));
        mascotas.add(new Mascota(R.drawable.cerdito, "Babe", 5));


    }

    public void inicializarAdaptador (){

        Adaptador adaptador = new Adaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public ArrayList obtenerMascotas(){

        return mascotas;
    }
}
