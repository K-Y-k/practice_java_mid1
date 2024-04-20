package time;

import java.time.Instant;
import java.time.ZonedDateTime;

public class InstantMain {
    public static void main(String[] args) {
        // 생성
        // UTC 기준의 현재 시간
        Instant now = Instant.now();

        // 다른 타입인 ZonedDateTime에서 Instant로 변환하기
        // 단 시간대 정보가 필요하므로 LocalDateTime은 사용할 수 없다.
        ZonedDateTime zdt = ZonedDateTime.now(); // 현재 날짜와 시간과 시간대와 타임존
        Instant from = Instant.from(zdt);        // ZonedDateTime을 Instant 시간으로 변환

        // 1970년 1월 1일 0시 0분 0초부터 지정한 시간만큼 적용하기
        Instant epochStart = Instant.ofEpochSecond(100); // 100초 추가

        // 계산(=불변이므로 계산 괄과를 반환값에 넣어줘야함)
        Instant later = epochStart.plusSeconds(3600); // 3600초 추가

        // 흐른 시간 조회
        long laterEpochSecond = later.getEpochSecond();

        System.out.println("now = " + now);
        System.out.println("from = " + from);
        System.out.println("epochStart = " + epochStart);
        System.out.println("laterEpochSecond = " + laterEpochSecond);
    }
}
