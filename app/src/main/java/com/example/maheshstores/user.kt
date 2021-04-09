package com.example.maheshstores

import android.os.Bundle
import android.text.Layout
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment

import com.example.maheshstores.databinding.FragmentUserBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [user.newInstance] factory method to
 * create an instance of this fragment.
 */

lateinit var Comp_name : MutableList<String>

//val Comp_Id = arrayOf("1","2", "3", "4")
//val return_date = arrayOf("10/4/2021", "11/4/2021", "12/4/2021", "13/4/2021")


class user : Fragment(), AdapterView.OnItemSelectedListener{

    lateinit var binding: FragmentUserBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("User", "onCreateView called")
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_user,container,false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val adapter : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(requireActivity(),R.array.Options, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        binding.Dynamic.adapter = adapter
        binding.Dynamic.setOnItemSelectedListener(this)
        binding.button2.setOnClickListener {display_List(binding.button2)}
        return binding.root
    }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        if(parent?.getItemAtPosition(position).toString() == "Roll No")
        {
            binding.editComponent.visibility = View.GONE
            binding.editRoll.visibility = View.VISIBLE
        }

        else
        {
            binding.editComponent.visibility = View.VISIBLE
            binding.editRoll.visibility = View.GONE
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }


    fun display_List(view:View)
    {
        if(binding.editRoll.visibility == View.VISIBLE){

            if(TextUtils.isEmpty(binding.editRoll.text))
            {
                Toast.makeText(activity, "Invalid Roll Number!!!", Toast.LENGTH_SHORT).show()
                return;
            }

            val roll_no : String = binding.editRoll.text.toString()

                val action = userDirections.actionUserToUserlist()
                action.rollNumber1334 = roll_no
                binding.editRoll.text.clear()
                NavHostFragment.findNavController(this).navigate(action)


        }
    }


}