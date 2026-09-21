package com.alakhaly.assistant

import android.content.Context
import java.io.File

class AlAkhalySelfDeveloper(private val context: Context) {

    fun saveScript(fileName: String, code: String): Boolean {
        return try {
            val file = File(context.filesDir, "scripts/$fileName")
            file.parentFile?.mkdirs()
            file.writeText(code)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun listScripts(): List<String> {
        val dir = File(context.filesDir, "scripts")
        return dir.listFiles()?.map { it.name } ?: emptyList()
    }

    fun readScript(fileName: String): String? {
        val file = File(context.filesDir, "scripts/$fileName")
        return if (file.exists()) file.readText() else null
    }
}
