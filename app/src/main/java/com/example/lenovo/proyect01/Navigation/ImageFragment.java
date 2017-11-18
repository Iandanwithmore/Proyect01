package com.example.lenovo.proyect01.Navigation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.proyect01.Image.Act_List;
import com.example.lenovo.proyect01.Image.Update_Image;
import com.example.lenovo.proyect01.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {
    private Button go;
    private Button go_gallery;

    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_image,container,false);
        go = (Button)v.findViewById(R.id.go_to_image_button);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goRecyclerActivity();
            }
        });

        go_gallery = (Button)v.findViewById(R.id.go_to_gallery_button);
        go_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goGalleryActivity();
            }
        });
        return v;
    }
    public void goRecyclerActivity() {
        Intent intent = new Intent(getActivity(),Update_Image.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void goGalleryActivity() {
        Intent intent = new Intent(getActivity(),Act_List.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
