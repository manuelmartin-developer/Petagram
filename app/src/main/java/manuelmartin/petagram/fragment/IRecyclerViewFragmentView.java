package manuelmartin.petagram.fragment;

import java.util.ArrayList;

import manuelmartin.petagram.adapter.MascotaAdaptador;
import manuelmartin.petagram.pojo.Mascota;

public interface IRecyclerViewFragmentView {

    void generarLayoutVertical();

    MascotaAdaptador crearAdaptador (ArrayList<Mascota> mascotas);

    void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador);

}
