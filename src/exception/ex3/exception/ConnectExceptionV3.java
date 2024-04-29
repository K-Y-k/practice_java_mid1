package exception.ex3.exception;

/**
 * 예외를 계층화 해보기
 * NetworkClientExceptionV3을 상속 받게 하여 계층화
 */
public class ConnectExceptionV3 extends NetworkClientExceptionV3{

    private final String address; // 어느 서버에 연결이 실패했는지의 서버 주소 필드

    public ConnectExceptionV3(String address, String message) {
        super(message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
