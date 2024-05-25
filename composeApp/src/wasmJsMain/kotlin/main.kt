import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import ui.App
import ui.navigation.rememberScreenNavigationState

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        val screenNavigationState = rememberScreenNavigationState()
        App(
            screenNavigationState = screenNavigationState,
        )
    }
}
