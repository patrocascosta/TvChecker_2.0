package pt.tvtime.app.repository.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import pt.tvtime.app.model.Serie;
import pt.tvtime.app.model.Visto;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface VistosDAO {

    @Query("SELECT * FROM Visto")
    LiveData<List<Visto>> getAllVistos();

    @Update
    public void update(Visto visto);

    @Update
    public void updateAll(List<Visto> vistoList);

    @Query("SELECT * FROM visto WHERE idSerie= :id")
    Visto getVistosBySerieId(long id);

    @Insert(onConflict = REPLACE)
    void insertVistos(List<Visto> vistoList);

   // @Query("SELECT idSerie FROM visto WHERE visto= 'True' ")
    //Visto getSerieIdVisto (boolean visto);



}
