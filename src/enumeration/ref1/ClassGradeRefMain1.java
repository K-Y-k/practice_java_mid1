package enumeration.ref1;


public class ClassGradeRefMain1 {
    public static void main(String[] args) {
        // ClassGrade의 각 상수는 미리 선언한 인스턴스의 참조값으로
        // 이 참조값이 같음을 활용하여 비교했다.
        int price = 10000;
        DiscountService discountService = new DiscountService();

        int basicDiscountPrice = discountService.discount(ClassGrade.BASIC, price);
        int goldDiscountPrice = discountService.discount(ClassGrade.GOLD, price);
        int diamondDiscountPrice = discountService.discount(ClassGrade.DIAMOND, price);

        System.out.println("BASIC 등급 할인 가격 = " + basicDiscountPrice);
        System.out.println("GOLD 등급 할인 가격 = " + goldDiscountPrice);
        System.out.println("DIAMOND 등급 할인 가격 = " + diamondDiscountPrice);
    }
}
