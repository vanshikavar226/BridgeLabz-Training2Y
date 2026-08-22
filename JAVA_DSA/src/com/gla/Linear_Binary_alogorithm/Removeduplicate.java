package com.gla.Linear_Binary_alogorithm;
import java.util.HashSet;
public class Removeduplicate {
        public static void main(String[] args) {
            String str = "programming";
            StringBuilder result = new StringBuilder();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!set.contains(ch)) {
                    result.append(ch);
                    set.add(ch);
                }
            }
            System.out.println(result);
        }
}
