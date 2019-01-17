package com.example.rondrae.httpreq;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    List<VideoModel>  videoList;

    public PostAdapter(List<VideoModel> videoList) {
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //CREATE ONE INSTANCE OF THE video
        VideoModel video = videoList.get(i);
        viewHolder.title.setText(video.getTitle());
        viewHolder.description.setText(video.getDescription());
        Picasso.get().load(video.getUrl()).into(viewHolder.thumbnail);


    }

    @Override
    public int getItemCount() {
        //RETURN THE SIZE OF THE LIST CREATED
        return videoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public  View mView;
        private TextView title;
        private TextView description;
        private ImageView thumbnail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleID);
            description = itemView.findViewById(R.id.descriptionID);
            thumbnail = itemView.findViewById(R.id.thumbNailID);



        }
    }
}
