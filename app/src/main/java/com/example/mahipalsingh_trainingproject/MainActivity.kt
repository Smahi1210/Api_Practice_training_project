package com.example.mahipalsingh_trainingproject

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mahipalsingh_trainingproject.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btApiCall.setOnClickListener {
            // Created Retrofit Service Instance
            val methods = RetrofitClient.getRetrofitInstance().create(Methods::class.java)

            // Make Api Call
            val call: Call<Model> = methods.getAllData()

            call.enqueue(object : Callback<Model> {
                override fun onResponse(call: Call<Model>, response: Response<Model>) {
                    // Handle API response
                    val data = response.body()?.data
                    val names = data?.map {
                        "Id : ${it.id}\nName : ${it.first_name} ${it.last_name}\nEmail : ${it.email}"
                    }?.toTypedArray()
                    binding.lvUser.adapter = ArrayAdapter(
                        applicationContext,
                        R.layout.simple_list_item_1,
                        names ?: emptyArray()
                    )
                }
                override fun onFailure(call: Call<Model>, t: Throwable) {
                    // Handle API call failure
                    Toast.makeText(applicationContext, "An error has occurred", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}

