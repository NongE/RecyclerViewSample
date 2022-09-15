package com.project.recyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.recyclerviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookList = mutableListOf<BookData>(
            BookData("A Book", "1000", "Publisher A"),
            BookData("B Book", "1100", "Publisher B"),
            BookData("C Book", "1200", "Publisher C"),
            BookData("D Book", "1300", "Publisher D"),
            BookData("E Book", "1400", "Publisher E"),
            BookData("F Book", "1500", "Publisher F"),
            BookData("G Book", "1600", "Publisher G"),
            BookData("H Book", "1700", "Publisher H"),
            BookData("I Book", "1800", "Publisher I"),
        )

        val adapter = BookAdaptor(bookList)

        adapter.setOnItemClickListener(object : BookAdaptor.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                Toast.makeText(v.context, "$position is clicked!", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(v: View, position: Int): Boolean {
                Toast.makeText(v.context, "$position is long clicked!", Toast.LENGTH_SHORT).show()
                return true
            }
        })

        binding.bookRecyclerView.adapter = adapter
        binding.bookRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}