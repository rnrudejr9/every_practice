package week6.day1;

/**
 * 모듈에서 new 새롭게하게되면
 * 기존 ref 받아온 빌더의 주소는 사라지고 새로운 주소를 받음
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb=  new StringBuilder();
        sb.append("메인함수 ");
        StringBuilder module = module(sb);
        System.out.println(sb.toString());
        System.out.println(module.toString());
    }
    public static StringBuilder module(StringBuilder sb){
        sb.append("모듈 ");
        sb = new StringBuilder("모듈에서 재생성 ");
        sb.append("더 더한 모듈 ");
        return sb;
    }
}
