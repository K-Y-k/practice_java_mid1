package lang.string.method;

public class StringUtilsMain1 {
    public static void main(String[] args) {
        int num = 100;
        boolean bool = true;
        Object obj = new Object();
        String str = "Hello, Java!";

        // String 클래스의 기타 유틸리티 관련 메서드

        // valueOf 메서드 : 다른 타입의 값을 문자로 바꿔줌
        String numString = String.valueOf(num);
        System.out.println("숫자의 문자열 값: " + numString);

        String boolString = String.valueOf(bool);
        System.out.println("불리언의 문자열 값: " + boolString);

        String objString = String.valueOf(obj);
        System.out.println("객체의 문자열 값: " + objString);


        // 문자 + x, concat() -> 문자 이어붙이기
        String numString2 = "" + num;
        String numString3 = "".concat(String.valueOf(num));
        System.out.println("빈문자열 + num: " + numString2);
        System.out.println("빈문자열 + num: " + numString3);


        // toCharArray 메서드 : char[] 배열로 변환
        char[] strCharArray = str.toCharArray();
        System.out.println("문자열을 문자 배열로 변환: " + strCharArray);

        for (char c : strCharArray) {
            System.out.print(c);
        }
    }
}
