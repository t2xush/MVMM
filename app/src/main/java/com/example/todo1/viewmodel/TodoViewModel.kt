package com.example.todo1.viewmodel


import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo1.Todo
import com.example.todo1.TodoApi
import kotlinx.coroutines.launch
import java.lang.Exception


class TodoViewModel :ViewModel(){
    var todos= mutableStateListOf<Todo>()
        private set

    init {
        getTodoList()
    }

    private fun getTodoList(){
        viewModelScope.launch {
            var todoApi: TodoApi?=null
            try {
                todoApi= TodoApi!!.getInstance()
                todos.clear()
                todos.addAll(todoApi.getTodos())
            }catch (e:Exception){
                Log.d("TODOVIEWMODEL",e.message.toString())
            }
        }
    }

}
