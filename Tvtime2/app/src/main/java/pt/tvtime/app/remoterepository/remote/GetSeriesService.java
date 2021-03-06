package pt.tvtime.app.remoterepository.remote;

import java.util.List;

import pt.tvtime.app.model.Favorito;
import pt.tvtime.app.model.Serie;
import pt.tvtime.app.model.Visto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetSeriesService {

    @GET("series")
    Call<List<Serie>> getSeries();

    @GET("favoritos")
    Call<List<Favorito>> getFavoritos();

    @GET("visto")
    Call<List<Visto>> getVistos();


    /*@GET("series/")
    Call<List<Serie>> getSeries();

    @GET("favoritos/")
    Call<List<Favorito>> getFavoritos();

    @GET("visto/")
    Call<List<Visto>> getVistos();*/
}
