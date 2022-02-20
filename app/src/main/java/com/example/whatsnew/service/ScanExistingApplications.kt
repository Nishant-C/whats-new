package com.example.whatsnew.service

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import android.content.pm.PackageInfo
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.whatsnew.dao.InstalledAppDao
import com.example.whatsnew.db.AppDatabase
import com.example.whatsnew.entity.InstalledApp

class ScanExistingApplications(name: String = "ScanExistingApplications") : IntentService(name) {
    private lateinit var db: RoomDatabase
    override fun onHandleIntent(p0: Intent?) {
        initializeDatabase()
        updateDatabase()
    }

    fun initializeDatabase(){
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "appDatabase"
        ).build()


    }

    fun updateDatabase(){
        var installedAppDao = (db as AppDatabase).installedAppDao()
        Log.i("Service", "Service Started")
        val pm = packageManager
        val apps = pm.getInstalledApplications(PackageManager.MATCH_UNINSTALLED_PACKAGES)
        Log.i("appLength", "" + apps.size)
        for(app in apps){

            val pInfo: PackageInfo = pm.getPackageInfo(app.packageName, 0)
            Log.i("packageInfo", "packageName: " + app.packageName +", Version: " + pInfo.versionName)

            val installedApp : InstalledApp = InstalledApp(packageName = app.packageName, versionInfo = pInfo.versionName)
            installedAppDao.insertAll(installedApp)
        }
    }

}