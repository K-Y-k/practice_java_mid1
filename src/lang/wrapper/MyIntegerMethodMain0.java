package lang.wrapper;

public class MyIntegerMethodMain0 {
    public static void main(String[] args) {
        // 기본형의 한계1
        int value = 10;

        // 기본형은 객체가 아니라서 관련 메서드가 없으므로 외부 메서드를 만들어서 비교해야 한다.
        // 만약 객체였으면 스스로 자기 자신 값과 다른 값을 비교하는 메서드를 만드는 것이 더 유용할 것이다.
        int i1 = compareTo(value, 5);  // 10 > 5이므로 1
        int i2 = compareTo(value, 10); // 10 == 10이므로 0
        int i3 = compareTo(value, 20); // 10 < 20이므로 -1

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
    }

    public static int compareTo(int value, int target) {
        if (value < target) {
            return -1;
        } else if (value > target) {
            return 1;
        } else {
            return 0;
        }
    }
}
