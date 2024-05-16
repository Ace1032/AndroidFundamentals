This simple Android program fetches API data when the system connects to Wi-Fi and the battery is at least half full. 
We will use 👋 JobScheduler to schedule the job with the specified conditions🚀

### AndroidManifest.xml and add the necessary permissions
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />


1)  class named ApiJobService that extends JobService. [ApiJobService.java](JobSchedulerDemo/app/src/main/java/com/example/jobschedulerdemo/ApiJobService.java)
2)  In AndroidManifest.xml, register the JobService
3)  JobInfoBuilder is responsible for building the JobInfo object with the required conditions.
   JobSchedulerDemo/app/src/main/java/com/example/jobschedulerdemo/JobInfoBuilder.java
4)  JobSchedulerHelper is responsible for scheduling the job. JobSchedulerDemo/app/src/main/java/com/example/jobschedulerdemo/JobSchedilerHelper.java
5)  



