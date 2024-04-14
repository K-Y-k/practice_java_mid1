package lang.string.test;

public class TestString9 {
    public static void main(String[] args) {
        // 이메일의 ID 부분과 도메인 부분을 분리해라
        String email = "hello@example.com";

        String[] parts = email.split("@");

        System.out.println("ID: " + parts[0]);
        System.out.println("Domain: " + parts[1]);
    }
}
