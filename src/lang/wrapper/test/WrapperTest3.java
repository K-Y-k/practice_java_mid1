package lang.wrapper.test;

public class WrapperTest3 {
    public static void main(String[] args) {
        // String str을 Integer로 변환해서 출력해라
        // Integer를 int로 변환해서 출력해라
        // int를 Integer로 변환해서 출력해라
        // 오토 박싱, 오토 언박싱을 사용하지 말고 직접 변환해야 한다.
        String str = "100";

        Integer integer1 = Integer.valueOf(str);       // String  -> Integer  변환
        int intValue = integer1.intValue();            // Integer -> int      언박싱
        Integer integer2 = Integer.valueOf(intValue);  // int     -> Integer  박싱

        System.out.println("integer1 = " + integer1);
        System.out.println("intValue = " + intValue);
        System.out.println("integer2 = " + integer2);
    }
}
