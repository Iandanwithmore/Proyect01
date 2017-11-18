package com.example.lenovo.proyect01.Navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.lenovo.proyect01.R;

/**
 * Created by Lenovo on 28/06/2017.
 */

public class Act_Navigation extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager manager = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.navigation_add_contact:
                    AddFragment add_frag = new AddFragment();
                    manager.beginTransaction()
                            .replace(R.id.content,add_frag,add_frag.getTag()).commit();
                    return true;
                case R.id.navigation_add_text:
                    TextFragment text_frag = new TextFragment();
                    manager.beginTransaction()
                            .replace(R.id.content,text_frag,text_frag.getTag()).commit();
                    return true;
                case R.id.navigation_add_image:
                    ImageFragment img_frag = new ImageFragment();
                    manager.beginTransaction()
                            .replace(R.id.content,img_frag,img_frag.getTag()).commit();
                    return true;
                case R.id.navigation_add_video:
                    VideoFragment video_frag = new VideoFragment();
                    manager.beginTransaction()
                            .replace(R.id.content,video_frag,video_frag.getTag()).commit();
                    return true;
                case R.id.navigation_add_maps:
                    MapsFragment maps_frag = new MapsFragment();
                    manager.beginTransaction()
                            .replace(R.id.content,maps_frag,maps_frag.getTag()).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        FragmentManager manager = getSupportFragmentManager();
        AddFragment add_frag = new AddFragment();
        manager.beginTransaction()
                .replace(R.id.content,add_frag,add_frag.getTag()).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
