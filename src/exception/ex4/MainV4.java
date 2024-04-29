package exception.ex4;


import exception.ex3.exception.NetworkClientExceptionV3;
import exception.ex4.exception.SendExceptionV4;

import java.util.Scanner;

/**
 * 실행 메인
 */
public class MainV4 {
    /**
     * 여기서는 해결할 수 없는 예외들을 공통으로 잡았다.
     */
    public static void main(String[] args) throws NetworkClientExceptionV3 {
        /**
         * 해결할 수 없는 예외들은 제외하고 예외 처리를 적용한 서비스
         */
        // NetworkServiceV4 networkService = new NetworkServiceV4();

        /**
         * V4 + 필수였던 외부 자원 해제를 fianlly가 아닌 try-with-resource 방식을 적용한 서비스
         */
        NetworkServiceV5 networkService = new NetworkServiceV5();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("전송할 문자: ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            /**
             * 해결할 수 없는 예외들은 마지막 끝 단계인 main()에서 공통 처리
             */
            try {
                networkService.sendMessage(input);
            } catch (Exception e) {
                // 모든 예외를 잡을 수 있게 최상위 부모인 Exception으로 잡아서 강제 종료되지 않도록 복구
                exceptionHandler(e);
            }

            System.out.println();
        }

        System.out.println("프로그램을 정상 종료합니다.");
    }


    /**
     * 공통 예외 처리
     */
    private static void exceptionHandler(Exception e) {
        // 공통 처리

        // 사용자에게 제공할 로직
        // 사용자에게는 시스템 내 자세한 정보는 알릴 필요가 없다.
        System.out.println("사용자 메시지: 죄송합니다. 알 수 없는 문제가 발생했습니다.");


        // 개발자에게 제공하는 로직
        // 개발자에게만 자세한 정보를 로그로 남기고 메일 등으로 알린다.
        System.out.println("==개발자용 디버깅 메시지==");
        e.printStackTrace(System.out); // 발생한 경로를 추적한 스택 트레이스 출력
        //e.printStackTrace();         // 이 방식은 출력 순서가 다를 수 있고 빨간 글씨로 출력된다. 일반적으로 이 방법을 사용
        // 위 방식은 콘솔로만 출력되어 서버에서 로그를 확인하기 어렵다.
        // 그래서 실무에서는 주로 Slf4J, logback 같은 별도의 로그 라이브러리를 사용해서 콘솔과 특정 파일에 함께 결과를 출력한다.

        // 필요하면 예외 별도의 추가 처리 가능
        // 최상위 부모로 받아왔으므로 하위 자식 인스턴스를 조회하여 추가 처리한다.
        // 여기서는 SendExceptionV4의 세부 필드를 활용하여 데이터를 세밀하게 받았다.
        if (e instanceof SendExceptionV4 sendEx) {
            System.out.println("[전송 오류] 전송 데이터: " + sendEx.getSendData());
        }
    }
}
