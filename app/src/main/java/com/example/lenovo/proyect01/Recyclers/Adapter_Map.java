package com.example.lenovo.proyect01.Recyclers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.proyect01.Objects.Maps;
import com.example.lenovo.proyect01.R;

import java.util.List;

/**
 * Created by Lenovo on 27/06/2017.
 */

public  class Adapter_Map extends RecyclerView.Adapter<Adapter_Map.TextHolder> {
    private List<Maps> map;

    public Adapter_Map(List<Maps> map)
    {
        this.map = map;
    }
    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_map,parent,false);
        TextHolder holder = new TextHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(TextHolder holder, int position) {
        Maps maps = map.get(position);
        holder.name.setText(maps.getMaps());
        holder.reference.setText(maps.getReference_contact());
    }

    @Override
    public int getItemCount() {
        return map.size();
    }

    public static class TextHolder extends RecyclerView.ViewHolder{
        TextView name,reference;
        public TextHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView_map);
            reference = (TextView) itemView.findViewById(R.id.textView_reference);

        }
    }
}
