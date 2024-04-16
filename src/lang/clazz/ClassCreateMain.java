package lang.clazz;

public class ClassCreateMain {
    public static void main(String[] args) throws Exception {
        // 리플렉션
        // Class를 사용하여 클래스 메타 정보 기반으로 클래스에 정의된 필드, 메서드, 생성자 등을 조회하고
        // 이들을 통해 객체 인스턴스를 생성하거나 메서드를 호출하는 작업을 뜻한다.
        // 자주 사용되지 않지만 프레임워크를 만들거나 자바의 깊이를 이해할 때 도움이 된다.

        Class helloClass = Hello.class;
        Class helloClass2 = Class.forName("lang.clazz.Hello");

        Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance(); // 해당 클래스의 생성자를 기반으로 인스턴스를 생성한다는 뜻
        String result = hello.hello();
        System.out.println("result = " + result);
    }
}
