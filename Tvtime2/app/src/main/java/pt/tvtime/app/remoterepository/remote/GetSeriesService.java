package pt.tvtime.app.remoterepository.remote;

import java.util.List;

import pt.tvtime.app.model.Serie;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetSeriesService {

    @GET("")
    Call<List<Serie>> getSeries();
}
