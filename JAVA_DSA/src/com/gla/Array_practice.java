package com.gla;
import java.util.Scanner;
public class Array_practice {
    public static int [] insertAtFirst(int arr[],int val) {
        int n = arr.length; // size
        int newArray[]= new int[n+1];
        newArray[0]= val;
        for(int i = 0;i<n;i++){
            newArray[i+1]=arr[i];
        }
        return newArray;
    }
    public static int [] insertAtMiddle(int arr[],int index,int val){
        int n = arr.length;
        int midArray[] = new int [n/2];


    }
   public static void display(int arr[]) {
       for (int i : arr) {
           System.out.println(i);
       }
   }
    public static void main(String[] args){
       // int arr[]= new int[]{1,2,3};
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int n = sc.nextInt();
        int arr[];
        arr = new int [n];
        System.out.println("enter the element:");
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        display(arr);
        int val = 0;
        int insertF[]=insertAtFirst(arr,val);
        display(insertF);
    }
}
