package com.example.whatsnew.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.whatsnew.dao.InstalledAppDao
import com.example.whatsnew.entity.InstalledApp


@Database(entities = [ InstalledApp::class ], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun installedAppDao(): InstalledAppDao

//    @Volatile
//    private var instance: AppDatabase? = null
//
////    public fun getDB(context: Context): AppDatabase? {
////        if (instance == null) {
////            synchronized(AppDatabase::class.java) {
////                if (instance == null) {
////                    instance = Room.databaseBuilder(
////                        context.applicationContext,
////                        AppDatabase::class.java, "appDatabase"
////                    ).build()
////                }
////            }
////        }
////        return instance
////    }
}