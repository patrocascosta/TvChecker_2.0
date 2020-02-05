package pt.tvtime.app.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Categoria {

    @PrimaryKey(autoGenerate = true)
    private int idCategoria;
    private String nomeCategoria;


    public Categoria(int idCategoria, String nomeCategoria){
        this.idCategoria= idCategoria;
        this.nomeCategoria=nomeCategoria;

    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
