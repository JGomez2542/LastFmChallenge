package com.example.admin.lastfmchallenge.di.activity;

import com.example.admin.lastfmchallenge.factories.CommunicatorViewModelFactory;
import com.example.admin.lastfmchallenge.factories.MainViewModelFactory;
import com.example.admin.lastfmchallenge.ui.AlbumViewFragment;
import com.example.admin.lastfmchallenge.ui.MainActivity;
import com.example.admin.lastfmchallenge.ui.RecyclerViewFragment;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    CommunicatorViewModelFactory getCommunicatorViewModelFactory();

    MainViewModelFactory getMainViewModelFactory();

    void inject(MainActivity mainActivity);

    void inject(RecyclerViewFragment recyclerViewFragment);

    void inject(AlbumViewFragment albumViewFragment);
}
