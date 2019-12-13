package com.jake.archstudy.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jake.archstudy.data.source.UpbitRepository
import com.jake.archstudy.util.ResourceProvider
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val repository: UpbitRepository,
    private val resourceProvider: ResourceProvider
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MainViewModel(repository = repository, resourceProvider = resourceProvider) as T
}