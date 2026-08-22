package com.gla.Linear_Binary_alogorithm;
public class Concatenatestring {
        public static void main(String[] args) {
            String[] arr = {"Hello", " ", "World", "!"};
            StringBuffer sb = new StringBuffer();
            for (String str : arr) {
                sb.append(str);
            }
            System.out.println(sb.toString());
        }
}
