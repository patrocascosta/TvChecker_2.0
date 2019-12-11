package pt.tvtime.app.repository.local.dao;



import androidx.room.Dao;
import androidx.room.Query;

import pt.tvtime.app.model.Temporada;

import java.util.List;

@Dao
public interface TemporadasDAO {
    @Query("SELECT * FROM Temporada")
    public List<Temporada> getAllTemporadas();
}

