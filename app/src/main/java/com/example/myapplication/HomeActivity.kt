package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityHomeBinding
    private lateinit var navController: NavController
    private var id: String? = ""
    private var name: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController= Navigation.findNavController(this,R.id.fragmentContainerView2)
        setupWithNavController(binding.bottomNavigationView,navController)
        id = intent.getStringExtra("id")
        name =intent.getStringExtra("name")
    }
    fun startChat(v:View){
        val intent = Intent(this,ChatActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_up_enter, R.anim.stay_exit)
    }
    fun startMedicine(v:View){
        val intent = Intent(this,MedicineActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_up_enter, R.anim.stay_exit)
    }
    fun startDiet(v:View){
        val intent = Intent(this,DietActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_up_enter, R.anim.stay_exit)
    }
    fun startProfile(v:View){
        val intent = Intent(this,ProfileActivity::class.java)
        intent.putExtra("id", id)
        intent.putExtra("name", name)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_up_enter, R.anim.stay_exit)
    }
}