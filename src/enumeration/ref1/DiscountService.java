package enumeration.ref1;


public class DiscountService {
    // 매개변수를 ClassGrade 타입으로 받아옴
    public int discount(ClassGrade classGrade, int price){
        // 클래스에 미리 적용한 할인율을 가져와서 코드 단축이 가능해짐
        return price * classGrade.getDiscountPercent() / 100;


        // 복잡한 if문이 없어진다.
//        if (classGrade == ClassGrade.BASIC) {
//            discountPercent = 10;
//        } else if (classGrade == ClassGrade.GOLD) {
//            discountPercent = 20;
//        } else if (classGrade == ClassGrade.DIAMOND){
//            discountPercent = 30;
//        } else {
//            System.out.println("할인X");
//        }
    }
}
