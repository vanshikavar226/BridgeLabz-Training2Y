package com.gla.Linear_Binary_alogorithm;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class Streamreader {
        public static void main(String[] args) {
            try (
                    FileInputStream fis =
                            new FileInputStream("data.txt");
                    InputStreamReader isr =
                            new InputStreamReader(fis, StandardCharsets.UTF_8);
                    BufferedReader br =
                            new BufferedReader(isr)
            ) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
