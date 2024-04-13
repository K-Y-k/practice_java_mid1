package lang.immutable.address;

// 불변 객체 : 객체의 상태(내부의 값, 필드, 멤버 변수)가 변하지 않는 객체이다.
public class ImmutableAddress {
    private final String value; // 내부 값이 변경되지 못하도록 final 키워드로 값을 고정

    public ImmutableAddress(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // final로 고정했으므로 setter 사용 불가
    // final로 고정하지 않아도 setter를 사용하지 않으면 불변 객체지만 의도를 명확히 할 수 있다.
//    public void setValue(String value) {
//        this.value = value;
//    }

    @Override
    public String toString() {
        return "Address{" +
                "value='" + value + '\'' +
                '}';
    }
}
