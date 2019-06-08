package com.example.myapplication.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.database.RoomDB
import com.example.myapplication.database.entities.GithubRepo
import com.example.myapplication.repository.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app:Application):AndroidViewModel(app) {
    private val repository:GithubRepoRepository
    init {
        val repoDao= RoomDB.getInstance(app).repoDAO()
        repository= GithubRepoRepository(repoDao)
    }
    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()

    //must be launch and here is where all the suspended functions are called
    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        //calls the insert method from the Repository which then calls the insert method from the Dao
        repository.insert(repo)
    }

    fun nuke() = repository.nuke()
}