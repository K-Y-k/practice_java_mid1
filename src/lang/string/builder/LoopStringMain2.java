package lang.string.builder;

public class LoopStringMain2 {
    public static void main(String[] args) {
        // StringBuilder를 사용하면 많은 반복일 때 성능이 좋다.
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("Hello Java ");
        } // 8초
        long endTime = System.currentTimeMillis();

        String result = sb.toString(); // 연산을 모두 마쳤으므로 불변 String으로 변경
        System.out.println("result = " + result);
        System.out.println("time = " + (endTime - startTime) + "ms");
    }
}
