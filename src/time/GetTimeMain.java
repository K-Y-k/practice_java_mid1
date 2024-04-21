package time;

import java.time.LocalDateTime;

public class GetTimeMain {
    public static void main(String[] args) {
        // 날짜와 시간을 조회할 때 각 날짜,시간의 필드를 뜻하는 ChronoField가 사용된다.

        // LocalDateTime의 get() 메서드에 구하고 싶은 필드를 ChronoField로 활용한 방법
        LocalDateTime dt = LocalDateTime.of(2030, 1, 1, 13, 30, 59);
//        System.out.println("YEAR = " + dt.get(ChronoField.YEAR));                    // 2030
//        System.out.println("MONTH_OF_YEAR = " +dt.get(ChronoField.MONTH_OF_YEAR));   // 1
//        System.out.println("DAY_OF_YEAR = " +dt.get(ChronoField.DAY_OF_YEAR));       // 1
//        System.out.println("HOUR_OF_YEAR = " +dt.get(ChronoField.HOUR_OF_YEAR));     // 13
//        System.out.println("MINUTE_OF_YEAR = " +dt.get(ChronoField.MINUTE_OF_YEAR)); // 30
//        System.out.println("SECOND_OF_YEAR = " +dt.get(ChronoField.SECOND_OF_YEAR)); // 59

        // LocalDateTime의 편의 메서드로 활용한 방법
        System.out.println("LocalDateTime은 편의 메서드 제공");
        System.out.println("YEAR = " + dt.getYear());                // 2030
        System.out.println("MONTH_OF_YEAR = " +dt.getMonthValue());  // 1
        System.out.println("DAY_OF_YEAR = " +dt.getDayOfMonth());    // 1
        System.out.println("HOUR_OF_YEAR = " +dt.getHour());         // 13
        System.out.println("MINUTE_OF_YEAR = " +dt.getMinute());     // 30
        System.out.println("SECOND_OF_YEAR = " +dt.getSecond());     // 59

        // LocalDateTime에 편의 메서드가 없는 것은 ChronoField로 활용해야 한다.
        System.out.println("LocalDateTime에 편의 메서드가 없는 것");
//        System.out.println("MINUTE_OF_DAY = " + dt.get(ChronoField.MINUTE_OF_DAY)); // 받아온 시간의 분 단위 13시 30분이므로 -> 810
//        System.out.println("SECOND_OF_DAY = " + dt.get(ChronoField.SECOND_OF_DAY)); // 받아온 시간의 초 단위 13시 30분 59초이므로 -> 48659초
    }
}
