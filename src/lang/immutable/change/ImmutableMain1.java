package lang.immutable.change;

public class ImmutableMain1 {
    public static void main(String[] args) {
        ImmutableObj obj1 = new ImmutableObj(10);
        ImmutableObj obj2 = obj1.add(20); // 연산하여 변경된 값을 반환한 새로운 객체의 참조값을 새로운 객체 변수에 대입한다.

        // 계산 이후에도 기존값과 신규값 모두 확인이 가능
        System.out.println("obj1 = " + obj1.getValue()); // 10
        System.out.println("obj2 = " + obj2.getValue()); // 30
    }
}
