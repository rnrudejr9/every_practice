package week6.day1;

/**
 * 멤버, 메소드 = private static
 * 생성자 = private
 */
class SingleTon{
    private int a;
    private static final SingleTon singleTon = new SingleTon();
    private SingleTon(){

    }
    public static SingleTon getInstance(){
        return singleTon;
    }

}
public class SingleTonPatternTest {
    public static void main(String[] args) {

        SingleTon instance = SingleTon.getInstance();
        SingleTon instance2 = SingleTon.getInstance();
        System.out.println(instance2 == instance);
    }
}
