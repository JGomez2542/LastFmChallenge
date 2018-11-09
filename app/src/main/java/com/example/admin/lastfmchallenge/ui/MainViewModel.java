package com.example.admin.lastfmchallenge.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.admin.lastfmchallenge.adapters.AlbumsListAdapter;
import com.example.admin.lastfmchallenge.data.repository.Repository;


public class MainViewModel extends ViewModel {

    private Repository repository;
    private CommunicatorViewModel communicatorViewModel;
    private final String TAG = "MainViewModel";

    public MainViewModel(Repository repository, CommunicatorViewModel communicatorViewModel) {
        this.repository = repository;
        this.communicatorViewModel = communicatorViewModel;
    }

    public void getAlbums(String album) {
        Log.d(TAG, "getAlbums: " + album);
        repository.getAlbumsResponse(album);

    }

    public LiveData<AlbumsListAdapter> getAlbumsLiveData() {
        return Transformations.map(repository.getAlbumsResponseLiveData(), albums -> {
            Log.d(TAG, "getAlbumsLiveData: " + albums.size());
            return new AlbumsListAdapter(albums, communicatorViewModel);
        });
    }
}
