package com.example.todo1.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo1.ui.theme.Todo1Theme
import com.example.todo1.viewmodel.TodoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo1.Todo


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Todo1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   TodoScreen()
                }
            }
        }
    }
}

@Composable
fun TodoScreen(todoViewModel: TodoViewModel= viewModel()){
  TodoList(todoViewModel.todos)
}


@Composable
fun TodoList(todos:List<Todo>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(todos) { todo ->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            Divider(color = Color.LightGray, thickness = 1.dp)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Todo1Theme {
        TodoScreen()
    }
}