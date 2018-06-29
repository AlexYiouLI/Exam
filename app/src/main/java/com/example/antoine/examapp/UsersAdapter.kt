package com.example.antoine.examapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.antoine.examapp.api.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter(var items: ArrayList<User>) : RecyclerView.Adapter<UsersAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemHolder (view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: User) = with(itemView) {
            tvUserName.text = item.name
            tvReput.text = item.reput.toString()
            Picasso.get().load(item.image).into(userImgView)
        }
    }
}