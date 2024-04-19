package enumeration.ref3;


public class EnumRefMain3_2 {
    public static void main(String[] args) {
        int price = 10000;

        /**
         * DiscountService 없이 Enum 클래스의 내부 메서드를 호출해서 적용한 리펙토링
         */
        int basicDiscountPrice = Grade.BASIC.discount(price);
        int goldDiscountPrice = Grade.GOLD.discount(price);
        int diamondDiscountPrice = Grade.DIAMOND.discount(price);

        System.out.println("BASIC 등급 할인 가격 = " + basicDiscountPrice);
        System.out.println("GOLD 등급 할인 가격 = " + goldDiscountPrice);
        System.out.println("DIAMOND 등급 할인 가격 = " + diamondDiscountPrice);
    }
}
