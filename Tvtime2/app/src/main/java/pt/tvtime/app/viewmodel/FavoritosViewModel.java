package pt.tvtime.app.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import pt.tvtime.app.model.Favorito;
import pt.tvtime.app.remoterepository.SeriesRepository;

public class FavoritosViewModel extends ViewModel {

    public LiveData<List<Favorito>> getFavoritos(Context context){
        return SeriesRepository.getInstance(context).getAllFavoritos();
    }

    public void updateFavoritos(Context context){
        SeriesRepository.getInstance(context).upDateFavoritos();
    }
}
