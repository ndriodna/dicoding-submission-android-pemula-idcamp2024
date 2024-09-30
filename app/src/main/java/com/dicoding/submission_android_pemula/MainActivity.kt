package com.dicoding.submission_android_pemula

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.submission_android_pemula.Activity.AboutActivity
import com.dicoding.submission_android_pemula.Activity.DetailActivity
import com.dicoding.submission_android_pemula.Adapter.ListWaiufAdapter
import com.dicoding.submission_android_pemula.Model.Waifu
import com.dicoding.submission_android_pemula.databinding.ActivityMainBinding
import com.dicoding.submission_android_pemula.helper.jsonHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Waifu>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Wuthering Waves Waifu"

        binding.rvMain.setHasFixedSize(false)

        list.addAll(jsonHelper.getWaifuList(this, R.raw.chardb))
        setRvList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_menu -> {
                val moveIntent = Intent(this, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setRvList() {
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        val listWaiufAdapter = ListWaiufAdapter(list)
        binding.rvMain.adapter = listWaiufAdapter
        listWaiufAdapter.onClickItem = { waifu: Waifu ->
            val moveIntent = Intent(this, DetailActivity::class.java)
            moveIntent.putExtra("waifu", waifu)
            startActivity(moveIntent)
        }

    }


}