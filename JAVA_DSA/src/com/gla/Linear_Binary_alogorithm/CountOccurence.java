package com.gla.Linear_Binary_alogorithm;
import java.io.*;
public class CountOccurence {
        public static void main(String[] args) {
            String word = "Java";
            int count = 0;
            try (BufferedReader br =
                         new BufferedReader(new FileReader("data.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    for (String w : words) {
                        if (w.equals(word)) {
                            count++;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Occurrences: " + count);
        }
}
