package time;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeMain {
    public static void main(String[] args) {
        // OffsetDateTime : 시간대를 고려한 날짜와 시간과 UTC(협정 세계시)로 부터의 시간차를 표현할 때 사용한다.
        // ex) 2013-11-21T08:20:30.12+9:00
        //     타임존은 없어 일광 절약 시간제 적용 X
        // UTC와의 시간 차이만 나타낼때 사용한다.
        // 글로벌 서비스할 때만 사용된다.

        // 현재 날짜와 시간과 시간차 가져오기
        OffsetDateTime nowOdt = OffsetDateTime.now();

        // 특정 날짜와 시간 가져오기
        LocalDateTime ldt = LocalDateTime.of(2030, 1, 1, 13, 30, 50);
        // 특정 시간인 LocalDateTime에 UTC(협정 세계시)로 부터의 시간차 추가하기(해당하는 시간차로 붙여야한다. 다른 시간차를 넣는다고 시간이 변경되지 않음)
        OffsetDateTime odt = OffsetDateTime.of(ldt, ZoneOffset.of("+01:00"));

        System.out.println("nowOdt = " + nowOdt);
        System.out.println("ldt = " + ldt);
        System.out.println("odt = " + odt);
    }
}
