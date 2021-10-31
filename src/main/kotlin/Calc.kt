import java.math.BigInteger
import kotlin.math.pow

class Calc() : Operations {
    override fun add(a: Double, b: Double): Double {
        return a + b
    }

    override fun subtract(a: Double, b: Double): Double {
        return b - a
    }

    override fun divide(a: Double, b: Double): Double {
        return b / a
    }

    override fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    override fun sqrt(a: Double): Double {
        var x0 = a / 2
        for (r in 1..200) {
            x0 = 0.5 * (x0 + (a / x0))
        }
        return x0
    }

    override fun gcd(a: Double, b: Double): Double {
        var aGDC = a
        var bGDC = b
        while (bGDC != 0.0) {
            val t = bGDC
            bGDC = aGDC.mod(bGDC)
            aGDC = t
        }

        return aGDC
    }

    override fun printFactorials(table: Map<Long, BigInteger>) {
        println("N N!")
        for ((key, value) in table) {
            println("$key $value")
        }
    }

    override fun printFactorials(table: Map<Long, BigInteger>, factorial: Long) {
        println("$factorial! = $table[factorial]")
    }

    override fun returnFactorials(table: Map<Long, BigInteger>, factorial: Long): BigInteger? {
        return table[factorial]
    }

    override fun cos(theta: Double): Double {
        var cosx = 0.0
        var flag = 1;
        for (r in 1..20) {
            if (r == 1) {
                cosx = 1.0
                continue
            } else if (r % 2 != 0) {
                continue
            }
            val factorial = FactorialLookupTable()
            val value: Double = theta.pow(r)/(factorial.getFactorial(r).toLong())
            if (flag == 0) {
                cosx += value
                flag = 1
            } else if(flag == 1) {
                cosx -= value
                flag = 0
            }
        }
        return cosx
    }

    override fun sin(theta: Double): Double {
        var sinx = 0.0
        var flag = 1;
        for (r in 1..20) {
            if (r == 1) {
                sinx = theta
                continue
            } else if (r % 2 == 0) {
                continue
            }
            val factorial = FactorialLookupTable()
            val value: Double = theta.pow(r)/(factorial.getFactorial(r).toLong())
            if (flag == 0) {
                sinx += value
                flag = 1
            } else if(flag == 1) {
                sinx -= value
                flag = 0
            }
        }
        return sinx
    }

}