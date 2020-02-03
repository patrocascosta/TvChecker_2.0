package pt.tvtime.app.repository.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import pt.tvtime.app.model.Serie;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface SeriesDAO {

    @Query("SELECT * FROM Serie")
    LiveData<List<Serie>> getAllSeries();

    /*@Query("SELECT * FROM Serie WHERE idCategoria = :id")
    LiveData<List<Serie>> getSeriesByCategory(ArrayList id);*/

    @Query("SELECT * FROM serie WHERE idSerie= :id")
    Serie getSerieById(long id);

    @Query("SELECT *FROM serie WHERE image = :image")
    Serie getSeriebyImage(String image);

    @Insert(onConflict = REPLACE)
    void insertSeries(List<Serie> serieList);

   // @Query("SELECT *FROM serie WHERE visto= 'true'")
   // List<Serie> getSeriebyVistos(Boolean visto);


}
