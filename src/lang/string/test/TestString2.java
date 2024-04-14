package lang.string.test;

public class TestString2 {
    public static void main(String[] args) {
        // 각 문자 길이와 총 길이 출력해라
        String[] arr = {"hello", "java", "jvm", "spring", "jpa"};
        int totalResult = 0;

        for (String s : arr) {
            int length = s.length();
            System.out.println(s + ":" + length);
            totalResult += length;
        }

        System.out.println("sum = " + totalResult);
    }
}
