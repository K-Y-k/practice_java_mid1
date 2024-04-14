package lang.string.method;

public class StringComparisonMain {
    public static void main(String[] args) {
        String str1 = "Hello, Java!"; // 대문자 일부 있음
        String str2 = "hello, java!"; // 모두 소문자
        String str3 = "Hello, World!";

        // String 클래스의 문자열 비교 관련 메서드
        System.out.println("str1 equals str2: " + str1.equals(str2));                     // String의 기본 equals는 대소문자 구분하므로 false
        System.out.println("str1 equalsIgnoreCase str2: " + str1.equalsIgnoreCase(str2)); // 대소문자 무시하므로 true

        System.out.println("'a' compareTo 'b': " + "a".compareTo("b")); // a와 b는 사전적으로 -한칸 차이라서 -1
        System.out.println("'b' compareTo 'a': " + "b".compareTo("a")); // b와 a는 사전적으로 한칸 차이라서 1
        System.out.println("'c' compareTo 'a': " + "c".compareTo("a")); // c와 a는 사전적으로 두칸 차이라서 2

        System.out.println("str1 compareTo str3: " + str1.compareTo(str3));
        System.out.println("str1 compareToIgnoreCase str2: " + str1.compareToIgnoreCase(str2)); // str1과 str2는 대소문자 구별안하면 똑같으므로 0

        System.out.println("str1 start with 'Hello': " + str1.startsWith("Hello")); // true
        System.out.println("str1 end with 'Java!': " + str1.endsWith("Java!"));     // true
    }
}
