package pt.tvtime.app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Temporada {

    @PrimaryKey()
    private long idTemporada;
    private int idSerie;
    private  int idEpisodio;

    public Temporada(long idTemporada, int idSerie, int idEpisodio) {
        this.idTemporada = idTemporada;
        this.idSerie = idSerie;
        this.idEpisodio = idEpisodio;
    }

    public long getIdTemporada() {
        return idTemporada;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public int getIdEpisodio() {
        return idEpisodio;
    }

    public void setIdTemporada(long idTemporada) {
        this.idTemporada = idTemporada;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public void setIdEpisodio(int idEpisodio) {
        this.idEpisodio = idEpisodio;
    }
}
