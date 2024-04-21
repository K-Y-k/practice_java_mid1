package time.test;

import java.time.LocalDate;
import java.time.Period;

public class TestLoopPlus {
    public static void main(String[] args) {
        // 2024년 1월 1일 부터 2주 간격으로 5번 반복하여 날짜를 출력해라
        LocalDate startDate = LocalDate.of(2024, 1, 1);

        for (int i = 0; i < 5; i++) {
            LocalDate nextDate = startDate.plusWeeks(2 * i);
            System.out.println("날짜 " + (i+1) + ": " + nextDate);

            // ChronoUnit을 활용한 방식
//            LocalDate nextDate = startDate.plus(2*i, ChronoUnit.WEEKS);
        }
    }
}
