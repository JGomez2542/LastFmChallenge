package com.example.admin.lastfmchallenge.di.application;

import android.arch.lifecycle.MutableLiveData;

import com.example.admin.lastfmchallenge.data.remote.RemoteServiceHelper;
import com.example.admin.lastfmchallenge.data.repository.Repository;
import com.example.admin.lastfmchallenge.data.repository.RepositoryImpl;
import com.example.admin.lastfmchallenge.models.Album;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    @ApplicationScope
    public RemoteServiceHelper providesRemoteServiceHelper() {
        return new RemoteServiceHelper();
    }

    @Provides
    @ApplicationScope
    public Repository providesRepository(RemoteServiceHelper remoteServiceHelper, MutableLiveData<List<Album>> listMutableLiveData) {
        return new RepositoryImpl(remoteServiceHelper, listMutableLiveData);
    }
}
