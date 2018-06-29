package com.example.antoine.examapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.antoine.examapp.api.Item
import com.example.antoine.examapp.db.AppDataBase
import com.example.antoine.examapp.db.Questions
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_favorite.view.*
import kotlinx.android.synthetic.main.item_question.view.*

class ItemAdapter(var items: ArrayList<Item>, private val context: Context) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
    private var addOnClickListener: View.OnClickListener

    init{
        addOnClickListener = View.OnClickListener  { view ->
            val item = view.tag as Item
            val db: AppDataBase = AppDataBase.getDataBase(context)
            db.favDao().insertQuestion(Questions(item.title, item.owner.profileImage))
            notifyDataSetChanged()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        with(holder.btAdd){
            tag = item
            setOnClickListener(addOnClickListener)
        }
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemHolder (view: View) : RecyclerView.ViewHolder(view) {
        val btAdd : Button = view.btAddFav
        fun bind(item: Item) = with(itemView) {
            tvLink.text = item.title
            tvDate.text = item.creationDate.toString()
            tvAutor.text = item.owner.displayName
            Picasso.get().load(item.owner.profileImage).into(imgView)
        }
    }
}