package exception.ex2;


/**
 * 클라이언트의 전체적인 흐름을 제어해주는 서비스
 * - V2_1보다 추가 개선된 점
 *   모든 곳에서 예외를 밖으로 던지기만 했으므로 예외를 잡는 부분 추가하여 정상 흐름으로 복구\
 * 
 * - 남은 문제
 *   1.정상 흐름과 예외 흐름을 한눈에 보기 어려움
 *   2.필수로 진행해야할 정상 흐름의 로직이 사용되고 끝나도록 할 수 없음
 *     ex) 마지막에는 필수로 연결을 종료해야 하는 로직 disconnect()
 */
public class NetworkServiceV2_2 {

    // 복잡한 클라이언트의 사용 로직을 여기서 처리한다.

    /**
     * 여기서 예외를 잡아서 처리한다.
     */
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);

        // 전송된 데이터에 에러가 있을 때의 필드 값 설정 메서드 추가
        client.initError(data);


        /**
         * 예외를 잡아서 정상 흐름이 진행된다.
         */
        try {
            client.connect();
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메세지: " + e.getMessage());

            /**
             * 다음 send() 로직이 진행되지 않도록 반환하여 끝냄
             */
            return;
        }

        try {
            client.send(data);
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메세지: " + e.getMessage());

            return;
        }

        client.disconnect();
    }
}
