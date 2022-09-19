package air.com.bartb

import air.com.bartb.astralblack.ASTRALCONST.MAIN_ID
import air.com.bartb.astralblack.ASTRALCONST.ONESIGNAL_APP_ID
import air.com.bartb.astralblack.AstralAdv
import android.app.Application
import android.content.Context
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AppClass : Application() {
    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        GlobalScope.launch(Dispatchers.IO) {
            hdydtwqwqe(context = applicationContext)
        }
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }

    private suspend fun hdydtwqwqe(context: Context) {
        val advertisingInfo = AstralAdv(context)
        val idInfo = advertisingInfo.yststdtqwd()
        Hawk.put(MAIN_ID, idInfo)
    }
}