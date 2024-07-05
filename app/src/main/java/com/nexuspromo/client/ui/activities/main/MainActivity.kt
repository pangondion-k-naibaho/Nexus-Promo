package com.nexuspromo.client.ui.activities.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nexuspromo.client.data.remote.ApiConfig
import com.nexuspromo.client.data.repository.PromoRepositoryImpl
import com.nexuspromo.client.ui.components.MainScreen
import com.nexuspromo.client.ui.theme.NexusPromoTheme
import com.nexuspromo.client.ui.viewmodels.MainViewModel
import com.nexuspromo.client.ui.viewmodels.MainViewModelFactory

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory(PromoRepositoryImpl(ApiConfig.createApiService()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexusPromoTheme {
                MainScreen(
                    context = this@MainActivity,
                    viewModel = mainViewModel
                ) {
                    Toast.makeText(this@MainActivity, "Failed to Retrieve Data", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
