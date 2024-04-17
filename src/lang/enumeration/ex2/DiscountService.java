package lang.enumeration.ex2;

public class DiscountService {
    // 매개변수를 ClassGrade 타입으로 받아옴
    public int discount(ClassGrade classGrade, int price){
        int discountPercent = 0;

        // 미리 각 상수의 인스턴스를 생성한 ClassGrade이므로
        // 같은 참조값의 비교가 가능하다.
        if (classGrade == ClassGrade.BASIC) {
            discountPercent = 10;
        } else if (classGrade == ClassGrade.GOLD) {
            discountPercent = 20;
        } else if (classGrade == ClassGrade.DIAMOND){
            discountPercent = 30;
        } else {
            System.out.println("할인X");
        }

        return price * discountPercent / 100;
    }
}
