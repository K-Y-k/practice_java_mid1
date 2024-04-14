package lang.string.test;

public class TestString8 {
    public static void main(String[] args) {
        // java라는 단어를 jvm으로 변경해라
        String input = "hello java spring jpa java";

        String result = input.replace("java", "jvm");
        System.out.println("result = " + result);
    }
}
