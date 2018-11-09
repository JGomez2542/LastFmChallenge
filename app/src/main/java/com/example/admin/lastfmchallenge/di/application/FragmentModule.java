package com.example.admin.lastfmchallenge.di.application;

import com.example.admin.lastfmchallenge.ui.AlbumViewFragment;
import com.example.admin.lastfmchallenge.ui.RecyclerViewFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    @Provides
    RecyclerViewFragment providesRecyclerViewFragment() {
        return new RecyclerViewFragment();
    }

    @Provides
    AlbumViewFragment providesAlbumViewFragment() {
        return new AlbumViewFragment();
    }
}
