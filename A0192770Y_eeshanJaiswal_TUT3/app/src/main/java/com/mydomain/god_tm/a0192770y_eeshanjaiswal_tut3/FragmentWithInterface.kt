package com.mydomain.god_tm.a0192770y_eeshanjaiswal_tut3


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentWithInterface : Fragment() {

    //private var listener: OnFragmentInteractionListener? = null // why not working

    interface InterfaceToImplement{

        fun onButtonPressed(position:Int){}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_fragment_with_interface, container, false)


    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)


    }




}
