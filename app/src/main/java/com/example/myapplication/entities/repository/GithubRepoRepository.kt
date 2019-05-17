package com.example.myapplication.entities.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.myapplication.database.GithubRepoDAO
import com.example.myapplication.entities.GithubRepo

class GithubRepoRepository(private val repoDAO: GithubRepoDAO) {
    fun getAll():LiveData<List<GithubRepo>> =repoDAO.getAll()
    fun nuke()= repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo:GithubRepo)=repoDAO.insert()
}