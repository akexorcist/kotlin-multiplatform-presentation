import UIKit
import SwiftUI
import ComposeApp
import GoogleMaps

struct ComposeView: UIViewControllerRepresentable {
    private let navigation: PlatformKeyboardNavigation
    
    init(navigation: PlatformKeyboardNavigation) {
        self.navigation = navigation
    }
    
    func makeUIViewController(context: Context) -> UIViewController {
        setupGoogleMaps()
        return MainViewControllerKt.MainViewController(navigation: navigation)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
    
    private func setupGoogleMaps() {
        let filePath = Bundle.main.path(forResource: "AppSecrets", ofType: "plist")!
        let plist = NSDictionary(contentsOfFile: filePath)!
        let googleMapsApiKey = plist["GOOGLE_MAPS_API_KEY"] as! String
        GMSServices.provideAPIKey(googleMapsApiKey)
    }
}

struct ContentView: View {
    private let navigation = PlatformKeyboardNavigation()
    
    var body: some View {
        ComposeView(navigation: navigation)
//            .onKeyPress(.leftArrow) {
//                navigation.onLeftPressed()
//                return .handled
//            }
//            .onKeyPress(.rightArrow) {
//                navigation.onRightPressed()
//                return .handled
//            }
//            .onKeyPress(.space) {
//                navigation.onSpacePressed()
//                return .handled
//            }
            .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}
