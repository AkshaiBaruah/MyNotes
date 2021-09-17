package com.example.mynotes

class NoteRepository( private val noteDao : NoteDao) {              //repository is not necessary but gives a cleaner API as we can fetch data in a single place
    val allNotes = noteDao.getAllNotes()                            //repo will take a DAO and perform its operation..basically we don't want to access DAO directly
                                                                    //(we wanna make an instance of DAO through the DAO returning function in database) but by making an instance of repository
                                                                    //repository

    // Just the functions of DAO to be accessible through repository

    suspend fun insert(note : Note){
        noteDao.insert(note)
    }
    suspend fun delete(note : Note){
        noteDao.delete(note)
    }
}