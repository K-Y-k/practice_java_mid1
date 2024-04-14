package lang.string;

public class StringConcatMain {
    public static void main(String[] args) {
        String a = "hello"; // x001
        String b = "java";  // x002

        String result1 = a.concat(b); // String 클래스에서 제공하는 이어붙이는 메서드
        String result2 = a + b;       // 원래 참조값끼리의 연산은 안되고 concat으로 이어붙여야 하지만 자바에서 편의상 + 연산으로 이어붙이게 제공해준 것

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }
}
