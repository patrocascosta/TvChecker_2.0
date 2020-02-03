package pt.tvtime.app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Array;
import java.util.ArrayList;

@Entity
public class Serie {

    @PrimaryKey(autoGenerate = true)
    private long idSerie;
    private String nomeSerie;
    //private ArrayList idCategoria;
    private String imdb;
    private String descricao;
    private String image;
    public Boolean visto;

    public Serie(long idSerie, String nomeSerie,/* ArrayList idCategoria,*/ String imdb, String descricao, String image) {
        this.idSerie = idSerie;
        this.nomeSerie = nomeSerie;
        //this.idCategoria = idCategoria;
        this.imdb = imdb;
        this.descricao = descricao;
        this.image = image;
    }


    public Boolean getVisto() {
        return visto;
    }

    public void setVisto(Boolean visto) {
        this.visto = visto;
    }

    public long getIdSerie() {
        return idSerie;
    }


    public String Imdb() {
        return imdb;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeSerie() {
        return nomeSerie;
    }


    public String getImdb() {
        return imdb;
    }


    public void setIdSerie(long idSerie) {
        this.idSerie = idSerie;
    }

    public void setNomeSerie(String nomeSerie) {
        this.nomeSerie = nomeSerie;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   /* public Array getIdCategoria() {
        return (Array) idCategoria;
    }

    public void setIdCategoria(ArrayList idCategoria) {
        this.idCategoria = idCategoria;
    }*/
}
