import java.math.BigInteger

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
        var res: Double
        var x0 = a/2
        for(r in 1..200){
            x0 = 0.5*(x0 + (a/x0))
        }

        return x0
    }

    override fun gcd(a: Double, b: Double): Double {
        var aGDC = a
        var bGDC = b
        while( bGDC != 0.0){
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
}