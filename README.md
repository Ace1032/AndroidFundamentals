# AndroidFundamentals


1) MyContactRecyclerViewTestApp - This app is a simple Android application that displays a list of names using a RecyclerView. It uses the MVVM design pattern and the Retrofit library to fetch data. The app consists of an AdapterClass to bind data to the RecyclerView and a MainActivity that sets up the user interface and populates the data.
[app link](https://github.com/Ace1032/AndroidFundamentals/tree/main/MyContactRecyclerViewTestApp)

2) JobSchedulerDemo🚀- This app is an Android application that schedules a background task to fetch API data when the device is connected to a Wi-Fi network and the battery is not low. The app uses the JobScheduler API to define and schedule a job with these specific conditions. The ApiJobService class handles the job execution, fetching the data in the background using an AsyncTask. The job is scheduled in the MainActivity when the app starts, ensuring that it runs under the specified conditions and persists across device reboots.
   [app link](https://github.com/Ace1032/AndroidFundamentals/tree/main/JobSchedulerDemo)
   
4) MVVMShareData 🚀 - This simple Android application demonstrates the MVVM (Model-View-ViewModel) architecture using Kotlin, ViewModel, LiveData, and Navigation Component. The application consists of two fragments and a CounterViewModel class to manage and share data between the fragments.
   [app link](https://github.com/Ace1032/AndroidFundamentals/tree/main/MVVMShareData)
   
5) PhotoShop 🚀 This Android application allows users to load an image from their device and adjust its brightness and color components (red, green, blue, and alpha) using seek bars. The main activity (MainActivity) includes methods to open an image picker, load the selected image into an ImageView using Glide, and apply color transformations using ColorMatrix and ColorMatrixColorFilter. The app provides real-time feedback as users adjust the seek bars, modifying the image's appearance directly on the screen.
   [app lisnk](https://github.com/Ace1032/AndroidFundamentals/blob/main/PhotoShop/app/src/main/java/com/example/photoshop/MainActivity.kt)
