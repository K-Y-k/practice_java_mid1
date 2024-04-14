package lang.string.equals;

public class StringEqualsMain2 {
    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("메서드 호출 비교1: " + isSame(str1, str2)); // false

        String str3 = "hello";
        String str4 = "hello";
        System.out.println("메서드 호출 비교2: " + isSame(str3, str4)); // true

    }

    // 매개변수는 String형태라서 new String("")형태일지, "" 리터럴 형태일지 알 수가 없으므로
    // equals()로 통일해야 한다.
    private static boolean isSame(String x, String y) {
        //return x == y; 문자열 리터럴은 ==이 가능할지라도
        return x.equals(y); // equals()로 통일해야 한다.
    }
}
