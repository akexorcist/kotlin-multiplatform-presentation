import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    private let navigation: PlatformKeyboardNavigation
    
    init(navigation: PlatformKeyboardNavigation) {
        self.navigation = navigation
    }
    
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(navigation: navigation)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    private let navigation = PlatformKeyboardNavigation()
    
    var body: some View {
        ComposeView(navigation: navigation)
            .onKeyPress(.leftArrow) {
                navigation.onLeftPressed()
                return .handled
            }
            .onKeyPress(.rightArrow) {
                navigation.onRightPressed()
                return .handled
            }
            .onKeyPress(.rightArrow) {
                navigation.onSpacePressed()
                return .handled
            }
            .onKeyPress(.space) {
                navigation.onSpacePressed()
                return .handled
            }
            .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}
