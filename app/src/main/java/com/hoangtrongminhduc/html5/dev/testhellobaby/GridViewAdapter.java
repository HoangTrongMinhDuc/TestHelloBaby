package com.hoangtrongminhduc.html5.dev.testhellobaby;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by HTML5 on 19/10/2017.
 */

public class GridViewAdapter extends ArrayAdapter<Video> {
    private Context context;
    private int resource;
    private List<Video> array;
    public GridViewAdapter(Context context,int resource, List<Video> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.array = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.itemvideo, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvtitle = (TextView) convertView.findViewById(R.id.tvtitle);
            viewHolder.imgvideo = (ImageView) convertView.findViewById(R.id.imgvideo);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Video video = array.get(position);
        String title = video.getTitle();
        if(video.getTitle().length()>=20){
            title = title.copyValueOf(title.toCharArray(),0,17)+"...";
        }
        viewHolder.tvtitle.setText(title);
        Picasso.with(context).load("https://i.ytimg.com/vi/"+video.getId()+"/hqdefault.jpg").into(viewHolder.imgvideo);
        return convertView;
    }
    public class ViewHolder {
        TextView tvtitle;
        ImageView imgvideo;
    }

}
