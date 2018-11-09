package com.example.admin.lastfmchallenge.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.admin.lastfmchallenge.models.Album;

public class CommunicatorViewModel extends ViewModel {

    private MutableLiveData<Album> albumMutableLiveData;

    public CommunicatorViewModel(MutableLiveData<Album> albumMutableLiveData) {
        this.albumMutableLiveData = albumMutableLiveData;
    }

    public LiveData<Album> getAlbum() {
        return albumMutableLiveData;
    }

    public void setAlbumLiveData(Album album) {
        albumMutableLiveData.setValue(album);
    }
}
