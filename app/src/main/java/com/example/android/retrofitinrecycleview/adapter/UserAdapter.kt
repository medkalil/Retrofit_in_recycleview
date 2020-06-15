package com.example.android.retrofitinrecycleview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.retrofitinrecycleview.Model.User
import com.example.android.retrofitinrecycleview.R
import kotlinx.android.synthetic.main.item.view.*
import org.w3c.dom.Text

class UserAdapter(private val context: Context, private val userList: MutableList<User>) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.id.text=userList[position].id
        holder.name.text=userList[position].name
        holder.email.text=userList[position].email


    }

    //  VIEWHOLDER
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var id: TextView
        var name: TextView
        var email: TextView

        init {
            id = itemView.findViewById(R.id.id)
            name = itemView.name
            email = itemView.email
        }
    }


}