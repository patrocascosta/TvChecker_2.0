package pt.tvtime.app.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Episodio {

    @PrimaryKey(autoGenerate = true)
    private long idEpisodio;
    private String nomeEpisodio;
    private int duracao;
    private int idTemporada;

    public Episodio(long idEpisodio, String nomeEpisodio, int duracao, int idTemporada) {
        this.idEpisodio = idEpisodio;
        this.nomeEpisodio = nomeEpisodio;
        this.duracao = duracao;
        this.idTemporada = idTemporada;
    }


    public long getIdEpisodio() {
        return idEpisodio;
    }

    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getIdTemporada() {
        return idTemporada;
    }

    public void setIdEpisodio(long idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setIdTemporada(int idTemporada) {
        this.idTemporada = idTemporada;
    }
}
