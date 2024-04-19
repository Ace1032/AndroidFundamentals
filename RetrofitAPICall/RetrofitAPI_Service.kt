
fun main(){
	RetrofitAPI_Service.execute()
}


    data class User(
		var id: Int,
		var name: String,
		var email: String
    	)


import retrofit2.Response
import retrofit2.http.*

interface APIService {
	
	@GET("/users")
	suspend fun getUsers():Response<List<User>>
	
	@POST("/users")
	suspend fun createUser(@Body user:User): Response<User>
	
	@PUT("/users/{id}")
	suspend fun updateUser(@Path("id") id:Int, @Body user: User): Response<User>
	
	@DELETE("/users/{id}")
	suspend fun deleteUser(@Path("id") id:Int) Response<Unit>

}


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object APIClient {
	
	private const val BASE_URL= "http:://api.example.com"
	
	val apiService: APIService by lazy {
		
		val restrofit: Restrofit.Builder()
					.baseUrl(BASE_UR)
					.addConverterFactory(GsonConverterFactory.create())
					.build()
		
		restrofit.create(APIService::class.java)
		
		}	
}



object RetrofitAPI_Service {
	
	private val apiService = APIClient.apiService
	
	fun execute() = runBlocking {
		
		//Get All Users
		val userResponse= apiService.getUsers()
		
		if(userResponse.isSuccessful){
			val users= userResponse.body()
			//Add user into a ArrayList
			
		}else {
            println("Error")
        }
		
		
		//Crate new User
		val newUser = User(id = 1, name = "John", email = "john@example.com")
		val createUserResponse= apiService.createUser((newUser)
			
			if (createUserResponse.isSuccessful) {
            val user = createUserResponse.body()
				
            //Report to the UI new user created successfully 
			} else {
            println("Error creating new User")
      }
			
		
	}
	
	

}
