package com.example.heart2heart.ui.notifications

import android.app.DatePickerDialog
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.heart2heart.R
import com.example.heart2heart.data.RegisterDataSource
import com.example.heart2heart.data.RegisterRepositor
import com.example.heart2heart.databinding.FragmentRegisterBinding
import java.util.Calendar


class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!


    private lateinit var registerRepository: RegisterRepositor
    private lateinit var registerDataSource: RegisterDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
       return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerDataSource = RegisterDataSource()
        registerRepository = RegisterRepositor(registerDataSource)
        val registerViewModel = ViewModelProvider(this, RegisterViewModelFactory()).get(RegisterViewModel::class.java)

        val fnameEditText = binding.fname
        val lnameEditText = binding.lname
        val dobEditText = binding.dob
        val emailEditText = binding.emailId
        val passwordEditText = binding.passwordId

        val registerButton = view?.findViewById<Button>(R.id.regis_button)
        registerButton?.setOnClickListener {

            // Log.d("RegisterFragment", "")
            registerViewModel.registerUser(
                fnameEditText.text.toString(),
                lnameEditText.text.toString(),
                dobEditText.text.toString(),
                emailEditText.text.toString(),
                passwordEditText.text.toString()
            )


        }



        registerDataSource.registerState.observe(viewLifecycleOwner,
            Observer { registerState ->
                if(registerState == null){
                    return@Observer
                }
                Log.d("RegisterFragment", "register observer called")
                if (registerState.result == true) {
                    Log.d("RegisterFragment", "Registration successful")
                    Toast.makeText(context, "Registration successful", Toast.LENGTH_SHORT).show()
                }
                else{
                    Log.d("RegisterFragment", "Registration failed ${registerState.failReson}" )
                    Toast.makeText(context, "Registration failed", Toast.LENGTH_SHORT).show()
                }
            })






        registerViewModel.registerResult.observe(viewLifecycleOwner,
            Observer { registerResult ->
               registerResult ?: return@Observer
                Log.d("RegisterFragment", "observe called")
                if (registerResult.result == true) {
                    Log.d("RegisterFragment", "Registration successful")
                    Toast.makeText(context, "Registration successful", Toast.LENGTH_SHORT).show()
                }
                else {
                    Log.d("RegisterFragment", "Registration failed")
                    Toast.makeText(context, "Registration failed", Toast.LENGTH_SHORT).show()
                    if(registerResult.nameError != null) {
                        fnameEditText.error = getString(registerResult.nameError)
                    }
                    if(registerResult.dobError != null) {
                        dobEditText.error = getString(registerResult.dobError)
                    }
                    if(registerResult.result == false) {
                        Log.d("RegisterFragment", "Registration failed with error: ${registerResult.failReson}")
                        Toast.makeText(context, registerResult.failReson, Toast.LENGTH_SHORT).show()
                    }
                }


            }
        )


        dobEditText.setOnClickListener {
            showDatePickerDialog()
        }



    }



    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = Calendar.getInstance().apply {
                    set(selectedYear, selectedMonth, selectedDay)
                }
                if (isValidDate(selectedDate)) {
                    //Log.d("RegisterFragment", "Valid date selected: $selectedDay/${selectedMonth + 1}/$selectedYear")
                    binding.dob.setText("$selectedDay/${selectedMonth + 1}/$selectedYear")
                } else {
                    Log.d("RegisterFragment", "Invalid date selected")
                }
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun isValidDate(selectedDate: Calendar): Boolean {

        val dob = Calendar.getInstance()
        return selectedDate.before(dob)
    }


}
