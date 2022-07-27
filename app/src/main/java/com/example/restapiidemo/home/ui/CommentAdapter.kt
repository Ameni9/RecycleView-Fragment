package com.example.restapiidemo.home.ui


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.restapiidemo.R
import com.example.restapiidemo.home.data.CommentModel
import kotlinx.android.synthetic.main.comment_item.view.*

class CommentAdapter: RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    private var data: ArrayList<CommentModel>? = null


    fun setData(list: ArrayList<CommentModel>) {
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }


    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }


    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: CommentModel?) {
            itemView.name.text = item?.name
            itemView.email.text = item?.email
            itemView.body.text = item?.body
        }
    }
}