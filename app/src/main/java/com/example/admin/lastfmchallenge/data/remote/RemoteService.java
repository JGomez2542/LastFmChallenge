package com.example.admin.lastfmchallenge.data.remote;

import com.example.admin.lastfmchallenge.models.AlbumsResponse;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RemoteService {

    @GET("2.0/")
    Single<AlbumsResponse> getAlbumsResponse(@QueryMap Map<String, String> options);
}
