package pt.tvtime.app.repository.local.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import pt.tvtime.app.model.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * From User")
    public List<User>GetAllUsers();

    @Update
    public void update(User User);

    @Insert
    public void insert(User User);

    @Insert
    public void insertAll(List<User> InsertAll);

    @Query("SELECT * FROM User WHERE email = :email")
    User getUserByEmail(String email);

}
