package com.example.admin.lastfmchallenge.di.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentActivity;

import com.example.admin.lastfmchallenge.R;
import com.example.admin.lastfmchallenge.databinding.ActivityMainBinding;
import com.example.admin.lastfmchallenge.factories.CommunicatorViewModelFactory;
import com.example.admin.lastfmchallenge.factories.MainViewModelFactory;
import com.example.admin.lastfmchallenge.ui.CommunicatorViewModel;
import com.example.admin.lastfmchallenge.ui.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private FragmentActivity activity;

    public ActivityModule(FragmentActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public ActivityMainBinding providesActivityBinding() {
        return DataBindingUtil.setContentView(activity, R.layout.activity_main);
    }

    @Provides
    @ActivityScope
    public CommunicatorViewModel providesCommunicatorViewModel(CommunicatorViewModelFactory factory) {
        return ViewModelProviders.of(activity, factory).get(CommunicatorViewModel.class);
    }

    @Provides
    @ActivityScope
    public MainViewModel providesMainViewModel(MainViewModelFactory factory) {
        return ViewModelProviders.of(activity, factory).get(MainViewModel.class);
    }
}
