# AndroidFundamentals


1) MyContactRecyclerViewTestApp - This app is a simple Android application that displays a list of names using a RecyclerView. It uses the MVVM design pattern and the Retrofit library to fetch data. The app consists of an AdapterClass to bind data to the RecyclerView and a MainActivity that sets up the user interface and populates the data.
[app link](https://github.com/Ace1032/AndroidFundamentals/tree/main/MyContactRecyclerViewTestApp)<br>

2)This sample app offers three main functionalities: a main page for displaying news articles, an activity screen for viewing individual and upcoming activities, and a chat feature for team communication. Each screen is created using fragments that observe LiveData from dedicated ViewModels. These ViewModels share a common DataRepository, ensuring efficient data management and real-time updates across the app. This structure enhances performance, responsiveness, and code maintainability. [app link](https://github.com/Ace1032/AndroidFundamentals/tree/main/Heart2Heart_1/app/src/main/java/com/example/heart2heart_1)<br>

3) JobSchedulerDemo🚀- This app is an Android application that schedules a background task to fetch API data when the device is connected to a Wi-Fi network and the battery is not low. The app uses the JobScheduler API to define and schedule a job with these specific conditions. The ApiJobService class handles the job execution, fetching the data in the background using an AsyncTask. The job is scheduled in the MainActivity when the app starts, ensuring that it runs under the specified conditions and persists across device reboots.
   [app link](https://github.com/Ace1032/AndroidFundamentals/tree/main/JobSchedulerDemo)<br>
   
   
4) MVVMShareData 🚀 - This simple Android application demonstrates the MVVM (Model-View-ViewModel) architecture using Kotlin, ViewModel, LiveData, and Navigation Component. The application consists of two fragments and a CounterViewModel class to manage and share data between the fragments.
   [app link](https://github.com/Ace1032/AndroidFundamentals/tree/main/MVVMShareData)<br>
   
   
5) PhotoShop 🚀 This Android application allows users to load an image from their device and adjust its brightness and color components (red, green, blue, and alpha) using seek bars. The main activity (MainActivity) includes methods to open an image picker, load the selected image into an ImageView using Glide, and apply color transformations using ColorMatrix and ColorMatrixColorFilter. The app provides real-time feedback as users adjust the seek bars, modifying the image's appearance directly on the screen.
   [app lisnk](https://github.com/Ace1032/AndroidFundamentals/blob/main/PhotoShop/app/src/main/java/com/example/photoshop/MainActivity.kt)<br>

   
6) This project demonstrates how to bind an Android service (MyService) to an activity (MainActivity) to fetch and display a random number using coroutines, while also utilizing WorkManager to perform background tasks with a RandomNumberWorker that processes and logs data. The activity binds to the service on start and updates the UI based on the service's output, and enqueues a one-time work request with WorkManager, observing the result to log a generated random number. This combination showcases efficient background processing and service binding in Android applications.[app link](https://github.com/Ace1032/AndroidFundamentals/tree/main/WorkManagerExample)<br>


