package exception.ex3;


import exception.ex3.exception.NetworkClientExceptionV3;

import java.util.Scanner;

/**
 * 실행 메인
 */
public class MainV3 {
    // 여기서는 예외를 잡지않고 밖으로 던지게 한다.
    public static void main(String[] args) throws NetworkClientExceptionV3 {
        /**
         * V3_1
         * 관련 예외들로 계층화한 서비스
         */
//        NetworkServiceV3_1 networkService = new NetworkServiceV3_1();

        /**
         * V3_2
         * 계층화를 활용하여 중요도에 따른 예외 처리를 적용한 서비스
         */
        NetworkServiceV3_2 networkService = new NetworkServiceV3_2();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("전송할 문자: ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            networkService.sendMessage(input);
            System.out.println();
        }

        System.out.println("프로그램을 정상 종료합니다.");
    }
}
