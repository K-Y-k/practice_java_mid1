package lang.wrapper;

public class AutoboxingMain1 {
    public static void main(String[] args) {
        // 박싱과 언박싱의 과정
        int value = 7;

        // 박싱 : 기본형 -> 래퍼 클래스
        Integer boxedValue = Integer.valueOf(7); // 박싱

        // 언박싱 : 래퍼 클래스 -> 기본형
        int unboxedValue = boxedValue.intValue();  // 언박싱

        System.out.println("boxedValue = " + boxedValue);      // 7
        System.out.println("unboxedValue = " + unboxedValue);  // 7
    }
}
