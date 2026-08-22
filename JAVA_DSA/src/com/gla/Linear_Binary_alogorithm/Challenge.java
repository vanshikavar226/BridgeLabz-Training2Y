package com.gla.Linear_Binary_alogorithm;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class Challenge {
        public static void main(String[] args) {
            int n = 1000000;
            // StringBuilder
            long start = System.nanoTime();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append("hello");
            }
            long end = System.nanoTime();

            System.out.println("StringBuilder Time: " +
                    (end - start) + " ns");
            // StringBuffer
            start = System.nanoTime();

            StringBuffer sf = new StringBuffer();

            for (int i = 0; i < n; i++) {
                sf.append("hello");
            }
            end = System.nanoTime();

            System.out.println("StringBuffer Time: " +
                    (end - start) + " ns");
            // FileReader
            long startFileReader = System.nanoTime();
            int words1 = countUsingFileReader("largefile.txt");
            long endFileReader = System.nanoTime();
            System.out.println("FileReader Word Count: " + words1);
            System.out.println("FileReader Time: " +
                    (endFileReader - startFileReader) + " ns");


            // InputStreamReader
            long startInputStream = System.nanoTime();

            int words2 = countUsingInputStreamReader("largefile.txt");

            long endInputStream = System.nanoTime();

            System.out.println("InputStreamReader Word Count: " + words2);

            System.out.println("InputStreamReader Time: " +
                    (endInputStream - startInputStream) + " ns");
        }
        // FileReader
        public static int countUsingFileReader(String fileName)
                throws RuntimeException {

            int count = 0;

            try (BufferedReader br =
                         new BufferedReader(new FileReader(fileName))) {

                String line;

                while ((line = br.readLine()) != null) {

                    String[] words = line.trim().split("\\s+");

                    if (!line.trim().isEmpty()) {
                        count += words.length;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return count;
        }
        // InputStreamReader
        public static int countUsingInputStreamReader(String fileName) {
            int count = 0;
            try (
                    FileInputStream fis =
                            new FileInputStream(fileName);
                    InputStreamReader isr =
                            new InputStreamReader(
                                    fis,
                                    StandardCharsets.UTF_8
                            );
                    BufferedReader br =
                            new BufferedReader(isr)
            ) {
                String line;
                while ((line = br.readLine()) != null) {

                    String[] words = line.trim().split("\\s+");
                    if (!line.trim().isEmpty()) {
                        count += words.length;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return count;
        }
}