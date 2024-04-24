package nested.test;

public class OuterClass2Main {
    public static void main(String[] args) {
        // 여기에서 InnerClass의 hello() 메서드를 호출하라.
        // 1.바깥 클래스를 생성한다.
        OuterClass2 outerClass2 = new OuterClass2();

        // 2.바깥 클래스의 인스턴스 소속인 내부 클래스를 생성한다.
        OuterClass2.InnerClass innerClass = outerClass2.new InnerClass();

        // 3.내부 클래스의 메서드 사용
        innerClass.hello();
    }
}
