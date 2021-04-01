package com.example.maheshstores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil

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

class user : Fragment(), AdapterView.OnItemSelectedListener{

    lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_user,container,false)
        val adapter : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(requireActivity(),R.array.Options, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        binding.Dynamic.adapter = adapter
        binding.Dynamic.setOnItemSelectedListener(this)
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


}