package lang.string.chaining;

public class MethodChainingMain2 {
    public static void main(String[] args) {
        ValueAdder adder = new ValueAdder();     // x001

        // 자기 객체를 반환하므로 결국 모두 같은 참조값을 담는다.
        // 근데 굳이 왜 이렇게 반환하도록 해야하나? = 메서드 체이닝 활용을 위해서!
        ValueAdder adder1 = adder.add(1);
        ValueAdder adder2 = adder.add(2);
        ValueAdder adder3 = adder.add(3);

        int result = adder.getValue();
        System.out.println("result = " + result); // 6

        System.out.println("result = " + adder1); // x001
        System.out.println("result = " + adder2); // x001
        System.out.println("result = " + adder3); // x001
    }
}
