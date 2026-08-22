package com.gla.Linear_Binary_alogorithm;
public class Reversestring {
        public static void main(String[] args) {
            String str = "hello";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String result = sb.reverse().toString();
            System.out.println(result);
        }
}
