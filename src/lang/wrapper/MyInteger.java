package lang.wrapper;

// 직접 만든 래퍼 클래스
public class MyInteger {
    private final int value; // final로 불변 객체로 설계

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // 객체의 장점인 스스로 자기 자신 값과 다른 값을 비교하는 메서드를 만들어서 더 유용해진다.
    public int compareTo(int target) {
        if (value < target) {
            return -1;
        } else if (value > target) {
            return 1;
        } else {
            return 0;
        }
    }

    // 참조값을 호출하지 않고 내부 값을 출력하도록 오버라이딩
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
