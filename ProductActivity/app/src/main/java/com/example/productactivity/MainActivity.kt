package com.example.productactivity

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    private lateinit var viewmodel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val apiService = ApiService()
            val dataBase = DataBase(applicationContext)
            val factory = ProductViewModelfactory(apiService, dataBase)
            viewmodel = ViewModelProvider(this, factory).get(ProductViewModel::class.java)

        } catch (e:Exception){
            Log.e("MainActivity", "Error initializing ViewModel", e)
        }


    }
}

class ProductViewModelfactory(
   private val apiService: ApiService, 
    private val dataBase: DataBase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProductViewModel::class.java)){
            return ProductViewModel(ProductRepository(apiService,dataBase)) as T
        }
        throw IllegalArgumentException("UnKnown ViewModel class")
    }

}

class ProductRepository(apiService: ApiService, dataBase: DataBase) {

}

class ProductViewModel(private val repository : ProductRepository) : ViewModel(){

}

class DataBase(applicationContext: Context?) {

}

class ApiService {

}

