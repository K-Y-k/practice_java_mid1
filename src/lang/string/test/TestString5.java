package lang.string.test;

public class TestString5 {
    public static void main(String[] args) {
        // 주어진 파일명과 확장자를 분리해서 출력 indexOf()와 substring()을 사용헤라
        String str = "hello.txt"; // 주어진 파일명
        String ext = ".txt";      // 주어진 확장자명

        int extIdx = str.indexOf(ext);

        String fileName = str.substring(0, extIdx);
        String extName = str.substring(extIdx);

        System.out.println("fileName = " + fileName);
        System.out.println("extName = " + extName);
    }
}
