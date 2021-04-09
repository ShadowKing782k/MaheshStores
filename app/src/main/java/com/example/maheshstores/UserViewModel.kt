package com.example.maheshstores

import android.util.Log
import androidx.lifecycle.ViewModel
import java.lang.NullPointerException

class UserViewModel(): ViewModel() {
    lateinit var comp_name: MutableList<String>
    var ROLL_NO: String?
    var Invalid_roll :Boolean?

    init {

        Invalid_roll = null
        comp_name = mutableListOf()
        ROLL_NO = null
    }

    fun retrieve()
    {
        if(comp_name.isEmpty())
        {
            if(ROLL_NO == "1234")
            {
                Invalid_roll = false
                comp_name = mutableListOf("Arduino Uno", "Nodemcu", "Raspberry Pi", "Arduino Mega")
            }

            else
            {
                if(Invalid_roll != null)
                    Invalid_roll = true
            }
        }


    }

    override fun onCleared() {
        super.onCleared()
        Log.i("UserViewModel", "onCleared called")
    }
}