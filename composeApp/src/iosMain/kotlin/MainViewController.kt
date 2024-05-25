import androidx.compose.ui.window.ComposeUIViewController
import ui.App
import ui.navigation.rememberScreenNavigationState

@Suppress("FunctionName")
fun MainViewController() = ComposeUIViewController {
    val screenNavigationState = rememberScreenNavigationState()
    App(
        screenNavigationState = screenNavigationState,
    )
}
