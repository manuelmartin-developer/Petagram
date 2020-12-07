package manuelmartin.petagram;

public class SnowBall {
    private int likes, foto;

    public SnowBall(int foto, int likes) {
        this.foto = foto;
        this.likes = likes;

    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
