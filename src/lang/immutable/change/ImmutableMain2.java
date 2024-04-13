package lang.immutable.change;

public class ImmutableMain2 {
    public static void main(String[] args) {
        ImmutableObj obj1 = new ImmutableObj(10);
        obj1.add(20); // 새로운 객체를 반환하므로 반환값을 받아서 사용하지 않으면 아무 의미없다. (기존 값은 그대로)

        System.out.println("obj1 = " + obj1.getValue()); // 10
    }
}
