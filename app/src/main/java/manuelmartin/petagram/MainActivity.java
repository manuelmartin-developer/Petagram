package manuelmartin.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declaración de objetos y variables

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private Mascota mascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        listaMascotas.setLayoutManager(linearLayoutManager);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.top5:
                abrirTop5();

        }

        return super.onOptionsItemSelected(item);
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

    public void abrirTop5(){
        Intent intent = new Intent(this, Top5.class);

        startActivity(intent);
    }

    public ArrayList obtenerMascotas(){

        return mascotas;
    }

}