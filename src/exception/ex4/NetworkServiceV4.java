package exception.ex4;


/**
 * 클라이언트의 전체적인 흐름을 제어해주는 서비스
 */
public class NetworkServiceV4 {

    // 복잡한 클라이언트의 사용 로직을 여기서 처리한다.

    // 여기서 예외를 잡아서 처리한다.
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV4 client = new NetworkClientV4(address);

        // 전송된 데이터에 에러가 있을 때의 필드 값 설정 메서드 추가
        client.initError(data);


        // 각 catch는 순서대로 실행되므로
        // 디테일한 예외를 제일 앞에서부터 작성한다.
        // 하나의 try 안에 모든 정상 흐름을 넣었다.
        // 정상 흐름과 예외 흐름이 명확히 분리 되었다.
        /**
         * 해결할 수 없는 예외들은 모두 잡지 않고 제외해주었다.
         * 해당 예외들 생각하지 않는 것이 해결할 수 있는 코드에 집중할 수 있고 깔끔해져 더 나은 선택일 수 있다.
         * 해결할 수 없는 예외들은 다른 곳에서 공통으로 처리한다.
         */
        try {
            // 정상 흐름
            client.connect();
            client.send(data);
        } finally {
            // finally 내부에 어떤 경우에도 반드시 실행해야 하는 로직을 넣어 실행하게 한다.
            client.disconnect();
        }
    }
}
