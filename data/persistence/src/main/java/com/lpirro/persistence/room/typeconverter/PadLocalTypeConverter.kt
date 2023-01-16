package com.lpirro.persistence.room.typeconverter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lpirro.persistence.model.PadLocal

@ProvidedTypeConverter
class PadLocalTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun padLocalToString(padLocal: PadLocal): String {
        return gson.toJson(padLocal)
    }

    @TypeConverter
    fun stringToPadLocal(padLocalString: String): PadLocal {
        val objectType = object : TypeToken<PadLocal>() {}.type
        return gson.fromJson(padLocalString, objectType)
    }
}
