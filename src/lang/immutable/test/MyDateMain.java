package lang.immutable.test;

public class MyDateMain {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(2024, 1, 1);
        MyDate date2 = date1; // date1과 같은 객체 참조값으로 공유

        System.out.println("date1 = " + date1); // 2024-1-1
        System.out.println("date2 = " + date2); // 2024-1-1

        System.out.println("2025 -> date1");
        date1.setYear(2025);                    // date1의 년도를 바꿨으나 객체 참조값 공유로 인해 둘다 변경됨
        System.out.println("date1 = " + date1); // 2025-1-1
        System.out.println("date2 = " + date2); // 2025-1-1
    }
}
