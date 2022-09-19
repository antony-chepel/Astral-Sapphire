package air.com.bartb.astralwhite

import air.com.bartb.R
import air.com.bartb.databinding.ActivityCityGameBinding
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListPopupWindow
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_city_game.*
import kotlin.random.Random

class FruitGame : AppCompatActivity() {
    private lateinit var binding: ActivityCityGameBinding
    private var dhsdhd = false
    private var jaiiaw: CountDownTimer? = null
    private var currentSpinCheck : String? = null
    private var fruitname : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imLogOut.setOnClickListener {
            startActivity(Intent(this@FruitGame,MainFruitGame::class.java))
        }
        getName()
        getCity()
        binding.bRes.setOnClickListener {
            iweqwwqefffsd()
        }

        val adapter = ArrayAdapter(this@FruitGame,R.layout.spinner_item_text,FruitsList.fruitsList)
        listDropdownSize(binding.spinner)
        binding.spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                currentSpinCheck = FruitsList.fruitsList[position]

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    @SuppressLint("DiscouragedPrivateApi")
    private fun listDropdownSize(spntText : Spinner) = with(binding){
        val popup = Spinner :: class.java.getDeclaredField("mPopup")
        popup.isAccessible = true
        val popUpMenu = popup.get(spntText) as ListPopupWindow
        popUpMenu.height = (200 * resources.displayMetrics.density).toInt()
    }

    @SuppressLint("SetTextI18n")
    private fun getName() =with(binding){
        val name = intent.getStringExtra("name")
        tvName.text = "Hello,$name!"
    }

    private fun getCity(){
        val city = intent.getStringExtra("city")
        binding.tvCity.text = city
        fruitname = city

    }


    private fun iweqwwqefffsd() = with(binding){
        var counter = 0
        jaiiaw?.cancel()
        jaiiaw = object : CountDownTimer(3000,100){
            override fun onTick(millisUntilFinished: Long) {
                counter++
                dhsdhd = true
                bRes.alpha = 0.7f
                spinner.isEnabled = false
                if(counter>13) counter = 0
                tvCity.text = FruitsList.fruitsList[counter]
            }

            override fun onFinish() {
                nncdswd()
                dhsdhd = false
                spinner.isEnabled = true
                bRes.alpha = 1.0f

            }

        }.start()

    }

    private fun nncdswd() =with(binding) {
        val tipText = FruitsList.fruitsList[Random.nextInt(14)]
        tvCity.text = tipText
     Handler().postDelayed({
         if(tipText == currentSpinCheck){
             startActivity(
                 Intent(this@FruitGame, ResultFruit::class.java)
                     .putExtra("success","success")
             )
         } else {
             startActivity(Intent(this@FruitGame, ResultFruit::class.java)
                 .putExtra("unluck","unluck")
             )
         }
     },1000)




    }


}