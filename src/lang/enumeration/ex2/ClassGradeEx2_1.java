package lang.enumeration.ex2;

public class ClassGradeEx2_1 {
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


        // 하지만, 해당 클래스를 따로 생성하여 사용하면 다른 인스턴스를 받아 문제가 발생한다.
        // 생성자를 private로 막음으로 해결
        // ClassGrade newClassGrade = new ClassGrade();
    }
}
