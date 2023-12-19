package com.example.tunisia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var recycler: RecyclerView
    private lateinit var fabDelete: FloatingActionButton
    private lateinit var adapter: MyAdapter
    private val tunisiaList = mutableListOf<tunisia>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recyclerView)
        tunisiaList.addAll(createTunisiaList())
        adapter = MyAdapter(tunisiaList, this)
        val layoutRecycler = LinearLayoutManager(applicationContext)
        recycler.layoutManager = layoutRecycler
        recycler.adapter = adapter

    }
    private fun createTunisiaList(): List<tunisia> {
        val tunisiaList = mutableListOf<tunisia>()

        tunisiaList.add(tunisia("Ariana1", R.drawable.bizerte))
        tunisiaList.add(tunisia("Ariana2", R.drawable.bizerte))
        tunisiaList.add(tunisia("Ariana3", R.drawable.bizerte))
        tunisiaList.add(tunisia("Ariana4", R.drawable.bizerte))
        tunisiaList.add(tunisia("Ariana5", R.drawable.bizerte))

        return tunisiaList
    }

    override fun onitemClicked(v: View?, item: tunisia?) {
        val intent = Intent(v?.context, DetailActivity::class.java)
        intent.putExtra("country_name", item?.name)
        intent.putExtra("country_image", item?.photoResourceId)
        v?.context?.startActivity(intent)
    }

     fun onItemDeleteClick(item: tunisia) {
        tunisiaList.remove(item)
        adapter.notifyDataSetChanged()
    }


}
