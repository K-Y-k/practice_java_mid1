package enumeration.ex3;

import java.util.Arrays;

public class EnumMethodMain {
    public static void main(String[] args) {
        // Enum 클래스의 주요 메서드

        // 모든 Enum 반환
        Grade[] values = Grade.values();
        System.out.println("values = " + Arrays.toString(values)); // 한번에 출력
        for (Grade value : values) {      // 각 이름과 순서 반환, 단 순서 ordianl()은 중간에 추가될 수 있으므로 사용하지 말자.
            System.out.println("name = " + value.name() + ", ordinal = " + value.ordinal());
        }
        
        // String -> Enum 변환, 잘못된 문자면 IllegalArgumentException 발생
        String input = "GOLD";
        Grade gold = Grade.valueOf(input);
        System.out.println("gold = " + gold); // toString() 오버라이딩 되어 상수 이름이 나옴
    }
}
