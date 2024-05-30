import androidx.compose.ui.window.ComposeUIViewController
import com.akexorcist.kotlin.multiplatform.ui.content.App
import com.akexorcist.kotlin.multiplatform.ui.navigation.rememberScreenNavigationState

@Suppress("FunctionName")
fun MainViewController() = ComposeUIViewController {
    val screenNavigationState = rememberScreenNavigationState()
    App(
        screenNavigationState = screenNavigationState,
    )
}
