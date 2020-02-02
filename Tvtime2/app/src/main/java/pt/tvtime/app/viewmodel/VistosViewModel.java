package pt.tvtime.app.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import pt.tvtime.app.model.Favorito;
import pt.tvtime.app.model.Visto;
import pt.tvtime.app.remoterepository.SeriesRepository;
import pt.tvtime.app.ui.VistosFragment;

public class VistosViewModel extends ViewModel {

    public LiveData<List<Visto>> getVistos(Context context){
        return SeriesRepository.getInstance(context).getAllVistos();
    }

    public void updateVistos(Context context){
        SeriesRepository.getInstance(context).upDateVistos();
    }
}
