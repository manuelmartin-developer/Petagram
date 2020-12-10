package manuelmartin.petagram.pojo;

public class Mascota {

    // Declaracion de variables
    private String nombre, id;
    private int foto, likes;


    // Método Constructor

    public Mascota(){

    }

    public Mascota(String nombre, int likes){

        this.nombre=nombre;
        this.likes=likes;

    }

    public Mascota(int foto, String nombre, int likes){
        this.foto = foto;
        this.nombre=nombre;
        this.likes=likes;
    }

    // Getters y Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Método toString()


    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", foto=" + foto +
                ", likes=" + likes +
                '}';
    }
}
