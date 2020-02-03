package pt.tvtime.app.repository.local;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import pt.tvtime.app.model.Favorito;
import pt.tvtime.app.model.Serie;
import pt.tvtime.app.model.User;
import pt.tvtime.app.model.Visto;
import pt.tvtime.app.repository.local.dao.FavoritosDAO;
import pt.tvtime.app.repository.local.dao.SeriesDAO;
import pt.tvtime.app.repository.local.dao.UserDAO;
import pt.tvtime.app.repository.local.dao.VistosDAO;

@Database(entities = {
        User.class,
        Favorito.class,
        Serie.class,
        Visto.class
},version=1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDAO getUserDAO();
    public abstract FavoritosDAO getFavoritosDAO();
    public abstract SeriesDAO getSeriesDAO();
    public abstract VistosDAO getVistosDAO();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "UserDB")
                    .allowMainThreadQueries()
                    // inserir coisas na base de dados
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            //Meter codigo sql
                            db.execSQL("INSERT INTO User(userId, email, password)"+ "VALUES('1','aaa','aaa')");
                        }
                    })

                    .build();
        }
        return INSTANCE;
    }

}
