package gatling.test.example.simulation

object SystemPropertiesUtil {
    fun getAsStringOrElse(key: String?, fallback: String): String {
        return System.getProperty(key) ?: fallback
    }

    fun getAsDoubleOrElse(key: String?, fallback: Double): Double {
        return System.getProperty(key)?.toDouble() ?: fallback
    }

    fun getAsIntOrElse(key: String?, fallback: Int): Int {
        return System.getProperty(key)?.toInt() ?: fallback
    }

    fun getAsLongOrElse(key: String?, fallback: Long): Long {
        return System.getProperty(key)?.toLong() ?: fallback
    }

    fun getAsBooleanOrElse(key: String?, fallback: Boolean): Boolean {
        return System.getProperty(key)?.toBoolean() ?: fallback
    }
}

