package exception.ex2;


/**
 * 클라이언트의 전체적인 흐름을 제어해주는 서비스
 * - V2_4보다 추가 개선된 점
 *   finally 키워드를 통해 어떤 경우에도 반드시 실행해야 하는 로직을 실행하게 한다.
 */
public class NetworkServiceV2_5 {

    // 복잡한 클라이언트의 사용 로직을 여기서 처리한다.

    // 여기서 예외를 잡아서 처리한다.
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);

        // 전송된 데이터에 에러가 있을 때의 필드 값 설정 메서드 추가
        client.initError(data);


        // 하나의 try 안에 모든 정상 흐름을 넣었다.
        // 정상 흐름과 예외 흐름이 명확히 분리 되었다.
        try {
            // 정상 흐름, 한곳에 catch의 매개 예외 객체가 해당되는 정상 흐름을 넣음
            client.connect();
            client.send(data);
        } catch (NetworkClientExceptionV2 e) {
            // 예외 흐름
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메세지: " + e.getMessage());
        } finally {
            /**
             * finally 내부에 어떤 경우에도 반드시 실행해야 하는 로직을 넣어 실행하게 한다.
             */
            client.disconnect();
        }
    }
}
