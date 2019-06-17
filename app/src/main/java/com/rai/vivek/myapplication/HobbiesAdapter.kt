package com.rai.vivek.myapplication

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_layout.view.*

class HobbiesAdapter(val context: Context, val hobbies: List<Hobby>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + "clicked!")

                }
            }

            itemView.imgShare.setOnClickListener {

                /*   this will stop from crashing app due to null pointer exception by us using
                   safe call ?.
                   null safe with let ?.let{}*/

                currentHobby?.let {
                    val message: String = "My Hobbies is:" + currentHobby!!.title

                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"

                    context.startActivity(Intent.createChooser(intent, "Please select app:"))
                }

            }
        }

        fun setData(hobby: Hobby?, pos: Int) {
            hobby?.let {
                itemView.txvTitle.text = hobby.title
            }


            this.currentHobby = hobby
            this.currentPosition = pos

        }


    }
}