    @file:OptIn(ExperimentalMaterial3Api::class)

    package com.freewind.material3.dropdownmenuitemdemo

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items
    import androidx.compose.foundation.text.input.rememberTextFieldState
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.*
    import androidx.compose.material3.*
    import androidx.compose.material3.carousel.rememberCarouselState
    import androidx.compose.material3.pulltorefresh.PullToRefreshBox
    import androidx.compose.runtime.*
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.state.ToggleableState
    import androidx.compose.ui.unit.dp

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                MaterialTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        DemoScreen()
                    }
                }
            }
        }
    }

    @Composable
    private fun DemoScreen() {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = { Text("DropdownMenuItem") },
                    )
                },
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    var expanded by remember { mutableStateOf(true) }
                    Box {
                        Button(onClick = { expanded = true }) { Text("Open") }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                        ) {
                            DropdownMenuItem(
                                text = { Text("Edit") },
                                onClick = { expanded = false },
                                leadingIcon = { Icon(Icons.Default.Edit, contentDescription = null) },
                            )
                        }
                    }

                }
            }

    }
