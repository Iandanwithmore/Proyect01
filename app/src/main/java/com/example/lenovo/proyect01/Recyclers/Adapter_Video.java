package com.example.lenovo.proyect01.Recyclers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.proyect01.Objects.Video;
import com.example.lenovo.proyect01.R;

import java.util.List;

/**
 * Created by Lenovo on 27/06/2017.
 */

public  class Adapter_Video extends RecyclerView.Adapter<Adapter_Video.TextHolder> {
    private List<Video> video;

    public Adapter_Video(List<Video> video)
    {
        this.video = video;
    }
    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_video,parent,false);
        TextHolder holder = new TextHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(TextHolder holder, int position) {
        Video videos = video.get(position);
        holder.name.setText(videos.getVideo());
        holder.reference.setText(videos.getReference_contact());
    }

    @Override
    public int getItemCount() {
        return video.size();
    }

    public static class TextHolder extends RecyclerView.ViewHolder{
        TextView name,reference;
        public TextHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView_video);
            reference = (TextView) itemView.findViewById(R.id.textView_reference);
        }
    }
}
