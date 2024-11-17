package com.miracakkoyun.listviewyemek

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.miracakkoyun.listviewyemek.databinding.ActivityMainBinding
import com.miracakkoyun.listviewyemek.databinding.ActivityYemekDetayBinding

class YemekDetay : AppCompatActivity() {
    lateinit var binding: ActivityYemekDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYemekDetayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var intent=intent
        var isim=intent.getStringExtra("name")
        var fiyat=intent.getIntExtra("price",0)
        var image=intent.getIntExtra("image",0)
        binding.textView.text=isim
        binding.textView2.text=fiyat.toString()
        binding.imageView.setImageResource(image)
    }
}