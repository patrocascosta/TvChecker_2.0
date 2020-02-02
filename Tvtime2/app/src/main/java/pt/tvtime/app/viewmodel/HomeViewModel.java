package pt.tvtime.app.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import pt.tvtime.app.model.Serie;
import pt.tvtime.app.remoterepository.SeriesRepository;

public class HomeViewModel extends ViewModel {

    public LiveData<List<Serie>> getHomeSeries(Context context){
        return SeriesRepository.getInstance(context).getAllSeries();
    }

    public void updateHome(Context context){
        SeriesRepository.getInstance(context).upDateSerie();
    }
}
