package com.example.androtask1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragm)

        val fragmentManager : FragmentManager = supportFragmentManager
        val Hfragment = HomeFragment()
        val fragment :Fragment? = fragmentManager.findFragmentByTag(Hfragment::class.java.simpleName)

        if(fragment !is Hfragment){
            fragmentManager
                .beginTransaction()
                .add(R.id.container,Hfragment, HomeFragment::class.java.simpleName)
                .commit()
        }

    }
}