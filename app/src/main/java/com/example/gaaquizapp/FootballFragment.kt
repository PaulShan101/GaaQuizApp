package com.example.gaaquizapp

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment


class FootballFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_football, container, false)
    }


}