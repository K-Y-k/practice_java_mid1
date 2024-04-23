package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV3 {
    private int outInstanceVar = 3;        // 바깥 클래스의 인스턴스 멤버

    public Printer process(int paramVar) { // 매개변수
        // 지역 변수 캡처하는 변수는 변하면 안된다. (final 키워드를 넣지 않아도 결국 변경되지 않는 변수이어야 한다.)
        int localVar = 1; // 지역변수 = 스택 프레임이 종료되는 순간 함께 제거된다.

        // 지역 클래스
         class LocalPrinter implements Printer{
             int value = 0; // 지역 클래스의 인스턴스 멤버

             // 지역 클래스의 인스턴스를 생성할 때는
             // 지역 클래스에서 사용하는 바깥의 지역 변수는 캡처를 한다.
             // 즉, 지역 클래스가 접근하는 지역 변수는 절대로 중간에 값이 변하면 안된다.
             // int localVar = 1;
             // int paramVar = 2;

             @Override
             public void print() {
                 System.out.println("value = " + value);

                 // 바깥의 지역 변수를 캡처해서 가져온 것
                 System.out.println("localVar = " + localVar);

                 // 바깥의 지역 변수를 캡처해서 가져온 것
                 System.out.println("paramVar = " + paramVar);

                 System.out.println("outInstanceVar = " + outInstanceVar);
             }
        }

        // 인스턴스를 생성하는 시점에 지역 변수 캡처가 진행된 것이다.
        LocalPrinter printer = new LocalPrinter();
        //printer.print();를 여기서 실행하지 않고 Printer 인스턴스만 반환한다.
        return printer;
    }

    public static void main(String[] args) {
        LocalOuterV3 localOuter = new LocalOuterV3();

        // process()가 메서드 영역의 스택 프레임으로 생성하고
        // 실행이 끝나면 그 안의 지역 변수들의 생존이 종료된다.
        Printer printer = localOuter.process(2); // Printer 인스턴스 생존 시작

        // 하지만 여기서 위 생존이 끝난 지역 변수를 접근하는데 정상적으로 실행되었다.
        // 지역 변수의 생명 주기는 짧고 인스턴스의 생명 주기는 길어서 발생하는 문제다.
        printer.print(); // 여기서 실행한다. 즉, process()의 스택 프레임이 사라진 후에 실행

        // 이 문제를 해결하기 위해 지역 클래스의 인스턴스를 생성하는 시점에 필요한 지역 변수를 복사해서
        // 생성한 인스턴스에 함께 넣어두는 변수 캡처이다.
        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field); // 캡처한 바깥의 지역 변수도 같이 나온다.
        }
    }
}