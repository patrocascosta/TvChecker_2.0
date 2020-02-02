package pt.tvtime.app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Favorito {

    @PrimaryKey(autoGenerate = true)
    private long idUser;
    private long idSerie;
    private boolean favorito;
    private long idFavoritos;
    private String image;

    public Favorito(long idUser, long idSerie, boolean favorito, long idFavoritos, String image) {
        this.idUser = idUser;
        this.idSerie = idSerie;
        this.favorito = favorito;
        this.idFavoritos = idFavoritos;
        this.image = image;
    }



    public long getIdUser() {
        return idUser;
    }

    public long getIdSerie() {
        return idSerie;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public void setIdSerie(long idSerie) {
        this.idSerie = idSerie;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }


    public long getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(long idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
