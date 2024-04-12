package lang.object.equals;

public class EqualsMainV1 {
    public static void main(String[] args) {
        UserV1 user1 = new UserV1("id-100");
        UserV1 user2 = new UserV1("id-100");

        // 이 둘은 각 다른 메모리의 인스턴스이므로 동일성은 다르지만
        // 같은 객체이므로 동등성은 같다.

        // 하지만 자바에서 제공하는 equals() 메서드는 기본으로 ==으로 동일성 비교를 제공한다.
        // 즉, 동등성에 대한 equals() 메서드는 오버라이딩으로 재정의 해줘야 한다!
        System.out.println("identity = " + (user1 == user2));      // false
        System.out.println("equality = " + (user1.equals(user2))); // false
    }
}
