package com.example.chartsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnBarChart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBarChart = findViewById(R.id.btn_bar_chart)
        btnBarChart.setOnClickListener {
            startActivity(Intent(this, BarChartActivity::class.java))
        }
    }
}