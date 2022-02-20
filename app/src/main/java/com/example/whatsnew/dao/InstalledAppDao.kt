package com.example.whatsnew.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.whatsnew.entity.InstalledApp

@Dao
interface InstalledAppDao {
    @Insert
    fun insertAll(vararg installedApps: InstalledApp)

    @Update
    fun update(vararg installedApps: InstalledApp)

}