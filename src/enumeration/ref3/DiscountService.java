package enumeration.ref3;


public class DiscountService {
    // 매개변수를 Enum 타입으로 받아옴
    public int discount(Grade classGrade, int price){
        // 1.클래스에 미리 적용한 할인율을 가져와서 코드 단축이 가능해짐
        // 2.데이터를 꺼내오지 않고 해당 클래스 내부에서 처리해준 후의 결과 값을 가져와서 객체지향의 캡슐화 적용
        return classGrade.discount(price);
    }
}
