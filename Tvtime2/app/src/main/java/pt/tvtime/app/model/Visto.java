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


}
