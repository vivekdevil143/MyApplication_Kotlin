package com.rai.vivek.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        val  TAG:String=MainActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnshowtoast.setOnClickListener {
            //code
            Log.i(TAG, "Button was clicked !")

            showToast(resources.getString(R.string.btn_clicked),Toast.LENGTH_LONG)

            //getString(R.string.btn_clicked)

            //Toast.makeText(this, "hello World", Toast.LENGTH_LONG).show()
        }
        
        btnSendDataToNextActivity.setOnClickListener {
            val message:String = userMessage.text.toString()
            
            val intent= Intent(this,SecondActivity::class.java)

            intent.putExtra(Constants.USER_MESSAGE_KEY,message)
            startActivity(intent)
            
            
        }

        btnShare.setOnClickListener {
            val message:String = userMessage.text.toString()

            val intent=Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type="text/plain"

            startActivity(Intent.createChooser(intent,"Please select app:"))
        }

        btnRecyclerview.setOnClickListener {

            val Hobbies_intent=Intent(this,HobbiesActivity::class.java)
            startActivity(Hobbies_intent)
        }
    }
}
