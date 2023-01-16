package com.lpirro.persistence.room.typeconverter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lpirro.persistence.model.AgencyLocal

@ProvidedTypeConverter
class AgencyLocalTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun agencyLocalToString(agencyLocal: AgencyLocal): String {
        return gson.toJson(agencyLocal)
    }

    @TypeConverter
    fun stringToAgencyLocal(agencyLocalString: String): AgencyLocal {
        val objectType = object : TypeToken<AgencyLocal>() {}.type
        return gson.fromJson(agencyLocalString, objectType)
    }
}
