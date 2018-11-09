package com.example.admin.lastfmchallenge.data.remote;

import com.example.admin.lastfmchallenge.models.AlbumsResponse;
import com.example.admin.lastfmchallenge.utils.Constants;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteServiceHelper {

    public Single<AlbumsResponse> getAlbumsResponse(String method, String album, String apiKey, String format) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("method", method);
        queryMap.put("album", album);
        queryMap.put("api_key", apiKey);
        queryMap.put("format", format);
        Retrofit retrofit = getRetrofit();
        RemoteService service = retrofit.create(RemoteService.class);
        return service.getAlbumsResponse(queryMap);
    }

    private Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
