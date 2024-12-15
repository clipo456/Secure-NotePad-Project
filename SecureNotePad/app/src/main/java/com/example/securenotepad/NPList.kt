package com.example.securenotepad

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NPList : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nplist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listView = findViewById<ListView>(R.id.lstvLista)
        val names = arrayOf("Teste01","Test02","Teste03")

        var ArrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, names
        )

        listView.adapter = ArrayAdapter
        listView.setOnItemClickListener{ adapterView, view, i, l ->
            /*Toast.makeText(this,"Item Selected "+ names[i],Toast.LENGTH_SHORT)
                .show()*/
            val intent = Intent(applicationContext, Note::class.java)

            startActivity(intent)
        }
    }
}