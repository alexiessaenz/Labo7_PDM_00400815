package com.example.myapplication.entities.repository.viewmodels

import android.app.Application
import android.util.AndroidException
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.RoomDB
import com.example.myapplication.entities.GithubRepo
import com.example.myapplication.entities.repository.GithubRepoRepository

class GithubRepoViewModel(app:Application):AndroidViewModel(app) {
    private val repository:GithubRepoRepository
    init {
        val repoDao= RoomDB.getInstance(app).repoDAO()
        repository= GithubRepoRepository(repoDao)
    }
    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()
}