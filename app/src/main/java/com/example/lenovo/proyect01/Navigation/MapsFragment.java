package com.example.lenovo.proyect01.Navigation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.proyect01.Objects.FirebaseReferences;
import com.example.lenovo.proyect01.Objects.Maps;
import com.example.lenovo.proyect01.R;
import com.example.lenovo.proyect01.Recyclers.RecyclerActivity_map;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends Fragment {
    private EditText editText_maps;
    private EditText editText_reference;

    private Button add;
    private Button cancelar;

    public MapsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_maps,container,false);
        editText_maps = (EditText)v.findViewById(R.id.maps_EditText);
        editText_reference = (EditText)v.findViewById(R.id.reference_EditText);
        add = (Button)v.findViewById(R.id.add_button);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(FirebaseReferences.MAPS_REFERENCE);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Maps text0 = new Maps(editText_maps.getText().toString(),editText_reference.getText().toString());
                //myRef.child(FirebaseReferences.CONTACS_REFERENCE).push().setValue(contac);
                myRef.push().setValue(text0);
            }
        });
        cancelar = (Button)v.findViewById(R.id.back_button);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goRecyclerActivity();
            }
        });
        return v;
    }
    public void goRecyclerActivity() {
        Intent intent = new Intent(getActivity(),RecyclerActivity_map.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
