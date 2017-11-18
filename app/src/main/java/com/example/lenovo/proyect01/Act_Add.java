package com.example.lenovo.proyect01;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.lenovo.proyect01.Objects.Contacs;
import com.example.lenovo.proyect01.Objects.FirebaseReferences;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import static com.example.lenovo.proyect01.R.layout.activity_add;

/**
 * Created by Lenovo on 25/06/2017.
 */

public class Act_Add extends AppCompatActivity {

    private EditText editText_name;
    private EditText editText_nickname;
    private EditText editText_email;

    private Button add;
    private Button cancelar;

    private EditText date;
    private DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_add);
        editText_name = (EditText)findViewById(R.id.name_EditText);
        editText_nickname = (EditText)findViewById(R.id.nickname_EditText);
        editText_email = (EditText)findViewById(R.id.email_EditText);

        date = (EditText) findViewById(R.id.date_EditText);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Act_Add.this,
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
        });

        add = (Button)findViewById(R.id.add_button);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(FirebaseReferences.CONTACS_REFERENCE);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Contacs contac = new Contacs(editText_name.getText().toString(),editText_nickname.getText().toString(),date.getText().toString(),editText_email.getText().toString(),"0");
                //myRef.child(FirebaseReferences.CONTACS_REFERENCE).push().setValue(contac);
                myRef.push().setValue(contac);
            }
        });

        cancelar = (Button)findViewById(R.id.back_button);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goRecyclerActivity();
            }
        });

    }
    public void goRecyclerActivity() {
        Intent intent = new Intent(this,RecyclerActivity_contact.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
