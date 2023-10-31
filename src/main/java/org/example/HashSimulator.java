package org.example;

public class HashSimulator {

    int[] runHashSimulation(String[] keys, int HTsize) {
        int[] hashResults = new int[6];

        // Initialize variables for collisions and probes for each hash function.
        int collisionsH1 = 0;
        int probesH1 = 0;
        int collisionsH2 = 0;
        int probesH2 = 0;
        int collisionsH3 = 0;
        int probesH3 = 0;

        // Initialize the hash table.
        String[] hashTable = new String[HTsize];

        // Iterate through the keys and hash them using each function
        for (String key : keys) {
            int hashH1 = H1(key, HTsize);
            int hashH2 = H2(key, HTsize);
            int hashH3 = H3(key, HTsize);

            // Handle collisions and probes for each function
            probesH1++;
            probesH2++;
            probesH3++;
        }

        // Populate the results array
        hashResults[0] = collisionsH1;
        hashResults[1] = probesH1;
        hashResults[2] = collisionsH2;
        hashResults[3] = probesH2;
        hashResults[4] = collisionsH3;
        hashResults[5] = probesH3;

        return hashResults;

    }

    //Sum of letter values mod HTsize
    public int H1(String name, int HTsize) {
        int sum = 0;
        for (char c : name.toCharArray()) {
            sum += (c - 'A' + 1);
        }
        return sum % HTsize;
    }

    //Multiply and sum character values with powers of 26
    public int H2(String name, int HTsize) {
        //Preventing overflow
        long sum = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int charVal = c - 'A' + 1;
            sum += charVal * Math.pow(26, i);
        }

        //Cast back to an int value.
        return (int) (sum % HTsize);
    }

    //Sourced H3 method from google.
    public int H3(String name, int HTsize) {
        int hash = 0;

        //Sum the ASCII values of the characters in the key
        for (char c : name.toCharArray()) {
            hash = hash + (int) c;
        }

        // Take the modulo to fit the result within the table size
        return hash % HTsize;
    }
}
