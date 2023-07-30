package week6.day7;

import java.util.Scanner;

public class P_별찍기_3 {
    public static void main(String[] args) {

    }
    public static void print(int n){
        System.out.println("별찍기 3");
        for (int i = 0; i < n; i++) {
            for (int j = (n-1)-i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
