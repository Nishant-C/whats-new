package com.example.whatsnew.service

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.content.pm.PackageManager
import android.util.Log
import android.util.Log.INFO
import android.content.pm.PackageInfo





class ScanExistingApplications(name: String = "ScanExistingApplications") : IntentService(name) {
    override fun onHandleIntent(p0: Intent?) {
        Log.i("Service", "Service Started")
        val pm = packageManager
        val apps = pm.getInstalledApplications(PackageManager.GET_META_DATA)
        Log.i("appLength", "" + apps.size)
        for(app in apps){


            val pInfo: PackageInfo =
                pm.getPackageInfo(app.packageName, 0)
            Log.i("packageInfo", "packageName: " + app.packageName +", Version: " + pInfo.versionName)

        }
    }
}