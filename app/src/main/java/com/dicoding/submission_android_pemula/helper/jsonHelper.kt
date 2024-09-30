package com.dicoding.submission_android_pemula.helper

import android.content.Context
import com.dicoding.submission_android_pemula.Model.Waifu
import org.json.JSONArray
import org.json.JSONObject

object jsonHelper {

    private fun readJson(context: Context, resourceId: Int): String {
        val inputStream = context.resources.openRawResource(resourceId)
        return inputStream.bufferedReader().use { it.readText() }
    }

    fun getWaifuList(context: Context, resourceId: Int): ArrayList<Waifu> {
        val json = readJson(context, resourceId)
        val jsonObject = JSONObject(json)

        val waifuObject = jsonObject.getJSONArray("data")
        val waifuList = ArrayList<Waifu>()
        for (i in 0 until waifuObject.length()) {
            val item = waifuObject.getJSONObject(i)
            val name = item.getString("name")
            val img = item.getString("img")
            val thumbnail = item.getString("thumbnail")
            val desc = item.getString("desc")
            val rarity = item.getString("rarity")
            val attribute = item.getString("attribute")
            val birth = item.getString("birth")
            waifuList.add(Waifu(name, img, thumbnail,desc, rarity, attribute, birth))

        }

        return waifuList

    }
    fun getAttribute(context: Context,resourceId: Int): JSONObject{
        val json = readJson(context, resourceId)
        val jsonObject = JSONObject(json)

        return jsonObject.getJSONObject("attribute")
    }
}