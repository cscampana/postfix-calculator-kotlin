import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FactorialLookupTable {
    private BigInteger result;
    private Map<Long, BigInteger> lookupTable;

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
        for (long i = 1; i < 5000000; i++) {
            long n = i;
            BigInteger allresult = new BigInteger("1");
            while (n > 0) {
                allresult = allresult.multiply(BigInteger.valueOf(i));
                n--;
            }
            lookupTable.put(i, allresult);
        }
    }
    public void printTable(){
        System.out.println("All the factorials \n " +
                "N \t N!");
        for ( long key : lookupTable.keySet()) {
            System.out.printf(" %d   %d\n", key, lookupTable.get(key));
        }
    }

    public void lookUpTableSave()  {
        try {
            FileOutputStream fileLookUp = new FileOutputStream("factorials.txt");
            ObjectOutputStream mapOutput = new ObjectOutputStream(fileLookUp);
            mapOutput.writeObject(lookupTable);

            fileLookUp.close();
            mapOutput.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
