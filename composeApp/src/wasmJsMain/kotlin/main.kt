import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.window.CanvasBasedWindow
import com.akexorcist.kotlin.multiplatform.ui.content.App
import com.akexorcist.kotlin.multiplatform.ui.navigation.rememberScreenNavigationState
import kotlinx.browser.document
import org.jetbrains.compose.resources.configureWebResources
import org.w3c.dom.events.KeyboardEvent

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    configureWebResources {
        resourcePathMapping { path -> "./$path" }
    }
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        val screenNavigationState = rememberScreenNavigationState()
        document.onkeydown = { event ->
            navigationKeyEvent(
                event = event,
                onSpace = { screenNavigationState.next() },
                onMetaRight = { screenNavigationState.last() },
                onRight = { screenNavigationState.next() },
                onMetaLeft = { screenNavigationState.first() },
                onLeft = { screenNavigationState.back() },
            )
        }
        App(
            screenNavigationState = screenNavigationState,
        )
    }
}


fun navigationKeyEvent(
    event: KeyboardEvent,
    onSpace: () -> Unit,
    onMetaRight: () -> Unit,
    onRight: () -> Unit,
    onMetaLeft: () -> Unit,
    onLeft: () -> Unit,
) {
    when {
        event.keyCode == Key.Spacebar.code() -> onSpace()
        event.keyCode == Key.DirectionRight.code() && event.metaKey -> onMetaRight()
        event.keyCode == Key.DirectionRight.code() -> onRight()
        event.keyCode == Key.DirectionLeft.code() && event.metaKey -> onMetaLeft()
        event.keyCode == Key.DirectionLeft.code() -> onLeft()
    }
}

private fun Key.code() = this.keyCode.toInt()