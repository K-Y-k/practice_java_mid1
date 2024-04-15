package lang.wrapper;

public class AutoboxingMain2 {
    public static void main(String[] args) {
        // 오토 박싱과 오토 언박싱
        // 개발하다보면 박싱, 언박싱 과정이 자주 발생하여 자바5부터 오토 박싱/언박싱을 지원한다
        int value = 7;

        // 기본형 -> 래퍼 클래스 오토 박싱
        Integer boxedValue = value;     // 오토 박싱

        // 래퍼 클래스 -> 기본형 오토 언박싱
        int unboxedValue = boxedValue;  // 오토 언박싱

        System.out.println("boxedValue = " + boxedValue);      // 7
        System.out.println("unboxedValue = " + unboxedValue);  // 7
    }
}
