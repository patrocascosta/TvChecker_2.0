package pt.tvtime.app.repository.local.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import pt.tvtime.app.model.Episodio;

import java.util.List;

@Dao
public interface EpisodiosDAO {

    @Query("SELECT * FROM Episodio")
    public List<Episodio> getAllEpisodios();

    @Update
    public void update(Episodio episodio);

    @Insert
    public void insert(Episodio episodio);

    @Insert
    public void insertAll(List<Episodio> episodios);

    @Delete
    public void remove(Episodio episodio);

}
