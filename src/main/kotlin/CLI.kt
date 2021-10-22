object CLI {
    const val intro: String = "Welcome to the Post-Fix calculator powered by Kotlin \n" +
            "Created by Caike Salles Campana (csallesc@ucsd.edu)"
    const val operations: String = "The following are valid operations within the scope of this " +
            "software: \n" +
            "\t [#] Stores the number into memory \n" +
            "\t + Addition \n" +
            "\t - Subtraction \n" +
            "\t * multiplication \n" +
            "\t R square root \n" +
            "\t G greatest common divisor \n"
    const val notValid: String = "This symbol is not valid, please input a valid symbol, or if \n" +
            "you need help, input h"
}

enum class OPCONST() {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}