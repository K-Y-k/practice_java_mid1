package nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV5 {
    // 리펙토링2
    // 각기 다른 코드 조각을 외부에서 전달 받게 구현
    
    public static void hello(Process process) { // 외부를 인터페이스를 전달 받도록 한다.
        System.out.println("프로그램 시작");

        // 코드 조각 시작
        process.run();
        // 코드 조각 종료

        System.out.println("프로그램 종료");
    }

    // 람다를 활용한 방법
    // - 자바 8이전에는 외부에서 전달을 기본형과 참조형 타입들 2가지로만 전달했다.
    // - 하지만 이후 메서드(함수)를 인수로 전달 받을 수 있게 됐다. 이것이 람다이다.
    // - 익명 클래스로만 전달할 수 있던 형태를 좀 더 간편하게 만든 람다로 적용할 수 있게 되었다.
    // - 하지만 람다는 클래스가 아니라서 익명 클래스처럼 지역 변수를 선언할 수 없다.
    public static void main(String[] args) {
        // 람다 활용으로 코드 조각을 메서드로 담아서 전달
        hello(() -> {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);
        });

        hello(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
            }
        });
    }
}
