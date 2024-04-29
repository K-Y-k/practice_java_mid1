package exception.ex4;


/**
 * 클라이언트의 전체적인 흐름을 제어해주는 서비스
 * - V4 보다 추가된 점
 * 필수로 적용해야 하는 로직을 finally 구문에 적용하는데
 * 보통 외부 자원을 해제하는 로직을 넣기에
 * 이 패턴이 반복되지 않도록 try가 끝나면 자동으로 호출되는 try-with-resources 기능을 도입한다.
 */
public class NetworkServiceV5 {

    // 복잡한 클라이언트의 사용 로직을 여기서 처리한다.

    // 여기서 예외를 잡아서 처리한다.
    public void sendMessage(String data) {
        String address = "http://example.com";
        /**
         * 여기서 클라이언트를 생성을 선언하고
         * 클라이언트의 메서드를 사용하였지만
         */
        //NetworkClientV4 client = new NetworkClientV4(address);
        //client.initError(data); // 전송된 데이터에 에러가 있을 때의 필드 값 설정 메서드 추가


        // 각 catch는 순서대로 실행되므로
        // 디테일한 예외를 제일 앞에서부터 작성한다.
        // 하나의 try 안에 모든 정상 흐름을 넣었다.
        // 정상 흐름과 예외 흐름이 명확히 분리 되었다.
        // 해결할 수 없는 예외들은 모두 잡지 않고 제외해주었다.
        // 해당 예외들 생각하지 않는 것이 해결할 수 있는 코드에 집중할 수 있고 깔끔해져 더 나은 선택일 수 있다.
        // 해결할 수 없는 예외들은 다른 곳에서 공통으로 처리한다.
        /**
         * try 구문에서 클라이언트를 생성을 선언하고 클라이언트의 메서드를 사용한다.
         * - 장점
         *   자원 해제의 코드 누락 방지
         *   자동 close 호출로 코드 간결성 및 가독성 향상
         *   try 안의 스코프 범위 한정하여 그 밖의 블록에서 사용 불가
         *   자원을 조금 더 빨리 해제하여 효율성 증가
         */
        try (NetworkClientV5 client = new NetworkClientV5(address)) {
            // 정상 흐름
            client.initError(data); // 전송된 데이터에 에러가 있을 때의 필드 값 설정 메서드 추가
            client.connect();
            client.send(data);

            /**
             * try가 끝나는 순간
             * AutoCloseable 인터페이스의 오버라이딩으로 구현한 close() 메서드가 자동 호출된다.
             */
        } catch (Exception e) {
            System.out.println("[예외 확인]: " + e.getMessage());
            throw e;
        }
    }
}
