package week6.day7;

public class P_별찍기_5 {
    public static void print(int n){
        System.out.println("별찍기 5");
        for (int i = 0; i <= n/2; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = n-(2*i); j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < n/2; i++) {

            for (int j = (n/2-1)-i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < (n/2) + (2*i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
