package com.example.lenovo.proyect01.Recyclers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.proyect01.Objects.Text;
import com.example.lenovo.proyect01.R;

import java.util.List;

/**
 * Created by Lenovo on 27/06/2017.
 */

public  class Adapter_Text extends RecyclerView.Adapter<Adapter_Text.TextHolder> {
    private List<Text> text;

    public Adapter_Text(List<Text> text)
    {
        this.text = text;
    }
    @Override
    public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_text,parent,false);
        TextHolder holder = new TextHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(TextHolder holder, int position) {
        Text texts = text.get(position);
        holder.name.setText(texts.getText());
        holder.reference.setText(texts.getReference_contact());
    }

    @Override
    public int getItemCount() {
        return text.size();
    }

    public static class TextHolder extends RecyclerView.ViewHolder{
        TextView name,reference;
        public TextHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView_name);
            reference = (TextView) itemView.findViewById(R.id.textView_reference);

        }
    }
}
