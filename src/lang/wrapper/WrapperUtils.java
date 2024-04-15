package lang.wrapper;

public class WrapperUtils {
    public static void main(String[] args) {
        // 래퍼 클래스의 주요 메서드

        // 변환 메서드
        Integer i1 = Integer.valueOf(10);      // 기본형 -> 래퍼 클래스로 박싱
        Integer i2 = Integer.valueOf("10");    // 문자열 -> 래퍼 클래스로 변환  (박싱은 기본형 -> 래퍼 클래스이므로 박싱 아님)
        int intValue = Integer.parseInt("10"); // 문자열 -> 기본형으로 변환

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("intValue = " + intValue);

        
        // 비교 메서드
        int compareResult = i1.compareTo(20);
        System.out.println("compareResult = " + compareResult);


        // 산술 연산 메서드
        System.out.println("sum: " + Integer.sum(10, 20));
        System.out.println("min: " + Integer.min(10, 20));
        System.out.println("max: " + Integer.max(10, 20));
    }
}
