package exception.ex3.exception;

/**
 * 예외를 계층화 해보기
 * 큰 분류로 나눈 예외의 최상위 부모를 Exception 부모로 받아 게층화
 */
public class NetworkClientExceptionV3 extends Exception {
    // 생성자는 메시지만 받도록 만듬
    public NetworkClientExceptionV3(String message) {
        super(message);
    }
}
