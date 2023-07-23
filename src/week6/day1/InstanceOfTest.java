package week6.day1;

/**
 * 안에 타입이 존재하는가? 그릇 그려보기
 *
 */
public class InstanceOfTest {
    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        A c = new C();

        System.out.println(a instanceof A);
        System.out.println(b instanceof A);
        System.out.println(c instanceof A);
        System.out.println(a instanceof B);
    }
}

class A{
    int a = 10;

    public int get() {
        return a;
    }
}

class B extends A{
    int b = 20;
    public int get(){
        return b;
    }
}

class C extends A{
    int c = 30;
    public int get(){
        return c;
    }
}
