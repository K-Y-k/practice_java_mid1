package nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV1 {
    // 리펙토링2
    // 각기 다른 코드 조각을 외부에서 전달 받게 구현

    // 내가 푼 방식
    // 입력 명령에 따른 코드 조각 실행
//    public static void hello(String command) {
//        System.out.println("프로그램 시작");
//
//        if (command.equals("Dice")) {
//            // 코드 조각 시작
//            int randomValue = new Random().nextInt(6) + 1;
//            System.out.println("주사위 = " + randomValue);
//            // 코드 조각 종료
//        }
//
//        if (command.equals("Sum")) {
//            // 코드 조각 시작
//            for (int i = 0; i < 3; i++) {
//                System.out.println("i = " + i);
//            }
//            // 코드 조각 종료
//        }
//
//        System.out.println("프로그램 종료");
//    }

    
    // 인터페이스의 다형성을 활용하여 
    // 메서드명으로 오버라이딩한 각 구현체에 따른 코드 조각이 적용되도록 리펙토링
    static class Dice implements Process {
        @Override
        public void run() {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);
        }
    }

    static class Sum implements Process {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
            }
        }
    }

    public static void hello(Process process) { // 외부를 인터페이스를 전달 받도록 한다.
        System.out.println("프로그램 시작");

        // 코드 조각 시작
        process.run();
        // 코드 조각 종료

        System.out.println("프로그램 종료");
    }


    public static void main(String[] args) {
        hello(new Dice());
        hello(new Sum());
    }
}
