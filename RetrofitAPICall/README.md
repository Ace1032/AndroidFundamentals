# Retrofit RESTful API Demonstration 🚀

### This repository contains a demonstration of using Retrofit to interact with a RESTful API in an Android application. This README serves as a cheat sheet to reference the main components used in this demonstration.

Components
1. User Data Class
The User data class represents a user object with id, name, and email as properties.

2. APIService Interface
The APIService interface defines the API endpoints and request methods using Retrofit annotations.

3. ApiClient Object
The ApiClient object creates a Retrofit instance and provides an instance of the APIService.

4. RetrofitAPI_Service
The RetrofitAPI_Service object contains the main function to execute the API calls using the ApiClient.


## Dependencies and Libraries

### Dependencies:
retrofit2:retrofit:2.9.0
retrofit2:converter-gson:2.9.0
kotlinx-coroutines-core:1.5.0

### Libraries:
Retrofit: A type-safe HTTP client for Android and Java.
Gson: A Java library to convert Java objects into their JSON representation.
Kotlin Coroutines: For asynchronous programming.
Converters:
GsonConverterFactory: Used to convert the JSON response into Kotlin objects.
