package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingMain1 {
    public static void main(String[] args) {
        // 포맷팅 : 날짜 -> 문자열로 변경
        LocalDate date = LocalDate.of(2024, 12, 31);
        System.out.println("date = " + date);

        // get()메서드를 활용한 난잡한 포맷팅 방식
        System.out.println(date.getYear() + "년 " + date.getMonthValue() + "월");

        // DateTimeFormatter를 활용한 포맷팅 방식
        DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String formattedDate = date.format(fomatter);
        System.out.println("날짜와 시간 포맷팅 = " + formattedDate);


        // 파싱 : 문자열 -> 날짜로 변경
        String input = "2030년 01월 01일";
        LocalDate parsedDate = LocalDate.parse(input, fomatter);
        System.out.println("parsedDate = " + parsedDate);
    }
}
