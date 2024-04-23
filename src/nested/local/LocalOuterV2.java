package nested.local;

public class LocalOuterV2 {
    private int outInstanceVar = 3;     // 바깥 클래스의 인스턴스 멤버

    public void process(int paramVar) { // 매개변수
        int localVar = 1; // 지역변수


        /**
         * 지역 클래스도 인터레이스 상속이 가능하다.
         */
         class LocalPrinter implements Printer{
            int value = 0; // 지역 클래스의 인스턴스 멤버

            @Override
            public void print() {
                System.out.println("value = " + value);
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter();
        printer.print();
    }

    public static void main(String[] args) {
        LocalOuterV2 localOuter = new LocalOuterV2();
        localOuter.process(2);
    }
}
