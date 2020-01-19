package pt.tvtime.app.remoterepository.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetSeriesDataSource {

    private static GetSeriesService service = new Retrofit.Builder()
            .baseURL("")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GetSeriesService.class);

    public static GetSeriesService getService() {return service;}
}
