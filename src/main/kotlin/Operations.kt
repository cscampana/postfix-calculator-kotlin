import java.math.BigInteger

interface Operations {

    fun add(a : Double, b : Double) : Double
    fun subtract(a : Double, b : Double) : Double
    fun divide(a : Double, b : Double) : Double
    fun multiply(a : Double, b : Double) : Double
    fun sqrt(a : Double) : Double
    fun gcd(a : Double, b : Double) : Double
    fun printFactorials(table : Map<Long,BigInteger>)
    fun printFactorials(table:Map<Long,BigInteger>, factorial: Long);
}