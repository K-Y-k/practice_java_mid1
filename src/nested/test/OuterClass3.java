package nested.test;

public class OuterClass3 {
    public void myMethod() {
        // 여기에 지역 클래스 LocalClass를 구현하고 hello() 메서드를 호출해라
        class LocalClass {
            public void hello() {
                System.out.println("LocalClass.hello");
            }

        }

        // 1.지역 클래스를 생성하고
        LocalClass localClass = new LocalClass();

        // 2.지역 클래스의 메서드를 사용한다.
        localClass.hello();
    }
}
