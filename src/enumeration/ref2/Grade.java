package enumeration.ref2;

/**
 * 리펙토링2 - Enum 타입일 때
 * ex3에서의 DiscountService에서 불필요한 if문이 많아서
 * 미리 클래스에 각 등급의 할인율을 적용해준다.
 * 즉, 등급과 할인율을 하나의 클래스안에 같이 적용해주어 유지보수 향상!
 */
public enum Grade {
    // Enum에서의 생성자 생성할 때 관련 필드 값을 넣을 경우
    // 각 상수 ()안에 값을 넣으면 된다.
    BASIC(10), GOLD(20), DIAMOND(30); // 아래 필드를 추가하면 구분을 위해 ;를 넣어줘야 한다.

    private final int discountPercent;

    Grade(int discountPercent) { // 열거형의 생성자는 외부에서 생성할 수 없게 private다.
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
