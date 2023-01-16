package com.lpirro.persistence.room.typeconverter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lpirro.persistence.model.MissionLocal

@ProvidedTypeConverter
class MissionLocalTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun missionLocalToString(missionLocal: MissionLocal?): String? {
        return gson.toJson(missionLocal)
    }

    @TypeConverter
    fun stringToMissionLocal(missionLocalString: String?): MissionLocal? {
        val objectType = object : TypeToken<MissionLocal>() {}.type
        return gson.fromJson(missionLocalString, objectType)
    }
}
