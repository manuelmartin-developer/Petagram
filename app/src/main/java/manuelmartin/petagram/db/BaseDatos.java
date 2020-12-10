package manuelmartin.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import manuelmartin.petagram.pojo.Mascota;


public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    // Método Constructor
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PETS + "(" +
            ConstantesBaseDatos.TABLE_PETS_ID    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ConstantesBaseDatos.TABLE_PETS_NAME  + " TEXT, " +
            ConstantesBaseDatos.TABLE_PETS_PHOTO + " INTEGER" +
            ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_PET+"(" +
                ConstantesBaseDatos.TABLE_LIKES_PET_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA  + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY(" + ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_PETS + "(" + ConstantesBaseDatos.TABLE_PETS_ID +")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_PET);

        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();

            mascotaActual.setId(registros.getString(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            mascotas.add(mascotaActual);

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + ") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA + "=" + mascotaActual.getId();
            Cursor registroLikes = db.rawQuery(queryLikes, null);
            if(registroLikes.moveToNext()) {
                mascotaActual.setLikes(registroLikes.getInt(0));
            }else{
                mascotaActual.setLikes(0);
            }
        }
        db.close();
        return mascotas;

    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT m.*, (SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES+")"+
                " FROM "+ConstantesBaseDatos.TABLE_LIKES_PET+
                " WHERE "+ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA+"=m.id) as likes"+
                " FROM "+ConstantesBaseDatos.TABLE_PETS+" m"+
                " ORDER BY likes DESC"+
                " LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(String.valueOf(registros.getInt(0)));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            mascotas.add(mascotaActual);

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES + ") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA + "=" + mascotaActual.getId();
            Cursor registroLikes = db.rawQuery(queryLikes, null);

            if(registroLikes.moveToNext()){
                mascotaActual.setLikes(registroLikes.getInt(0));
            }
            else {
                mascotaActual.setLikes(0);
            }
        }
        db.close();
        return mascotas;
    }



    public void insertarMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS, null, contentValues);

        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_PET, null, contentValues);
        db.close();

    }

    public int obtenerLikesMascota (Mascota mascota){

        int likes = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES+")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_PET + " WHERE " + ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA +
                " = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){

            likes = registros.getInt(0);
        }
        db.close();

        return likes;
    }
}
