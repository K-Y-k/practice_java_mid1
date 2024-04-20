package time;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {
    public static void main(String[] args) {
        // 가장 기본이 되는 날짜와 시간 클래스는 LocalDate, LoalTime, LocalDateTime이다.
        // 국내 시간만 사용할 경우 이 클래스들을 사용하면 된다.
        // LocalDateTime : LocalDate와 LocalTime을 합한 개념

        // 날짜와 시간 가져오기
        LocalDateTime nowDt = LocalDateTime.now(); // 현재 날짜와 시간
        LocalDateTime ofDt = LocalDateTime.of(2016, 8, 16, 8, 10, 1); // 특정 날짜와 시간
        System.out.println("현재 날짜시간 = " + nowDt);
        System.out.println("지정 날짜시간 = " + ofDt);

        // 날짜와 시간 분리
        LocalDate localDate = ofDt.toLocalDate();
        LocalTime localTime = ofDt.toLocalTime();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);
        
        // 날짜와 시간 합체
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime = " + localDateTime);

        // 계산(=불변이므로 계산 괄과를 반환값에 넣어줘야함)
        LocalDateTime ofDtPlusDay = ofDt.plusDays(1000);
        System.out.println("지정 날짜시간 + 1000일 = " + ofDtPlusDay);
        LocalDateTime ofDyPlusYear = ofDt.plusYears(1);
        System.out.println("지정 날짜시간 + 1년 = " +ofDyPlusYear);

        // 비교
        System.out.println("현재 날짜시간이 지정 날짜시간 보다 이전인가? " + nowDt.isBefore(ofDt));
        System.out.println("현재 날짜시간이 지정 날짜시간 보다 이후인가? " + nowDt.isAfter(ofDt));
        System.out.println("현재 날짜시간과 지정 날짜시간이 같은가? " + nowDt.isEqual(ofDt));

        // isEqual() vs equals()
        // isEqual()은 단순히 비교 대상이 시간적으로 같으면 된다.
        // 객체가 다르고 타임존이 달라도 시간적으로 같으면 된다는 뜻
        // ex) 서울의 9시와 UTC의 0시는 기잔적을 같다. => true

        // equals()은 객체의 타입, 타임존 등 내부 데이터의 모든 구성요소가 같아야 된다.
        // ex) 서울의 9시와 UTC의 0시는 시간적으로 같지만 타임존의 데이터가 다르다. => false
    }
}
