package com.example.admin.lastfmchallenge.factories;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.admin.lastfmchallenge.data.repository.Repository;
import com.example.admin.lastfmchallenge.ui.CommunicatorViewModel;
import com.example.admin.lastfmchallenge.ui.MainViewModel;

import javax.inject.Inject;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private Repository repository;
    private CommunicatorViewModel communicatorViewModel;

    @Inject
    public MainViewModelFactory(Repository repository, CommunicatorViewModel communicatorViewModel) {
        this.repository = repository;
        this.communicatorViewModel = communicatorViewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(repository, communicatorViewModel);
        } else {
            throw new IllegalArgumentException("ViewModel not found");
        }
    }
}
