package com.example.mymusicapp.viewmodel

import android.util.Log
import com.example.mymusicapp.model.Album
import com.example.mymusicapp.model.Artist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.lang.Exception

class SpotifyClient {




    suspend fun fetchData(){
        withContext(Dispatchers.IO){
            try {
                fetchDataFromLocal()
               // fetchDataFromSpotify()
            }catch (e:Exception){
                Log.d("fetchError", e.toString())
            }
        }
    }

    private fun fetchDataFromLocal() {


    }


    fun fetchDataFromSpotify() {

        var client = OkHttpClient()

        val request = Request.Builder()
            .url("https://spotify23.p.rapidapi.com/search/?q=Acefundog&type=multi&offset=0&limit=10&numberOfTopResults=5")
            .get()
            .addHeader("X-RapidAPI-Key", "13a10a088bmsh46367b12aacf395p194deejsnc84cef70b345")
            .addHeader("X-RapidAPI-Host", "spotify23.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
        while (response != null) {
            Log.d("response", response.toString())


            val responseBody = response.body?.string()
            responseBody?.let {
                val jsonObject = JSONObject(it)
                val albums = parseAlbums(jsonObject)
                for (i in 0 until 20) {
                    Log.d("album", albums.get(i).toString())
                }
            }


        }
    }
    private fun parseAlbums(jsonObject: JSONObject): ArrayList<Album> {
        val albumsArray = jsonObject.optJSONObject("albums")?.optJSONArray("items")
        val albums = ArrayList<Album>()
        albumsArray?.let {
            for (i in 0 until it.length()) {
                val albumObject = it.optJSONObject(i)
                val uri = albumObject.optString("uri", "")
                val name = albumObject.optString("name", "")
                val artistObject = albumObject.optJSONArray("artists")?.optJSONObject(0)
                val artistUri = artistObject?.optString("uri", "")
                val artistName = artistObject?.optString("name", "")
                val coverArtArray = albumObject.optJSONObject("coverArt")?.optJSONArray("sources")
                val coverArtUrl = coverArtArray?.optJSONObject(0)?.optString("url", "")

                Log.d("check", name)
                albums.add(Album(uri, name, Artist(artistUri.toString(), artistName.toString(), ""), coverArtUrl.toString()))
            }
        }
        return albums
    }

}