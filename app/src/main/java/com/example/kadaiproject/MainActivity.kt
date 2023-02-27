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

        /**
         * FIXME: SharedPreferences で値を取り出せているのはGood！
         * SharedPreferences では配列をそのまま保存することができないので、配列を文字列に変換し、配列のフォーマットが守られた文字列を保存する必要がある
         * なので、SharedPreferences から文字列を取り出したら、その文字列を配列に戻してあげる必要がある
         */
        var note = pref.getString("notes","[]")

        // FIXME: 削除して良さそう！
        //データを用意
        var writtenList = mutableListOf<String>("A","B","C","D","E")

        /**
         * TODO: writeList には、保存している文字列を変換して得られた配列を代入すると良さそう！
         * val note = pref.getString("notes","[]")
         * val writtenList = `文字列を配列に戻す処理`(note)
         */
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