package com.mas.material1.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mas.material1.R
import kotlin.properties.Delegates

class MainFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private var numColor by Delegates.notNull<Int>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mainViewModel =
                ViewModelProvider(this).get(MainViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        mainViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val colorGroup = root.findViewById<RadioGroup>(R.id.color_group)
        if (savedInstanceState == null) {
            colorGroup.check(R.id.blue_color)
            numColor = colorGroup.checkedRadioButtonId
        } else {
            numColor = savedInstanceState.getInt("numCol")
            colorGroup.check(numColor)
        }

        colorGroup.setOnCheckedChangeListener { group, checkedId -> numColor = checkedId }
        return root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("numCol", numColor)
    }
}