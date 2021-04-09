package com.example.maheshstores

data class Component(var roll_no :String)
{
    private var Roll_no :String
    lateinit var Details : MutableList<String>
    init{
        Roll_no = roll_no
    }

    fun retrieve()
    {

    }
}
