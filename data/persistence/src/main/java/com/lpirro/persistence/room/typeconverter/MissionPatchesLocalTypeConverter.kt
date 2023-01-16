package com.lpirro.persistence.room.typeconverter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lpirro.persistence.model.MissionPatchesLocal

@ProvidedTypeConverter
class MissionPatchesLocalTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun missionPatchesListToString(missionPatchesLocal: List<MissionPatchesLocal>?): String? {
        val type = object : TypeToken<List<MissionPatchesLocal>>() {}.type
        return gson.toJson(missionPatchesLocal, type)
    }

    @TypeConverter
    fun stringToMissionPatchesLocalList(missionPatchesLocalString: String?): List<MissionPatchesLocal>? {
        val objectType = object : TypeToken<List<MissionPatchesLocal>>() {}.type
        return gson.fromJson(missionPatchesLocalString, objectType)
    }
}
