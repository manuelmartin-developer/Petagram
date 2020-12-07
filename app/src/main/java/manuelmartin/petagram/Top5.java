package manuelmartin.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import manuelmartin.petagram.adapter.Adaptador;

public class Top5 extends AppCompatActivity {

    // Declaración de objetos y variables

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);

        setSupportActionBar(findViewById(R.id.toolBar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        listaMascotas.setLayoutManager(linearLayoutManager);
        inicializarListaMascotas();
        inicializarAdaptador();

    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.caniche, "Lanitas", 8));
        mascotas.add(new Mascota(R.drawable.husky, "Rocky", 6));
        mascotas.add(new Mascota(R.drawable.cerdito, "Babe", 5));
        mascotas.add(new Mascota(R.drawable.mapache, "Thief", 4));
        mascotas.add(new Mascota(R.drawable.gato, "Fluffy", 3));

    }

    public void inicializarAdaptador (){

        Adaptador adaptador = new Adaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
}