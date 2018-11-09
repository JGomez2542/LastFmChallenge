package com.example.admin.lastfmchallenge.di.application;

import android.arch.lifecycle.MutableLiveData;

import com.example.admin.lastfmchallenge.models.Album;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class LiveDataModule {

    @Provides
    public MutableLiveData<List<Album>> providesAlbumsMutableLiveData() {
        return new MutableLiveData<>();
    }

    @Provides
    public MutableLiveData<Album> providesAlbumMutableLiveData() {
        return new MutableLiveData<>();
    }
}
