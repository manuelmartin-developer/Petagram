package manuelmartin.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import manuelmartin.petagram.Mascota;
import manuelmartin.petagram.R;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas (Context context) {
        this.context=context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        insertarVariasMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarVariasMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Fluffy");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.drawable.gato);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "SnowBall");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.drawable.gato2);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Rocky");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.drawable.husky);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Thief");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.drawable.mapache);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Lanitas");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.drawable.caniche);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Babe");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.drawable.cerdito);

        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES, LIKE);

        db.insertarLikeMascota(contentValues);

    }

    public int obtenerLikesMascota (Mascota mascota){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);

    }

}
