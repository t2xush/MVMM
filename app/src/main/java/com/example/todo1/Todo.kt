package com.example.todo1
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Todo(
    var userId:Int,
    var id: Int,
    var title:String,
    var completed:Boolean
)

const val Base_URL="https://jsonplaceholder.typicode.com"

interface TodoApi{
    @GET("todos")
    suspend fun getTodos():List<Todo>

    companion object{
        var todoService: TodoApi?=null
        fun getInstance(): TodoApi {
            if(todoService ===null){
                todoService =Retrofit.Builder()
                    .baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodoApi::class.java)
            }
            return todoService!!
        }
    }
}