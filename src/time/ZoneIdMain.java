package time;

import java.time.ZoneId;
import java.util.Set;

public class ZoneIdMain {
    public static void main(String[] args) {
        // ex) 2013-11-21T08:20:30.12+9:00[Asia/Seoul]
        //     +9:00은 UTC(협정 세계시)로 부터의 시간대 차이다. 오프셋이라고 한다. 한국은 UTC보다 +9시간이다.
        //     Asia/Seoul은 타임존이다. 타임존을 알면 오프셋과 일광 절약 시간제를 알 수 있다.

        // ZoneId
        // 이용가능한 타임존 id를 얻을 수 있다.
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String availableZoneId : availableZoneIds) {
            System.out.println("availableZoneId = " + availableZoneId);

            // 존 id를 넣어 해당하는 존 객체를 구할 수 있다.
            ZoneId zoneId = ZoneId.of(availableZoneId);
            System.out.println(zoneId + " | " + zoneId.getRules()); // zoneId.getRules()은 오프셋과 일광 시간의 정보가 들어있다.
        }

        // 내 시스템 운영체제의 기반 존 확인
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("ZoneId.systemDefault = " + zoneId);

        // 역으로 존의 존 id 확인
        ZoneId seoulZoneId = zoneId.of("Asia/Seoul");
        System.out.println("seoulZoneId = " + seoulZoneId);
    }
}
