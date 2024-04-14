package lang.string.test;

public class TestString4 {
    public static void main(String[] args) {
        // substring()을 사용해서 hello와 .txt를 분리해라
        String str = "hello.txt";

        String fileName = str.substring(0, 5);
        String extName = str.substring(5);

        System.out.println("fileName = " + fileName);  // hello
        System.out.println("extName = " + extName);    // .txt
    }
}
