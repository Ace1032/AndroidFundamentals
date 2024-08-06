package com.example.twofragmentssharedatamvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.twofragmentssharedatamvvm.databinding.FragmentIncreamentBinding

class MainActivity : AppCompatActivity() {
    private  val bindingIn:IncreamentFragment?=null
    private  val bindingDe:DecrementFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFrag= IncreamentFragment()

        val transaction= supportFragmentManager.beginTransaction()

        transaction.replace(R.id.fragment_container_id,firstFrag).commit()




    }
}