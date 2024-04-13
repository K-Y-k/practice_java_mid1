package lang.immutable.address;

public class RefMain1_3 {
    public static void main(String[] args) {
        // 참조형 변수는 하나의 인스턴스를 공유할 수 있다.
        Address a = new Address("서울");
        Address b = a;                  // a의 참조값을 복사하여 대입

        System.out.println("a = " + a); // 서울
        System.out.println("b = " + b); // 서울

        // 여기서는 change 메서드의 내부 로직을 모르기에
        // 공유되면 사이드 이펙트가 발생할지 모를 수밖에 없다.
        change(b, "부산");
        System.out.println("a = " + a); // 부산 : 객체의 참조값을 공유하기 때문에 같이 변경된 것
        System.out.println("b = " + b); // 부산
    }

    private static void change(Address address, String changeAddress) {
        System.out.println("주소 값을 변경합니다 -> " + changeAddress);

        address.setValue(changeAddress);
    }
}
