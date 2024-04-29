package exception.ex3.exception;

/**
 * 예외를 계층화 해보기
 * NetworkClientExceptionV3을 상속 받게 하여 계층화
 */
public class SendExceptionV3 extends NetworkClientExceptionV3 {

    private final String sendData; // 전송을 시도한 데이터 필드

    public SendExceptionV3(String sendData, String message) {
        super(message);
        this.sendData = sendData;
    }

    public String getSendData() {
        return sendData;
    }
}
