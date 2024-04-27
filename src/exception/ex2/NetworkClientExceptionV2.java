package exception.ex2;

/**
 * 예외 객체
 */
public class NetworkClientExceptionV2 extends Exception {
    private String errorCode; // 어떤 종류의 오류 코드인지 구분하기 위한 오류 코드 필드 추가;

    public NetworkClientExceptionV2(String errorCode, String message) {
        // 매개 변수로 오류 메시지를 받아 
        // 최상위 부모인 Throwable 객체에 어떤 오류 메시지인지 보관한다.
        super(message);
        
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
