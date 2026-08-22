package com.gla.Linear_Binary_alogorithm;
import java.io.*;
public class ReadandWrite {
        public static void main(String[] args) {
            try (
                    BufferedReader br =
                            new BufferedReader(
                                    new InputStreamReader(System.in)
                            );
                    FileWriter fw =
                            new FileWriter("output.txt")
            ) {
                String input;
                System.out.println("Enter text. Type exit to stop:");
                while (true) {
                    input = br.readLine();
                    if (input.equals("exit")) {
                        break;
                    }
                    fw.write(input);
                    fw.write("\n");
                }
                System.out.println("Data saved successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
