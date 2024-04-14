package lang.string.test;

public class TestString11 {
    public static void main(String[] args) {
        // 문자열을 반대로 뒤집어라
        String str = "Hello Java";

        // 내가 푼 방식
//      StringBuilder sb = new StringBuilder(str);
//      StringBuilder result = sb.reverse();

        String result = new StringBuilder(str).reverse().toString();

        System.out.println("result = " + result);
    }
}
