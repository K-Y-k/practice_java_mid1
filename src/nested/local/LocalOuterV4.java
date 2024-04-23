package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV4 {
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

         /**
          * 만약 캡처한 지역 변수의 값을 변경하려면?
          * => 동기화 문제로 사이드 이펙트가 발생하므로 절대 변경 못하게 막았다.
          */
         // localVar = 10; // 사용되는 곳에서 컴파일 오류

         /**
          * 대안은 새로운 변수를 선언해서 적용할 수 있다.
          */
         int newLocalVar = 10;

         return printer;
    }

    public static void main(String[] args) {
        LocalOuterV4 localOuter = new LocalOuterV4();

        Printer printer = localOuter.process(2); // Printer 인스턴스 생존 시작
        printer.print();

        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field); // 캡처한 바깥의 지역 변수도 같이 나온다.
        }
    }
}