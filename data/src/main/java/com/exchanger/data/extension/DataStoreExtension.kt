package com.exchanger.data.extension

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import java.io.IOException

fun <Type> DataStore<Preferences>.get(key: Preferences.Key<Type>): Type? {
    return runBlocking { getStream(key).first() }
}

fun <Type> DataStore<Preferences>.get(key: Preferences.Key<Type>, defaultValue: Type): Type {
    return runBlocking { getStream(key, defaultValue).first() }
}

fun <T> DataStore<Preferences>.getStream(key: Preferences.Key<T>): Flow<T?> {
    return data.catch {
        if (it is IOException) {
            emit(emptyPreferences())
        } else throw it
    }.map { it[key] }
}

fun <Type> DataStore<Preferences>.getStream(key: Preferences.Key<Type>, defaultValue: Type): Flow<Type> {
    return data.catch {
        if (it is IOException) {
            emit(emptyPreferences())
        } else throw it
    }.map { it[key] ?: defaultValue }
}

suspend fun <T> DataStore<Preferences>.put(key: Preferences.Key<T>, value: T) {
    edit { it[key] = value }
}
