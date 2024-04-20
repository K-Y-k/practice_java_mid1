package time;

import java.time.Duration;
import java.time.LocalTime;

public class DurationMain {
    public static void main(String[] args) {
        // Duration : 두 시간 사이의 간격을 시, 분, 초(나노초) 단위로 나타내는 클래스
        // 주의점은 get메서드는 초단위만 제공하므로
        // 시간과 분 단위는 toHours(), toMinutes(), toMinutesParts() 메서드를 사용해야 한다.

        // 시간 생성
        Duration duration = Duration.ofMinutes(30); // 30초의 시간 생성
        System.out.println("duration = " + duration);

        // 계산에 시간을 사용
        // 계산 메서드에 Period 클래스 변수를 그대로 넣을 수 있다.
        LocalTime lt = LocalTime.of(1, 0);
        LocalTime plusTime = lt.plus(duration);

        System.out.println("lt = " + lt);
        System.out.println("더한 시간: " + plusTime);
        
        
        // 시간 차이
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(10, 0);
        Duration between = Duration.between(startTime, endTime);

        // toMinutes()는 전체 분이고
        // toMinutesPart()는 시간단위를 뺀 나머지 분의 값으로 60분이 넘어가지 않는다.
        System.out.println("차이: " + between.getSeconds() + "초");
        System.out.println("근무 시간: " + between.toHours() + "시간" + between.toMinutesPart() + "분");
    }
}
