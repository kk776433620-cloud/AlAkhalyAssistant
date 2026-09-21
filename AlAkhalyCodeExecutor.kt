package com.alakhaly.assistant

import java.io.BufferedReader
import java.io.InputStreamReader

class AlAkhalyCodeExecutor {

    fun executeShellCommand(command: String): String {
        return try {
            val process = Runtime.getRuntime().exec(command)
            val reader = BufferedReader(InputStreamReader(process.inputStream))
            val output = StringBuilder()
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                output.append(line).append("\n")
            }
            process.waitFor()
            output.toString().ifEmpty { "تم التنفيذ بنجاح." }
        } catch (e: Exception) {
            "خطأ أثناء التنفيذ: ${e.localizedMessage}"
        }
    }
}
