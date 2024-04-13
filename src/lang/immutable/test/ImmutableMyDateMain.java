package lang.immutable.test;

public class ImmutableMyDateMain {
    public static void main(String[] args) {
        ImmutableMyDate date1 = new ImmutableMyDate(2024, 1, 1); // x001
        ImmutableMyDate date2 = date1;          // date1과 같은 객체 참조값으로 공유     x001

        System.out.println("date1 = " + date1); // 2024-1-1, x001
        System.out.println("date2 = " + date2); // 2024-1-1, x001

        System.out.println("2025 -> date1");

        date1 = date1.withYear(2025);   // 변경한 년도 값을 넣은 새로운 객체를 생성하여 반환된 참조값으로 변경, x002
        System.out.println("date1 = " + date1); // 2025-1-1, x002
        System.out.println("date2 = " + date2); // 2024-1-1, x001
    }
}
