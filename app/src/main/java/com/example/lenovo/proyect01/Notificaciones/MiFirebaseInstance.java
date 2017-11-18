package com.example.lenovo.proyect01.Notificaciones;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Lenovo on 3/07/2017.
 */

public class MiFirebaseInstance extends FirebaseInstanceIdService{
    public static final String TAG = "NOTICIAS";
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();

    }
}
