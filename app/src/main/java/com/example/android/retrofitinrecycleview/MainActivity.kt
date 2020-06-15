package com.example.android.retrofitinrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.android.retrofitinrecycleview.Common.Common
import com.example.android.retrofitinrecycleview.Model.User
import com.example.android.retrofitinrecycleview.Retrofit.RetrofitService
import com.example.android.retrofitinrecycleview.adapter.UserAdapter
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: UserAdapter
    lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService=Common.retrofitService

        recycle.setHasFixedSize(true)
        layoutManager= LinearLayoutManager(this)
        recycle.layoutManager=layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllUser()
    }

    private fun getAllUser() {
        dialog.show()

        mService.getUser().enqueue(object : Callback<MutableList<User>> {

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>
            ) {
                adapter= UserAdapter(baseContext,response.body()!! )
                adapter.notifyDataSetChanged()
                recycle.adapter=adapter

                dialog.dismiss()

            }

        } )//object

    }//getAllUser()

}
