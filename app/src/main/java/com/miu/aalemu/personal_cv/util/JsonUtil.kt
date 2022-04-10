package com.miu.aalemu.personal_cv.util

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.miu.aalemu.personal_cv.data.CommonData
import java.io.IOException

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getDataFromJson(context: Context, fileName: String): List<CommonData> {

        val jsonFileString = getJsonDataFromAsset(context, "$fileName.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }
        val gson = Gson()
        val listType = object : TypeToken<List<CommonData>>() {}.type
        return gson.fromJson(jsonFileString, listType)
    }
