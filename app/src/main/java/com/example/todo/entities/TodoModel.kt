package com.example.todo.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="todo_table")
class TodoModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long =0,
    val name:String,
    var priority:String,
    var date: Long,
    var time: Long,
    @ColumnInfo(name="Done")
    var isCompleted: Boolean=false

)