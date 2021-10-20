class Processing() {
    private val stack = ArrayDeque<Double>()

    fun pushNumber(number: Double) {
        stack.addFirst(number)
    }

    fun popNumber(number: Double): Double {
        if (stack.size == 0) {
            throw NoSuchElementException()
        }
        return stack.removeFirst()
    }

    fun printStack(){
        for (d: Double in stack){
            println(d)
        }
    }


}
