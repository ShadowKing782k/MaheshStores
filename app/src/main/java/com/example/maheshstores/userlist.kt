package com.example.maheshstores

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavArgs
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.maheshstores.databinding.FragmentUserlistBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [userlist.newInstance] factory method to
 * create an instance of this fragment.
 */





class userlist : Fragment() {
    lateinit var binding : FragmentUserlistBinding
    lateinit var comp_name : MutableList<String?>
    var rollNo : String? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_userlist, container, false)
        rollNo = userlistArgs.fromBundle(requireArguments()).rollNumber1334

        if(rollNo == "1234")
        {
            comp_name = mutableListOf("Arduino UNO", "Arduino MEGA", "Nodemcu", "Raspberry Pi")
            val adapter : ArrayAdapter<String?> = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, comp_name)
            binding.compList.adapter = adapter
        }

        else if(rollNo == "1357"){
            comp_name = mutableListOf("MQ-135", "MQ-9", "MQ-7", "MQ-8")
        val adapter : ArrayAdapter<String?> = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, comp_name)
        binding.compList.adapter = adapter
            }

        else
        {
            Toast.makeText(activity, "No Records Found", Toast.LENGTH_SHORT).show()
            val  action = userlistDirections.actionUserlistToUser()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root
    }


}