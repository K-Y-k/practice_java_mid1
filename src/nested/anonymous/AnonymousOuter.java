package nested.anonymous;

import nested.local.Printer;

public class AnonymousOuter {
    private int outInstanceVar = 3;     // 바깥 클래스의 인스턴스 멤버

    public void process(int paramVar) { // 매개변수
        int localVar = 1; // 지역변수


        /**
         * 익명 클래스
         * - 지역 클래스인데 클래스의 이름이 없다는 특징이 추가된 클래스
         * - 이 특징으로 지역 클래스는 선언과 생성이 따로 사용되었지만
         *   익명 클래스는 클래스의 이름을 생략하고 선언과 생성을 한번에 처리할 수 있다.
         * - 익명 클래스는 부모 클래스를 상속 받거나 인터페이스가 필요하다.
         * - 기본 생성자만 사용되고 다른 생성자를 가질 수 없다.
         *
         * - 클래스를 별도로 정의하지 않고도 추상 클래스를 즉석에서 구현하여 코드가 더 간결해진다.
         *   즉, 지역 클래스가 일회성으로 사용되거나 간단한 구현일 때 사용된다.
         * - 하지만 복잡하거나 재사용이 필요한 경우에는 별도의 지역 클래스를 정의하는 것이 좋다.
         */
        // 인터페이스인 Printer를 생성한 것처럼 보이지만 인터페이스 생성은 불가능하다.
        // 즉, 인터페이스를 구현한(상속 받은) 익명 클래스를 생성하는 것이다.
        Printer printer = new Printer() { // 선언과 생성을 한번에
            int value = 0; // 익명 클래스의 인스턴스 멤버

            @Override
            public void print() {
                System.out.println("value = " + value);
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        };

        printer.print();
        System.out.println("printer.class = " + printer.getClass());
    }

    public static void main(String[] args) {
        AnonymousOuter localOuter = new AnonymousOuter();
        localOuter.process(2);
    }
}
