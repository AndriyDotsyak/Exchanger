package com.exchanger.database.util

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

object DatabaseUtil {

    fun <T : RoomDatabase> crateDatabase(
        context: Context,
        klass: Class<T>,
        name: String,
        onCreate: ((SupportSQLiteDatabase) -> Unit)? = null,
        onOpen: ((SupportSQLiteDatabase) -> Unit)? = null,
        onDestructiveMigration: ((SupportSQLiteDatabase) -> Unit)? = null
    ): T {
        val callback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                onCreate?.invoke(db)
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                onOpen?.invoke(db)
            }

            override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                onDestructiveMigration?.invoke(db)
            }
        }
        return Room.databaseBuilder(context, klass, name)
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }

    fun <T : RoomDatabase> crateDatabase(
        context: Context,
        klass: Class<T>,
        name: String,
        path: String,
        onCreate: ((SupportSQLiteDatabase) -> Unit)? = null,
        onOpen: ((SupportSQLiteDatabase) -> Unit)? = null,
        onDestructiveMigration: ((SupportSQLiteDatabase) -> Unit)? = null
    ): T {
        val callback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                onCreate?.invoke(db)
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                onOpen?.invoke(db)
            }

            override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                onDestructiveMigration?.invoke(db)
            }
        }
        return Room.databaseBuilder(context, klass, name)
            .createFromAsset(path)
            .addCallback(callback)
            .build()
    }
}
