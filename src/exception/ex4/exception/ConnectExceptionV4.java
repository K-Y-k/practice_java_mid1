package exception.ex4.exception;

/**
 * 예외를 계층화 해보기
 * NetworkClientExceptionV4을 상속 받게 하여 계층화
 */
public class ConnectExceptionV4 extends NetworkClientExceptionV4 {

    private final String address; // 어느 서버에 연결이 실패했는지의 서버 주소 필드

    public ConnectExceptionV4(String address, String message) {
        super(message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
