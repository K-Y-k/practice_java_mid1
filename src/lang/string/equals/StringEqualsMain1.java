package lang.string.equals;

public class StringEqualsMain1 {
    public static void main(String[] args) {
        String str1 = new String("hello"); // x001
        String str2 = new String("hello"); // x002

        System.out.println("new String() == 비교 " + (str1 == str2));          // 서로 다른 참조값이므로 false
        System.out.println("new String() equals 비교 " + (str1.equals(str2))); // String 클래스에서 equals()를 동등성으로 오버라이딩을 해줬기에 내부 문자 값이 같으면 true이다.

        // ""와 같이 문자열 리터럴을 사용하는 경우
        // 자바는 성능 최적화를 위해 문자열 풀을 사용한다.
        // 자바가 실행되는 시점에 클래스에 문자열 리터럴이 있으면 문자열 풀에 String 인스턴스를 미리 만들어준다.
        // 이때 같은 문자열이 있으면 만들지 않고 해당 문자열의 인스턴스 참조값을 가진다.
        String str3 = "hello"; // x003
        String str4 = "hello"; // x003
        System.out.println("리터럴 == 비교: " + (str3 == str4));          // true
        System.out.println("리터럴 equals 비교: " + (str3.equals(str4))); // 내부 문자가 같으므로 true
    }
}
