package lang.object.tostring;

// 객체 정보를 출력하는 클래스를 만들어본 방식
public class ObjectPrinter {
    // 추상적인 Object에 의존한 다형성을 활용하여 매개변수 참조 객체가 모두 올 수 있게 했다.
    // 이 메서드의 원리가 System.out.println()에 객체를 넣으면 toString()이 호출되는 내부 동작 원리이다.
    public static void print(Object obj) {
        String string = "객체 정보 출력: " + obj.toString();
        System.out.println(string);
    }
}
