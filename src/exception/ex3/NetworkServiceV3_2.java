package exception.ex3;


import exception.ex3.exception.ConnectExceptionV3;
import exception.ex3.exception.NetworkClientExceptionV3;
import exception.ex3.exception.SendExceptionV3;

/**
 * 클라이언트의 전체적인 흐름을 제어해주는 서비스
 * - V3_1보다 추가 개선된 점
 *   중요한 오류는 따로 로직을 적용하고
 *   중요하지 않은 오류는 하나의 부모 객체로 동일하게 처리하고
 *   알 수 없는 오류는 최상위 예외로 처리했다.
 */
public class NetworkServiceV3_2 {

    // 복잡한 클라이언트의 사용 로직을 여기서 처리한다.

    // 여기서 예외를 잡아서 처리한다.
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);

        // 전송된 데이터에 에러가 있을 때의 필드 값 설정 메서드 추가
        client.initError(data);


        /**
         * 각 catch는 순서대로 실행되므로
         * 디테일한 예외를 제일 앞에서부터 작성한다.
         */
        // 하나의 try 안에 모든 정상 흐름을 넣었다.
        // 정상 흐름과 예외 흐름이 명확히 분리 되었다.
        try {
            // 정상 흐름, 한곳에 catch의 매개 예외 객체가 해당되는 정상 흐름을 넣음
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV3 e) {
             // 각 예외 객체에 해당하는 필드로
             // 각 고유의 기능을 세밀하게 활용할 수 있게 되었다.
            /***
             * 중요한 오류는 따로 적용하고
             */
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메시지: " + e.getMessage());
        } catch (NetworkClientExceptionV3 e) {
            /**
             * 중요하지 않은 오류는 하나의 부모 객체로 동일하게 처리하고
             */
            System.out.println("[네트워크 오류] 메시지: " + e.getMessage());
        } catch (Exception e) {
            /**
             * 알 수 없는 오류는 최상위 예외로 처리했다.
             */
            System.out.println("[알 수 없는 오류] 메시지: " + e.getMessage());
        } finally {
            // finally 내부에 어떤 경우에도 반드시 실행해야 하는 로직을 넣어 실행하게 한다.
            client.disconnect();
        }

        // 둘 이상 묶어서 처리하는법
        // catch (ConnectExceptionV3 | NetworkClientExceptionV3 |e) 
        // 장점 : 묶어서 처리할 수 있다.
        // 단점 : 각 객체의 다른 필드와 메서드 사용 불가능하여 공통 부모의 기능만 사용 가능하다.
    }
}
