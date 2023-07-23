package week6.day1;


/**
 * TRUE
 * FALSE
 * FALSE
 */
public class StringRefTest {
    public static void main(String[] args) {
        String A = "스트링은 불변";
        String B = "스트링은 불변";
        String newA = new String("스트링은 불변");
        String newB = new String("스트링은 불변");
        System.out.println(A == B);
        System.out.println(A == newA);
        System.out.println(newA == newB);
    }
}
