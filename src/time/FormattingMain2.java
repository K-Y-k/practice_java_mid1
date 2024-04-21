package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingMain2 {
    public static void main(String[] args) {
        // 포맷팅 : 날짜 -> 문자열로 변경
        LocalDate date = LocalDate.of(2024, 12, 31);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // 변환할 문자열 패턴 선언
        String formattedDateTime = date.format(formatter);                                // 받아온 날짜 시간 객체를 해당 패턴으로 적용

        System.out.println("date = " + date);
        System.out.println("날짜와 시간 포맷팅: " + formattedDateTime);


        // 파싱 : 문자열 -> 날짜로 변경
        String dateTimeString = "2030-01-01 11:30:00";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, formatter);
        System.out.println("문자열 파싱 날짜와 시간: " + parsedDateTime);
    }
}
