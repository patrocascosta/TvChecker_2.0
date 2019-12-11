package pt.tvtime.app.repository.local;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import pt.tvtime.app.model.User;
import pt.tvtime.app.repository.local.dao.UserDAO;

@Database(entities = {User.class},version=1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDAO getUserDAO();

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
                            db.execSQL("INSERT INTO User(password, email, nacionalidade)"+ "VALUES('123','123','Potuguesa')");
                        }
                    })

                    .build();
        }
        return INSTANCE;
    }

}
