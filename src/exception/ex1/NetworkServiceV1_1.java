package exception.ex1;

/**
 * 오류 상황이 발생할 수 있게 만들어보는 예제
 * - 남은 문제: 연결이 실패하면 데이터를 전송하지 않아야하는데 여기서는 전송한다.
 * - 추가 요구사항: 오류 로그를 남기기
 */
// NetworkCilent의 전체적인 흐름을 제어해주는 서비스
public class NetworkServiceV1_1 {
    
    // 복잡한 클라이언트의 사용 로직을 여기서 처리한다.
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);

        /**
         * 전송된 데이터에 에러가 있을 때의 필드 값 설정 메서드 추가
         */
        client.initError(data);

        client.connect();
        client.send(data);
        client.disconnect();
    }
}
