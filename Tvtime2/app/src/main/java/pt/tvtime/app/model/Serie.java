package pt.tvtime.app.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Serie {

    @PrimaryKey()
    private long idSerie;
    private String nomeSerie;
    private long idCategoria;
    private String imdb;
    private String descricao;
    private String  imagem;
    public Boolean visto;

    public Serie(long idSerie, String nomeSerie, long idCategoria, String imdb, String descricao, String imagem) {
        this.idSerie = idSerie;
        this.nomeSerie = nomeSerie;
        this.idCategoria = idCategoria;
        this.imdb = imdb;
        this.descricao = descricao;
        this.imagem = imagem;
    }


    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
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
    public long getIdCategoria() {
        return idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeSerie() {
        return nomeSerie;
    }

    public String getImagem() { return imagem;}

    public String getImdb() {
        return imdb;
    }


    public void setIdSerie(long idSerie) {
        this.idSerie = idSerie;
    }

    public void setNomeSerie(String nomeSerie) {
        this.nomeSerie = nomeSerie;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
