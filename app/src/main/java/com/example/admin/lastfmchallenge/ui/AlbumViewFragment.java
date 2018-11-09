package com.example.admin.lastfmchallenge.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.admin.lastfmchallenge.R;
import com.example.admin.lastfmchallenge.databinding.AlbumItemBinding;

import javax.inject.Inject;

public class AlbumViewFragment extends Fragment {

    @Inject
    CommunicatorViewModel communicatorViewModel;
    private AlbumItemBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.album_item, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity) getActivity()).activityComponent.inject(this);
        communicatorViewModel.getAlbum().observe(this, album -> {
            binding.tvName.setText(album.getName());
            binding.tvMbid.setText(String.format("MbId: %s", album.getMbid()));
            binding.tvArtist.setText(String.format("Artist: %s", album.getArtist()));
            binding.tvStreamable.setText(String.format("Streamable: %s", album.getStreamable()));
            Glide.with(getActivity())
                    .load(album.getImage().get(2).getText())
                    .into(binding.imageView);
        });
    }
}
