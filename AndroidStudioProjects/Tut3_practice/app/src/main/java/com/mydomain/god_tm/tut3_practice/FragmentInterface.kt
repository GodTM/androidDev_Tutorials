package com.mydomain.god_tm.tut3_practice

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FragmentInterface : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit  var listener : FI

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragmen


        var view =   inflater.inflate(R.layout.fragment_fragment_interface, container, false)

        var btn = view.findViewById<Button>(R.id.ToastFrag)
        btn.setOnClickListener {

            listener.onFragmentInterface(" I am a toast in Activity !")
        }
        return view
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as FI

        if (listener==null){
            throw ClassCastException("$context must implement OnArticleSelectedListener")
        }
    }


}

interface FI{
    fun onFragmentInterface(str:String)
}