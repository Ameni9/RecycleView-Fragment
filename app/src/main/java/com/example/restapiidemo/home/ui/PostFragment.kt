package com.example.restapiidemo.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapiidemo.R
import com.example.restapiidemo.databinding.FragmentPostBinding
import com.example.restapiidemo.home.data.PostModel
import com.example.restapiidemo.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_post.*


class PostFragment : Fragment() {


    private lateinit var vm:HomeViewModel
    private lateinit var adapter: HomeAdapter

    private var _binding: FragmentPostBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[HomeViewModel::class.java]
        vm.fetchAllPosts()

        vm.postModelListLiveData?.observe(this, Observer {
            if (it!=null){
                rv_home.visibility = View.VISIBLE
                adapter.setData(it as ArrayList<PostModel>)
            }else{
                showToast("Something went wrong")
            }
            progress_home.visibility = View.GONE
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         adapter = HomeAdapter()
         rv_home.layoutManager = LinearLayoutManager(context)
         rv_home.adapter = adapter
    }

    private fun showToast(msg:String){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}