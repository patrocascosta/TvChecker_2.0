package pt.tvtime.app.remoterepository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import pt.tvtime.app.model.Favorito;
import pt.tvtime.app.model.Serie;
import pt.tvtime.app.model.Visto;
import pt.tvtime.app.remoterepository.remote.GetSeriesDataSource;
import pt.tvtime.app.repository.local.AppDatabase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesRepository {

    private static SeriesRepository seriesRepository;
    private Context context;

    private SeriesRepository(Context context){
        this.context = context.getApplicationContext();
    }

    public static SeriesRepository getInstance(Context context){
        if (seriesRepository == null) seriesRepository = new SeriesRepository(context);
        return seriesRepository;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------

    private LiveData<List<Favorito>> listLiveDataFavoritos;

    public LiveData<List<Favorito>> getAllFavoritos(){
        if (listLiveDataFavoritos == null) listLiveDataFavoritos = AppDatabase.getInstance(context).getFavoritosDAO().getAllFavoritos();
        return listLiveDataFavoritos;
    }

    public void upDateFavoritos(){
        Call<List<Favorito>> call = GetSeriesDataSource.getService().getFavoritos();
        call.enqueue(new Callback<List<Favorito>>() {
            @Override
            public void onResponse(Call<List<Favorito>> call, Response<List<Favorito>> response) {
                if (response.isSuccessful()){
                    final List<Favorito> favoritoList = response.body();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            AppDatabase.getInstance(context).getFavoritosDAO().insertFavoritos(favoritoList);
                        }
                    }).start();
                }
            }

            @Override
            public void onFailure(Call<List<Favorito>> call, Throwable t) {

            }
        });
    }

    private LiveData<List<Serie>> listLiveDataSerie;

    public  LiveData<List<Serie>> getAllSeries(){
        if (listLiveDataSerie == null) listLiveDataSerie = AppDatabase.getInstance(context).getSeriesDAO().getAllSeries();
        return listLiveDataSerie;
    }

    public void upDateSerie(){
        Call<List<Serie>> call = GetSeriesDataSource.getService().getSeries();
        call.enqueue(new Callback<List<Serie>>() {
            @Override
            public void onResponse(Call<List<Serie>> call, Response<List<Serie>> response) {
                if (response.isSuccessful()){
                    final List<Serie> serieList = response.body();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            AppDatabase.getInstance(context).getSeriesDAO().insertSeries(serieList);
                        }
                    }).start();
                }
            }

            @Override
            public void onFailure(Call<List<Serie>> call, Throwable t) {

            }
        });
    }

    private LiveData<List<Visto>> listLiveDataVisto;

    public LiveData<List<Visto>> getAllVistos(){
        if (listLiveDataVisto == null) listLiveDataVisto = AppDatabase.getInstance(context).getVistosDAO().getAllVistos();
        return listLiveDataVisto;
    }

    public void upDateVistos(){
        Call<List<Visto>> call = GetSeriesDataSource.getService().getVistos();
        call.enqueue(new Callback<List<Visto>>() {
            @Override
            public void onResponse(Call<List<Visto>> call, Response<List<Visto>> response) {
                if (response.isSuccessful()){
                    final List<Visto> vistoList = response.body();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            AppDatabase.getInstance(context).getVistosDAO().getAllVistos();
                        }
                    }).start();
                }
            }

            @Override
            public void onFailure(Call<List<Visto>> call, Throwable t) {

            }
        });

    }

}
