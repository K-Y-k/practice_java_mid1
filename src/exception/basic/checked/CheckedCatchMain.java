package exception.basic.checked;

public class CheckedCatchMain {
    public static void main(String[] args) {
        Service service = new Service();
        
        // try catch로 예외를 처리했기 때문에
        service.callCatch();
        
        // main()에서는 정상 흐름
        System.out.println("정상 종료");
    }
}
