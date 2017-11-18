package com.example.lenovo.proyect01.Image;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lenovo.proyect01.Navigation.Act_Navigation;
import com.example.lenovo.proyect01.Objects.Image;
import com.example.lenovo.proyect01.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 27/06/2017.
 */

public class Act_List extends AppCompatActivity {
    private DatabaseReference mDatabaseRef;
    private List<Image> imgList;
    private ListView lv;
    private Adapter_List adapter;
    private ProgressDialog progressDialog;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_image);
        imgList = new ArrayList<>();
        lv = (ListView)findViewById(R.id.list_image);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait");
        progressDialog.show();

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        db.getReference().child("image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                imgList.removeAll(imgList);
                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    Toast.makeText(getBaseContext(),"entre",Toast.LENGTH_SHORT).show();
                    Image img = snapshot.getValue(Image.class);
                    imgList.add(img);

                    adapter = new Adapter_List(Act_List.this,R.layout.item_list,imgList);
                    lv.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getBaseContext(),"failed",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
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
