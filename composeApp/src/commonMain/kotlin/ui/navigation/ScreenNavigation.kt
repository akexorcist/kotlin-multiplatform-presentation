package ui.navigation

import androidx.compose.runtime.*

@Composable
fun rememberScreenNavigationState() = remember { ScreenNavigationState() }

class ScreenNavigationState {
    var currentScreen by mutableStateOf(Screen.Introduction)
        private set

    fun next() {
        if (IndexedScreens.indexOf(currentScreen) < IndexedScreens.lastIndex) {
            currentScreen = IndexedScreens[IndexedScreens.indexOf(currentScreen) + 1]
        }
    }

    fun back() {
        if (IndexedScreens.indexOf(currentScreen) > 0) {
            currentScreen = IndexedScreens[IndexedScreens.indexOf(currentScreen) - 1]
        }
    }

    fun goTo(screen: Screen) {
        currentScreen = screen
    }

    fun first() {
        currentScreen = IndexedScreens.first()
    }

    fun last() {
        currentScreen = IndexedScreens.last()
    }
}
