package com.pberrueco.pmdmu2actividad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pberrueco.pmdmu2actividad.databinding.ActivityHomeBinding
import com.pberrueco.pmdmu2actividad.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityHomeBinding
    private val binding: ActivityHomeBinding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}