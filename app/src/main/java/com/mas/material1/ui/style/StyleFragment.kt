package com.mas.material1.ui.style

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mas.material1.R

class StyleFragment : Fragment() {

    private lateinit var styleViewModel: StyleViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        styleViewModel =
                ViewModelProvider(this).get(StyleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_style, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        styleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}