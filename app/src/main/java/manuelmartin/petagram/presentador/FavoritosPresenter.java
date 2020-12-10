package manuelmartin.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import manuelmartin.petagram.ITop5;
import manuelmartin.petagram.db.ConstructorMascotas;
import manuelmartin.petagram.pojo.Mascota;

public class FavoritosPresenter implements IFavoritosPresenter {

    private ITop5 iTop5;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;


    public FavoritosPresenter (ITop5 iTop5, Context context){
        this.iTop5=iTop5;
        this.context=context;
        obtenerMascotasFavoritasBaseDatos();
    }

    @Override
    public void obtenerMascotasFavoritasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotasFavoritas();
        mostrarMascotasFavoritasRV();

    }

    @Override
    public void mostrarMascotasFavoritasRV() {
        iTop5.inicializarAdaptadorRV(iTop5.crearAdaptador(mascotas));
        iTop5.generarLinearLayoutVertical();

    }
}
