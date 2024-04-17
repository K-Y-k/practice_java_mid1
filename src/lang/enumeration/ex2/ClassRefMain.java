package lang.enumeration.ex2;

public class ClassRefMain {
    public static void main(String[] args) {
        // 각 상수는 모두 ClassGrade 타입을 기반으로 인스턴스를 만들었기 때문에
        // getClass()의 결과는 모두 ClassGrade
        System.out.println("class BASIC = " + ClassGrade.BASIC.getClass());
        System.out.println("class GOLD = " + ClassGrade.GOLD.getClass());
        System.out.println("class DIAMOND = " + ClassGrade.DIAMOND.getClass());

        // 각 상수는 모두 서로 다른 ClassGrade 인스턴스를 참조하기 때문에
        // 참조값이 모두 다르게 출력된다.
        System.out.println("ref BASIC = " + ClassGrade.BASIC);
        System.out.println("ref GOLD = " + ClassGrade.GOLD);
        System.out.println("ref DIAMOND = " + ClassGrade.DIAMOND);


    }
}
