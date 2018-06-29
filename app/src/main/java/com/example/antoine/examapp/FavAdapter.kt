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

class FavAdapter(var items: ArrayList<Questions>, private val context: Context) : RecyclerView.Adapter<FavAdapter.ItemHolder>() {

    private var removeOnClickListener: View.OnClickListener

    init{
        removeOnClickListener = View.OnClickListener  { view ->
            val item = view.tag as Questions
            val db: AppDataBase = AppDataBase.getDataBase(context)
            items.remove(item)
            db.favDao().deleteQuestion(item)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]

        with(holder.btDel){
            tag = item
            setOnClickListener(removeOnClickListener)
        }

        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemHolder (view: View) : RecyclerView.ViewHolder(view) {
        val btDel : Button = view.btRemoveFav
        fun bind(item: Questions) = with(itemView) {
            tvFavTitle.text = item.title
            Picasso.get().load(item.image).into(imgFavView)
        }
    }
}