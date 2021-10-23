class Calc(): Operations{
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
        TODO("Not yet implemented")
    }

    override fun gdc(a: Double, b: Double): Double {
        TODO("Not yet implemented")
    }
}