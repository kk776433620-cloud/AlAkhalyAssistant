package com.alakhaly.assistant

object AlAkhalyPersona {

    fun getDialectGreeting(): String {
        val greetings = listOf(
            "حياك الله يا صاحبي! كيف أقدر أساعدك اليوم؟",
            "أهلاً وسهلاً بك، الأكحلي في خدمتك جاهز لكل الأوامر.",
            "يا مرحبا! أبشر بعزك، آمرني شو أعمل لك؟"
        )
        return greetings.random()
    }

    fun formatResponse(response: String): String {
        // Formats AI response into warm Yemeni cultural persona style
        return response
            .replace("مرحباً", "حياك الله")
            .replace("كيف يمكنني مساعدتك؟", "أبشر، ايش أقدر أخدمك فيه؟")
    }
}
