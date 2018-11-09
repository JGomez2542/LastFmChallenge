package com.example.admin.lastfmchallenge.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.lastfmchallenge.R;
import com.example.admin.lastfmchallenge.databinding.RecyclerFragmentBinding;

import javax.inject.Inject;

public class RecyclerViewFragment extends Fragment {

    @Inject
    MainViewModel mainViewModel;
    private RecyclerFragmentBinding binding;
    private final String TAG = "RecyclerViewFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.recycler_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity) getActivity()).activityComponent.inject(this);
        mainViewModel.getAlbumsLiveData().observe(this, albumsListAdapter -> {
            Log.d(TAG, "onActivityCreated: " + albumsListAdapter.getItemCount());
            binding.recyclerView.setAdapter(albumsListAdapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        });
    }
}
