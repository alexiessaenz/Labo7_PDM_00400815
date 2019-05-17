package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.database.GithubRepoDAO
import com.example.myapplication.entities.GithubRepo

@Database(entities = [GithubRepo::class],version = 1,exportSchema = false)
public abstract class RoomDB:RoomDatabase(){
    abstract fun repoDAO():GithubRepoDAO

    companion object {

        @Volatile
        private  var INSTANCE:RoomDB?=null

        fun getInstance(context: Context):RoomDB{
            val temInstance= INSTANCE
            if(temInstance!=null){
                return temInstance
            }
            synchronized(this){
                val instance= Room
                    .databaseBuilder(context,RoomDB::class.java,"Repo_DB")
                    .build()

                INSTANCE=instance
                return instance
            }
        }
    }

}