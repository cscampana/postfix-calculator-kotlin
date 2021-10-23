import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FactorialLookupTable {
    private BigInteger result;
    private Map<Integer, BigInteger> lookupTable;

    public FactorialLookupTable() {
        lookupTable = new HashMap<>();
        result = new BigInteger("1");
        allFactorials();
    }

    public FactorialLookupTable(Integer numberToBeMultiplied) {
        result = new BigInteger("1");
        calculateFactorial(numberToBeMultiplied);
    }

    private void calculateFactorial(int n) {
        while (n > 0) {
            result = result.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(result);
    }

    public void allFactorials() {
        for (int i = 1; i < 100; i++) {
            int key = i;
            BigInteger allresult = new BigInteger("1");
            while (i > 0) {
                allresult = allresult.multiply(BigInteger.valueOf(i));
                i--;
            }
            lookupTable.put(key, allresult);
        }
    }
    public void printTable(){
        System.out.println("All the factorials \n " +
                "N \t N!");
        for ( int key : lookupTable.keySet()) {
            System.out.printf("%d  %d", key, lookupTable.get(key));
        }
    }
}
