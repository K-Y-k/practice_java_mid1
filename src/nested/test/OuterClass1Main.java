package nested.test;

public class OuterClass1Main {
    public static void main(String[] args) {
        // 여기에서 NestedClass의 hello() 메서드를 호출하라.
        // 1.정적 중첩 클래스는 바깥 클래스의 인스턴스 소속이 아니므로 바깥클래스명.중첩클래스명으로 바로 생성 가능
        OuterClass1.NestedClass nestedClass = new OuterClass1.NestedClass();

        // 2.정적 중첩 클래스의 메서드 사용
        nestedClass.hello();
    }
}
