package lang.enumeration.ex3;

import static enumeration.ex3.Grade.*;

public class DiscountService {
    // 매개변수를 Enum 타입으로 받아옴
    public int discount(Grade classGrade, int price){
        int discountPercent = 0;

        // 미리 각 상수의 인스턴스를 생성한 Enum 타입이므로
        // 같은 참조값의 비교가 가능하다.
        if (classGrade == BASIC) {
            discountPercent = 10;
        } else if (classGrade == GOLD) {
            discountPercent = 20;
        } else if (classGrade == DIAMOND){
            discountPercent = 30;
        } else {
            System.out.println("할인X");
        }

        return price * discountPercent / 100;
    }
}
