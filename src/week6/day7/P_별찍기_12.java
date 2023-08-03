package week6.day7;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P_별찍기_12 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);


        int n = sc.nextInt();
        for (int i = 0; i <= ((n*2)-1)/2; i++) {
            for (int j = ((n*2)-1)/2 - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < ((n*2)-1)/2; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = ((n*2)-1)/2 - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();

        }

    }
}
