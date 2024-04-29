package exception.ex2;



import java.util.Scanner;

/**
 * 실행 메인
 */
public class MainV2 {
    /**
     * 여기서는 예외를 잡지않고 밖으로 던지게 한다.
     */
    public static void main(String[] args) throws NetworkClientExceptionV2 {
        /**
         * V2_1: 예외 계층을 활용하고 모든 곳에 밖에 던진 경우 
         *       -> 예외가 발생하면 main() 밖까지 던저져서
         *          예외가 발생한 경로를 추적하는 스택 트레이스를 출력하고 프로그램을 종료한다.
         */
//        NetworkServiceV2_1 networkService = new NetworkServiceV2_1();

        /**
         * V2_2: 서비스단에서 예외를 잡은 경우
         *       -> 예외가 발생해도 예외를 처리했기에 정상 흐름으로 진행된다.
         *          즉, 복구가 되고 프로그램이 계속 수행할 수 있다.
         */
//        NetworkServiceV2_2 networkService = new NetworkServiceV2_2();

        /**
         * V2_3: 하나의 try안에 정상 흐름을 넣고 정상 흐름과 예외 흐름을 분리한 경우
         */
//        NetworkServiceV2_3 networkService = new NetworkServiceV2_3();

        /**
         * V2_4: 필수로 실행해야 하는 로직은 try 밖에 배치하여 항상 진행되도록 함
         */
//        NetworkServiceV2_4 networkService = new NetworkServiceV2_4();

        /**
         * V2_5: finally 키워드를 통해 어떤 경우에도 반드시 실행해야 하는 로직을 실행하게 한다.
         */
        NetworkServiceV2_5 networkService = new NetworkServiceV2_5();


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
