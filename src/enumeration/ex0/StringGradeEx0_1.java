package enumeration.ex0;

public class StringGradeEx0_1 {
    public static void main(String[] args) {
        // 각 회원 등급에 따른 할인 가격을 출력해보기
        
        int price = 10000;
        DiscountService discountService = new DiscountService();

        int basicDiscountPrice = discountService.discount("BASIC", price);
        int goldDiscountPrice = discountService.discount("GOLD", price);
        int diamondDiscountPrice = discountService.discount("DIAMOND", price);

        System.out.println("BASIC 등급 할인 가격 = " + basicDiscountPrice);
        System.out.println("GOLD 등급 할인 가격 = " + goldDiscountPrice);
        System.out.println("DIAMOND 등급 할인 가격 = " + diamondDiscountPrice);
    }
}
