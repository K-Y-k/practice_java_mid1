package time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeMain {
    public static void main(String[] args) {
        // ZonedDateTime : 시간대를 고려한 날짜와 시간을 표현할 때 사용한다.
        //                  즉, LocalDateTime + UTC(협정 세계시)로 부터의 시간차 + Zone 기능이 합쳐진 것
        // ex) 2013-11-21T08:20:30.12+9:00[Asia/Seoul]
        //     +9:00은 UTC(협정 세계시)로 부터의 시간대 차이다. 오프셋이라고 한다. 한국은 UTC보다 +9시간이다.
        //     Asia/Seoul은 타임존이다. 타임존을 알면 오프셋과 일광 절약 시간제를 알 수 있다.
        // 글로벌 서비스할 때만 사용된다.

        // 날짜와 시간과 시간차와 존 가져오기
        // 현재 날짜와 시간과 시간차와 존
        ZonedDateTime nowZdt = ZonedDateTime.now();

        // 특정 날짜와 시간 가져오기
        LocalDateTime ldt = LocalDateTime.of(2030, 1, 1, 13, 30);
        // 특정 시간인 LocalDateTime에 타임존 추가하기(해당하는 시간의 타임존으로 붙여야한다. 다른 타임존을 넣는다고 시간이 변경되지 않음)
        ZonedDateTime zdt1 = ZonedDateTime.of(ldt, ZoneId.of("Asia/Seoul"));

        // 생성자에 나노초 + 해당 타임존까지 한번에 넣기
        ZonedDateTime zdt2 = ZonedDateTime.of(2030, 1, 1, 13, 30, 50, 0, ZoneId.of("Asia/Seoul"));

        System.out.println("nowZdt = " + nowZdt);
        System.out.println("ldt = " + ldt);
        System.out.println("zdt1 = " + zdt1);
        System.out.println("zdt2 = " + zdt2);


        // 타임존 변경
        // 지정한 타임존에 맞춘 시간으로 변경하기
        ZonedDateTime utcZdt = zdt2.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("utcZdt = " + utcZdt);
    }
}
