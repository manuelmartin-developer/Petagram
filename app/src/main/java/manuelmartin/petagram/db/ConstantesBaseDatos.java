package manuelmartin.petagram.db;

public class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;


    // Almacenamos las constantes de la base de datos en esta clase por practicidad y mantenimiento
    public static final String TABLE_PETS           = "mascota";
    public static final String TABLE_PETS_ID        = "id";
    public static final String TABLE_PETS_NAME      = "nombre";
    public static final String TABLE_PETS_PHOTO     = "foto";


    public static final String TABLE_LIKES_PET              = "mascota_likes";
    public static final String TABLE_LIKES_PET_ID           = "id" ;
    public static final String TABLE_LIKES_PET_ID_MASCOTA   = "id_mascota" ;
    public static final String TABLE_LIKES_PET_NUMERO_LIKES = "numero_likes" ;
}
