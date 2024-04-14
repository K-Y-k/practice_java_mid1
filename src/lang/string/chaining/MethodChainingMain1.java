package lang.string.chaining;

public class MethodChainingMain1 {
    public static void main(String[] args) {
        ValueAdder adder = new ValueAdder();

        // 누적 연산
        adder.add(1);
        adder.add(2);
        adder.add(3);

        int result = adder.getValue();
        System.out.println("result = " + result); // 6
    }
}
