package com.example.lenovo.proyect01;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.proyect01.Objects.Contacs;

import java.util.List;

/**
 * Created by Lenovo on 27/06/2017.
 */

public  class Adapter_Contact extends RecyclerView.Adapter<Adapter_Contact.ContactHolder> {
    private List<Contacs> contact;

    public Adapter_Contact(List<Contacs> contacts)
    {
        this.contact = contacts;
    }
    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_contac,parent,false);
        ContactHolder holder = new ContactHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {
        Contacs contacts = contact.get(position);
        holder.name.setText(contacts.getName_contact());
        holder.nickname.setText(contacts.getNickname_contact());
        holder.birthday.setText(contacts.getBirthday_contact());
        holder.email.setText(contacts.getEmail_contact());
        holder.reference.setText(contacts.getReference_contact());
    }

    @Override
    public int getItemCount() {
        return contact.size();
    }

    public static class ContactHolder extends RecyclerView.ViewHolder{
        TextView letter,name,nickname,birthday,email,reference;
        public ContactHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView_name);
            nickname = (TextView) itemView.findViewById(R.id.textView_nickname);
            birthday = (TextView) itemView.findViewById(R.id.textView_birthday);
            email = (TextView) itemView.findViewById(R.id.textView_email);
            reference = (TextView) itemView.findViewById(R.id.textView_reference);

        }
    }
}
