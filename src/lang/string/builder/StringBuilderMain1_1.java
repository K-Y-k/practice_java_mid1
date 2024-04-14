package lang.string.builder;

public class StringBuilderMain1_1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        // 끝에 문자 추가 메서드
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");

        System.out.println("sb = " + sb);

        // 중간 삽입 메서드
        sb.insert(1, "Java");
        System.out.println("insert = " + sb);

        // 범위 삭제 메서드
        sb.delete(4, 8);
        System.out.println("delete = " + sb);

        // 뒤집기 메서드
        sb.reverse();
        System.out.println("reverse = " + sb);

        // StringBuilder -> String
        String string = sb.toString();
    }
}
