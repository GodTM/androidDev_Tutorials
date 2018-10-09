package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut5

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        Toast.makeText(context , " I am the receiver of the BroadCast Receiver" , Toast.LENGTH_LONG).show()
    }


}