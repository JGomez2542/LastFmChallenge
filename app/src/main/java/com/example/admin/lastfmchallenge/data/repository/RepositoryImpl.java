package com.example.admin.lastfmchallenge.data.repository;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.admin.lastfmchallenge.data.remote.RemoteServiceHelper;
import com.example.admin.lastfmchallenge.models.Album;
import com.example.admin.lastfmchallenge.utils.Constants;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RepositoryImpl implements Repository {

    private RemoteServiceHelper remoteServiceHelper;
    private MutableLiveData<List<Album>> albumsResponseLiveData;

    public RepositoryImpl(RemoteServiceHelper remoteServiceHelper, MutableLiveData<List<Album>> albumsResponseLiveData) {
        this.remoteServiceHelper = remoteServiceHelper;
        this.albumsResponseLiveData = albumsResponseLiveData;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getAlbumsResponse(String album) {
        remoteServiceHelper.getAlbumsResponse(Constants.SEARCH_TYPE, album, Constants.API_KEY, Constants.FORMAT)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(albumsResponse -> albumsResponse.getResults().getAlbummatches().getAlbum())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(albums -> albumsResponseLiveData.setValue(albums), Throwable::printStackTrace);
    }

    @Override
    public LiveData<List<Album>> getAlbumsResponseLiveData() {
        return albumsResponseLiveData;
    }
}
