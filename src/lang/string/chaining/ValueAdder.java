package lang.string.chaining;

public class ValueAdder {
    private int value;

    public ValueAdder add(int addValue) {
        value += addValue;
        return this; // 반환을 자기 자신의 참조값으로 하여 메서드 체이닝 가능하도록함
    }

    public int getValue() {
        return value;
    }
}
