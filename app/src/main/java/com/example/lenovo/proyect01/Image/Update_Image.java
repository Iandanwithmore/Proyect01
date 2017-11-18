package com.example.lenovo.proyect01.Image;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.proyect01.Navigation.Act_Navigation;
import com.example.lenovo.proyect01.Objects.FirebaseReferences;
import com.example.lenovo.proyect01.Objects.Image;
import com.example.lenovo.proyect01.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

/**
 * Created by Lenovo on 27/06/2017.
 */

public class Update_Image extends AppCompatActivity {
    private Button update_image;
    private StorageReference mStorage;
    private static final int GALLERY_INTENT = 2;
    private ProgressDialog mProgressDialog;

    private Button update_photo;
    private Button back;
    private ImageView nImage;
    private static final int CAMERA_REQUEST_CODE = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        mStorage = FirebaseStorage.getInstance().getReference();
        update_image = (Button) findViewById(R.id.add_image);
        mProgressDialog = new ProgressDialog(this);
        update_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/=");
                startActivityForResult(intent,GALLERY_INTENT);
            }
        });

        update_photo = (Button)findViewById(R.id.add_photo);
        nImage = (ImageView)findViewById(R.id.imageView);
        update_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST_CODE);
            }
        });

        back = (Button)findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back();
            }
        });

    }

    public void go_back()
    {
        Intent intent = new Intent(this,Act_Navigation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLERY_INTENT && resultCode == RESULT_OK)
        {
            mProgressDialog.setMessage("Uploading ...");
            mProgressDialog.show();
            Uri uri = data.getData();

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference myRef = database.getReference(FirebaseReferences.IMAGE_REFERENCE);

            StorageReference filepath = mStorage.child(FirebaseReferences.PHOTO_REFERENCE).child(uri
                    .getLastPathSegment());

            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    @SuppressWarnings("VisibleForTests")Uri downloadUri = taskSnapshot.getDownloadUrl();
                    Image imagen = new Image("0",downloadUri.toString());
                    myRef.push().setValue(imagen);
                    Glide.with(Update_Image.this).load(downloadUri).fitCenter().into(nImage);
                    Toast.makeText(Update_Image.this,"Update Done.",Toast.LENGTH_SHORT).show();
                    mProgressDialog.dismiss();
                }

            });
        }
    }
}
