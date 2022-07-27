package com.example.restapiidemo.home.ui


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.restapiidemo.R
import com.example.restapiidemo.home.data.PostModel
import kotlinx.android.synthetic.main.home_rv_item_view.view.itemBody
import kotlinx.android.synthetic.main.home_rv_item_view.view.itemPost
import kotlinx.android.synthetic.main.home_rv_item_view.view.itemTitle

class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    private var data : ArrayList<PostModel>?=null

    fun setData(list: ArrayList<PostModel>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_rv_item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)

        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, DetailFragment::class.java)
            intent.putExtra("id",item?.id)
            intent.putExtra("title",item?.title)
           // v.context.startActivity(intent)
            Navigation.findNavController(v).navigate(R.id.action_postFragment_to_detailFragment)
        }

    }

    class HomeViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){
        fun bindView(item: PostModel?) {
            itemView.itemPost.text = item?.id.toString()
            itemView.itemTitle.text = item?.title
            itemView.itemBody.text = item?.body
        }
    }
}