package exception.basic.unchecked;

public class Client {
    public void call() { // 언체크 예외는 throws 키워드를 생략한다.
        throw new MyUncheckedException("ex");

    }
}
