import java.math.BigInteger

fun main() {
    //val cli = CommandProp()
    // cli.readCommandLine()
    val flt = FactorialLookupTable("factorials.txt")
    val table: Map<Long,BigInteger> = flt.map
    print(table)
}

