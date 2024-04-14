package lang.string.builder;

public class LoopStringMain1 {
    public static void main(String[] args) {
        // String에서의 간단한 + 연산은
        // 자동으로 StringBuilder로 연산한 후 String으로 저장해서 최적화한다.
        // String result = str1 + str2;
        //  → String result = new StringBuilder().append(str1).append(str2).toString();

        // 하지만 루프 안에서 문자열을 더하는 경우에는 최적화가 이루어지지 않는다.
        // 왜냐하면 결국 new StringBuilder 생성이 반복되기 때문이다.
        long startTime = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 100000; i++) {
            result += "Hello Java ";
            // result = new StringBuilder().append("Hello Java ").toString();
        } // 11초
        long endTime = System.currentTimeMillis();

        System.out.println("result = " + result);
        System.out.println("time = " + (endTime - startTime) + "ms");
    }
}
