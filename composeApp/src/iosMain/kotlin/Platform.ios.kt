import platform.CoreLocation.CLLocationManager
import platform.UIKit.UIDevice
import platform.WebKit.WKWebView

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
//    override val name: String
//        get() = throw NullPointerException("Awesome")
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun getDeviceInformation(): List<String> {
    return listOf()
}

//fun awesome() {
//
//    val manager = CLLocationManager.new()?.let {
//        val status: Int = it.authorizationStatus
//        // Do something
//    }
//
//    val webView = WKWebView()
//
//
//    platform.DeviceCheck.DCDevice.currentDevice.
//}