package com.neppplus.keepthetime_20220311.fcm

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFCM : FirebaseMessagingService() {

//    메세지 수신시 할 일.

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

//        예시 : notification이 왔을때.
//         => 토스트로 알림의 제목만 출력.

        val title = p0.notification!!.title!!

//        UI쓰레드에게 토스트 띄우는 업무 부여.

        val myHandler = Handler(Looper.getMainLooper()) // UI쓰레드에 일을 맡겨주는 Handler
        myHandler.post {
            Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()
        }

    }

}