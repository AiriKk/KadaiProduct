package com.example.kadaiproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kadaiproject.databinding.ActivityMainBinding
import com.example.kadaiproject.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private lateinit var bindingW: ActivityWriteBinding
    private lateinit var prefW: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingW = ActivityWriteBinding.inflate(layoutInflater).apply{
            setContentView(this.root)}

        val writeIntent: Intent = Intent(this,MainActivity::class.java)
        val editor = prefW.edit()
        var writtenNote = bindingW.writtenText.text.toString()

    bindingW.doneFloatingButton.setOnClickListener{

        editor.putString("notes",writtenNote)
        editor.apply()
        startActivity(writeIntent)
        }

    }
}