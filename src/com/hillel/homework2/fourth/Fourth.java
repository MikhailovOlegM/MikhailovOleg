package com.hillel.homework2.fourth;
import java.util.Scanner;
  public class Fourth{
    public static void main(String[] args){

      Scanner in = new Scanner(System.in);

      int number = 10;
      System.out.print("Input 1 number: ");
      int a = in.nextInt();
      System.out.print("Input 2 number: ");
      int b = in.nextInt();

      int ost1 = Math.abs(number - a);
      int ost2 = Math.abs(number - b);

      if (ost1 == ost2){
        System.out.println(" This numbers are same");
      } else{
      if ( ost1 < ost2){
          System.out.println(a + " win");
      } else {
        System.out.println(b + " win");
      }
    }
  }
}
