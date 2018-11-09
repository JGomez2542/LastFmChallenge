package com.example.admin.lastfmchallenge.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.admin.lastfmchallenge.R;
import com.example.admin.lastfmchallenge.databinding.AlbumItemBinding;
import com.example.admin.lastfmchallenge.models.Album;
import com.example.admin.lastfmchallenge.ui.CommunicatorViewModel;

import java.util.List;

public class AlbumsListAdapter extends RecyclerView.Adapter<AlbumsListAdapter.ViewHolder> {

    private List<Album> albumList;
    private CommunicatorViewModel communicatorViewModel;
    private Context context;
    private final String TAG = "AlbumsListAdapter";

    public AlbumsListAdapter(List<Album> albumList, CommunicatorViewModel communicatorViewModel) {
        this.albumList = albumList;
        this.communicatorViewModel = communicatorViewModel;
    }

    @NonNull
    @Override
    public AlbumsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        AlbumItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.album_item, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsListAdapter.ViewHolder viewHolder, int i) {
        Album temp = albumList.get(i);
        viewHolder.binding.tvArtist.setText(String.format("Artist: %s", temp.getArtist()));
        viewHolder.binding.tvName.setText(temp.getName());
        viewHolder.binding.tvMbid.setText(String.format("MbId: %s", temp.getMbid()));
        viewHolder.binding.tvStreamable.setText(String.format("Streamable: %s", temp.getStreamable()));
        viewHolder.itemView.setOnClickListener(view -> communicatorViewModel.setAlbumLiveData(temp));
        Glide.with(viewHolder.itemView.getContext())
                .load(temp.getImage().get(2).getText())
                .into(viewHolder.binding.imageView);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        AlbumItemBinding binding;

        public ViewHolder(@NonNull AlbumItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
