package nested.anonymous.ex;

import java.util.Random;

public class Ex1Main {
    // 리펙토링2
    // 각기 다른 코드 조각을 외부에서 전달 받게 구현

    public static void helloDice() {
        System.out.println("프로그램 시작");

        // 코드 조각 시작
        int randomValue = new Random().nextInt(6) + 1;
        System.out.println("주사위 = " + randomValue);
        // 코드 조각 종료

        System.out.println("프로그램 종료");
    }

    public static void hellSum() {
        System.out.println("프로그램 시작");

        // 코드 조각 시작
        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
        }
        // 코드 조각 종료

        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        helloDice();
        hellSum();
    }
}
