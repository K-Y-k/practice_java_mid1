package exception.ex3;


import exception.ex3.exception.ConnectExceptionV3;
import exception.ex3.exception.SendExceptionV3;

/**
 * 클라이언트의 전체적인 흐름을 제어해주는 서비스
 */
public class NetworkServiceV3_1 {

    // 복잡한 클라이언트의 사용 로직을 여기서 처리한다.

    // 여기서 예외를 잡아서 처리한다.
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);

        // 전송된 데이터에 에러가 있을 때의 필드 값 설정 메서드 추가
        client.initError(data);


        // 하나의 try 안에 모든 정상 흐름을 넣었다.
        // 정상 흐름과 예외 흐름이 명확히 분리 되었다.
        try {
            // 정상 흐름, 한곳에 catch의 매개 예외 객체가 해당되는 정상 흐름을 넣음
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV3 e) {
            /**
             * 각 예외 객체에 해당하는 필드로
             * 각 고유의 기능을 세밀하게 활용할 수 있게 되었다.
             */
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메시지: " + e.getMessage());
        } catch (SendExceptionV3 e) {
            System.out.println("[전송 오류] 전송 데이터: " + e.getSendData() + ", 메시지: " + e.getMessage());
        } finally {
            // finally 내부에 어떤 경우에도 반드시 실행해야 하는 로직을 넣어 실행하게 한다.
            client.disconnect();
        }
    }
}
