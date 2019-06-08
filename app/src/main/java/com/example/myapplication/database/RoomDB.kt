package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.myapplication.database.dao.GithubRepoDAO
import com.example.myapplication.database.entities.GithubRepo

@Database(entities = [GithubRepo::class], version = 1, exportSchema = false)
public abstract class RoomDB: RoomDatabase(){
    abstract fun repoDAO(): GithubRepoDAO

    companion object {

        @Volatile
        private  var INSTANCE: RoomDB?=null

        fun getInstance(context: Context): RoomDB {
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= databaseBuilder(context, RoomDB::class.java,"Repo_DB")
                    .build()

                INSTANCE =instance
                return instance
            }
        }
    }

}