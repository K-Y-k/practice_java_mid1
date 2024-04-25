package exception.ex1;

/**
 * 오류 상황이 발생할 수 있게 만들어보는 예제
 * - 추가된 사항
 * 1.연결(connect())이 실패하면 데이터를 전송하지 않아야하는데(send()) 여기서는 전송한다.
 * 2.오류 로그를 남기기
 *
 * - 남은 문제
 * 1.connect(), send()에서 에러가 발생하면 반드시 disconnect()로 연결을 끊어야한다. (자원 고갈 문제)
 *   자바의 인스턴스의 경우 자동으로 GC가 제거해주지만 외부 연결은 자동으로 해제되지 않는다.
 * 2.정상 흐름과 예외 흐름이 전혀 분리되어 있지 않다.
 */
// NetworkCilent의 전체적인 흐름을 제어해주는 서비스
public class NetworkServiceV1_2 {
    
    // 복잡한 클라이언트의 사용 로직을 여기서 처리한다.
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);

        client.initError(data); // 전송된 데이터에 에러가 있을 때의 필드 값 설정


        /**
         * 연결과 전송의 상태 결과를 받아서 이에 따른 검증 처리
         */
        String connectResult = client.connect();
        if (isError(connectResult)) {
            // 로그 해결
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);

            // 실패하면 다음 로직 실행하지 못하게 끝냄
            return;
        }

        String sendResult = client.send(data);
        if (isError(sendResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + sendResult);
            return;
        }

        client.disconnect();
    }


    /**
     * !result.equals("success")와 같은 형태는 한눈에 이해하기 어렵다.
     * 즉, 어떤 검증인지 메서드명을 작성하여 가독성 향상 리펙토링
     */
    private static boolean isError(String result) {
        return !result.equals("success");
    }
}
