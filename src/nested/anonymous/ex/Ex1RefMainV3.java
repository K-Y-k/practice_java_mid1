package nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV3 {
    // 리펙토링2
    // 각기 다른 코드 조각을 외부에서 전달 받게 구현

    public static void hello(Process process) { // 외부를 인터페이스를 전달 받도록 한다.
        System.out.println("프로그램 시작");

        // 코드 조각 시작
        process.run();
        // 코드 조각 종료

        System.out.println("프로그램 종료");
    }

    // 익명 클래스를 활용한 방법
    // 현재 한번만 생성하고 사용하는 간단한 경우라 익명 클래스를 활용하여 코드를 줄일 수 있다.
    public static void main(String[] args) {
        // 메인 메서드 안에 익명 클래스를 정의
        Process dice = new Process() {
            @Override
            public void run() {
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("주사위 = " + randomValue);
            }
        };
        Process sum = new Process() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("i = " + i);
                }
            }
        };

        hello(dice);
        hello(sum);
    }
}
