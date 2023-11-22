package ru.protei.tuyakovms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.protei.tuyakovms.ui.theme.TuyakovmsTheme
import ru.protei.tuyakovms.domain.*

class MainActivity : ComponentActivity() {
    private val notes = listOf(
        Note("Заметка", "Текст заметки 1"),
        Note("Заметка", "Текст заметки 2"),
        Note("Заметка", "Текст заметки 3")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TuyakovmsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NotesScreen(notes)
                }
            }
        }
    }

    @Composable
    private fun NotesScreen(notes: List<Note>) {
        LazyColumn {
            items(notes) { note ->
                Text(text = "Заголовок: ${note.title}")
                Text(text = "Текст: ${note.text}\n")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TuyakovmsTheme {
        Greeting("Android")
    }
}