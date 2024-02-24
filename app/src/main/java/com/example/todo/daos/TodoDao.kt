package com.example.todo.daos
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todo.entities.TodoModel

@Dao
interface TodoDao {
    @Insert
    fun addTodo(todoModel: TodoModel)

    @Update
    fun updateTodo(todoModel: TodoModel)

    @Delete
    fun deleteTodo(todoModel: TodoModel)

    @Query("select * from todo_table order by id desc")
    fun getAllTodos(): LiveData<List<TodoModel>>
}