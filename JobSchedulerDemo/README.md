This simple Android program fetches API data when the system connects to Wi-Fi and the battery is at least half full. 
We will use 👋 JobScheduler to schedule the job with the specified conditions🚀

### AndroidManifest.xml and add the necessary permissions
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />


1)  class named ApiJobService that extends JobService. [ApiJobService.java](https://github.com/Ace1032/AndroidFundamentals/blob/main/JobSchedulerDemo/app/src/main/java/com/example/jobschedulerdemo/ApiJobService.java)
2)  In AndroidManifest.xml, register the JobService[AndroidManifest.xml](https://github.com/Ace1032/AndroidFundamentals/blob/main/JobSchedulerDemo/app/src/main/AndroidManifest.xml)
3)  JobInfoBuilder is responsible for building the JobInfo object with the required conditions.[JobInfoBuilder.java](https://github.com/Ace1032/AndroidFundamentals/blob/main/JobSchedulerDemo/app/src/main/java/com/example/jobschedulerdemo/JobInfoBuilder.java)
4)  JobSchedulerHelper is responsible for scheduling the job.[JobSchedulerHelper.java](https://github.com/Ace1032/AndroidFundamentals/blob/main/JobSchedulerDemo/app/src/main/java/com/example/jobschedulerdemo/JobSchedilerHelper.java)
    



