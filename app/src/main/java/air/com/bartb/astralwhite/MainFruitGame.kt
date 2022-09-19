package air.com.bartb.astralwhite

import air.com.bartb.databinding.ActivityMainCityGameBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainFruitGame : AppCompatActivity() {
    private lateinit var binding: ActivityMainCityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bsggdqw()
    }


    private fun bsggdqw() = with(binding){
        bContinue.setOnClickListener {
            val nameText = edName.text.toString()
            val cityText = edCity.text.toString()

            if(nameText.isEmpty() || nameText.length<3 && cityText.isEmpty() || cityText.length<3){
                tvError.visibility = View.VISIBLE
                tvErrorCity.visibility = View.VISIBLE
            } else {
                startActivity(
                    Intent(this@MainFruitGame, FruitGame::class.java)
                        .putExtra("name",nameText)
                        .putExtra("city",cityText)
                )
                tvError.visibility = View.GONE
                tvErrorCity.visibility = View.GONE
                edName.text.clear()
                edName.clearFocus()
                edCity.text.clear()
                edCity.clearFocus()
            }

        }
    }


}