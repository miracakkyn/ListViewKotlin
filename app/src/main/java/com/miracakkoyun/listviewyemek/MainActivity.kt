package com.miracakkoyun.listviewyemek

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.miracakkoyun.listviewyemek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var pizza=yemekler("Pizza",250,R.drawable.pizza)
        var corba=yemekler("Çorba", 100,R.drawable.corba)
        var doner=yemekler("Et Döner",200,R.drawable.doner)
        var kofteBurger=yemekler("Hamburger",200,R.drawable.kofteburger)
        var yemeklerListe=ArrayList<yemekler>()
        yemeklerListe.add(pizza)
        yemeklerListe.add(corba)
        yemeklerListe.add(doner)
        yemeklerListe.add(kofteBurger)

        //Adapter veri ile xml dosyalarını bağlamak için

        //var adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,yemeklerListe)
        //binding.listView.adapter=adapter
            // bu şekilde çalıştırırsak bize abuk subuk yazıların olduğu bir liste verir bu ayzılar bellekten gelir
            // biz bunun yazdığı yerde yemek adlarının yazmasını istiyoruzs

        //bu hatayı engellemek için map kullanmamız gerek
        var adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,yemeklerListe.map { yemekler -> yemekler.name })
        binding.listView.adapter=adapter
    
        binding.listView.onItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->
            var intent= Intent(this,YemekDetay::class.java)
            intent.putExtra("name",yemeklerListe.get(position).name)
            intent.putExtra("price",yemeklerListe.get(position).price)
            intent.putExtra("image",yemeklerListe.get(position).image)

            startActivity(intent)
        }
        
    }
}