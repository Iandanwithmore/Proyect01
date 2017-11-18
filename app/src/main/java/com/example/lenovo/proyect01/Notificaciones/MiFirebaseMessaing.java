package com.example.lenovo.proyect01.Notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.example.lenovo.proyect01.Act_001;
import com.example.lenovo.proyect01.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Lenovo on 3/07/2017.
 */

public class MiFirebaseMessaing extends FirebaseMessagingService{
    public static final String TAG = "NOTICIAS";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String from = remoteMessage.getFrom();
        if(remoteMessage.getNotification() != null)
        {
            mostrarNotificacion(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        }
    }

    private void mostrarNotificacion(String title, String body) {
        Intent intent = new Intent(this,Act_001.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher).setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());
    }
}
