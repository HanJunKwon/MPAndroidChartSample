package com.example.chartsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler.Value
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlin.math.round

class BarChartActivity : AppCompatActivity() {

    private lateinit var barChart: BarChart
    private var entries: List<BarEntry> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_chart)

        barChart = findViewById(R.id.bar_chart)

        setData()
        setXAxis()
        setAxisLeft()
        setAxisRight()
        setChart()
    }

    /**
     * BarChart X축 설정
     */
    private fun setXAxis() {
        barChart.xAxis.apply {
            setDrawGridLines(false)
            position = XAxis.XAxisPosition.BOTTOM   // 축 하단 표시
            textSize = 14f                          // 라벨 텍스트 사이즈 설정

            labelCount = entries.size   // X축 라벨링을 위하여 entries 갯수만큼 라벨 표시.
            granularity = 1f            // X축 라벨의 간격을 1f로 설정하여 라벨링이 중복되지 않도록 수정
            // X축의 라벨링 커스텀
            valueFormatter = object : ValueFormatter() {
                override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                    return value.toInt().toString()
                }
            }
        }
    }

    /**
     * BarChart 주 Y축 설정
     */
    private fun setAxisLeft() {
        barChart.axisLeft.apply {
            setDrawGridLines(false)
            setDrawAxisLine(false)
            textColor = getColor(R.color.black)
            textSize = 12f
        }
    }

    /**
     * BarChart 보조 Y축 설정
     */
    private fun setAxisRight() {
        barChart.axisRight.apply {
            setDrawGridLines(false)
            setDrawAxisLine(false)
            textColor = getColor(R.color.black)
            textSize = 12f
        }
    }

    private fun setData() {
        entries = mutableListOf(
            BarEntry(0f, 100f),
            BarEntry(1f, 200f),
            BarEntry(2f, 300f),
            BarEntry(3f, 300f),
            BarEntry(4f, 300f),
            BarEntry(5f, 300f),
            BarEntry(6f, 300f),
            BarEntry(7f, 300f),
            BarEntry(8f, 300f),
            BarEntry(9f, 300f),
            BarEntry(10f, 300f),
            BarEntry(11f, 300f),
            BarEntry(12f, 300f),
            BarEntry(13f, 300f),
            BarEntry(14f, 300f),
        )

        var dataSet = BarDataSet(entries, "Counter").apply {
            setDrawValues(false)
        }

        var barData = BarData(dataSet).apply {
            barWidth = 0.5f
            setValueTextSize(16f)
        }

        barChart.data = barData
        barChart.invalidate()
    }

    private fun setChart() {
        barChart.apply {
            setPinchZoom(true)
            description.isEnabled = false   // Desciprtion Hide
        }
    }
}