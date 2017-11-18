package com.example.lenovo.proyect01.Image;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.proyect01.Objects.Image;
import com.example.lenovo.proyect01.R;

import java.util.List;

/**
 * Created by Lenovo on 27/06/2017.
 */

public class Adapter_List extends ArrayAdapter<Image> {

    private Activity context;
    private int resource;
    private List<Image> listImage;

    public Adapter_List(@NonNull Activity context, @LayoutRes int resource, @NonNull List<Image> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        listImage = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View v  = inflater.inflate(resource,null);
        ImageView img = (ImageView)v.findViewById(R.id.imgView);
        Glide.with(context).load(listImage.get(position).getReference_contact()).into(img);
        return v;
    }
}
