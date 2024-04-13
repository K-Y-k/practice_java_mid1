package lang.immutable.change;

// 가변 객체
public class MutableObj {
    private int value;

    public MutableObj(int value) {
        this.value = value;
    }

    // 가변 객체에서의 필드 값 변경 메서드
    public void add(int addValue) {
        value = value + addValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
