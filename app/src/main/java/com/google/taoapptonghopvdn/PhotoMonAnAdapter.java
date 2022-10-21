package com.google.taoapptonghopvdn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotoMonAnAdapter extends  RecyclerView.Adapter<PhotoMonAnAdapter.PhotoViewHolder>{

    private final List<PhotoMoAn> mListPhoto;

    public PhotoMonAnAdapter(List<PhotoMoAn> mListPhoto) {
        this.mListPhoto = mListPhoto;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photomonan, parent, false);

        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        PhotoMoAn photo=mListPhoto.get(position);
        if (photo == null){
            return;
        }
        holder.imgPhoto.setImageResource(photo.getResourceId());
    }

    @Override
    public int getItemCount() {
        if (mListPhoto != null){
            return mListPhoto.size();
        }
        return 0;
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imgPhoto;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }
    }
}
