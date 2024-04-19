package enumeration.ref1;

public class ClassGrade {
    /**
     * 리펙토링1
     * ex2에서의 DiscountService에서 불필요한 if문이 많아서
     * 미리 클래스에 각 등급의 할인율을 적용해준다.
     * 즉, 등급과 할인율을 하나의 클래스안에 같이 적용해주어 유지보수 향상!
     */

    // 각 등급별로 상수를 선언한다.
    // 이때 각 상수마다 별도의 인스턴스를 생성하고 생성한 인스턴스를 대입한다.
    // 각 등급의 생성할 때 할인율을 주입받음
    public static final ClassGrade BASIC = new ClassGrade(10);   // x001
    public static final ClassGrade GOLD = new ClassGrade(20);    // x002
    public static final ClassGrade DIAMOND = new ClassGrade(30); // x003


    // 적용해줄 할인율 필드 추가
    private final int discountPercent;

    // 내부 생성자에 할인율 필드의 값을 주입 받음
    private ClassGrade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
