package week6.day7;

public class P_별찍기_6 {
    public static void print(int n){
        System.out.println("별찍기 6");
        for (int i = 0; i < n/2; i++) {
            for (int j = (n-1)-i; j >= 0 ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i +1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < n/2; i++) {
            for (int j = (n/2-1)-i; j >= 0 ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i + 1; j++) {
                System.out.print("*");
            }
            for (int j = (n-1) -2*i; j > 0 ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }




    }
}
