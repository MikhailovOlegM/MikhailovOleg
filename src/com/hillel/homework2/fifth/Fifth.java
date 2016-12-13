package com.hillel.homework2.fifth;
import java.util.Scanner;
  public class Fifth{
    public static void main(String[] args){

      Scanner in = new Scanner(System.in);

      System.out.println("How many days? ");
      int day = in.nextInt();

      int cost = day * 40;

      if (day > 7){
        cost = cost - 50;
      } else{
        if (day > 5) {
          cost = cost - 20;
        }else{
          cost = cost;
        }
      }
      System.out.println("Sum= " + cost);

  }
}
