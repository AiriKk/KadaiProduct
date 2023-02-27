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
        bindingW = ActivityWriteBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        // TODO: SharedPreferences を初期化する
        prefW = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)

        val writeIntent: Intent = Intent(this, MainActivity::class.java)
        val editor = prefW.edit()

        // FIXME: onCreate で EditText の text を取得すると、その時点で表示されていた内容が取得されてしまう
        var writtenNote = bindingW.writtenText.text.toString()

        bindingW.doneFloatingButton.setOnClickListener {

            editor.putString("notes", writtenNote)
            editor.apply()
            startActivity(writeIntent)
        }
    }
}