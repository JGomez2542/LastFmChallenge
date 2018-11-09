package com.example.admin.lastfmchallenge.data.repository;

import android.arch.lifecycle.LiveData;

import com.example.admin.lastfmchallenge.models.Album;

import java.util.List;

public interface Repository {

    void getAlbumsResponse(String album);

    LiveData<List<Album>> getAlbumsResponseLiveData();
}
