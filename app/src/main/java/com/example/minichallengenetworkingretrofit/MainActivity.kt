package com.example.minichallengenetworkingretrofit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.minichallengenetworkingretrofit.adapter.CountryAdapter
import com.example.minichallengenetworkingretrofit.model.GetAllCountryResponseItem
import com.example.minichallengenetworkingretrofit.network.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDataCountries()
    }

    private fun getDataCountries() {
        ApiClient.instance.getAllCountry()
            .enqueue(object : Callback<List<GetAllCountryResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllCountryResponseItem>>,
                    response: Response<List<GetAllCountryResponseItem>>
                ) {
                    if (response.isSuccessful) {
                        val dataCountries = response.body()
                        val adapt = CountryAdapter(dataCountries!!)
                        val lm = LinearLayoutManager(
                            applicationContext,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        rv_country_list.layoutManager = lm
                        rv_country_list.adapter = adapt
                    } else {
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllCountryResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}