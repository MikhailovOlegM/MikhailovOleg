package com.hillel.homework2.third;
import java.util.Scanner;
  public class Third{
    public static void main(String[] args){

      Scanner in = new Scanner(System.in);
      System.out.print("Input 1 number: ");
      int a = in.nextInt();
      System.out.print("Input 2 number: ");
      int b = in.nextInt();

      if (a % b == 0){
          System.out.println("Is div correct");
      } else {
        System.out.println("Is div incorrect");
      }
  }
}
