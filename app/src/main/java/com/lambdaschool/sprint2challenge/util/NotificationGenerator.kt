package com.lambdaschool.sprint2challenge.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color.parseColor
import android.os.Build
import androidx.core.app.NotificationCompat
import com.lambdaschool.sprint2challenge.R
import com.lambdaschool.sprint2challenge.activity.ShoppingListActivity

object NotificationGenerator {

    private val colorPrimary = "#01579b"

    fun simpleNotification(context: Context) {
        // Create an intent for the notification to open the app
        //val contentIntent = Intent(context, ShoppingListActivity::class.java)
        //val pendingContentIntent = PendingIntent.getActivity(context, 0, contentIntent, PendingIntent.FLAG_ONE_SHOT)

        // Channel ID (needed outside of `if` statements)
        val channelId = "${context.packageName}.simplechannel"
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Check for build version greater than or equal to version Oreo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notifications"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val description = "You orderd some food"

            val channel = NotificationChannel(channelId, name, importance)
            channel.description = description

            notificationManager.createNotificationChannel(channel)
        }

        // Will always happen independent of build version
        val notificationBuilder = NotificationCompat.Builder(context, channelId)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Confirmation")
            .setContentText("Your order has been placed")
            //.setContentIntent(pendingContentIntent)
            .setDefaults(Notification.DEFAULT_ALL)
            .setAutoCancel(true)
            .setTimeoutAfter(3000)
            .setColor(parseColor(colorPrimary))
        notificationManager.notify(ShoppingListActivity.NOTIFICATION_ID, notificationBuilder.build())
    }
}