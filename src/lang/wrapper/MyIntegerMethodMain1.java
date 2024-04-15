package lang.wrapper;

public class MyIntegerMethodMain1 {
    public static void main(String[] args) {
        // 기본형의 한계1을 해결한 래퍼 클래스 활용
        MyInteger myInteger = new MyInteger(10);

        // 객체 내부에 만든 메서드로 자기 자신 값과 비교
        // 즉 외부 메서드 필요없이 자신이 가진 메서드를 편리하게 호출할 수 있다.
        int i1 = myInteger.compareTo(5);
        int i2 = myInteger.compareTo(10);
        int i3 = myInteger.compareTo(20);

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
    }
}
