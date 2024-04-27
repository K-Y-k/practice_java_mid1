package exception.ex2;

/**
 * 클라이언트
 * - 기존 V1에서는 로그처리만 했지만
 * - V2에서는 만들었던 예외를 터트려서 호출한 곳으로 예외를 던진다.
 */
public class NetworkClientV2 {
    private final String address; // 접속할 외부 서버
    public boolean connectError;  // boolean의 기본값은 false
    public boolean sendError;

    public NetworkClientV2(String address) {
        this.address = address;
    }


    // 외부 서버에 연결한다.
    public void connect() throws NetworkClientExceptionV2 {
        // connectError 발생했는지 검증
        if (connectError) {
            /**
             * 예외를 터트린다.(= 예외 객체 생성)
             * 예외만 터트리므로 반환값을 String에서 void로 반환하고
             * 체크 예외이므로 선언한 throws를 통해 호출한 곳으로 해당 예외를 던진다.
             */
            throw new NetworkClientExceptionV2("connectError", address + " 서버 연결 실패");
        }

        // 연결 성공
        System.out.println(address + " 서버 연결 성공");
    }

    // 연결한 외부 서버에 데이터를 전송한다.
    public void send(String data) throws NetworkClientExceptionV2 {
        // sendError 발생했는지 검증
        if (sendError) {
            throw new NetworkClientExceptionV2("sendError", address + " 서버에 데이터 전송 실패: " + data);
        }

        // 전송 성공
        System.out.println(address + " 서버에 데이터 전송: " + data);
    }

    // 외부 서버와 연결을 해제한다.
    public void disconnect() {
        System.out.println(address + " 서버 연결 헤제");
    }


    // 오류 필드 값 설정 메서드
    public void initError(String data) {
        if (data.contains("error1")) {
            connectError = true;
        }

        if (data.contains("error2")) {
            sendError = true;
        }
    }
}
