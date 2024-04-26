package exception.basic.unchecked;

public class UnCheckedThrowMain {
    public static void main(String[] args) {
        Service service = new Service();

        // 예외를 잡지 않고 던진 메서드를 넣으면 main에도 thorws가 붙는다.
        service.callThrow();

        // main() 밖으로 던졌으므로
        // 예외가 던져진 경로 로그가 뜨면서 정상 흐름이 진행되지 않고 프로그램이 종료된다.
        System.out.println("정상 종료");
    }
}
