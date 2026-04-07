package com.example.app21_RecyclerView.ui.screen.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app21_RecyclerView.data.preferences.SettingsRepository

class DetailViewModelFactory (
        private val pokemonId: Int,
        private val repository: SettingsRepository
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(pokemonId, repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
