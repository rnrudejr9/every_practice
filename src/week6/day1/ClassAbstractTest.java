package week6.day1;

/**
 * abstract 키워드가 있다면 클래스 앞에도 붙여야됨
 * 꼭 메소드 정의할 필요는 없음 ( 넘겨도됨 )
 * final 키워드랑은 사용할 수 없음
 *
 * 추상클래스는 내부 구현체를 만들지 않으면 객체할당 할 수 없음
 */
public class ClassAbstractTest{
    public static void main(String[] args) {
        AbstractClass2 B = new AbstractClass1();
        System.out.println(B.a);
        System.out.println(B.b);
        B.test();
        System.out.println(B.a);
    }

}

class AbstractClass1 extends AbstractClass2{
    int a = 10;

    @Override
    void test() {
        a = super.b;
    }
}

abstract class AbstractClass2{
    public int a;
    public int b = 100;
    abstract void test();

    final void test2() {

    }
}

//class AbstractClass3{
//    abstract void test();
//}




