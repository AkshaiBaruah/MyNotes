package com.example.mynotes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteTable")
class Note(
    val title : String,
    val description : String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}