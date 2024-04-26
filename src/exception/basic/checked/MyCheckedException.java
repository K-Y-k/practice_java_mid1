package exception.basic.checked;

/**
 * 체크 예외 만들어보기
 * - 체크 예외는 Exception과 하위 객체들이다. (RuntimeException 제외)
 *
 * - 체크 예외는 try ~ catch로 잡아서 처리하거나
 *   throws를 지정해서 예외를 밖으로 던진다는 선언을 필수로 명시적으로 처리해야 한다.
 *
 * - 예외 클래스를 만들려면 예외를 상속 받아야 한다.
 *   즉, Exception을 상속받은 예외는 체크 예외가 된다.
 */
public class MyCheckedException extends Exception {
    // 예외 객체가 제공하는 기본 기능이 있는데
    // 예외의 최상위 부모 Throwable에 오류 메시지를 보관한다.
    // 오류 메시지를 받을 메서드
    public MyCheckedException(String message) {
        // super(message)로 전달한 메시지는 Throwable에 있는 detailMessage에 보관된다.
        // getMessage()를 통해 조회할 수 있다.
        super(message);
    }
}
