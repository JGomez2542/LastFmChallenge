package com.example.admin.lastfmchallenge.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.admin.lastfmchallenge.AppController;
import com.example.admin.lastfmchallenge.R;
import com.example.admin.lastfmchallenge.databinding.ActivityMainBinding;
import com.example.admin.lastfmchallenge.di.activity.ActivityComponent;
import com.example.admin.lastfmchallenge.di.activity.ActivityModule;
import com.example.admin.lastfmchallenge.utils.Constants;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    CommunicatorViewModel communicatorViewModel;

    @Inject
    MainViewModel mainViewModel;

    @Inject
    ActivityMainBinding binding;

    @Inject
    RecyclerViewFragment recyclerViewFragment;

    @Inject
    AlbumViewFragment albumViewFragment;

    ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        setUpFragments();
        binding.setMainViewModel(mainViewModel);
    }

    private void setUpFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.recyclerFrag, recyclerViewFragment, Constants.RECYCLER_FRAGMENT_TAG)
                .add(R.id.albumFrag, albumViewFragment, Constants.ALBUM_FRAGMENT_TAG)
                .commit();
    }

    private void injectDependencies() {
        activityComponent = ((AppController) getApplication()).getApplicationComponent().newActivityComponent(new ActivityModule(this));
        activityComponent.inject(this);
    }
}
