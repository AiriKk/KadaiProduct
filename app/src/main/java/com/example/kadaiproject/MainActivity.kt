package com.example.kadaiproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.kadaiproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val mainIntent: Intent = Intent(this,WriteActivity::class.java)

        pref = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
        var note = pref.getString("notes","[]")

        //データを用意
        var writtenList = mutableListOf<String>("A","B","C","D","E")
        writtenList.add(0,note.toString())

        //ListViewにデータをセット
        binding.memoListView.adapter = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,writtenList)

        //FloatingButtonをクリックした時の処理
        binding.addFloatingButton.setOnClickListener{
            startActivity(mainIntent)
        }

    }
}