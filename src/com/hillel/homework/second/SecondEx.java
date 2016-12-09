package com.hillel.homework.second;
import java.util.Scanner;

  public class SecondEx{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.print("Input 1 cathet: ");
        int a = in.nextInt();
        System.out.print("Input 2 cathet: ");
        int b = in.nextInt();
        System.out.print("Input hypotenuse: ");
        int c = in.nextInt();
        int S = (a+b)/2;
        int P = a+b+c;
        System.out.println("S=" + S + "  P=" +P);
    }
}
