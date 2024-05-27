package com.example.photoshop

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.SeekBar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.graphics.get
import com.bumptech.glide.Glide
import com.example.photoshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var imageUri: Uri? = null
    private var cropendBitmap : Bitmap?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLoad.setOnClickListener{ openImage()

        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                adjustBritness(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.d("MainActivity", "SeekBar onStartTrackingTouch")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.d("MainActivity", "SeekBar onStopTrackingTouch")
            }

        })

        binding.seekBarColor1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                adjustRed(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.d("MainActivity", "SeekBar onStartTrackingTouch")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.d("MainActivity", "SeekBar onStopTrackingTouch")
            }

        })

        binding.seekBarColor2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                adjustGreen(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.d("MainActivity", "SeekBar onStartTrackingTouch")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.d("MainActivity", "SeekBar onStopTrackingTouch")
            }

        })

        binding.seekBarColor3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                adjustBlue(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.d("MainActivity", "SeekBar onStartTrackingTouch")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.d("MainActivity", "SeekBar onStopTrackingTouch")
            }

        })

        binding.seekBarColor4.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                adjustVector(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.d("MainActivity", "SeekBar onStartTrackingTouch")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.d("MainActivity", "SeekBar onStopTrackingTouch")
            }

        })



    }

    private fun setAllToNormal() {
        val colorMatrix = ColorMatrix().apply {
            setScale(50f, 50f,50f, 50f)
        }
        binding.imageView.colorFilter = ColorMatrixColorFilter(colorMatrix)
    }

    private fun getBitmapFromImageView(imageView : ImageView): Bitmap{
        val drawable=imageView.drawable
        return if(drawable is BitmapDrawable){
            Log.d("MainActivity tracking", "getBitmapFromImageView is drawable")
            drawable.bitmap
        }else{
            //val width = if (drawable.intrinsicWidth > 0) drawable.intrinsicWidth else 1
            //val height = if (drawable.intrinsicHeight > 0) drawable.intrinsicHeight else 1
           // Log.d("MainActivity tracking", "getBitmapFromImageView not  drawable")

            //Log.d("MainActivity tracking", "${width} ${height}")
            val bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888 )

            val canvas = Canvas(bitmap)
            drawable.setBounds(0,0,canvas.width, canvas.height)
            Log.d("MainActivity tracking", "${canvas.toString()}")
            drawable.draw(canvas)
            bitmap
        }

    }



    private fun adjustBritness(process: Int){
        Log.d("MainActivity messages","adjustBritness(process: Int)" )
        val scale = process / 100.0f
        val colorMatrix = ColorMatrix().apply {
            setScale(scale, scale, scale, 1f)
        }
        binding.imageView.colorFilter = ColorMatrixColorFilter(colorMatrix)
    }
    private fun adjustRed(process: Int){
        Log.d("MainActivity messages","adjustBritness(process: Int)" )
        val scale = process / 100.0f
        val colorMatrix = ColorMatrix().apply {
            setScale(scale, 1f, 1f, 1f)
        }
        binding.imageView.colorFilter = ColorMatrixColorFilter(colorMatrix)
    }
    private fun adjustGreen(process: Int){
        Log.d("MainActivity messages","adjustBritness(process: Int)" )
        val scale = process / 100.0f
        val colorMatrix = ColorMatrix().apply {
            setScale(1f, scale, 1f, 1f)
        }
        binding.imageView.colorFilter = ColorMatrixColorFilter(colorMatrix)
    }

    private fun adjustBlue(process: Int){
        Log.d("MainActivity messages","adjustBritness(process: Int)" )
        val scale = process / 100.0f
        val colorMatrix = ColorMatrix().apply {
            setScale(1f, 1f, scale, 1f)
        }
        binding.imageView.colorFilter = ColorMatrixColorFilter(colorMatrix)
    }
    private fun adjustVector(process: Int){
        Log.d("MainActivity messages","adjustBritness(process: Int)" )
        val scale = process / 100.0f
        val colorMatrix = ColorMatrix().apply {
            setScale(1f, 1f, 1f, scale)
        }
        binding.imageView.colorFilter = ColorMatrixColorFilter(colorMatrix)
    }

    private fun openImage(){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        imagePickerLauncher.launch(intent)
    }

    private val imagePickerLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
            Log.d("MainActivity messages","${result.resultCode.toString()} $RESULT_OK" )
            if(result.resultCode == RESULT_OK){
                Log.d("MainActivity messages", "Image URI: $result.resultCode")
                imageUri = result.data?.data
                imageUri?.let{
                    Glide.with(this).load(it).into(binding.imageView)
                }
            }else{
                Log.d("MainActivity messages", "Loading fallback image from drawable")
                Glide.with(this).load(R.drawable.chelse).into(binding.imageView)

            }
        }



}