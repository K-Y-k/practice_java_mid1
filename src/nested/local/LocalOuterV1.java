package nested.local;

public class LocalOuterV1 {
    private int outInstanceVar = 3;     // 바깥 클래스의 인스턴스 멤버

    public void process(int paramVar) { // 매개변수
        int localVar = 1; // 지역변수


        // 지역 클래스
        // 내부 클래스의 종류 중 하나로
        // 내부클래스의 특징을 가지면서 지역 변수와 같은 위치인 코드 블록 안에서 정의된다.
        // 지역 변수와 같은 특징으로 클래스에 private 같은 접근 제어자 사용불가능
        class LocalPrinter {
            int value = 0; // 지역 클래스의 인스턴스 멤버

            public void printDate() {
                // 자신의 인스턴스 멤버 접근 가능
                System.out.println("value = " + value);

                // 지역변수 접근 가능
                System.out.println("localVar = " + localVar);

                // 매개변수 접근 가능
                System.out.println("paramVar = " + paramVar);
                
                // 내부 클래스이므로 바깥 클래스의 인스턴스 멤버 접근 가능
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter();
        printer.printDate();
    }

    public static void main(String[] args) {
        LocalOuterV1 localOuter = new LocalOuterV1();
        localOuter.process(2);
    }
}
