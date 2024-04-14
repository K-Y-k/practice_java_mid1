package lang.string.test;

public class TestString7 {
    public static void main(String[] args) {
        // 양쪽 공백을 제거하라
        String original = "    Hello Java    ";

        String result = original.trim();
//       ==  String result = original.strip();
        System.out.println("result = " + result);
    }
}
