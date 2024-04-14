package lang.string;

public class StringBasicMain {
    public static void main(String[] args) {
        // 문자열은 매우 자주 사용되어 편의상 쌍따옴표로 문자열을 감싸면 new String("")와 같이 변경해준다.
        String str1 = "hello"; // 자바에서 아래처럼 변경해준다.
        String str2 = new String("hello"); // 변경해주는 형태

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
    }
}
