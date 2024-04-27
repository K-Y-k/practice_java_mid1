package exception.ex2;


/**
 * 클라이언트의 전체적인 흐름을 제어해주는 서비스
 * - V2_2보다 추가 개선된 점
 *   정상 흐름과 예외 흐름을 명확히 분리하였다.
 *
 * - 남은 문제
 *   필수로 진행해야할 정상 흐름의 로직이 사용되고 끝나도록 할 수 없음
 *   ex) 마지막에는 필수로 연결을 종료해야 하는 로직 disconnect()
 */
public class NetworkServiceV2_3 {

    // 복잡한 클라이언트의 사용 로직을 여기서 처리한다.

    // 여기서 예외를 잡아서 처리한다.
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);

        // 전송된 데이터에 에러가 있을 때의 필드 값 설정 메서드 추가
        client.initError(data);


        /**
         * 하나의 try 안에 모든 정상 흐름을 넣었다.
         * -> 정상 흐름과 예외 흐름이 명확히 분리 되었다.
         */
        try {
            /**
             * - 문제점
             * 정상 흐름이 한곳에 있어서 좋지만
             * 각 메서드의 예외가 발생하면 필수로 진행해야할 disconnet()가 실행되지 않고 catch문으로 넘어간다.
             */
            client.connect();
            client.send(data);
            client.disconnect();
        } catch (NetworkClientExceptionV2 e) {
            // 예외 흐름
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메세지: " + e.getMessage());
        }
    }
}
