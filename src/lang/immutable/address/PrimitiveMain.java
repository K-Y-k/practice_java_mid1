package lang.immutable.address;

public class PrimitiveMain {
    public static void main(String[] args) {
        // 기본형은 절대로 같은 값을 공유하지 않는다.
        int a = 10;
        int b = a;                       // a -> b, a의 값을 복사 후 b에 대입하므로 별도의 메모리에 존재하므로 완전히 다른 10이다.

        System.out.println("a = " + a);  // 10
        System.out.println("b = " + b);  // 10

        b = 20;                          // b의 값을 20으로 변경
        System.out.println("20 -> b");

        System.out.println("a = " + a);  // 10 : 공유하지 않기 때문에 b의 값이 변경되도 그대로 유지한 것
        System.out.println("b = " + b);  // 20
    }
}
