package pt.tvtime.app.repository.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import pt.tvtime.app.model.Favorito;

import java.util.List;

@Dao
public interface FavoritosDAO {

    @Query("SELECT * FROM Favorito")
    LiveData<List<Favorito>> getAllFavoritos();

    @Update
    public void update(Favorito favorito);

    @Insert
    public void insert(Favorito favorito);

    @Insert
    public void insertAll(List<Favorito> favoritoLista);

    @Insert
    void insertFavoritos(List<Favorito> favoritoList);

    @Delete
    public void remove(Favorito favorito);



}
