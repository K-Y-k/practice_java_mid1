package lang.string.method;

public class StringChangeMain2 {
    public static void main(String[] args) {
        String strWithSpaces = "    Java Programming ";

        // String 클래스의 문자열 조작 및 변환 관련 메서드
        System.out.println("소문자로 변환: " + strWithSpaces.toLowerCase());
        System.out.println("대문자로 변환: " + strWithSpaces.toUpperCase());

        // trim()은 단순 Whitespcae만 제거하고
        // strip()은 유니코드 공백도 포함해서 제거한다.(자바11)
        System.out.println("공백 제거(trim): '" + strWithSpaces.trim() + "'");
        System.out.println("공백 제거(strip): '" + strWithSpaces.strip() + "'");
        System.out.println("앞 공백만 제거(strip): '" + strWithSpaces.stripLeading() + "'");
        System.out.println("뒤 공백만 제거(strip): '" + strWithSpaces.stripTrailing() + "'");
    }
}
