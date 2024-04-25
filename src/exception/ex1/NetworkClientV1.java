package exception.ex1;

/**
 * 오류 상황이 발생할 수 있게 만들어보는 예제
 */
public class NetworkClientV1 {
    private final String address; // 접속할 외부 서버
    public boolean connectError;  // boolean의 기본값은 false
    public boolean sendError;

    public NetworkClientV1(String address) {
        this.address = address;
    }


    // 외부 서버에 연결한다.
    public String connect() {
        // connectError 발생했는지 검증
        if (connectError) {
            System.out.println(address + " 서버 연결 실패");
            return "connectError";
        }

        // 연결 성공
        System.out.println(address + " 서버 연결 성공");
        return "success";
    }

    // 연결한 외부 서버에 데이터를 전송한다.
    public String send(String data) {
        // sendError 발생했는지 검증
        if (sendError) {
            System.out.println(address + " 서버에 데이터 전송 실패: " + data);
            return "sendError";
        }

        // 전송 성공
        System.out.println(address + " 서버에 데이터 전송: " + data);
        return "success";
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
