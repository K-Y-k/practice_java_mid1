package lang.string.test;

public class TestString3 {
    public static void main(String[] args) {
        // ".txt" 문자열이 언제부터 시작하는지 위치를 찿아라
        // 이부분을 짤라서 뽑을 때 사용
        String str = "hello.txt";

        int idx = str.indexOf(".txt");
        System.out.println("index = " + idx);
    }
}
