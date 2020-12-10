package manuelmartin.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import manuelmartin.petagram.adapter.FavoritosAdaptador;
import manuelmartin.petagram.adapter.MascotaAdaptador;
import manuelmartin.petagram.pojo.Mascota;
import manuelmartin.petagram.presentador.FavoritosPresenter;
import manuelmartin.petagram.presentador.IFavoritosPresenter;

public class Top5 extends AppCompatActivity implements ITop5 {

    // Declaración de objetos y variables

    ArrayList<Mascota> mascotas;
    private IFavoritosPresenter presenter;
    private RecyclerView listaMascotas;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);

        setSupportActionBar(findViewById(R.id.toolBar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = findViewById(R.id.rvLikeMascotas);
        presenter = new FavoritosPresenter(this, this);

    }




    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        listaMascotas.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);

        return adaptador;
    }


    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

}