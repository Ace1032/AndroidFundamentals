package com.example.portfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.MainA_Button_preview_message


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       MainA_Button_preview_message.setOnClickListener {
            onPreViewedClicked()
        }
    }

    private fun onPreViewedClicked() {
        val contact_name=id_Main_ac_contact_name.text.toString()
        val contact_numbe=id_contactNumber.text.toString()
        val nickName=id_ac_dispay_name.text.toString()
        val hire_date=id_MainA_avila_date.text.toString()

        var contact_data= contact_name +", "+ contact_numbe+", "+
                nickName+", "+hire_date

        Toast.makeText(this,contact_data,Toast.LENGTH_LONG).show()
    }
}