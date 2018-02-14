
package com.clausasd.alarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.widget.Toast;
import android.util.Log;

import java.io.IOException;

import static android.content.Context.NOTIFICATION_SERVICE;

public class RNScheduleAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = intent.getParcelableExtra("notification");

        int id = intent.getIntExtra("notification-id", 0);
        String fileName = intent.getStringExtra("fileName");
        notification.sound = Uri.parse(String.format("android.resource://%s/%s/%s", context.getPackageName(), "raw", fileName));
        notificationManager.notify(id, notification);


    }
}