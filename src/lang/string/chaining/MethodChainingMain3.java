package lang.string.chaining;

public class MethodChainingMain3 {
    public static void main(String[] args) {
        ValueAdder adder = new ValueAdder();     // x001

        // 자신 참조값을 반환하여 메서드 체이닝이 가능한 것이다!
        //           x001.add(1) x001.add(2) x001.add(3)  x001.getValue()
        int result = adder.add(1).add(2).add(3).getValue();

        System.out.println("result = " + result); // 6
   }
}
