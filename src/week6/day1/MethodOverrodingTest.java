package week6.day1;


/**
 * 반환타입만 다르면 오버로딩 성립 하지 않음.
 * 반환타입은 같고 매개변수가 다르면 오버로딩 성립
 * 반환타입 다르고 매개변수도 다르면 오버로딩 성립
 */
class Test {

    static void display(int num1) { System.out.println(num1); }

    static void display(int num1, int num2) { System.out.println(num1 * num2); }

    static void display(int num1, double num2) { System.out.println(num1 + num2); }

}



public class MethodOverrodingTest {


    public static void main(String[] args) {

        Test myfunc = new Test();



        myfunc.display(10);

        myfunc.display(10, 20);

        myfunc.display(10, 3.14);

        myfunc.display(10, 'a');

    }

}