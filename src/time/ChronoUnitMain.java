package time;

import java.time.LocalTime;
//import java.time.temporal.ChronoUnit;

public class ChronoUnitMain {
    public static void main(String[] args) {
        // 시간의 단위와 시간 필드 인터페이스는
        // - 시간의 단위를 뜻하는 TemporalUnit(구현체 ChronoUnit)과
        // - 시간의 필드를 뜻하는 TemporalField(구현체 ChronoField)이 있다.

        // - TemporalUnit 인터페이스
        //   날짜와 시간을 측정하는 단위를 나타내며, 주로 사용되는 구현체는 ChronoUnit 열거형 클래스이다.
        //   ChronoUnit은 다양한 시간 단위를 제공한다.


        // 특정 단위 가져오기
//        System.out.println("HOURS = " + ChronoUnit.HOURS); // 시 단위 Hours
//        System.out.println("DAYS = " + ChronoUnit.DAYS);   // 일 단위 Days

        // 날짜와 시간의 모든 단위 가져오기
//        ChronoUnit[] values = ChronoUnit.values();
//        for (ChronoUnit value : values) {
//            System.out.println("value = " + value);
//        }

        // 다른 시간의 단위로 변환하기
//        System.out.println("HOURS.duration = " + ChronoUnit.HOURS.getDuration().getSeconds()); // 1시간 단위 = 3600초
//        System.out.println("DAYS.duration = " ChronoUnit.DAYS.getDuration().getSeconds());     // 1일 단위 = 86400

        // 차이 구하기
        LocalTime lt1 = LocalTime.of(1, 10, 0);
        LocalTime lt2 = LocalTime.of(1, 20, 0);

//        long secondsBetween = ChronoUnit.SECONDS.between(lt1, lt2); // 차이를 초단위로 반환
//        System.out.println("secondsBetween = " + secondsBetween);   // 600초
//
//        long minutesBetween = ChronoUnit.MINUTES.between(lt1, lt2); // 차이를 분단위로 반환
//        System.out.println("minutesBetween = " + minutesBetween);   // 10일
    }
}
