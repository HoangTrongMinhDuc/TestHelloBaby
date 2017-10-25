package com.hoangtrongminhduc.html5.dev.testhellobaby.VideoYoutube;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hoangtrongminhduc.html5.dev.testhellobaby.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by HTML5 on 22/10/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.DataViewHolder> {
    private List<Video> videos;
    private Context mContext;
    private LayoutInflater mInflater;

    public RecycleAdapter(List<Video> videos, Context mContext) {
        this.videos = videos;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecycleAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recycle_item, parent, false);
        return new DataViewHolder(itemView);
    }
    //Xu li item
    @Override
    public void onBindViewHolder(RecycleAdapter.DataViewHolder holder, int position) {
        final Video video = videos.get(position);
        String title = video.getTitle();
        if(video.getTitle().length()>=20){
            title = title.copyValueOf(title.toCharArray(),0,17)+"...";
        }
        holder.tvtitle1.setText(title); //set text cho item
        Picasso.with(mContext).load("https://i.ytimg.com/vi/"+video.getId()+"/hqdefault.jpg").into(holder.imgvideo1);

        //xu li su kien chon item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //gui doi tuong contact qua activity Detail neu chon item
                Intent intent = new Intent(mContext,PlayerVideo.class);
                intent.putExtra("TITLE",video.getTitle());
                intent.putExtra("ID", video.getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{
        TextView tvtitle1;
        ImageView imgvideo1;
        public DataViewHolder(View itemView){
            super(itemView);
            itemView.setClickable(true);
            tvtitle1 = (TextView)itemView.findViewById(R.id.tvtitle1);
            imgvideo1 = (ImageView)itemView.findViewById(R.id.imgvideo1);
        }
    }
}