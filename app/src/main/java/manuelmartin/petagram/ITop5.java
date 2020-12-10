package manuelmartin.petagram;

import java.util.ArrayList;

import manuelmartin.petagram.adapter.MascotaAdaptador;
import manuelmartin.petagram.pojo.Mascota;

public interface ITop5 {

    void generarLinearLayoutVertical();

    MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
