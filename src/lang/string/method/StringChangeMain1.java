package lang.string.method;

public class StringChangeMain1 {
    public static void main(String[] args) {
        String str = "Hello, Java! Welcome to Java";

        // String 클래스의 문자열 조작 및 변환 관련 메서드
        System.out.println("인덱스 7부터의 부분 문자열: " + str.substring(7));
        System.out.println("인덱스 7~12까지의 부분 문자열: " + str.substring(7, 12));

        System.out.println("문자열 결합: " + str.concat("!!!"));

        System.out.println("모든 'Java'를 'World'로 교체: " + str.replace("Java", "World"));
        System.out.println("첫번째 'Java'만 'World'로 교체: " + str.replaceFirst("Java", "World"));
        
    }
}
