package com.example.antoine.examapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.antoine.examapp.ItemAdapter
import com.example.antoine.examapp.R
import com.example.antoine.examapp.UsersAdapter
import com.example.antoine.examapp.api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersFragment : Fragment() {
    private lateinit var itemAdapter: UsersAdapter
    private lateinit var rootView : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_users, container, false)
        itemAdapter = UsersAdapter(ArrayList())

        var recyclerView = rootView.findViewById<RecyclerView>(R.id.userRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemAdapter

        val stackExchangeService = ApiClient.getClient().create(StackExchangeService::class.java)

        stackExchangeService.users().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>){
                itemAdapter.items = response.body()?.items ?: ArrayList()
                itemAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Users>, t: Throwable){
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                Log.d("Error:::",t.message)
            }
        })

        return rootView
    }
}