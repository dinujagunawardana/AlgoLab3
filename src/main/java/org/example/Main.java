package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Read a text file containing a list of names, one per line, and return an array of strings.
     *
     * @param fileName: text file containing a list of names, one per line
     * @return an array of strings
     * @throws IOException if there is an error reading the file
     */
    public static String[] readStrings(String fileName) throws IOException {
        List<String> listOfStrings = Files.readAllLines(Paths.get(fileName));
        return listOfStrings.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Specify the path to your data file
        String filePath = "/Users/dinujagunawardana/IdeaProjects/AlgoLab3/src/main/java/org/example/641names.txt";

        try {
            // Call the readStrings method to read the data file
            String[] keys = readStrings(filePath);

            // Now you can use the keys array in your HashSimulator
            HashSimulator hashSimulator = new HashSimulator();
            int HTsize = 100; // Set your desired hash table size
            int[] hashResults = hashSimulator.runHashSimulation(keys, HTsize);

            // Print the results or use them as needed
            System.out.println("Collisions and probes for different hash functions:");
            System.out.println("H1 Collisions: " + hashResults[0] + ", Probes: " + hashResults[1]);
            System.out.println("H2 Collisions: " + hashResults[2] + ", Probes: " + hashResults[3]);
            System.out.println("H3 Collisions: " + hashResults[4] + ", Probes: " + hashResults[5]);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading the data file.");
        }
    }
}