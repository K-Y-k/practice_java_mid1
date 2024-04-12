package lang.object.equals;

public class EqualsMainV2 {
    public static void main(String[] args) {
        UserV2 user1 = new UserV2("id-100");
        UserV2 user2 = new UserV2("id-100");

        // UserV2에 equals()를 동등성으로 재정의하였으므로 서로 다른 결과가 나온다!
        System.out.println("identity = " + (user1 == user2));      // false
        System.out.println("equality = " + (user1.equals(user2))); // true
    }
}
