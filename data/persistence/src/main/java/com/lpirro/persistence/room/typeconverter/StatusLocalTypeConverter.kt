package com.lpirro.persistence.room.typeconverter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lpirro.persistence.model.StatusLocal

@ProvidedTypeConverter
class StatusLocalTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun statusLocalToString(statusLocal: StatusLocal): String {
        return gson.toJson(statusLocal)
    }

    @TypeConverter
    fun stringToStatusLocal(statusLocalString: String): StatusLocal {
        val objectType = object : TypeToken<StatusLocal>() {}.type
        return gson.fromJson(statusLocalString, objectType)
    }
}
