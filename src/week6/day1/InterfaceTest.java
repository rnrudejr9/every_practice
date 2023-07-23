package week6.day1;

public class InterfaceTest  implements InterfaceA{

    public static void main(String[] args) {
        InterfaceA inf = new InterfaceTest();
        inf.method();
        inf.test();
        System.out.println(InterfaceA.a);

    }
    @Override
    public void test() {
        System.out.println("is Overrided");
    }
//    @Override
//    public void method() {
//        System.out.println("default is Overrided");
//    }
}

/**
 * 인터페이스 접근제어자는 무조건 public
 * 메소드 같은 경우에는 abstract 가 붙는다
 *
 * 멤버변수 : public static final 이여서 초기화 필수
 * 메소드 : public abstract 키워드가 붙여짐
 *
 * 디폴트 메소드는 오버라이드해도되고 안해도됨
 *
 */
interface InterfaceA{
    public static final int a = 1;
    public abstract void test();
    default void method(){
        System.out.println("hello!");
    }
//    private String print();
}

