package com.example.mobilprogodev

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.os.HandlerThread
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.logging.Handler

class SplashActivity : AppCompatActivity() {

    var context: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        loadSplashScreen()

        if(checkConnection(context)) {
            Toast.makeText(this, "İnternetiniz Bağlı", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "İnternetiniz Bağlı Değil", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun loadSplashScreen() {
        android.os.Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        },3000)
    }


    fun checkConnection(context: Context) : Boolean{
        val connectivityManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected

    }
}