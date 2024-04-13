package lang.immutable.change;

// 불변 객체
public class ImmutableObj {
    private final int value;

    public ImmutableObj(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // 불변 객체에서의 필드 값 변경 메서드
    public ImmutableObj add(int addValue) {
        int result = value + addValue;

        // 필드 값을 변경하기 위해 새로 생성한 불변 객체를 반환한다.
        return new ImmutableObj(result);
    }
}
