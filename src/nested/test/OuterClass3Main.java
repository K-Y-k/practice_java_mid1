package nested.test;

public class OuterClass3Main {
    public static void main(String[] args) {
        // 여기에서 LocalClass의 hello() 메서드를 호출하라.

        // 바깥 클래스의 메서드에 지역 클래스를 생성하고 hello() 메서드를 호출하므로
        // 1.바깥 클래스를 생성한다.
        OuterClass3 outerClass3 = new OuterClass3();

        // 2.바깥 클래스의 메서드를 실행한다.
        outerClass3.myMethod();
    }
}
