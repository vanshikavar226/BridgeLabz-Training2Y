package com.gla.Linear_Binary_alogorithm;
public class Specificword {
        public static String searchSentence(
                String[] sentences, String word) {
            for (int i = 0; i < sentences.length; i++) {
                if (sentences[i].contains(word)) {
                    return sentences[i];
                }
            }
            return "Not Found";
        }
        public static void main(String[] args) {

            String[] sentences = {
                    "I love Java programming",
                    "Python is easy",
                    "Data structures are important"
            };
            String word = "Java";
            System.out.println(searchSentence(sentences, word));
        }
}
