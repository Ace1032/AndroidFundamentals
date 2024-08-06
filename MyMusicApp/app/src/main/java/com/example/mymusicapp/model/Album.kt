package com.example.mymusicapp.model

data class Album(val uri: String,
                 val name: String,
                 val artist: Artist,
                 val coverArtUrl: String)
data class Artist(val uri: String,
                  val name: String,
                  val avatarImageUrl: String?)

data class Track(val uri:String,
                 var album: Album
                    )

