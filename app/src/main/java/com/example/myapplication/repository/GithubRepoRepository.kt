package com.example.myapplication.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.myapplication.database.dao.GithubRepoDAO
import com.example.myapplication.database.entities.GithubRepo

class GithubRepoRepository(private val repoDAO: GithubRepoDAO) {
    fun getAll():LiveData<List<GithubRepo>> =repoDAO.getAll()
    fun nuke()= repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo: GithubRepo) = repoDAO.insert(repo)/*repoDao.insert(repo)*/
}