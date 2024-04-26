package exception.basic.checked;

public class Service {
    Client client = new Client();

    /**
     * 체크 예외를 잡아서 처리하는 코드
     */
    public void callCatch() {
        // 예외를 잡으려면 try catch()를 사용한다.
        try {
            // 예외 터트린 코드 넣기
            client.call(); //throw new MyCheckedException("ex");
        } catch (MyCheckedException e) { // 만약 try에 발생한 예외 객체가 여기에 해당하는 예외 객체가 아니면 throws로 던져야 한다.
            // 예외 처리 로직
            System.out.println("예외 처리, message = " + e.getMessage());
        }
        
        // 정상 흐름
        System.out.println("정상 흐름");
    }

    /**
     * 체크 예외를 잡지 못하여 호출한 곳으로 던지는 코드
     * 체크 예외는 밖으로 던지려면 throws 키워드를 해당 메서드 옆에 필수로 선언해줘야 한다.
     */
    public void callThrow() throws MyCheckedException {
        // 예외 터트린 코드 넣기
        client.call();
    }
}
