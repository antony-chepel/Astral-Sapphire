package air.com.bartb.astralwhite

import air.com.bartb.R
import air.com.bartb.databinding.ActivityResultCityBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ResultFruit : AppCompatActivity() {
    private lateinit var binding: ActivityResultCityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultCityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gshdhwqd()
    }

    private fun gshdhwqd() = with(binding) {
        val sadres = intent.getStringExtra("success")
        val success = intent.getStringExtra("unluck")

        if (sadres?.isNotEmpty() == true) {
            imWeather.setImageResource(R.drawable.fr_sucess)
        }

        if (success?.isNotEmpty() == true) {


            imWeather.setImageResource(R.drawable.fr_unluck)
            tvResText.text = "Unfortunately, bad luck now"
        }

        bTry.setOnClickListener {
            startActivity(Intent(this@ResultFruit,MainFruitGame::class.java))
        }
    }
}