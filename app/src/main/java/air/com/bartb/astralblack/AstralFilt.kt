package air.com.bartb.astralblack

import air.com.bartb.R
import air.com.bartb.astralblack.ASTRALCONST.C1
import air.com.bartb.astralblack.ASTRALCONST.D1
import air.com.bartb.astralblack.ASTRALCONST.DEV
import air.com.bartb.astralwhite.MainFruitGame
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_filt.*
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class AstralFilt : AppCompatActivity() {

    lateinit var jsoup: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filt)

        jsoup = ""

        val job = GlobalScope.launch(Dispatchers.IO) {
            jsoup = gststdwqdqwd()
            Log.d("jsoup status from global scope", jsoup)
        }

        runBlocking {
            try {
                job.join()

                Log.d("jsoup status out of global scope", jsoup)
                txtMain.text = jsoup

                if (jsoup == ASTRALCONST.jsoupCheck) {
                    Intent(applicationContext, MainFruitGame::class.java).also { startActivity(it) }
                } else {
                    Intent(applicationContext, AstralWeb::class.java).also { startActivity(it) }
                }
                finish()
            } catch (e: Exception) {

            }
        }

    }

    private suspend fun gststdwqdqwd(): String {
        val hawk: String? = Hawk.get(C1, "null")
        val hawkAppLink: String? = Hawk.get(D1, "null")
        val hawkDevOrNot: String? = Hawk.get(DEV, "false")


        //added devModeCheck
        val forJsoupSetNaming: String = ASTRALCONST.lru + ASTRALCONST.odone + hawk + "&" + ASTRALCONST.twoSub + hawkDevOrNot
        val forJsoupSetAppLnk: String = ASTRALCONST.lru + ASTRALCONST.odone + hawkAppLink + "&" +  ASTRALCONST.twoSub + hawkDevOrNot

        withContext(Dispatchers.IO) {
            //changed logical null to string null
            if (hawk != "null") {
                oaspooqweqwe(forJsoupSetNaming)
                Log.d("Check1C", forJsoupSetNaming)
            } else {
                oaspooqweqwe(forJsoupSetAppLnk)
                Log.d("Check1C", forJsoupSetAppLnk)
            }
        }
        return jsoup
    }

    private fun oaspooqweqwe(link: String) {
        val url = URL(link)
        val urlConnection = url.openConnection() as HttpURLConnection

        try {
            val text = urlConnection.inputStream.bufferedReader().readText()
            if (text.isNotEmpty()) {
                Log.d("jsoup status inside Url function", text)
                jsoup = text
            } else {
                Log.d("jsoup status inside Url function", "is null")
            }
        } catch (ex: Exception) {

        } finally {
            urlConnection.disconnect()
        }
    }

}