package enumeration.ref3;

/**
 * 리펙토링2 - Enum 타입일 때
 * ex3에서의 DiscountService에서 불필요한 if문이 많아서
 * 미리 클래스에 각 등급의 할인율을 적용해준다.
 * 즉, 등급과 할인율을 하나의 클래스안에 같이 적용해주어 유지보수 향상!
 */

/**
 * 리펙토링3
 * ref1과2에서 하나의 클래스안에 등급과 할인을 적용했는데
 * Grade 클래스의 데이터를 가져와서 할인금액을 구하는 메서드가 DiscountService 클래스인 외부에서 구현되었다.
 * 결국 Grade 클래스의 데이터만 꺼내서 사용하는데
 * 객체지향 관점에서는 자신의 데이터를 외부에 노출하는 것 보다는 관련된 클래스 안에서 관리하는 캡슐화 원칙이 더 맞으므로
 *
 * 즉, Grade 클래스의 데이터를 꺼내지는 않고 가공하는 메서드는 여기서 만들고
 * 가공한 데이터를 서비스 클래스에 전달해주면 된다.
 *
 * 하지만 결국 서비스 클래스에 따로 사용하지 않아도 된다.
 * Grade 클래스에서의 관련 메서드를 호출해서 바로 적용하면 되기 때문이다.
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
    
    
    // Grade 클래스의 데이터를 다루는 메서드를 
    // 다른 클래스에서 구현한 것을 내부 클래스에 리펙토링 
    public int discount(int price){
        return price * discountPercent / 100;
    }
}
