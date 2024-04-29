package exception.ex4;


import exception.ex4.exception.ConnectExceptionV4;
import exception.ex4.exception.SendExceptionV4;

/**
 * 클라이언트
 */
public class NetworkClientV4 {
    private final String address; // 접속할 외부 서버
    public boolean connectError;  // boolean의 기본값은 false
    public boolean sendError;

    public NetworkClientV4(String address) {
        this.address = address;
    }


    /**
     * 내가 만든 예외가 언체크 예외의 최상위를 상속받았으므로
     * throws()를 생략할 수 있다.
     */
    // 과거에는 에러 코드를 문자열로 받아 구분했지만
    // 이제는 각 에러 코드를 예외 객체 자체로 만들어서 분류했다.
    // 외부 서버에 연결한다.
    public void connect() {
        // connectError 발생했는지 검증
        if (connectError) {
            // 내가 직접 만든 서버 연결 실패 예외 객체로 생성
            throw new ConnectExceptionV4(address, address + " 서버 연결 실패");
        }

        // 연결 성공
        System.out.println(address + " 서버 연결 성공");
    }

    /**
     * 내가 만든 예외가 언체크 예외의 최상위를 상속받았으므로
     * throws()를 생략할 수 있다.
     */
    // 연결한 외부 서버에 데이터를 전송한다.
    public void send(String data) {
        // sendError 발생했는지 검증
        if (sendError) {
            throw new SendExceptionV4(data, address + " 서버에 데이터 전송 실패: " + data);
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
