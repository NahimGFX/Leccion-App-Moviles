package com.example.leccion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.leccion.data.Libro

@Composable
fun LibroDetailScreen(
    libro: Libro,
    onBackClick: () -> Unit
) {

    Scaffold(

        containerColor = MaterialTheme.colorScheme.background,

        topBar = {
            AppTopBar(
                title = "Detalle del libro",
                onBackClick = onBackClick
            )
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(20.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth(),

                shape = RoundedCornerShape(24.dp),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),

                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {

                androidx.compose.foundation.Image(
                    painter = painterResource(
                        id = libro.imageResourceId
                    ),

                    contentDescription = stringResource(
                        libro.name
                    ),

                    modifier = Modifier
                        .fillMaxWidth()
                        .size(280.dp)
                        .clip(
                            RoundedCornerShape(24.dp)
                        ),

                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = stringResource(libro.name),

                style = MaterialTheme.typography.headlineMedium,

                color = MaterialTheme.colorScheme.primary,

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 4.dp
                    )
            )


            Card(
                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(20.dp),

                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.surfaceVariant
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),

                    verticalArrangement =
                        Arrangement.spacedBy(18.dp)
                ) {

                    // Autor
                    InfoRow(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        },

                        title = "Autor",

                        value = stringResource(
                            libro.author
                        )
                    )

                    // Género
                    InfoRow(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Book,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        },

                        title = "Género",

                        value = stringResource(
                            libro.gender
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun InfoRow(
    icon: @Composable () -> Unit,
    title: String,
    value: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),

        verticalAlignment = Alignment.CenterVertically,

        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        icon()

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,

                style = MaterialTheme.typography.labelMedium,

                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = value,

                style = MaterialTheme.typography.bodyLarge,

                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}