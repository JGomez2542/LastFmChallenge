package com.example.admin.lastfmchallenge.factories;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.admin.lastfmchallenge.models.Album;
import com.example.admin.lastfmchallenge.ui.CommunicatorViewModel;

import javax.inject.Inject;

public class CommunicatorViewModelFactory implements ViewModelProvider.Factory {

    private MutableLiveData<Album> albumMutableLiveData;

    @Inject
    public CommunicatorViewModelFactory(MutableLiveData<Album> albumMutableLiveData) {
        this.albumMutableLiveData = albumMutableLiveData;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CommunicatorViewModel.class)) {
            return (T) new CommunicatorViewModel(albumMutableLiveData);
        } else {
            throw new IllegalArgumentException("Viewmodel not found");
        }
    }
}
