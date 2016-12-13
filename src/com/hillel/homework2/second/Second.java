package com.hillel.homework2.second;
import java.util.Scanner;
  public class Second{
    public static void main(String[] args){

      Scanner in = new Scanner(System.in);
      System.out.print("Input number: ");
      int a = in.nextInt();

      if (a % 2 == 0){
          System.out.println("Number " + a + " is even");
      } else {
        System.out.println("Number " + a + " is odd");
      }
  }
}
