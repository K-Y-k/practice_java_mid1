package lang.string.method;

public class StringUtilsMain2 {
    public static void main(String[] args) {
        int num = 100;
        boolean bool = true;
        String str = "Hello, Java!";

        // String 클래스의 기타 유틸리티 관련 메서드

        // format 메서드 : String의 형태를 변경
        String format1 = String.format("num: %d, bool: %b, str: %s", num, bool, str);
        System.out.println(format1);

        String format2 = String.format("숫자: %.2f", 10.1234);
        System.out.println(format2);

        // printf : format 형태로 출력할 때 사용
        System.out.printf("숫자: %.2f\n", 10.1234);

        // matches 메서드 : 정규 표현식과 일치하는지 확인할 때 사용
        String regex = "Hello, (Java!|World)";
        System.out.println("'str'이 패턴과 일치하는가? " + str.matches(regex));
    }
}
