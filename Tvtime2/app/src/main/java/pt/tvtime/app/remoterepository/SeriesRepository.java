package pt.tvtime.app.remoterepository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import pt.tvtime.app.remoterepository.remote.GetSeriesService;
import pt.tvtime.app.repository.local.AppDatabase;

public class SeriesRepository {

    private static SeriesRepository INSTANCE;


    public static SeriesRepository getInstance(Context context){
        if (INSTANCE == null) INSTANCE = new SeriesRepository(context);
        return INSTANCE;
    }

    private AppDatabase appDatabase;
    private SeriesRepository service;

    private SeriesRepository(Context context){
        this.appDatabase = AppDatabase.getInstance(context);
        this.service = GetSeriesService.getService();
    }

}
