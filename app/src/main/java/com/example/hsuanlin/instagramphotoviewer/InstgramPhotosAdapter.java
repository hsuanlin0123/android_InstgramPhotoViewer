package com.example.hsuanlin.instagramphotoviewer;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hsuanlin on 2015/7/30.
 */
public class InstgramPhotosAdapter extends ArrayAdapter<InstgramPhoto> {
    public InstgramPhotosAdapter(Context context, List<InstgramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InstgramPhoto photo = getItem(position);
        if( convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo,parent,false);
        }

        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        String content = "<b>" + photo.username + "</b>" + " -- " + photo.caption;
        tvCaption.setText(Html.fromHtml(content));
        ivPhoto.setImageResource(0);
        Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);
        return convertView;
    }
}
