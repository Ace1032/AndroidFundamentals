package com.example.cointoss

//import com.google.mlkit.nl.languageid.languageIdentification
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cointoss.databinding.ActivityMainResultBinding

class MainActivity_result : AppCompatActivity() {
    private lateinit var binding: ActivityMainResultBinding
    private lateinit var result_view:TextView
    private lateinit var text_editor:EditText
    private lateinit var identify_button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        result_view= binding.resultViewId
        text_editor=binding.textEditorId
        identify_button=binding.identifyId

       if (intent.getBooleanExtra("toss",true)) {
            result_view.setText("Head")
        } else {
            result_view.setText("Tail")
        }
        val input:String=text_editor.toString()
        identify_button.setOnClickListener {
            identifyLanguage(input)
        }

    }

    private fun identifyLanguage(input: String) {
    //    langugeIdentifier
    }
}