package manuelmartin.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import manuelmartin.petagram.db.ConstructorMascotas;
import manuelmartin.petagram.fragment.IRecyclerViewFragmentView;
import manuelmartin.petagram.pojo.Mascota;

public class RecyclerViewFragmentPresenter implements IReciclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerVewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerVewFragmentView, Context context) {

        this.iRecyclerVewFragmentView= iRecyclerVewFragmentView;
        this.context=context;
        obtenerMascotasBBDD();
    }



    @Override
    public void obtenerMascotasBBDD() {

        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {

        iRecyclerVewFragmentView.inicializarAdaptadorRV(iRecyclerVewFragmentView.crearAdaptador(mascotas));
        iRecyclerVewFragmentView.generarLayoutVertical();

    }
}
