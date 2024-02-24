package com.example.todo.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo.daos.TodoDao
import com.example.todo.entities.TodoModel

@Database(entities = [TodoModel::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun getTodoDao(): TodoDao

    companion object{
        private var todoDatabase: TodoDatabase? = null

        fun getDb(context: Context):TodoDatabase{
            return todoDatabase?:synchronized(this){
                val db = Room.databaseBuilder(context, TodoDatabase::class.java, "todo_db")
                    .allowMainThreadQueries()
                    .build()
                todoDatabase = db
                db
            }
        }
    }
}