# MyContactRecyclerViewTestApp

1) This is a simple Android application created to demonstrate how to implement `RecyclerView`. The project is designed for learning purposes and provides a basic understanding of setting up and using a `RecyclerView` in Android.

The AdapterClass is a custom adapter for a RecyclerView in an Android application. It binds data from an ArrayList of DataClass objects to the views defined in a RecyclerView item layout.

## Components of AdapterClass: [AdapterClass.kt](https://github.com/Ace1032/AndroidFundamentals/blob/main/MyContactRecyclerViewTestApp/app/src/main/java/com/example/mycontactrecyclerviewtestapp/AdapterClass.kt)
Primary Constructor:

private val dataList: ArrayList<DataClass>: Takes a list of DataClass objects to be displayed in the RecyclerView.
Inner ViewHolder Class:

class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView): Defines a ViewHolder that holds the view components for each item in the RecyclerView.
val name: TextView = itemView.findViewById(R.id.name_id): Initializes a TextView to display the name field from DataClass.
Override Methods:

onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass: Inflates the item layout (item_layout) and returns a ViewHolderClass instance.
getItemCount(): Int: Returns the size of the dataList, indicating the number of items to be displayed.
onBindViewHolder(holder: ViewHolderClass, position: Int): Binds the data from the dataList at the given position to the corresponding views in the ViewHolder.


2) The MainActivity class is the main entry point for the application and is responsible for setting up the user interface and populating the RecyclerView with data.

Components of MainActivity: [MainActivity.kt](https://github.com/Ace1032/AndroidFundamentals/blob/main/MyContactRecyclerViewTestApp/app/src/main/java/com/example/mycontactrecyclerviewtestapp/MainActivity.kt)
Class Declaration:

class MainActivity : AppCompatActivity(): Defines MainActivity as a subclass of AppCompatActivity.
Member Variables:

private lateinit var recyclerView: RecyclerView: Declares a RecyclerView to display a list of items.
private lateinit var dataList: ArrayList<DataClass>: Declares an ArrayList to hold DataClass objects.
onCreate Method:

override fun onCreate(savedInstanceState: Bundle?): The method called when the activity is created.
setContentView(R.layout.activity_main): Sets the layout for the activity.
recyclerView = findViewById(R.id.rvContacts): Initializes the RecyclerView by finding it in the layout.
dataList = arrayListOf<DataClass>(): Initializes the dataList.
getData(): Calls the getData method to populate the dataList.
recyclerView.layoutManager = LinearLayoutManager(this): Sets a LinearLayoutManager to handle the layout of the RecyclerView.
recyclerView.setHasFixedSize(true): Optimizes the RecyclerView for fixed size.
recyclerView.adapter = AdapterClass(dataList): Sets the custom adapter (AdapterClass) for the RecyclerView.
getData Method:

private fun getData(): A helper method to populate the dataList with dummy data.
Uses a loop to add 20 DataClass objects to dataList, each with a name like "name 1", "name 2", etc.
