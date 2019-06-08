package com.example.myapplication.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.database.entities.GithubRepo

@Dao
interface GithubRepoDAO {
    @Query("SELECT*FROM repo")
    fun getAll():LiveData<List<GithubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repo: GithubRepo)

    @Query("DELETE FROM repo")
    fun nukeTable()
}