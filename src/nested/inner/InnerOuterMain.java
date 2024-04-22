package nested.inner;

public class InnerOuterMain {
    public static void main(String[] args) {
        // 바깥 클래스 생성
        InnerOuter outer = new InnerOuter();

        // 바깥 클래스의 내부 클래스는 인스턴스에 소속되므로
        // 바깥클래스명.내부클래스명으로 접근해야 한다.
        InnerOuter.Inner inner = outer.new Inner();
        inner.print();

        System.out.println("innerClass = " + inner.getClass());
    }
}
