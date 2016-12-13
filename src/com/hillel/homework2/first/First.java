package com.hillel.homework2.first;

  public class First{
    public static void main(String[] args){
      int a = 140;
      int b = 51;
      int c = 43;

      int min = a;
      int max = a;

      if (b < min){
        min = b;
      }
      if (c < min){
        min = c;
      }
      //max
      if (b>max){
        max = b;
      }
      if (c>max){
        max = c;
      }

        System.out.println("Min number: " + min);
        System.out.println("Max number: " + max);
  }
}
