package nested.anonymous.ex;

public class Ex0Main {
    // 리펙토링1 : 코드의 중복을 줄이는 방법
    // 변하지 않는 부분과 변하는 부분을 분리해야 한다.
    // 변하는 부분은 외부에 전달을 받아 재사용성을 높일 수 있다.
    public static void helloJava() {
        System.out.println("프로그램 시작");  // 변하지 않는 부분
        System.out.println("Hello Java");   // 변하는 부분
        System.out.println("프로그램 종료");  // 변하지 않는 부분
    }

    public static void helloSpring() {
        System.out.println("프로그램 시작");   // 변하지 않는 부분
        System.out.println("Hello Spring");  // 변하는 부분
        System.out.println("프로그램 종료");   // 변하지 않는 부분
    }

    // 내가 푼 방식
//    public static void hello(String skill) {
//        System.out.println("프로그램 시작");
//        System.out.println("Hello " + skill);
//        System.out.println("프로그램 종료");
//    }


    // 리펙토링 정답
    // 변하는 부분은 외부에서 전달 받게 한다.
    public static void hello(String str) {
        System.out.println("프로그램 시작");
        System.out.println(str);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        helloJava();
        helloSpring();
        hello("Hello Java");   // 변하는 부분은 외부에서 전달
        hello("Hello Spring");
    }
}
