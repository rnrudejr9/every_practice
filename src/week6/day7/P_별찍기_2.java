package week6.day7;

public class P_별찍기_2 {
    public static void print(int n){
        System.out.println("별찍기22");
        for (int i = 1; i <= n; i++) {
            for (int j = n-i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
