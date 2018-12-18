class JavaCode {
    fun toJSON(collection: Collection<Int>): String {
        val sb = StringBuilder()
        sb.append("[")
        val iterator = collection.iterator()
        while (iterator.hasNext()) {
            val element = iterator.next()
            sb.append(element)
            if (iterator.hasNext()) {
                sb.append(", ")
            }
        }
        sb.append("]")
        return sb.toString()
    }

    fun joinToString(
            separator: String = ", ",
            prefix: String = "",
            postfix: String = ""
            /* ... */
    ): String = ""

    fun containsEven(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }
}