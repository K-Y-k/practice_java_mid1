package lang.immutable.change;

public class MutableMain {
    public static void main(String[] args) {
        MutableObj obj = new MutableObj(10);     // 값 10인 객체 초기화
        System.out.println("obj = " + obj.getValue()); // 10

        obj.add(20); // 값 더하기 연산 메서드 : 10 + 20 = 30
        System.out.println("obj = " + obj.getValue()); // 30
    }
}
