package com.example.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.example.todo.databinding.FragmentNewtodoBinding
import com.example.todo.db.TodoDatabase
import com.example.todo.dialogs.DatePickerDialogFrag
import com.example.todo.dialogs.TimePickerDialogFr
import com.example.todo.entities.TodoModel
import com.example.todo.utils.getFormattedDateTime
import com.example.todo.utils.priority_normal


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class newtodoF : Fragment() {
    private lateinit var binding:FragmentNewtodoBinding
    private var priority= priority_normal

    private var dateInMillis = System.currentTimeMillis()
    private var timeInMillis = System.currentTimeMillis()

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentNewtodoBinding.inflate(inflater,container,false)

        binding.priorityRG.setOnCheckedChangeListener { radioGroup, i ->
            val rb= radioGroup.findViewById<RadioButton>(i)
            priority=rb.text.toString()
            Toast.makeText(activity, priority, Toast.LENGTH_SHORT).show()

        }

        binding.dateBtn.setOnClickListener {
            DatePickerDialogFrag {timestamp->
                dateInMillis = timestamp
                binding.dateBtn.text= getFormattedDateTime(dateInMillis,"yyyy-MM-dd HH:mm:ss")
            }.show(childFragmentManager,"date_picker")

        }

        binding.timeBtn.setOnClickListener {
            TimePickerDialogFr {timestamp->
                dateInMillis = timestamp
                binding.timeBtn.text= getFormattedDateTime(dateInMillis,"hh:mm:a")


            }.show(childFragmentManager,"time_picker")



        }

        binding.sabebt.setOnClickListener {
            val todoName = binding.todoInputEt.text.toString()
            if (todoName.isEmpty()){
                binding.todoInputEt.error="Inout Valid ToDo"
                return@setOnClickListener
            }
            val todo = TodoModel(name=todoName,priority=priority, date = dateInMillis, time = timeInMillis)
            TodoDatabase.getDb(requireActivity()).getTodoDao().addTodo(todo)
        }

        return binding.root
    }

}