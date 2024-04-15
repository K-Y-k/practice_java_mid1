package lang.wrapper;

public class WrapperClassMain {
    public static void main(String[] args) {
        // 자바에서 제공하는 래퍼 클래스 활용
        // 기본형을 래퍼 클래스로 변경하는 작업인 박싱
        Integer newInteger1 = new Integer(10);       // 미래에 삭제 예정인 형태
        Integer newInteger2 = Integer.valueOf(10);      // 사용 권장하는 형태로 자주 사용하는 숫자인 -128~127을 미리 만들어둔 것을 재사용한다.(= 성능 최적화) 불변

        Long longObj = Long.valueOf(100);
        Double doubleObj = Double.valueOf(10.5);

        System.out.println("newInteger1 = " + newInteger1); // toString()으로 참조값이 아닌 실제값이 나오도록 오버라이딩한 것이다.
        System.out.println("newInteger2 = " + newInteger2); // 10
        System.out.println("longObj = " + longObj);         // 100
        System.out.println("doubleObj = " + doubleObj);     // 10.5


        // 언박싱 : 래퍼 클래스의 실제 기본형 값을 꺼내는 것
        System.out.println("내부 값 읽기");
        int intValue = newInteger2.intValue(); // 해당 래퍼 클래스의 내부 값을 읽을 때의 메서드 사용
        long longValue = longObj.longValue();

        System.out.println("intValue = " + intValue);   // 10
        System.out.println("longValue = " + longValue); // 100


        System.out.println("비교");
        System.out.println("==: " + (newInteger1 == newInteger2));          // 서로 다른 참조값이므로 false
        System.out.println("equals: " + (newInteger1.equals(newInteger2))); // 내부의 값을 비교하므로 true
    }
}
