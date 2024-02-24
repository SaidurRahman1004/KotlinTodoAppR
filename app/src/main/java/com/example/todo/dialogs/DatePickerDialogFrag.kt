package com.example.todo.dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerDialogFrag(val callback: (Long) ->Unit): DialogFragment(),DatePickerDialog.OnDateSetListener {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar= Calendar.getInstance()
        val year=calendar.get(Calendar.YEAR)
        val month=calendar.get(Calendar.MONTH)
        val day=calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireActivity(), this,year,month,day)


    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar=Calendar.getInstance()
        calendar.set(year,month,dayOfMonth)
        val timestamp = calendar.timeInMillis

    }
}