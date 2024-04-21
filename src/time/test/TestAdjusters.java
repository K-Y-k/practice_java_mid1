package time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;

public class TestAdjusters {
    public static void main(String[] args) {
        // 입력 받은 월의 첫날 요일과 마지막날 요일을 구해라
        int year = 2024;
        int month = 1;

        // 첫날 요일
        LocalDate date = LocalDate.of(year, month, 1); // 입력한 년월의 1일을 선언한 후
        DayOfWeek firstDayOfWeek = date.getDayOfWeek();           // 해당 일의 요일을 가져온다.

        // 마지막날 요일
//        DayOfWeek lastDayOfWeek = date.with(TemporalAdjuster.lastDayOfMonth()).getDayOfMonth();

        System.out.println("firstDayOfWeek = " + firstDayOfWeek);
//        System.out.println("lastDayOfWeek = " + lastDayOfWeek);
    }
}
