package com.example.lenovo.proyect01.Navigation;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.proyect01.Objects.Contacs;
import com.example.lenovo.proyect01.Objects.FirebaseReferences;
import com.example.lenovo.proyect01.R;
import com.example.lenovo.proyect01.RecyclerActivity_contact;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {
    private EditText editText_name;
    private EditText editText_nickname;
    private EditText editText_email;
    private EditText editText_reference;

    private Button add;
    private Button cancelar;

    private EditText date;
    private DatePickerDialog datePickerDialog;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add,container,false);
        editText_name = (EditText)v.findViewById(R.id.name_EditText);
        editText_nickname = (EditText)v.findViewById(R.id.nickname_EditText);
        editText_email = (EditText)v.findViewById(R.id.email_EditText);
        editText_reference = (EditText)v.findViewById(R.id.reference_EditText);

        date = (EditText)v.findViewById(R.id.date_EditText);
        // perform click event on edit text
        /*date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(AddFragment.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });*/
        add = (Button)v.findViewById(R.id.add_button);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(FirebaseReferences.CONTACS_REFERENCE);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Contacs contac = new Contacs(editText_name.getText().toString(),editText_nickname.getText().toString(),date.getText().toString(),editText_email.getText().toString(),editText_reference.getText().toString());
                //myRef.child(FirebaseReferences.CONTACS_REFERENCE).push().setValue(contac);
                myRef.push().setValue(contac);
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
        Intent intent = new Intent(getActivity(),RecyclerActivity_contact.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
