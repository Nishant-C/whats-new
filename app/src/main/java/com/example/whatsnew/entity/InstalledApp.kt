package com.example.whatsnew.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class InstalledApp (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var packageName: String?,
    var versionInfo: String?
)