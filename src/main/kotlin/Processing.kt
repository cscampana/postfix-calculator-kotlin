import kotlin.system.exitProcess

class Processing() {
    private val stack = ArrayDeque<Double>()

    fun pushElement(number: Double) {
        stack.addFirst(number)
    }

    fun popNumber(): Double {
        if (stack.size == 0) {
            throw NoSuchElementException()
        }
        return stack.removeFirst()
    }

    fun printStack() {
        for (d: Double in stack) {
            println(d)
        }
    }

    fun printTop() {
        println(stack[0])
    }

}

class CommandProp() {
    init {
        println(CLI.intro)
        println(CLI.operations)
    }

    fun readCommandLine() {
        val processing = Processing()
        val calc = Calc()
        var command: Any? = null
        while (command != 'c') {
            print(CLI.inputSymbol)
            command = readLine()
            if (command?.toDoubleOrNull() != null && command != null) {
                processing.pushElement(command.toDouble())
                continue
            }
            command = command!![0]
            when (command) {
                '+' -> {
                    processing.pushElement(
                        calc.add(
                            processing.popNumber(), processing
                                .popNumber()
                        )
                    )
                    processing.printTop()
                }
                '-' -> {
                    processing.pushElement(
                        calc.subtract(
                            processing.popNumber(),
                            processing.popNumber()
                        )
                    )
                    processing.printTop()
                }
                '*' -> {
                    processing.pushElement(
                        calc.multiply(
                            processing.popNumber(), processing
                                .popNumber()
                        )
                    )
                    processing.printTop()
                }
                '/' -> {
                    processing.pushElement(calc.divide(processing.popNumber(), processing.popNumber()))
                    processing.printTop()
                }
                'h','H' -> println(CLI.operations)
                'q','Q' -> exitProcess(0)
                'p','P' -> processing.printStack()
                else -> println(CLI.notValid)
            }
        }
    }

}
