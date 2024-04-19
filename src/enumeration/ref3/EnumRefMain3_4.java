package enumeration.ref3;


public class EnumRefMain3_4 {
    public static void main(String[] args) {
        /**
         * 새로운 등급이 추가되어도 모든 등급이 출력하도록 리펙토링
         */
        int price = 10000;

        // 해당 Enum 타입의 모든 상수를 배열로 가져오고 
        Grade[] grades = Grade.values();
        
        // 반복문으로 출력
        for (Grade grade : grades) {
            printDiscount(grade, price);
        }
    }


    /**
     * 출력 부분의 중복을 메서드로 제거하는 리펙토링
     */
    private static void printDiscount(Grade grade, int price) {
        System.out.println(grade.name() + " 등급의 할인 금액: " + grade.discount(price));
    }
}
