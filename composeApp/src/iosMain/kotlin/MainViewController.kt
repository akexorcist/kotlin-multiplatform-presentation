import androidx.compose.ui.window.ComposeUIViewController
import com.akexorcist.kotlin.multiplatform.ui.content.App
import com.akexorcist.kotlin.multiplatform.ui.navigation.rememberScreenNavigationState

@Suppress("FunctionName")
fun MainViewController(navigation: PlatformKeyboardNavigation) = ComposeUIViewController {
    val screenNavigationState = rememberScreenNavigationState()
    navigation.addOnKeyEventListener(
        PlatformKeyboardNavigationAdapter(
            onLeftPressed = { screenNavigationState.back() },
            onMetaLeftPressed = { screenNavigationState.first() },
            onRightPressed = { screenNavigationState.next() },
            onMetaRightPressed = { screenNavigationState.last() },
            onSpacePressed = { screenNavigationState.next() },
        )
    )
    App(
        screenNavigationState = screenNavigationState,
    )
}

class PlatformKeyboardNavigation {
    private val listeners = arrayListOf<Listener>()

    fun onLeftPressed() {
        listeners.forEach { it.onLeftPressed() }
    }

    fun onMetaLeftPressed() {
        listeners.forEach { it.onMetaLeftPressed() }
    }

    fun onRightPressed() {
        listeners.forEach { it.onRightPressed() }
    }

    fun onMetaRightPressed() {
        listeners.forEach { it.onMetaRightPressed() }
    }

    fun onSpacePressed() {
        listeners.forEach { it.onSpacePressed() }
    }

    fun addOnKeyEventListener(
        listener: Listener
    ) {
        listeners.add(listener)
    }

    interface Listener {
        fun onLeftPressed()
        fun onMetaLeftPressed()
        fun onRightPressed()
        fun onMetaRightPressed()
        fun onSpacePressed()
    }
}

private class PlatformKeyboardNavigationAdapter(
    onLeftPressed: () -> Unit,
    onMetaLeftPressed: () -> Unit,
    onRightPressed: () -> Unit,
    onMetaRightPressed: () -> Unit,
    onSpacePressed: () -> Unit,
) : PlatformKeyboardNavigation.Listener {
    override fun onLeftPressed() {
        onLeftPressed()
    }

    override fun onMetaLeftPressed() {
        onMetaLeftPressed()
    }

    override fun onRightPressed() {
        onRightPressed()
    }

    override fun onMetaRightPressed() {
        onMetaRightPressed()
    }

    override fun onSpacePressed() {
        onSpacePressed()
    }
}
