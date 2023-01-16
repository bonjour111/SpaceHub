package com.lpirro.persistence.room.typeconverter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lpirro.persistence.model.UpdateLocal

@ProvidedTypeConverter
class UpdateLocalTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun updateLocalListToString(updates: List<UpdateLocal>?): String? {
        val type = object : TypeToken<List<UpdateLocal>>() {}.type
        return gson.toJson(updates, type)
    }

    @TypeConverter
    fun stringToUpdateLocalList(updateString: String?): List<UpdateLocal>? {
        val objectType = object : TypeToken<List<UpdateLocal>>() {}.type
        return gson.fromJson(updateString, objectType)
    }
}
