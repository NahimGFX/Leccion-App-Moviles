package com.example.leccion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.leccion.data.Libro

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {

    var currentScreen by remember {
        mutableStateOf("home")
    }

    var selectedLibro by remember {
        mutableStateOf<Libro?>(null)
    }

    when (currentScreen) {

        "home" -> {
            HomeScreen(
                onNavigateToCatalog = {
                    currentScreen = "catalog"
                }
            )
        }

        "catalog" -> {
            Catalog(
                onBackClick = {
                    currentScreen = "home"
                },
                onLibroClick = { libro ->

                    selectedLibro = libro
                    currentScreen = "detail"
                }
            )
        }

        "detail" -> {
            selectedLibro?.let { libro ->

                LibroDetailScreen(
                    libro = libro,
                    onBackClick = {
                        currentScreen = "catalog"
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AppNavigation()
        }
    }
}