package manuelmartin.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import manuelmartin.petagram.adapter.PageAdapter;
import manuelmartin.petagram.fragment.PerfilFragment;
import manuelmartin.petagram.fragment.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    // Declaración de objetos y variables

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    private Mascota mascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Menú Opciones
        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.top5:
                abrirTop5();
                break;

            case R.id.mContacto:
                Intent intent = new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;

            case R.id.mAcercade:
                Intent intent2 = new Intent(this, AcercaActivity.class);
                startActivity(intent2);

        }

        return super.onOptionsItemSelected(item);
    }



    public void abrirTop5(){
        Intent intent = new Intent(getApplicationContext(), Top5.class);

        startActivity(intent);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments(),2));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.fragment1);
        tabLayout.getTabAt(1).setIcon(R.drawable.fragment2);
    }





}