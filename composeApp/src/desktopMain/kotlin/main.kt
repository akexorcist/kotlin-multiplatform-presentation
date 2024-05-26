import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.*
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import ui.App
import ui.component.template.DefaultTemplate
import ui.navigation.rememberScreenNavigationState

private val PreviewCode = """
    // Single-line function with default argument and lambda expression
    fun calculate(x: Int, y: Int = 0, operation: (Int, Int) -> Int) = operation(x, y)
    
    // Function call with named argument and lambda expression
    val result = calculate(x = 5, operation = { a, b -> a + b })
    
    // Data class with default value for one property
    data class Person(val name: String, val age: Int = 0)
    
    // Object declaration with a single function
    object MySingleton {
        fun doSomething() = println("Doing something...")
    }
    
    // Extension function to check if a number is even
    fun Int.isEven() = this % 2 == 0
    
    // Higher-order function that operates on two numbers using a provided operation
    fun operate(a: Int, b: Int, operation: (Int, Int) -> Int): Int = operation(a, b)
""".trimIndent()

fun main() = application {
    val screenNavigationState = rememberScreenNavigationState()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kotlin Multiplatform",
        state = WindowState(
            size = DpSize(1280.dp, 720.dp),
        ),
        onKeyEvent = { event ->
            println(event)
            when {
                event.key == Key.Spacebar && event.type == KeyEventType.KeyDown -> {
                    screenNavigationState.next()
                    true
                }

                event.key == Key.DirectionRight && event.type == KeyEventType.KeyDown && event.isMetaPressed -> {
                    screenNavigationState.last()
                    true
                }

                event.key == Key.DirectionRight && event.type == KeyEventType.KeyDown -> {
                    screenNavigationState.next()
                    true
                }

                event.key == Key.DirectionLeft && event.type == KeyEventType.KeyDown && event.isMetaPressed -> {
                    screenNavigationState.first()
                    true
                }

                event.key == Key.DirectionLeft && event.type == KeyEventType.KeyDown -> {
                    screenNavigationState.back()
                    true
                }

                else -> false
            }
        }
    ) {
        App(
            screenNavigationState = screenNavigationState
        )
    }
}


@Preview
@Composable
fun AppPreview() {
    MaterialTheme {
        DefaultTemplate(
            title = "Title",
            content = "Content",
        )
    }
}