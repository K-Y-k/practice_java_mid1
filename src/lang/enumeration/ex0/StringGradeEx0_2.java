package lang.enumeration.ex0;

public class StringGradeEx0_2 {
    public static void main(String[] args) {
        // 존재하지 않는 등급을 넣을 경우
        // 컴파일 시점에 오류가 발생하지 않아 데이터 일관성과 타입 안정성이 부족하다!
        int price = 10000;
        DiscountService discountService = new DiscountService();
        
        // 존재하지 않은 등급을 넣음
        int vipDiscountPrice = discountService.discount("VIP", price);
        System.out.println("VIP 등급 할인 가격 = " + vipDiscountPrice);

        // 오타인 등급을 넣음
        int diamondDiscountPrice = discountService.discount("DIAMONDD", price);
        System.out.println("DIAMOND 등급 할인 가격 = " + diamondDiscountPrice);

        // 소문자 등급을 입력
        int goldDiscountPrice = discountService.discount("gold", price);
        System.out.println("GOLD 등급 할인 가격 = " + goldDiscountPrice);
    }
}
