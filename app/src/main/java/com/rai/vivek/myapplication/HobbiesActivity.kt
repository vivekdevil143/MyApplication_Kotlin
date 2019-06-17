package com.rai.vivek.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_hobbies.*


class HobbiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        val  layoutManger=LinearLayoutManager(this)
        layoutManger.orientation=LinearLayoutManager.VERTICAL
        Hobbies_RecyclerView.layoutManager=layoutManger

        val adapter=HobbiesAdapter(this,Supplier.hobbies)
        Hobbies_RecyclerView.adapter=adapter
    }
}
