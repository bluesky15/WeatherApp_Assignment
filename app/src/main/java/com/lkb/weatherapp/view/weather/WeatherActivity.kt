package com.lkb.weatherapp.view.weather

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.lkb.weatherapp.Constants
import com.lkb.weatherapp.R
import com.lkb.weatherapp.model.data.WeatherResponse
import com.lkb.weatherapp.view.common.BaseActivity
import com.lkb.weatherapp.viewmodel.ViewModelFactory
import com.lkb.weatherapp.viewmodel.weather.WeatherViewModel
import kotlinx.android.synthetic.main.weather_main.*
import javax.inject.Inject

class WeatherActivity : BaseActivity(), MyAdapter.OnItemClickListener {

    @Inject
    lateinit var adapter: MyAdapter

    @Inject
    lateinit var mViewModelFactory: ViewModelFactory

    private lateinit var mViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresentationComponent().inject(this)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.weather_main)
        recycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            this,
            androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
            false
        )
        adapter.setListenerInstance(this)
        recycler.adapter = adapter
    }


    override fun onStart() {
        super.onStart()
        mViewModel = ViewModelProvider(this,mViewModelFactory)
            .get(WeatherViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        bindWeatherData()

    }

    private fun bindWeatherData() {
            mViewModel.callWeather("hyderabad","Metric", Constants.WEATHER_API_KEY)
            mViewModel.mWeatherData.observe(this,{
                initUi(it)
            })
    }
    private fun initUi(data: WeatherResponse.WeatherData) {
        temparatureTxt.text = data.main.temp.toString()
        locationTxt.text = data.name
        progressBar.visibility = View.GONE
        locationTxt.visibility = View.VISIBLE
        temparatureTxt.visibility = View.VISIBLE
        degreeImage.visibility = View.VISIBLE
    }

    override fun onCityClicked(city: String) {
        mViewModel.callWeather(city,"Metric", Constants.WEATHER_API_KEY)
    }

}