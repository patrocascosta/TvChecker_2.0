package pt.tvtime.app.repository.local.dao;

import androidx.room.Dao;
import androidx.room.Query;

import pt.tvtime.app.model.Categoria;

import java.util.List;

@Dao
public interface CategoriasDAO {

    @Query(" SELECT * FROM Categoria")
    List<Categoria> getAllCategorias();

}
