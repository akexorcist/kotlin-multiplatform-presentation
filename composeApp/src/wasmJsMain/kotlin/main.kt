import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.akexorcist.kotlin.multiplatform.ui.feature.App
import com.akexorcist.kotlin.multiplatform.ui.navigation.rememberScreenNavigationState

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        val screenNavigationState = rememberScreenNavigationState()
        App(
            screenNavigationState = screenNavigationState,
        )
    }
}
