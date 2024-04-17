package lang.enumeration.ex1;

public class StringGradeEx1_2 {
    public static void main(String[] args) {
        // 존재하지 않는 등급을 넣을 경우
        // 하지만, 미리 선언한 클래스의 문자열 상수를 넣지 않고 일반 문자열을 넣을 수 있는 문제는 그대로다!
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
