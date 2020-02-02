package pt.tvtime.app.repository.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import pt.tvtime.app.model.Favorito;
import pt.tvtime.app.model.Serie;

import java.util.List;

@Dao
public interface SeriesDAO {

    @Query("SELECT * FROM Serie")
    LiveData<List<Serie>> getAllSeries();

    @Query("SELECT * FROM Serie WHERE idCategoria = :id")
    List<Serie> getSeriesByCategory(long id);

    @Query("SELECT * FROM serie WHERE idSerie= :id")
    Serie getSerieById(long id);

    @Query("SELECT *FROM serie WHERE imagem = :imagem")
    Serie getSeriebyImagem(String imagem);

    @Insert
    void insertSeries(List<Serie> serieList);

   // @Query("SELECT *FROM serie WHERE visto= 'true'")
   // List<Serie> getSeriebyVistos(Boolean visto);


}
