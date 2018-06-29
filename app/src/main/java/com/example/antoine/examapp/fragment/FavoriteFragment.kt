package com.example.antoine.examapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.antoine.examapp.FavAdapter
import com.example.antoine.examapp.R
import com.example.antoine.examapp.db.AppDataBase
import com.example.antoine.examapp.db.Questions

class FavoriteFragment : Fragment() {
    private var favList: ArrayList<Questions> = ArrayList()
    private lateinit var db: AppDataBase
    private lateinit var favAdapter: FavAdapter
    private lateinit var rootView : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_questions, container, false)
        favAdapter = FavAdapter(ArrayList(), context!!)
        db = AppDataBase.getDataBase(context)
        favList = ArrayList(db.favDao().questions)

        var recyclerView = rootView.findViewById<RecyclerView>(R.id.userRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = favAdapter

        return rootView
    }
}