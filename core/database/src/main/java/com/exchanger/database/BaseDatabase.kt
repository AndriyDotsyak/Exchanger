package com.exchanger.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RawQuery
import androidx.room.Transaction
import androidx.room.Update
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery

abstract class BaseDatabase<T>(
    protected val tableName: String
) {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(item: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(items: List<T>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(item: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(items: List<T>)

    @Transaction
    open fun replace(items: List<T>) {
        deleteAll()
        insert(items)
    }

    @Delete
    abstract fun delete(item: T)

    @Delete
    abstract fun delete(items: List<T>)

    @RawQuery
    protected abstract fun getAll(query: SupportSQLiteQuery): List<T>

    @RawQuery
    protected abstract fun deleteAll(query: SupportSQLiteQuery): Int

    @RawQuery
    protected abstract fun getCount(query: SupportSQLiteQuery): Int

    fun getAll(): List<T> {
        return getAll(SimpleSQLiteQuery("SELECT * FROM $tableName"))
    }

    fun deleteAll() {
        deleteAll(SimpleSQLiteQuery("DELETE FROM $tableName"))
    }

    fun isEmpty(): Boolean {
        return getCount() == 0
    }

    fun isNotEmpty(): Boolean {
        return getCount() > 0
    }

    fun getCount(): Int {
        return getCount(SimpleSQLiteQuery("SELECT COUNT(*) FROM $tableName"))
    }
}
