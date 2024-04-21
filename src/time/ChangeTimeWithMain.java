package time;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;

public class ChangeTimeWithMain {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2018, 1, 1, 13, 30, 59);
        System.out.println("dt = " + dt);                 // 2018-01-01-T13;30:59

        // with()는 기존의 일부 필드 값을 새로운 객체로 만든 필드 값으로 바꿈
        // ChronoField를 활용한 방법
//        LocalDateTime changedDt1 = dt.with(ChronoField.YEAR, 2020); // 년도 필드가 2020인 새로운 객체로 생성하고 이 필드값만 바꾼다.
//        System.out.println("changedDt1 = " + changedDt1); // 2020-01-01-T13;30:59
        
        // LocalDateTime의 편의 메서드를 활용한 방법
        LocalDateTime changedDt2 = dt.withYear(2020);
        System.out.println("changedDt2 = " + changedDt2);


        // 복잡한 변경인 경우
        // 다음주 금요일 같은 복잡한 변경을 TemporalAdjuster을 사용하여 쉽게 변경
//        LocalDateTime with1 = dt.with(TemporalAdjuster.next(DayOfWeek.FRIDAY));
        System.out.println("기준 날짜: " + dt);
//        System.out.println("다음 금요일: " + with1);

        // 이번 달의 마지막 일요일
//        LocalDateTime with2 = dt.with(TemporalAdjuster.lastInMonth(DayOfWeek.SUNDAY));
//        System.out.println("같은 달의 마지막 일요일 = " + with2);
    }
}
