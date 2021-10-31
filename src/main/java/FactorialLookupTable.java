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
    }

    public FactorialLookupTable(String file) {
        //TODO: Create a mechanism to check if the file exists, if not create it.
        lookupTable = new HashMap<>();
        result = new BigInteger("1");
        allFactorials();
        lookupTableRead(file);
    }

    public FactorialLookupTable(Integer numberToBeMultiplied) {
        result = new BigInteger("1");
        calculateFactorial(numberToBeMultiplied);
    }

    private BigInteger calculateFactorial(int n) {
        while (n > 0) {
            result = result.multiply(BigInteger.valueOf(n));
            n--;
        }
        return result;
    }

    public void allFactorials() {
        for (long i = 1; i < 101; i++) {
            long n = i;
            BigInteger allresult = new BigInteger("1");
            while (n > 0) {
                allresult = allresult.multiply(BigInteger.valueOf(n));
                n--;
            }
            lookupTable.put(i, allresult);
        }
    }

    public void printTable() {
        System.out.println("All the factorials \n " +
                "N \t N!");
        for (long key : lookupTable.keySet()) {
            System.out.printf(" %d   %d\n", key, lookupTable.get(key));
        }
    }

    public void lookUpTableSave() {
        try {
            FileOutputStream fileLookUp = new FileOutputStream("factorials.txt");
            ObjectOutputStream mapOutput = new ObjectOutputStream(fileLookUp);
            mapOutput.writeObject(lookupTable);

            fileLookUp.close();
            mapOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void lookupTableRead(String file) {
        try {
            FileInputStream fileTable = new FileInputStream(file);
            ObjectInputStream mapInput = new ObjectInputStream(fileTable);
            lookupTable = (Map<Long, BigInteger>) mapInput.readObject();

            mapInput.close();
            fileTable.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<Long, BigInteger> getMap() {
        return lookupTable;
    }

    public BigInteger getFactorial(int n) {
        return calculateFactorial(n);
    }
}
