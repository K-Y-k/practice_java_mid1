package nested.nested;

public class NestedOuterMain {
    public static void main(String[] args) {
        // 정적 중첩 클래스는 바깥 클래스의 인스턴스 소속이 아니므로
        // new 바깥클래스명.중첩클래스명()로 생성할 수 있다.
        NestedOuter.Nested nested = new NestedOuter.Nested();

        nested.print();

        System.out.println("nestedClass = " + nested.getClass());
    }
}
