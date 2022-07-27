package com.example.restapiidemo.home.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapiidemo.R
import com.example.restapiidemo.databinding.FragmentDetailBinding
import com.example.restapiidemo.home.data.CommentModel
import com.example.restapiidemo.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_post.*


class DetailFragment : Fragment() {
    private lateinit var vm: HomeViewModel
    private lateinit var adapter2: CommentAdapter

    private var _binding: FragmentDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var intent:Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

//        val id=intent.getIntExtra("id", 0)
//        val title=intent.getStringExtra("title")
//
//
//        itemPost.text=id.toString()
//        itemTitle.text=title
//        itemBody.text= ""


        vm = ViewModelProvider(this)[HomeViewModel::class.java]
        vm.fetchAllComments(2)
        vm.commentModelListLiveData?.observe(this, Observer {
            if (it!=null){
                recycleComment.visibility = View.VISIBLE
                adapter2.setData(it as ArrayList<CommentModel>)
            }else{
                showToast("Something went wrong")
            }
        })

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun showToast(msg:String){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter2 = CommentAdapter()
        recycleComment.layoutManager = LinearLayoutManager(context)
        recycleComment.adapter = adapter2
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home ->
                findNavController().navigate(R.id.action_detailFragment_to_postFragment)
        }
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}