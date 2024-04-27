package exception.ex2;


/**
 * 클라이언트의 전체적인 흐름을 제어해주는 서비스
 * - V2_3보다 추가 개선된 점
 *   필수로 진행해야할 정상 흐름의 로직이 사용되고 끝나도록 할 수 없음
 *   ex) 마지막에는 필수로 연결을 종료해야 하는 로직 disconnect()
 *
 * - 남은 문제
 *   try의 실행하는 메서드 내부의 중간에서 catch() 안에 잡은 매개 예외 객체가 아닌 다른 예외가 발생하면 잡지 않고 이 예외를 밖에 던지게되어
 *   필수로 실행해야할 로직이 진행되지 않는다.
 */
public class NetworkServiceV2_4 {

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

            /**
             * - 문제점
             * 만약 이 메서드 내부에 throw new RuntimeException()이 터지면
             * catch (NetworkClientExceptionV2 e)에 해당되는 객체가 아니라서 자동으로 밖으로 던져진다.
             * 그러면 아래 필수로 실행해야할 로직이 진행되지 않는다.
             */
            client.send(data);
        } catch (NetworkClientExceptionV2 e) {
            // 예외 흐름
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메세지: " + e.getMessage());
        }

        /**
         * 필수로 실행해야 하는 로직을 try catch 밖에 넣었다.
         */
        client.disconnect();
    }
}
