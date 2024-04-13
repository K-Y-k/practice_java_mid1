package lang.immutable.address;

public class MemberMainV2 {
    public static void main(String[] args) {
        ImmutableAddress address = new ImmutableAddress("서울"); // 불변 객체의 주소 생성

        MemberV2 memberA = new MemberV2("회원A", address);       // 서로 같은 주소 객체의 참조값으로 넣음
        MemberV2 memberB = new MemberV2("회원B", address);       // 서로 같은 주소 객체의 참조값으로 넣음

        // 회원A, 회원B의 처음 주소는 모두 사용
        System.out.println("memberA = " + memberA);   // 서울
        System.out.println("memberB = " + memberB);   // 서울

        // 회원B의 주소만 부산으로 변경해야함
//        memberB.getAddress().setValue("부산");       // 불변 객체로 인해 컴파일 오류
        memberB.setAddress(new ImmutableAddress("부산")); // 부산인 주소 객체를 새로 생성하고 객체 참조값 자체를 변경
        System.out.println("부산 -> memberB.address");
        System.out.println("memberA = " + memberA);   // 서울
        System.out.println("memberB = " + memberB);   // 부산
    }
}
