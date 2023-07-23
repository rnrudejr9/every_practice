package week6.day1;

public class StringIsImmutableTest {
    public static void main(String[] args) {
        String s = "hello world!";
        changeString(s);
        System.out.println(s); // "hello world!"

    }

    /**
     * Call by value
     * String 은 참조타입에도 불구하고 immutable 하기 때문에
     *
     * final 클래스로 상속하여 오버라이드 금지
     * @param s
     */
    public static void changeString(String s){
        s += " new world!";
    }
}
