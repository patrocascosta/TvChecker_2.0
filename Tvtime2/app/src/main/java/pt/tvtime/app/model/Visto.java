package pt.tvtime.app.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Visto {

    @PrimaryKey()
    private long id;
    private long idUser;
    private long idSerie;
    public boolean visto;
    private String image;

    public Visto(long id, long idUser, long idSerie, String image) {
        this.id = id;
        this.idUser = idUser;
        this.idSerie = idSerie;
        this.image = image;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public long getIdSerie() {
        return idSerie;
    }

    public boolean isVisto() {
        return visto;
    }


    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public void setIdSerie(long idEpisodio) {
        this.idSerie = idSerie;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }


    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }
}
