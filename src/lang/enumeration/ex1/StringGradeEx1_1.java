package lang.enumeration.ex1;

public class StringGradeEx1_1 {
    public static void main(String[] args) {
        // 클래스에 미리 선언한 문자열 상수인 등급으로 할인 가격을 출력해보기
        // 선언된 등급을 가져오므로 오타시 컴파일 시점에 오류가 발생한다.
        
        int price = 10000;
        DiscountService discountService = new DiscountService();

        int basicDiscountPrice = discountService.discount(StringGrade.BASIC, price);
        int goldDiscountPrice = discountService.discount(StringGrade.GOLD, price);
        int diamondDiscountPrice = discountService.discount(StringGrade.DIAMOND, price);

        System.out.println("BASIC 등급 할인 가격 = " + basicDiscountPrice);
        System.out.println("GOLD 등급 할인 가격 = " + goldDiscountPrice);
        System.out.println("DIAMOND 등급 할인 가격 = " + diamondDiscountPrice);
    }
}
