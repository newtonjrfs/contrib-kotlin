package com.example.contribmontano

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contribmontano.model.Repository
import com.example.contribmontano.network.GithubFactory
import kotlinx.coroutines.launch

class MontanoViewModel : ViewModel() {

    private val repositories =  MutableLiveData<List<Repository>>()

    fun getRepositories(): LiveData<List<Repository>> {
        return repositories
    }

    fun requestRepositories() {
        viewModelScope.launch {
            loadRepositories()
        }
    }

    private suspend fun loadRepositories() {
        val service = GithubFactory.searchList()
        val response = service.getRepos()

        repositories.value = response.body()
    }
}