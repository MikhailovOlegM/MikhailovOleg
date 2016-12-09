package com.hillel.homework.third;
  public class ThirdEx{
    public static void main(String[] args){

        int num = 4125;
        int a,b,c,d;
        a = num/1000;
        b = (num-(a*1000))/100;
        c = (num-(a*1000)-(b*100))/10;
        d = (num-(a*1000)-(b*100)-(c*10));

        int sum = a+b+c+d;
        System.out.println("Your number: " + num);
        System.out.println("Summ of numerals= " +sum);
        }
  }
