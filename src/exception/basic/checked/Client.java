package exception.basic.checked;

public class Client {
    // 예외가 발생하는 메서드일 때
    // 여기서 해결 못하고 MyCheckedException으로 던질거라는 것을 적는다.
    // throws는 호출한 곳인 밖에 던지는 키워드
    public void call() throws MyCheckedException {
        // 문제 상황 발생하여 예외 터트리기
        // throw는 예외를 터트리는 키워드
        throw new MyCheckedException("ex");
    }
}
