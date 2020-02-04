package pt.tvtime.app.remoterepository.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetSeriesDataSource {

    private static GetSeriesService service = new Retrofit.Builder()
            .baseUrl("http://my-json-server.typicode.com/godofanimes/Series/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GetSeriesService.class);

   /* private static GetSeriesService service = new Retrofit.Builder()
            .baseUrl("http://localhost:8000/api/serie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GetSeriesService.class);*/

    public static GetSeriesService getService() {return service;}
}
