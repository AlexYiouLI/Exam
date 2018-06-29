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
import com.example.antoine.examapp.api.ApiClient
import com.example.antoine.examapp.api.Question
import com.example.antoine.examapp.api.StackExchangeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionsFragment : Fragment() {
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var rootView : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_questions, container, false)
        itemAdapter = ItemAdapter(ArrayList(), context!!)

        var recyclerView = rootView.findViewById<RecyclerView>(R.id.questionRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemAdapter

        val stackExchangeService = ApiClient.getClient().create(StackExchangeService::class.java)

        stackExchangeService.questions("desc").enqueue(object : Callback<Question> {
            override fun onResponse(call: Call<Question>, response: Response<Question>){
                itemAdapter.items = response.body()?.items ?: ArrayList()
                itemAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Question>, t: Throwable){
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                Log.d("Error:::",t.message)
            }
        })

        return rootView
    }
}