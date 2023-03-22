package `in`.hahow.android_recruit_project.data

import java.io.ByteArrayOutputStream
import java.io.InputStream


object FakeRemoteCourseLoader {
    fun getInputStream(): InputStream? {
        return try {
            FakeRemoteCourseLoader::class.java.classLoader?.getResourceAsStream("data.json")
        } catch (e: Exception) {
            null
        }
    }

    fun loadString(): String? {
        return try {
            getInputStream()?.use { inputStream ->
                loadString(inputStream)
            }
        } catch (e: Exception) {
            return null
        }
    }

    private fun loadString(inputStream: InputStream?): String? {
        inputStream ?: return null
        return try {
            ByteArrayOutputStream().use { result ->
                val buffer = ByteArray(2048)
                var length: Int
                while (inputStream.read(buffer).also { length = it } > 0) {
                    result.write(buffer, 0, length)
                }
                result.toString("UTF-8")
            }
        } catch (e: Exception) {
            null
        }
    }
}