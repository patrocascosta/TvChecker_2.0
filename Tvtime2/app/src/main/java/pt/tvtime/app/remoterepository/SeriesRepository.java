package pt.tvtime.app.remoterepository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import pt.tvtime.app.model.Favorito;
import pt.tvtime.app.remoterepository.remote.GetSeriesDataSource;
import pt.tvtime.app.remoterepository.remote.GetSeriesService;
import pt.tvtime.app.repository.local.AppDatabase;

public class SeriesRepository {

    private static SeriesRepository INSTANCE;


    public static SeriesRepository getInstance(Context context){
        if (INSTANCE == null) INSTANCE = new SeriesRepository(context);
        return INSTANCE;
    }

    private AppDatabase appDatabase;
    private GetSeriesService service;

    private SeriesRepository(Context context){
        this.appDatabase = AppDatabase.getInstance(context);
        this.service = GetSeriesDataSource.getService();
    }

    private LiveData<List<Favorito>> listLiveDataFavoritos;

    public LiveData<List<Favorito>> getAllFavoritos(){
        if (listLiveDataFavoritos == null) listLiveDataFavoritos = AppDatabase.getInstance(this).getFavoritosDAO().getAllFavoritos();
        return listLiveDataFavoritos;
    }

}
