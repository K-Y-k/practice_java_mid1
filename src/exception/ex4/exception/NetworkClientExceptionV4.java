package exception.ex4.exception;

/**
 * 처리할 수 없는 예외들은
 * 공통으로 처리할 예외로 계층화 해보기
 * 큰 분류로 나눈 예외의 최상위 부모를 RuntimeException 부모로 받아 게층화
 */
public class NetworkClientExceptionV4 extends RuntimeException {
    // 생성자는 메시지만 받도록 만듬
    public NetworkClientExceptionV4(String message) {
        super(message);
    }
}
