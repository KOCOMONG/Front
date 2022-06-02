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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController= Navigation.findNavController(this,R.id.fragmentContainerView2)
        setupWithNavController(binding.bottomNavigationView,navController)



    }

    fun startChat(v:View){
        val intent = Intent(this,ChatActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_up_enter, R.anim.stay_exit)
    }

    fun medicineResult(v:View){
        val intent = Intent(this,MedicineResultActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_up_enter, R.anim.stay_exit)
    }

    fun startDiet(v:View){
        val intent = Intent(this,DietResultActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_up_enter, R.anim.stay_exit)
    }
}