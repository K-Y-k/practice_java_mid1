package lang.string;

public class CharArrayMain {
    public static void main(String[] args) {
        // char은 문자 하나를 담는다.
        char a = '가';
        System.out.println("a = " + a);

        // 여러개의 문자를 담을려면 배열로 담아야 한다.
        char[] charArr = new char[]{'h', 'e', 'l', 'l', 'o'};
        System.out.println(charArr);

        // 하지만 자바에서 문자열을 매우 편리하게 다룰 수 있는 String 클래스가 더 편하다.
        String str = "hello";
        System.out.println("str = " + str);
    }
}
