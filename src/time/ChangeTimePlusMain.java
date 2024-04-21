package time;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

public class ChangeTimePlusMain {
    public static void main(String[] args) {
        // 날짜와 시간을 조작하려면 어떤 시간 단위를 변경할지 선택해야 한다.
        // 이때 날짜와 시간의 단위를 뜻하는 ChronoUnit이 사용된다.

        LocalDateTime dt = LocalDateTime.of(2018, 1, 1, 13, 30, 59);
        System.out.println("dt = " + dt);

        // 어떤 시간 단위로 더할지를 ChronoUnit을 활용한 방법
//        LocalDateTime plusDt1 = dt.plus(10, ChronoUnit.YEARS); // 10년을 더하게 된다 -> 2028-01-01T13:30:59
//        System.out.println("plusDt1 = " + plusDt1);

        // LocalDateTime의 편의 메서드로 활용한 방법
        LocalDateTime plusDt2 = dt.plusYears(10);               // 10년을 더하게 된다 -> 2028-01-01T13:30:59
        System.out.println("plusDt2 = " + plusDt2);

        // Period로 활용한 방법
        Period period = Period.ofYears(10);
        LocalDateTime plusDt3 = dt.plus(period);               // 10년을 더하게 된다 -> 2028-01-01T13:30:59
        System.out.println("plusDt3 = " + plusDt3);
    }
}
