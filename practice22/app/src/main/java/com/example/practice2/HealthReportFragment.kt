package com.example.practice2

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

import com.example.practice2.databinding.FragmentHealthReportBinding

class HealthReportFragment : Fragment() {

    private var _binding:FragmentHealthReportBinding? = null
    private val binding get()= _binding!!

    private val REQUEST_IMAGE_CAPTURE = 1
    private lateinit var  packageManager: PackageManager
    private lateinit var imageView: ImageView


    private val takePictureLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        } else {
            Toast.makeText(requireContext(), "Picture wasn't taken", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentHealthReportBinding.inflate(inflater, container, false)
        return binding.root


    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureLauncher.launch(takePictureIntent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // To avoid memory leaks, set the binding object to null
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView=binding.picture
        binding.cameraButtonId.setOnClickListener {
            dispatchTakePictureIntent()
       }

    }









}