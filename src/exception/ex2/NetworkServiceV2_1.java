package exception.ex2;


/**
 * 클라이언트의 전체적인 흐름을 제어해주는 서비스
 * - 클라이언트의 메서드에 예외를 던졌으므로
 *   여기서 예외를 잡거나 예외를 밖으로 던지는 것이 추가된다.
 */
public class NetworkServiceV2_1 {

    // 복잡한 클라이언트의 사용 로직을 여기서 처리한다.

    /**
     * 여기서는 예외를 밖으로 던진다.
     * 모든 곳에서 발생한 예외를 잡지 않고 던졌기 때문에
     * main() 밖으로 예외가 던져진다.
     * main() 밖까지 던져지면 예외가 발생한 경로를 추적하는 스택 트레이스를 출력하고 종료한다.
     * 어디서 예외가 발생했는지 바로 확인이 가능해진다.
     * 즉, 예외의 로그 처리는 정말 중요하다.
     */
    public void sendMessage(String data) throws NetworkClientExceptionV2 {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);

        // 전송된 데이터에 에러가 있을 때의 필드 값 설정 메서드 추가
        client.initError(data);

        client.connect();
        client.send(data);
        client.disconnect();
    }
}
