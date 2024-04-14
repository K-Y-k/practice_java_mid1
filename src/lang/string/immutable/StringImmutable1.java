package lang.string.immutable;

public class StringImmutable1 {
    public static void main(String[] args) {
        // String 클래스는 불변 객체
        String str1 = "hello";
        str1.concat(" java"); // 불변 객체라서 새로 객체에 주입하지 않으면 합쳐지지 않는다.
        System.out.println("str1 = " + str1);

        // 따라서 필요한 경우 기존 값을 변경하지 않고 새로운 String 객체 결과를 만들어서 반환한다.
        String str2 = str1.concat(" java"); // 새로운 String 객체에 주입
        System.out.println("str2 = " + str2);
    }
}
