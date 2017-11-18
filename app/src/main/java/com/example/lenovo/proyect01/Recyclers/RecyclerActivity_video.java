package com.example.lenovo.proyect01.Recyclers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.lenovo.proyect01.Navigation.Act_Navigation;
import com.example.lenovo.proyect01.Objects.Video;
import com.example.lenovo.proyect01.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.lenovo.proyect01.R.id.recycler_video;

/**
 * Created by Lenovo on 27/06/2017.
 */

public class RecyclerActivity_video extends AppCompatActivity {
    private RecyclerView rv_contact;
    private List<Video> video;
    private Adapter_Video adapter;

    private static final String TAG = "TEXT";

    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_video);

        rv_contact = (RecyclerView) findViewById(recycler_video);
        rv_contact.setLayoutManager(new LinearLayoutManager(this));

        video = new ArrayList<>();
        adapter = new Adapter_Video(video);
        rv_contact.setAdapter(adapter);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        db.getReference().child("video").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                video.removeAll(video);
                for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    Video videos = snapshot.getValue(Video.class);
                    Log.i("text",videos.toString());
                    video.add(videos);
                    Log.i(TAG,"agrege un contacto");
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                    Log.i(TAG,"error no entre en ondatachanged");
            }
        });
    }
    public void add(View view)
    {
        goMenuScreen();
    }

    private void goMenuScreen() {
        Intent intent = new Intent(this,Act_Navigation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
