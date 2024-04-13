package lang.immutable.address;

public class RefMain1_2 {
    public static void main(String[] args) {
        // 참조형 변수는 하나의 인스턴스를 공유할 수 있다.
        Address a = new Address("서울");
        Address b = new Address("서울"); // 다른 메모리로 객체 생성

        System.out.println("a = " + a);       // 서울
        System.out.println("b = " + b);       // 서울
        
        b.setValue("부산");                    // b의 필드값을 변경
        System.out.println("부산 -> b");
        System.out.println("a = " + a);       // 서울
        System.out.println("b = " + b);       // 부산 : 서로 다른 참조값이므로 b만 변경되었다
    }
}
