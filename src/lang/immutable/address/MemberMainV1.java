package lang.immutable.address;

public class MemberMainV1 {
    public static void main(String[] args) {
        Address address = new Address("서울");

        MemberV1 memberA = new MemberV1("회원A", address); // 서로 같은 주소 객체의 참조값으로 넣음
        MemberV1 memberB = new MemberV1("회원B", address); // 서로 같은 주소 객체의 참조값으로 넣음

        // 회원A, 회원B의 처음 주소는 모두 사용
        System.out.println("memberA = " + memberA);   // 서울
        System.out.println("memberB = " + memberB);   // 서울

        // 회원B의 주소만 부산으로 변경해야함
        memberB.getAddress().setValue("부산");         // 같은 참조값의 주소 객체였으므로 사이드 이펙트 발생!
        System.out.println("부산 -> memberB.address");
        System.out.println("memberA = " + memberA);   // 부산
        System.out.println("memberB = " + memberB);   // 부산
    }
}
