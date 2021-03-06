package com.ismin.projectapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable


const val ARG_CENTERS = "ARG_CENTERS"


class CovidTestCenterFragment : Fragment() {
    private lateinit var centers: ArrayList<CovidTestCenter>
    private lateinit var favoriteList: Set<String>
    private lateinit var rcvCenters: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            centers = it.getSerializable(ARG_CENTERS) as ArrayList<CovidTestCenter>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_covid_test_center_list, container, false)

        this.rcvCenters = rootView.findViewById(R.id.f_center_list_rcv)
        this.rcvCenters.adapter = TestCenterAdapter(centers)//, favoriteList)
        val linearLayoutManager = LinearLayoutManager(context)
        this.rcvCenters.layoutManager = linearLayoutManager

        val dividerItemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
        this.rcvCenters.addItemDecoration(dividerItemDecoration)

        return rootView;
    }

    companion object {
        @JvmStatic
        fun newInstance(centers: List<CovidTestCenter>) = //, favoriteList: List<Boolean>) =
            CovidTestCenterFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CENTERS, ArrayList(centers))
                }
            }
    }
}